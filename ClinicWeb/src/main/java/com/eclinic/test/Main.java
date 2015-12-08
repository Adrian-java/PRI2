package com.eclinic.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eclinic.domain.view.VisitView;
import com.eclinic.user.mangament.patient.PatientCrud;
import com.eclinic.visit.VisitCrud;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.web.rest.DoctorRestController;

public class Main {

	private static VisitCrud visitCrud;

	private static PatientCrud patientCrud;
	
	private static DoctorRestController doctorRest;
	

	public static void main(String... args) throws ParseException, JsonGenerationException, JsonMappingException, IOException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// visitCrud = (VisitCrud) ctx.getBean("VisitCrud");
		patientCrud = (PatientCrud) ctx.getBean("PatientCrud");
		
		visitCrud = (VisitCrud) ctx.getBean("VisitCrud");
		doctorRest = (DoctorRestController) ctx.getBean("DoctorRestController");
		
		Response listDoctors = doctorRest.listDoctors();
		System.out.println();
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date startDate = format.parse("01/01/2016 ");
		Date endDate= format.parse("08/01/2016 ");
		Set<VisitView> allVisit = visitCrud.findVisitBySpecializationAndDate("Dermatolog", startDate, endDate);
		System.out.println();
		
		NewVisitMapper newVisitMapper = new NewVisitMapper();
		
	   
		newVisitMapper.setPatientId("pesel11");
		newVisitMapper.setDate(new Date());
		newVisitMapper.setDescription("");
		newVisitMapper.setIdReceptionist("receptionist1");
		newVisitMapper.setIdDoctor("71120789123");
		newVisitMapper.setTypeOfVisit("Dermatolog");
		
		
		visitCrud.addVisit(newVisitMapper);
//		boolean first = true;
//		for (int i = 200; i <= 203; i++) {
//			SystemUser s = new SystemUser();
//			s.setPassword("password" + i);
//			s.setEmail("email" + i);
//			s.setId("pesel" + i);
//			Admin p = new Admin();
//			p.setIsSuper(first);
//			s.setAdmin(p);
//			first = false;
//			patientCrud.addPatient(s);
//		}
		// Date date = new Date(2016, 01, 15,9,00,00);
		// Set<VisitView> findVisitByDate = visitCrud.findVisitByDate(date);
		//
		// String doctor = "71120789890";
		// Set<VisitView> findVisitByDoctor =
		// visitCrud.findVisitByDoctor(doctor); dziala
		//
		// String id = "123456";
		// Set<VisitView> findVisitByPatient = visitCrud.findVisitByPatient(id);
		// dziala
		// String specialization = "Psycholog";
		// Set<VisitView> findVisitBySpecialization =
		// visitCrud.findVisitBySpecialization(specialization); dziala
		// String status = "niepotwierdzona";
		// Set<VisitView> findVisitByStatus =
		// visitCrud.findVisitByStatus(status); dziala
		//
		// VisitView findFirstFreeTermByDoctor =
		// visitCrud.findFirstFreeTermByDoctor(doctor); dziala
		//
		// visitCrud.findFirstFreeTermBySpecialization(specialization); dziala
		//
		// Integer resultCounterMonth = null;
		// Set<VisitView> findFreeTermsByDoctor =
		// visitCrud.findFreeTermsByDoctor(doctor, 4); dziala
		//
		// visitCrud.findFreeTermsBySpecialization(specialization,
		// resultCounterMonth); dziala
		//
		// NewVisitSchedulerMapper visitSchedulerMapper = null;
		// visitCrud.addVisitScheduler(visitSchedulerMapper);
		//
		// VisitScheduler visitScheduler = null;
		// visitCrud.deleteVisitScheduler(visitScheduler);
		//
		// String patientId = "123456";
		// Integer visitId = 1;
		// visitCrud.addVisit(patientId, visitId); //dziala
		// Integer id2 = 1;
		// String status = "niepotwierdzona";
		// visitCrud.changeStatusOfVisit(id2, status); dziala

		// visitCrud.deleteVisit(id2); dziala
		//
		// visitCrud.addFreeVisit(); dziala

	}
}
