package com.eclinic.web.rest;

import java.io.IOException;
import java.net.URL;

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

import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Patient;
import com.eclinic.model.Prescription;
import com.eclinic.service.PatientService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;


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
		return "Hello spring world!";
	}
	
	@RequestMapping(value="/prescription/{patient_id}")
	public String findPrescription(@PathParam("patient_id") Integer patientId) {
		
		return compileReport();
		
//		Patient patient = patientService.findPatientByPrimaryKey(patientId);
//		String str = patient.getName() + " " + patient.getSurname();
//		
//		return str;
	}
	
	
	private String compileReport() {
		String sourceFileName = "WEB-INF/classes/reports/preescription.jrxml";
		
		ClassLoader loader = this.getClass().getClassLoader();
		
		String str = loader.getResource("reports/prescription.jrxml").getPath();	
		
		try {
			JasperCompileManager.compileReportToFile(str);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		
		return "PATH TO:  " + str;
	}
	
}
