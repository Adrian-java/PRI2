package com.eclinic.test;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eclinic.visit.VisitCrud;

public class Main {

	private static VisitCrud visitCrud;

	public static void main(String... args) throws ParseException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		visitCrud = (VisitCrud) ctx.getBean("VisitCrud");

		// Date date = new Date(2016, 01, 15,9,00,00);
		// Set<VisitView> findVisitByDate = visitCrud.findVisitByDate(date);
		//
		String doctor = "71120789890";
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
