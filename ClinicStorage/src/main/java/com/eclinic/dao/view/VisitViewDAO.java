package com.eclinic.dao.view;

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

}