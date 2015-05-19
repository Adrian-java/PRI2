package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

import com.eclinic.service.GraphicService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Graphic entities
 * 
 */

@Controller("GraphicRestController")
public class GraphicRestController {

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
	 * Service injected by Spring that provides CRUD operations for Graphic entities
	 * 
	 */
	@Autowired
	private GraphicService graphicService;

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newGraphicDoctor(@PathVariable Integer graphic_id, @RequestBody Doctor doctor) {
		graphicService.saveGraphicDoctor(graphic_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteGraphic(@PathVariable Integer graphic_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphic_id);
		graphicService.deleteGraphic(graphic);
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@RequestMapping(value = "/Graphic", method = RequestMethod.PUT)
	@ResponseBody
	public Graphic saveGraphic(@RequestBody Graphic graphic) {
		graphicService.saveGraphic(graphic);
		return graphicDAO.findGraphicByPrimaryKey(graphic.getId());
	}

	/**
	 * Show all Graphic entities
	 * 
	 */
	@RequestMapping(value = "/Graphic", method = RequestMethod.GET)
	@ResponseBody
	public List<Graphic> listGraphics() {
		return new java.util.ArrayList<Graphic>(graphicService.loadGraphics());
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadGraphicDoctor(@PathVariable Integer graphic_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteGraphicDoctor(@PathVariable Integer graphic_id, @PathVariable Integer related_doctor_id) {
		graphicService.deleteGraphicDoctor(graphic_id, related_doctor_id);
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Get Doctor entity by Graphic
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getGraphicDoctor(@PathVariable Integer graphic_id) {
		return graphicDAO.findGraphicByPrimaryKey(graphic_id).getDoctor();
	}

	/**
	 * Create a new Graphic entity
	 * 
	 */
	@RequestMapping(value = "/Graphic", method = RequestMethod.POST)
	@ResponseBody
	public Graphic newGraphic(@RequestBody Graphic graphic) {
		graphicService.saveGraphic(graphic);
		return graphicDAO.findGraphicByPrimaryKey(graphic.getId());
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveGraphicDoctor(@PathVariable Integer graphic_id, @RequestBody Doctor doctor) {
		graphicService.saveGraphicDoctor(graphic_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Select an existing Graphic entity
	 * 
	 */
	@RequestMapping(value = "/Graphic/{graphic_id}", method = RequestMethod.GET)
	@ResponseBody
	public Graphic loadGraphic(@PathVariable Integer graphic_id) {
		return graphicDAO.findGraphicByPrimaryKey(graphic_id);
	}
}