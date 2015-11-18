package com.eclinic.web.rest;

import java.awt.PageAttributes;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclinic.converter.PrescriptionConverter;
import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Specialization;
import com.eclinic.model.Clinic;
import com.eclinic.model.Prescription;
import com.eclinic.model.PrescriptionData;
import com.eclinic.service.PatientService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Component("DocumentController")
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	private PatientDAO patientDao;
	
	private PatientService patientService;
	

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public String hello() {
		return "Hello compiled world!";
	}
	
	@RequestMapping(value="/prescription/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public String findPrescription(@PathParam("patient_id") Integer patientId) {
		
		compileReport("prescription.jrxml");
		
		String prescription = getReportPath("prescription.jasper");
		Prescription prescription2 = createPrescription();
		
		PrescriptionConverter converter = new PrescriptionConverter();
		PrescriptionData data = converter.convert(prescription2);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getRemedy());
		
		Map<String, Object> parameters = converter.convertToMap(prescription2);
		
		String printFile = fillDocument(prescription, parameters, dataSource);
		
		try {
			JasperExportManager.exportReportToPdfFile(printFile);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		
		
		return "Successfully compilled!";
//		Patient patient = patientService.findPatientByPrimaryKey(patientId);
//		String str = patient.getName() + " " + patient.getSurname();
//		
//		return str;
	}
	
	
	private void compileReport(String filename) {
		String filePath = getReportPath(filename);	
		
		try {
			JasperCompileManager.compileReportToFile(filePath);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		
//		return "PATH TO:  " + filePath;
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
	
	
	private Prescription createPrescription() {
		Prescription prescription = new Prescription();
		
		prescription.setClinic(createClinic());
		prescription.setDepartment("Oddział 2");
		prescription.setDoctor(createDoctor());
		prescription.setExecutionDate(Calendar.getInstance().getTime());
		prescription.setIssuedDate(Calendar.getInstance().getTime());
		prescription.setNumber(1000);
		prescription.setPatient(createPatient());
		prescription.setPermissions("brak");
		prescription.setRemedy("lek1;100%;lek2;50%");
		
		return prescription;
	}
	
	
	private Patient createPatient() {
		Patient patient = new Patient();
		
		Address address = new Address();
		address.setCity("Warszawa");
		
		patient.setName("Seba");
		patient.setSurname("Cebula");
		patient.setAddress(address);
		
		return patient;
	}
	
	private Doctor createDoctor() {
		Doctor doctor = new Doctor();
		
		doctor.setName("Janusz");
		doctor.setSurname("Cebula");
		
		return doctor;
	}
	
	private Clinic createClinic() {
		Clinic clinic = new Clinic();

		clinic.setCity("Poznań");
		clinic.setCode("61-142");
		clinic.setEmail("aadasd@asdad.pl");
		clinic.setHouseNumber("22");
		clinic.setName("Przychodnia dobra nadzieja");
		clinic.setNip("1315515151");
		clinic.setPhone("2211323213");
		clinic.setRegon("243135115");
		clinic.setStreet("poznanska");
		
		return clinic;
	}
	
}
