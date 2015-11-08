package com.eclinic.dao;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.SevenDays;

/**
 * DAO to manage Address entities.
 * 
 */
public interface SevenDaysDAO extends JpaDao<SevenDays> {

	public SevenDays findSevenDaysById(Integer id) throws DataAccessException;

	
}