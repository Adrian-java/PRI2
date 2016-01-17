package com.eclinic.test;

import java.io.IOException;
import java.sql.Time;
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
import com.eclinic.model.VisitEdit;
import com.eclinic.visit.VisitCrud;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;
import com.eclinic.web.rest.DoctorRestController;
import com.eclinic.web.rest.DocumentController;
import com.eclinic.web.rest.VisitRestController;
import com.eclinic.web.rest.VisitSchedulerRestController;

public class Main {

	private static VisitCrud visitCrud;

	private static DocumentsCrud documentsCrud;

	private static DoctorRestController doctorRest;

	private static VisitRestController visitSchedulerRestController;

	public static void main(String... args) throws ParseException,
			JsonGenerationException, JsonMappingException, IOException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// documentsCrud = (DocumentsCrud) ctx.getBean("DocumentsCrud");

		// DocumentsModel docm = new DocumentsModel();
		// docm.setDate(new Date());
		// docm.setDescription("desc1");
		// docm.setIdVisit(879);
		// documentsCrud.addDocument(docm);
		visitSchedulerRestController = (VisitRestController) ctx
				.getBean("VisitRestController");

		VisitEdit edit = new VisitEdit();
		edit.setVisitId(2502);
		edit.setDesciption("Opis testowy");
		System.out.println(visitSchedulerRestController.editVisit(edit));
//		NewVisitSchedulerMapper vsm = new NewVisitSchedulerMapper();
//		vsm.setDuration(20);
//		vsm.setIdDoctor("78010287654");
//		vsm.setSpecialization("Neurolog");

//		Calendar c = Calendar.getInstance();
//		c.set(2017, 02, 10);
//		vsm.setStartDate(c.getTime());
//		vsm.setTimeFrom(new Time(8, 0, 0));
//		vsm.setTimeTo(new Time(9, 0, 0));
//		vsm.setVisitRepeat(7);
//		visitSchedulerRestController.addVisitScheduler(vsm);

		// Response findPrescription =
		// docController.findPrescription("pesel38");
		// docController.findCertificate("pesel38");
		// docController.findReferral("pesel38");
		// PrescriptionModel prescription = new PrescriptionModel();
		// Prescription d = new Prescription();
		// Calendar c = Calendar.getInstance();
		// c.setTime(new Date());
		// prescription.setIssuedDate(c.getTime());
		// prescription.setDepartment("dep");
		// prescription.setExecutionDate(c.getTime());
		// prescription.setIdClinic(1);
		// prescription.setRemady("remady");
		// prescription.setVisitId(879);
		// documentsCrud.addPrescription(prescription);

		// CertificateModel cert = new CertificateModel();
		// cert.setPurpose("purpose");
		// cert.setRecognition("recognition");
		// cert.setVisitId(879);
		// documentsCrud.addCertificate(cert);
		// //
		// ReferralModel ref = new ReferralModel();
		// ref.setDestination("destination");
		// ref.setPurpose("purpose");
		// ref.setRecognition("recognition");
		// ref.setVisitId(879);
		// documentsCrud.addReferral(ref);
	}
}
