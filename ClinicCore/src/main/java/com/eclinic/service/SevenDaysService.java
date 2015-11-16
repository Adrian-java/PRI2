package com.eclinic.service;

import com.eclinic.domain.SevenDays;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SevenDays entities
 * 
 */
public interface SevenDaysService {

	/**
	 * Return a count of all SevenDays entity
	 * 
	 */
	public Integer countSevenDayss();

	/**
	 * Return all SevenDays entity
	 * 
	 */
	public List<SevenDays> findAllSevenDayss(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing SevenDays entity
	 * 
	 */
	public void deleteSevenDays(SevenDays sevendays);

	/**
	 * Load an existing SevenDays entity
	 * 
	 */
	public Set<SevenDays> loadSevenDayss();

	/**
	 */
	public SevenDays findSevenDaysByPrimaryKey(Integer id);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public SevenDays saveSevenDaysVisitSchedulers(Integer id_1, VisitScheduler related_visitschedulers);

	/**
	 * Save an existing SevenDays entity
	 * 
	 */
	public void saveSevenDays(SevenDays sevendays_1);

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public SevenDays deleteSevenDaysVisitSchedulers(Integer sevendays_id, Integer related_visitschedulers_id);
}