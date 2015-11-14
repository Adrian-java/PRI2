package com.eclinic.web.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Patient;
import com.eclinic.model.Prescription;
import com.eclinic.service.PatientService;


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
		return "Hello world!";
	}
	
	@RequestMapping(value="/prescription/{patient_id}")
	public String findPrescription(@PathParam("patient_id") Integer patientId) {
		
		Patient patient = patientService.findPatientByPrimaryKey(patientId);
		String str = patient.getName() + " " + patient.getSurname();
		
		return str;
	}
	
}
