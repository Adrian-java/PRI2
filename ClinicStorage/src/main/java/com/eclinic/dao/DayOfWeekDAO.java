package com.eclinic.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.DayOfWeek;

/**
 * DAO to manage Address entities.
 * 
 */
public interface DayOfWeekDAO extends JpaDao<DayOfWeek> {

	public DayOfWeek findDayOfWeekById(Integer id) throws DataAccessException;

	public Set<DayOfWeek> findAllDayOfWeeks(Integer startResult, Integer maxRows);

	public Set<DayOfWeek> findAllDayOfWeeks();
	
}