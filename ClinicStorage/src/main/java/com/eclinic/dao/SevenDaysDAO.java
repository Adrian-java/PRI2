package com.eclinic.dao;

import java.util.Collection;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.SevenDays;

/**
 * DAO to manage Address entities.
 * 
 */
public interface SevenDaysDAO extends JpaDao<SevenDays> {

	public SevenDays findSevenDaysById(Integer id) throws DataAccessException;

	public Collection<? extends SevenDays> findAllSevenDayss();

	public SevenDays findSevenDaysByPrimaryKey(Integer id, int i, int j);

	
}