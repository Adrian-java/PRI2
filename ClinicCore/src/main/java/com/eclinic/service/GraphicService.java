package com.eclinic.service;

import com.eclinic.domain.DayOfWeek;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Graphic entities
 * 
 */
public interface GraphicService {

	/**
	 * Load an existing Graphic entity
	 * 
	 */
	public Set<Graphic> loadGraphics();

	/**
	 * Delete an existing DayOfWeek entity
	 * 
	 */
	public Graphic deleteGraphicDayOfWeek(Integer graphic_id, Integer related_dayofweek_id);

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	public void saveGraphic(Graphic graphic);

	/**
	 */
	public Graphic findGraphicByPrimaryKey(Integer id);

	/**
	 * Save an existing DayOfWeek entity
	 * 
	 */
	public Graphic saveGraphicDayOfWeek(Integer id_1, DayOfWeek related_dayofweek);

	/**
	 * Return all Graphic entity
	 * 
	 */
	public List<Graphic> findAllGraphics(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Graphic deleteGraphicDoctor(Integer graphic_id_1, String related_doctor_id);

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	public void deleteGraphic(Graphic graphic_1);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Graphic saveGraphicDoctor(Integer id_2, Doctor related_doctor);

	/**
	 * Return a count of all Graphic entity
	 * 
	 */
	public Integer countGraphics();
}