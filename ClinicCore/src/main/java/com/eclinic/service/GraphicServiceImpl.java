package com.eclinic.service;

import com.eclinic.dao.DayOfWeekDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;

import com.eclinic.domain.DayOfWeek;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Graphic entities
 * 
 */

@Service("GraphicService")
@Transactional
public class GraphicServiceImpl implements GraphicService {

	/**
	 * DAO injected by Spring that manages DayOfWeek entities
	 * 
	 */
	@Autowired
	private DayOfWeekDAO dayOfWeekDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * Instantiates a new GraphicServiceImpl.
	 *
	 */
	public GraphicServiceImpl() {
	}

	/**
	 * Load an existing Graphic entity
	 * 
	 */
	@Transactional
	public Set<Graphic> loadGraphics() {
		return graphicDAO.findAllGraphics();
	}

	/**
	 * Delete an existing DayOfWeek entity
	 * 
	 */
	@Transactional
	public Graphic deleteGraphicDayOfWeek(Integer graphic_id, Integer related_dayofweek_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphic_id, -1, -1);
		DayOfWeek related_dayofweek = dayOfWeekDAO.findDayOfWeekById(related_dayofweek_id);

		graphic.setDayOfWeek(null);
		related_dayofweek.getGraphics().remove(graphic);
		graphic = graphicDAO.store(graphic);
		graphicDAO.flush();

		related_dayofweek = dayOfWeekDAO.store(related_dayofweek);
		dayOfWeekDAO.flush();

		dayOfWeekDAO.remove(related_dayofweek);
		dayOfWeekDAO.flush();

		return graphic;
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@Transactional
	public void saveGraphic(Graphic graphic) {
		Graphic existingGraphic = graphicDAO.findGraphicByPrimaryKey(graphic.getId());

		if (existingGraphic != null) {
			if (existingGraphic != graphic) {
				existingGraphic.setId(graphic.getId());
				existingGraphic.setAbsence(graphic.getAbsence());
				existingGraphic.setTimeFrom(graphic.getTimeFrom());
				existingGraphic.setTimeTo(graphic.getTimeTo());
			}
			graphic = graphicDAO.store(existingGraphic);
		} else {
			graphic = graphicDAO.store(graphic);
		}
		graphicDAO.flush();
	}

	/**
	 */
	@Transactional
	public Graphic findGraphicByPrimaryKey(Integer id) {
		return graphicDAO.findGraphicByPrimaryKey(id);
	}

	/**
	 * Save an existing DayOfWeek entity
	 * 
	 */
	@Transactional
	public Graphic saveGraphicDayOfWeek(Integer id, DayOfWeek related_dayofweek) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(id, -1, -1);
		DayOfWeek existingdayOfWeek = dayOfWeekDAO.findDayOfWeekById(related_dayofweek.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdayOfWeek != null) {
			existingdayOfWeek.setId(related_dayofweek.getId());
			existingdayOfWeek.setName(related_dayofweek.getName());
			related_dayofweek = existingdayOfWeek;
		}

		graphic.setDayOfWeek(related_dayofweek);
		related_dayofweek.getGraphics().add(graphic);
		graphic = graphicDAO.store(graphic);
		graphicDAO.flush();

		related_dayofweek = dayOfWeekDAO.store(related_dayofweek);
		dayOfWeekDAO.flush();

		return graphic;
	}

	/**
	 * Return all Graphic entity
	 * 
	 */
	@Transactional
	public List<Graphic> findAllGraphics(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Graphic>(graphicDAO.findAllGraphics(startResult, maxRows));
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Graphic deleteGraphicDoctor(Integer graphic_id, String related_doctor_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphic_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		graphic.setDoctor(null);
		related_doctor.getGraphics().remove(graphic);
		graphic = graphicDAO.store(graphic);
		graphicDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return graphic;
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	@Transactional
	public void deleteGraphic(Graphic graphic) {
		graphicDAO.remove(graphic);
		graphicDAO.flush();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Graphic saveGraphicDoctor(Integer id, Doctor related_doctor) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		graphic.setDoctor(related_doctor);
		related_doctor.getGraphics().add(graphic);
		graphic = graphicDAO.store(graphic);
		graphicDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return graphic;
	}

	/**
	 * Return a count of all Graphic entity
	 * 
	 */
	@Transactional
	public Integer countGraphics() {
		return ((Long) graphicDAO.createQuerySingleResult("select count(o) from Graphic o").getSingleResult()).intValue();
	}
}
