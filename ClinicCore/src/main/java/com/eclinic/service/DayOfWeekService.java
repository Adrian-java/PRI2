package com.eclinic.service;

import com.eclinic.domain.DayOfWeek;
import com.eclinic.domain.Graphic;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for DayOfWeek entities
 * 
 */
public interface DayOfWeekService {

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	public DayOfWeek saveDayOfWeekGraphics(Integer id, Graphic related_graphics);

	/**
	 */
	public DayOfWeek findDayOfWeekByPrimaryKey(Integer id_1);

	/**
	 * Return a count of all DayOfWeek entity
	 * 
	 */
	public Integer countDayOfWeeks();

	/**
	 * Load an existing DayOfWeek entity
	 * 
	 */
	public Set<DayOfWeek> loadDayOfWeeks();

	/**
	 * Return all DayOfWeek entity
	 * 
	 */
	public List<DayOfWeek> findAllDayOfWeeks(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing DayOfWeek entity
	 * 
	 */
	public void deleteDayOfWeek(DayOfWeek dayofweek);

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	public DayOfWeek deleteDayOfWeekGraphics(Integer dayofweek_id, Integer related_graphics_id);

	/**
	 * Save an existing DayOfWeek entity
	 * 
	 */
	public void saveDayOfWeek(DayOfWeek dayofweek_1);
}