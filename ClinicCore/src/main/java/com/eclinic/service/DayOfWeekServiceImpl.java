package com.eclinic.service;

import com.eclinic.dao.DayOfWeekDAO;
import com.eclinic.dao.GraphicDAO;

import com.eclinic.domain.DayOfWeek;
import com.eclinic.domain.Graphic;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for DayOfWeek entities
 * 
 */

@Service("DayOfWeekService")
@Transactional
public class DayOfWeekServiceImpl implements DayOfWeekService {

	/**
	 * DAO injected by Spring that manages DayOfWeek entities
	 * 
	 */
	@Autowired
	private DayOfWeekDAO dayOfWeekDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * Instantiates a new DayOfWeekServiceImpl.
	 *
	 */
	public DayOfWeekServiceImpl() {
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@Transactional
	public DayOfWeek saveDayOfWeekGraphics(Integer id, Graphic related_graphics) {
		DayOfWeek dayofweek = dayOfWeekDAO.findDayOfWeekById(id);
		Graphic existinggraphics = graphicDAO.findGraphicByPrimaryKey(related_graphics.getId());

		// copy into the existing record to preserve existing relationships
		if (existinggraphics != null) {
			existinggraphics.setId(related_graphics.getId());
			existinggraphics.setAbsence(related_graphics.getAbsence());
			existinggraphics.setTimeFrom(related_graphics.getTimeFrom());
			existinggraphics.setTimeTo(related_graphics.getTimeTo());
			related_graphics = existinggraphics;
		}

		related_graphics.setDayOfWeek(dayofweek);
		dayofweek.getGraphics().add(related_graphics);
		related_graphics = graphicDAO.store(related_graphics);
		graphicDAO.flush();

		dayofweek = dayOfWeekDAO.store(dayofweek);
		dayOfWeekDAO.flush();

		return dayofweek;
	}

	/**
	 */
	@Transactional
	public DayOfWeek findDayOfWeekByPrimaryKey(Integer id) {
		return dayOfWeekDAO.findDayOfWeekById(id);
	}

	/**
	 * Return a count of all DayOfWeek entity
	 * 
	 */
	@Transactional
	public Integer countDayOfWeeks() {
		return ((Long) dayOfWeekDAO.createQuerySingleResult("select count(o) from DayOfWeek o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing DayOfWeek entity
	 * 
	 */
	@Transactional
	public Set<DayOfWeek> loadDayOfWeeks() {
		return dayOfWeekDAO.findAllDayOfWeeks();
	}

	/**
	 * Return all DayOfWeek entity
	 * 
	 */
	@Transactional
	public List<DayOfWeek> findAllDayOfWeeks(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<DayOfWeek>(dayOfWeekDAO.findAllDayOfWeeks(startResult, maxRows));
	}

	/**
	 * Delete an existing DayOfWeek entity
	 * 
	 */
	@Transactional
	public void deleteDayOfWeek(DayOfWeek dayofweek) {
		dayOfWeekDAO.remove(dayofweek);
		dayOfWeekDAO.flush();
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	@Transactional
	public DayOfWeek deleteDayOfWeekGraphics(Integer dayofweek_id, Integer related_graphics_id) {
		Graphic related_graphics = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		DayOfWeek dayofweek = dayOfWeekDAO.findDayOfWeekById(dayofweek_id);

		related_graphics.setDayOfWeek(null);
		dayofweek.getGraphics().remove(related_graphics);

		graphicDAO.remove(related_graphics);
		graphicDAO.flush();

		return dayofweek;
	}

	/**
	 * Save an existing DayOfWeek entity
	 * 
	 */
	@Transactional
	public void saveDayOfWeek(DayOfWeek dayofweek) {
		DayOfWeek existingDayOfWeek = dayOfWeekDAO.findDayOfWeekById(dayofweek.getId());

		if (existingDayOfWeek != null) {
			if (existingDayOfWeek != dayofweek) {
				existingDayOfWeek.setId(dayofweek.getId());
				existingDayOfWeek.setName(dayofweek.getName());
			}
			dayofweek = dayOfWeekDAO.store(existingDayOfWeek);
		} else {
			dayofweek = dayOfWeekDAO.store(dayofweek);
		}
		dayOfWeekDAO.flush();
	}
}
