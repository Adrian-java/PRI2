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
import com.eclinic.documents.util.DocumentsModel;
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
		documentsCrud = (DocumentsCrud) ctx.getBean("DocumentsCrud");
		
//		DocumentsModel docm = new DocumentsModel();
//		docm.setDate(new Date());
//		docm.setDescription("desc1");
//		docm.setIdVisit(879);
//		documentsCrud.addDocument(docm);
		docController = (DocumentController) ctx.getBean("DocumentController");
		
		Response findPrescription = docController.findPrescription("pesel38");
		docController.findCertificate("pesel38");
		docController.findReferral("pesel38");
//		 PrescriptionModel prescription = new PrescriptionModel();
//		 Prescription d = new Prescription();
//		 Calendar c = Calendar.getInstance();
//		 c.setTime(new Date());
//		 prescription.setIssuedDate(c.getTime());
//		 prescription.setDepartment("dep");
//		 prescription.setExecutionDate(c.getTime());
//		 prescription.setIdClinic(1);
//		 prescription.setRemady("remady");
//		 prescription.setVisitId(879);
//		 documentsCrud.addPrescription(prescription);

//		 CertificateModel cert = new CertificateModel();
//		 cert.setPurpose("purpose");
//		 cert.setRecognition("recognition");
//		 cert.setVisitId(879);
//		 documentsCrud.addCertificate(cert);
//		//
//		 ReferralModel ref = new ReferralModel();
//		 ref.setDestination("destination");
//		 ref.setPurpose("purpose");
//		 ref.setRecognition("recognition");
//		 ref.setVisitId(879);
//		 documentsCrud.addReferral(ref);
	}
}
