package com.eclinic.visit;

import java.util.Date;
import java.util.Set;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;

public interface VisitCrud {

	public Set<Visit> findVisitByDate(Date date);

	public Set<Visit> findVisitByDoctor(Doctor doctor);

	public Set<Visit> findVisitByPatient(Patient patient);

	public Set<Visit> findVisitBySpecialization(Specialization specialization);

	public Set<Visit> findVisitByStatus(StatusOfVisit status);

	public VisitScheduler findFirstFreeTermByDoctor(Doctor doctor);

	public VisitScheduler findFirstFreeTermBySpecialization(
			Specialization specialization);

	public Set<VisitScheduler> findFreeTermsByDoctor(Doctor doctor,
			Integer resultCounterMonth);

	public Set<VisitScheduler> findFreeTermsBySpecialization(
			Specialization specialization, Integer resultCounterMonth);
	
	public void addVisitScheduler(VisitScheduler visitScheduler);
	
	public void deleteVisitScheduler(VisitScheduler visitScheduler);
	
	public void addVisit(Visit visit);
	
	public void changeStatusOfVisit(Visit visit, StatusOfVisit status);
	
	public void deleteVisit(Visit visit);
	
	

}
