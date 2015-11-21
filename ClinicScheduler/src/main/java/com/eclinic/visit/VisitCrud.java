package com.eclinic.visit;

import java.util.Date;
import java.util.Set;

import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.view.VisitView;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;

public interface VisitCrud {

    public Set<VisitView> findVisitByDate(Date date);

    public Set<VisitView> findVisitByDoctor(String doctor);

    public Set<VisitView> findVisitByPatient(String id);

    public Set<VisitView> findVisitBySpecialization(String specialization);

    public Set<VisitView> findVisitByStatus(String status);

    public VisitView findFirstFreeTermByDoctor(String id);

    public VisitView findFirstFreeTermBySpecialization(String specialization);

    public Set<VisitView> findFreeTermsByDoctor(String id, Integer resultCounterMonth);

    public Set<VisitView> findFreeTermsBySpecialization(String specialization,
	    Integer resultCounterMonth);

    public VisitScheduler addVisitScheduler(NewVisitSchedulerMapper visitSchedulerMapper);

    public void deleteVisitScheduler(VisitScheduler visitScheduler);

    public Visit addVisit(String  patientId, Integer visitId);

    public void changeStatusOfVisit(Integer id, String status);

    public void deleteVisit(Integer id);

	public VisitScheduler addFreeVisit();

}
