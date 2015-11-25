package com.eclinic.dao.view;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.view.VisitSchedulerView;

/**
 * DAO to manage Doctor entities.
 * 
 */
public interface VisitSchedulerViewDAO extends JpaDao<VisitSchedulerView> {

	public Set<VisitSchedulerView> findAllVisitScheduler() throws DataAccessException;

}