package com.eclinic.web.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.eclinic.converter.PrescriptionConverter;
import com.eclinic.dao.PatientDAO;
import com.eclinic.helper.PrescriptionBuilder;
import com.eclinic.model.Prescription;
import com.eclinic.model.PrescriptionData;
import com.eclinic.service.PatientService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component("DocumentController")
@javax.ws.rs.Path("/documents")
public class DocumentController {
	
	@Autowired
	private PatientDAO patientDao;
	
	private PatientService patientService;
	
	public DocumentController() {
		compileReport("prescription.jrxml");
	}
	
/*
 * HOW TO CREATE A PRESCRIPTION: 
 * 
 * 1. Get path to the compiled prescription template (.jasper file)
 * 2. Get Prescription object and extract its data using the Converter
 * 		a. Create DataSource using PrescriptionData - it contains the list of remedies
 * 		b. Create parameters Map from Prescription object
 * 3. Fill the file from step 1 with parameters and dataSource
 * 4. Extract the document to PDF
 * 5. Return the document as view
 * 
 * */	
	
	@javax.ws.rs.Path("/prescription/{patient_id}")
	@GET
	@Produces("application/pdf")
	public Response findPrescription(@PathParam("patient_id") Integer patientId) {

		//TODO - remove builder when db stops returning nullable objects. After that create a new prescription using data passed to the controller
		PrescriptionBuilder builder = new PrescriptionBuilder();
//		Patient patient = patientService.findPatientByPrimaryKey(patientId);
		
		//TODO - Converter should be autowired
		PrescriptionConverter converter = new PrescriptionConverter();
		
		String prescriptionFile = getReportPath("prescription.jasper");
		
		Prescription prescription = builder.createPresctiption();
		
		PrescriptionData data = converter.convert(prescription);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getRemedy());
		Map<String, Object> parameters = converter.convertToMap(prescription);
		
		String printFile = fillDocument(prescriptionFile, parameters, dataSource);
		
		extractToPDF(printFile);
		
		return Response.status(200).entity(convertPdfFile("prescription.pdf")).build();
	}

	private void compileReport(String filename) {
		String filePath = getReportPath(filename);	
		
		try {
			JasperCompileManager.compileReportToFile(filePath);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

	private String getReportPath(String filename) {
		ClassLoader loader = this.getClass().getClassLoader();
		String file =  "reports/" + filename;
		return loader.getResource(file).getPath();
	}
	
	private String fillDocument(String sourceFileName, Map<String,Object> parameters, JRBeanCollectionDataSource dataSource) {
		
		try {
			return JasperFillManager.fillReportToFile(sourceFileName, parameters, dataSource);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void extractToPDF(String printFile) {
		try {
			JasperExportManager.exportReportToPdfFile(printFile);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
//	Use this method when you want to create a ResponseEntity<byte[]>
	private ResponseEntity<byte[]> createResponse(String filename) {
		byte[] fileBytes = convertPdfFile(filename);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.parseMediaType("application/pdf"));
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    return new ResponseEntity<byte[]>(fileBytes, headers, HttpStatus.OK);
	}

	private byte[] convertPdfFile(String filename) {
		String filePath = getReportPath(filename);
		filePath = filePath.replaceFirst("^/(.:/)", "$1");
		
		Path path = Paths.get(filePath); 
		

		
		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return bytes;
	}
	
	
}
