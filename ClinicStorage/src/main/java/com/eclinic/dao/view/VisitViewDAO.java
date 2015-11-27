package com.eclinic.dao.view;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.view.VisitView;

/**
 * DAO to manage Doctor entities.
 * 
 */
public interface VisitViewDAO extends JpaDao<VisitView> {

	public Set<VisitView> findAllVisit() throws DataAccessException;
	
	public Set<VisitView> findFreeVisitBySpecialization(String specialization, int numberOfVisit) throws DataAccessException;
	
	public Set<VisitView> findFreeVisitByDoctor(String doctorId, int numberOfVisit) throws DataAccessException;
	
	public VisitView findVisitById(Integer visitId) throws DataAccessException;

	public Set<VisitView> findVisitByDateOfVisit(Calendar calendar);

	public Set<VisitView> findVisitByDoctor(String doctor, int i, int j);

	public Set<VisitView> findVisitByPatient(String id);

	public Set<VisitView> findVisitByStatus(String status);
	
	public Set<VisitView> findVisitBySpecialization(String s);
	
	public Set<VisitView> findVisitBySpecializationAndDate(String s, Date start, Date stop);

}