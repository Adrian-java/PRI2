package com.eclinic.visit;

import java.util.Date;
import java.util.Set;

import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.view.VisitView;
import com.eclinic.model.VisitEdit;
import com.eclinic.model.VisitInfo;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;

public interface VisitCrud {

    public Set<VisitView> findVisitByDate(Date date);

    public Set<VisitView> findVisitByDoctor(String doctor, Date start, Date stop);

    public Set<VisitView> findPlaneVisitByPatient(String id);
    
    public Set<VisitView> findDoneVisitByPatient(String id);
    
    public VisitInfo findVisitById(Integer id);
    
    public VisitView findVisitWithInfoById(Integer id);

    public Set<VisitView> findVisitBySpecialization(String specialization);

    public Set<VisitView> findAllVisit();
    
    public Set<VisitView> findVisitByStatus(String status);

    public VisitView findFirstFreeTermByDoctor(String id);

    public VisitView findFirstFreeTermBySpecialization(String specialization);
    
    public VisitView findFirstFreeTermBySpecializationAndDoctor(String specialization,String doctor);
    
    public Set<VisitView> findFreeTermBySpecializationAndDoctor(String specialization,String doctor);

    public Set<VisitView> findFreeTermsByDoctor(String id, Integer resultCounterMonth);

    public Set<VisitView> findFreeTermsBySpecialization(String specialization,
	    Integer resultCounterMonth);

    public VisitScheduler addVisitScheduler(NewVisitSchedulerMapper visitSchedulerMapper);

    public void deleteVisitScheduler(VisitScheduler visitScheduler);

    public Visit addVisit(NewVisitMapper newVisitMapper);

    public void changeStatusOfVisit(Integer id, String status);

    public void deleteVisit(Integer id);

	public VisitScheduler addFreeVisit();
	
	public Set<VisitView> findAllVisitByDate(Date start, Date stop);
	
	public Set<VisitView> findVisitBySpecializationAndDate(String specialization, Date startDate, Date endDate);

	public Set<VisitScheduler> findVisitSchedulerBySpecialization(String specialization);
	
	public Set<VisitScheduler> findVisitSchedulerByDoctor(String doctorId);

	public Set<VisitView> findVisitByDoctorAndSpecialization(String doctor,
			String specialization, Date parse, Date parse2);

	public Set<VisitView> getAllVisitByPatient(String id);
	
	public Visit editVisit(VisitEdit ve);
}
