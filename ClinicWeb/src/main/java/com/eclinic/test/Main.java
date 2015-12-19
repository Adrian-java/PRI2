package com.eclinic.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
import com.eclinic.domain.Documents;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.view.VisitView;
import com.eclinic.user.mangament.patient.PatientCrud;
import com.eclinic.visit.VisitCrud;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.web.rest.DoctorRestController;

public class Main {

	private static VisitCrud visitCrud;

	private static DocumentsCrud documentsCrud;
	
	private static DoctorRestController doctorRest;
	

	public static void main(String... args) throws ParseException, JsonGenerationException, JsonMappingException, IOException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// visitCrud = (VisitCrud) ctx.getBean("VisitCrud");
		documentsCrud = (DocumentsCrud) ctx.getBean("DocumentsCrud");
		PrescriptionModel prescription = new PrescriptionModel();
		Prescription d = new Prescription();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		prescription.setIssuedDate(c.getTime());
		prescription.setDepartment("dep");
		prescription.setExecutionDate(c.getTime());
		prescription.setIdClinic(1);
		prescription.setRemady("remady");
		documentsCrud.addPrescription(prescription);
		
		CertificateModel cert = new CertificateModel();
		cert.setIdNumber("123");
		cert.setPurpose("purpose");
		cert.setRecognition("recognition");
		documentsCrud.addCertificate(cert);
		
		ReferralModel ref = new ReferralModel();
		ref.setDestination("destination");
		ref.setPurpose("purpose");
		ref.setRecognition("recognition");
		documentsCrud.addReferral(ref);
	}
}
