package com.eclinic.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eclinic.documents.util.CertificateModel;
import com.eclinic.documents.util.DocumentsCrud;
import com.eclinic.documents.util.PrescriptionModel;
import com.eclinic.documents.util.ReferralModel;
import com.eclinic.domain.Prescription;
import com.eclinic.visit.VisitCrud;
import com.eclinic.web.rest.DoctorRestController;
import com.eclinic.web.rest.DocumentController;

public class Main {

	private static VisitCrud visitCrud;

	private static DocumentsCrud documentsCrud;

	private static DoctorRestController doctorRest;

	private static DocumentController docController;

	public static void main(String... args) throws ParseException,
			JsonGenerationException, JsonMappingException, IOException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		documentsCrud = (DocumentsCrud) ctx.getBean("DocumentsCrud");
		docController = (DocumentController) ctx.getBean("DocumentController");
		
		Response findPrescription = docController.findPrescription("pesel25");
		docController.findCertificate("pesel25");
		docController.findReferral("pesel25");
		 PrescriptionModel prescription = new PrescriptionModel();
//		 Prescription d = new Prescription();
		// Calendar c = Calendar.getInstance();
		// c.setTime(new Date());
		// prescription.setIssuedDate(c.getTime());
		// prescription.setDepartment("dep");
		// prescription.setExecutionDate(c.getTime());
		// prescription.setIdClinic(1);
		// prescription.setRemady("remady");
//		 prescription.setPatientId("pesel25");
		// documentsCrud.addPrescription(prescription);

		// CertificateModel cert = new CertificateModel();
		// cert.setIdNumber("123");
		// cert.setPurpose("purpose");
		// cert.setRecognition("recognition");
		// cert.setPatientId("pesel25");
//		 documentsCrud.addCertificate(csert);
		//
		// ReferralModel ref = new ReferralModel();
		// ref.setDestination("destination");
		// ref.setPurpose("purpose");
		// ref.setRecognition("recognition");
		// ref.setPatientId("pesel25");
		// documentsCrud.addReferral(ref);
	}
}
