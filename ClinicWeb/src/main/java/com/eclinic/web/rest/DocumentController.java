package com.eclinic.web.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.eclinic.converter.DocumentConverter;
import com.eclinic.domain.Patient;
import com.eclinic.domain.view.PatientView;
import com.eclinic.helper.DocumentBuilder;
import com.eclinic.helper.EntityConverter;
import com.eclinic.model.Certificate;
import com.eclinic.model.Prescription;
import com.eclinic.model.PrescriptionData;
import com.eclinic.model.Referral;
import com.eclinic.user.mangament.patient.PatientCrudDB;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component("DocumentController")
@javax.ws.rs.Path("/documents")
public class DocumentController {
	
	@Autowired
	private PatientCrudDB patientCrudDB;
	
	private DocumentConverter converter = new DocumentConverter();;
	
	private DocumentBuilder builder = new DocumentBuilder();
	
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
	
	@GET
	@Path("/prescription/{patientId}")
	@Produces("application/pdf")
	public Response findPrescription(@PathParam("patientId") Integer patientId) {

		PatientView view = patientCrudDB.getPatientById(patientId.toString());
		
		EntityConverter entityConverter = new EntityConverter();
		Patient patient = entityConverter.convertToPatient(view);
		
		String prescriptionFile = getReportPath("prescription.jasper");
		Prescription prescription = builder.createPresctiption();
		prescription.setPatient(patient);
		
		PrescriptionData data = converter.getDataFrom(prescription);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getRemedy());
		Map<String, Object> parameters = converter.convertToPrescription(prescription);
		
		String printFile = fillDocument(prescriptionFile, parameters, dataSource);
//		String fileName = String.format("prescription_%s.pdf", patientId.toString());
//		String f = getReportPath(fileName);
		exportToPDF(printFile);
		
		return Response.status(200).entity(convertPdfFile("prescription.pdf")).build();
	}
	
	@GET
	@Path("/certificate/{patientId}")
	@Produces("application/pdf")
	public Response findCertificate(@PathParam("patientId") Integer patientId) {
		compileReport("certificate.jrxml");
		Certificate certificate = builder.createCertificate();
		String certificateFile = getReportPath("certificate.jasper");
		Map<String, Object> parameters = converter.convertToCertificate(certificate);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(initializeDataSource());
		
		String printFileName = fillDocument(certificateFile, parameters, dataSource);
//		String fileName = String.format("certificate_%s.pdf", patientId.toString());
		exportToPDF(printFileName);
		
		return Response.status(200).entity(convertPdfFile("certificate.pdf")).build();
	}
	
	@GET
	@Path("/referral/{patientId}")
	@Produces("application/pdf")
	public Response findReferral(@PathParam("patientId") Integer patientId) {
		compileReport("referral.jrxml");
		Referral referral = builder.createReferaral();
		String referralFile = getReportPath("referral.jasper");
		Map<String,Object> parameters = converter.convertToReferral(referral);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(initializeDataSource());
		
		String printFileName = fillDocument(referralFile, parameters, dataSource);
		exportToPDF(printFileName);
		
		return  Response.status(200).entity(convertPdfFile("referral.pdf")).build();
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
	
	private void exportToPDF(String printFile) {
		try {
			JasperExportManager.exportReportToPdfFile(printFile);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	private byte[] convertPdfFile(String filename) {
		String filePath = getReportPath(filename);
		filePath = filePath.replaceFirst("^/(.:/)", "$1");
		
		java.nio.file.Path path = Paths.get(filePath); 
		
		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return bytes;
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

	
	private List<Object> initializeDataSource() {
		List<Object> list = new ArrayList<Object>();
		list.add("list");
		return list;
	}
	
}
