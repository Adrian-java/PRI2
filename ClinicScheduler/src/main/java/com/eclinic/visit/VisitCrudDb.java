package com.eclinic.visit;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;

@Component("VisitCrudDb")
public class VisitCrudDb implements VisitCrud{

	@Autowired
	private VisitDAO visitDao;
	
	@Autowired
	private VisitSchedulerDAO visitSchedulerDao;
	
	public Set<Visit> findVisitByDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return visitDao.findVisitByDateOfVisit(calendar);
	}

	public Set<Visit> findVisitByDoctor(Doctor doctor) {
		return visitDao.findVisitByDoctor(doctor, -1, -1);
	}

	public Set<Visit> findVisitByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Visit> findVisitBySpecialization(Specialization specialization) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Visit> findVisitByStatus(StatusOfVisit status) {
		// TODO Auto-generated method stub
		return null;
	}

	public VisitScheduler findFirstFreeTermByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	public VisitScheduler findFirstFreeTermBySpecialization(
			Specialization specialization) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<VisitScheduler> findFreeTermsByDoctor(Doctor doctor,
			Integer resultCounterMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<VisitScheduler> findFreeTermsBySpecialization(
			Specialization specialization, Integer resultCounterMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		
	}

	public void changeStatusOfVisit(Visit visit, StatusOfVisit status) {
		// TODO Auto-generated method stub
		
	}

	public void deleteVisit(Visit visit) {
		// TODO Auto-generated method stub
		
	}

	public void addVisitScheduler(VisitScheduler visitScheduler) {
		// TODO Auto-generated method stub
		
	}

	public void deleteVisitScheduler(VisitScheduler visitScheduler) {
		// TODO Auto-generated method stub
		
	}

}
