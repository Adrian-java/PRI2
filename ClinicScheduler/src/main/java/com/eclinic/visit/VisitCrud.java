package com.eclinic.visit;

import java.util.Date;
import java.util.Set;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;
import com.eclinic.visit.mapper.VisitProposal;

public interface VisitCrud {

    public Set<Visit> findVisitByDate(Date date);

    public Set<Visit> findVisitByDoctor(Doctor doctor);

    public Set<Visit> findVisitByPatient(Integer id);

    public Set<Visit> findVisitBySpecialization(String specialization);

    public Set<Visit> findVisitByStatus(String status);

    public VisitProposal findFirstFreeTermByDoctor(Integer id);

    public VisitProposal findFirstFreeTermBySpecialization(String specialization);

    public Set<VisitProposal> findFreeTermsByDoctor(Integer id, Integer resultCounterMonth);

    public Set<VisitProposal> findFreeTermsBySpecialization(String specialization,
	    Integer resultCounterMonth);

    public VisitScheduler addVisitScheduler(NewVisitSchedulerMapper visitSchedulerMapper);

    public void deleteVisitScheduler(VisitScheduler visitScheduler);

    public Visit addVisit(NewVisitMapper visit);

    public void changeStatusOfVisit(Integer id, String status);

    public void deleteVisit(Integer id);

}
