package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import com.eclinic.service.VisitSchedulerService;

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
 * Spring Rest controller that handles CRUD requests for VisitScheduler entities
 * 
 */

@Controller("VisitSchedulerRestController")
public class VisitSchedulerRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerService visitSchedulerService;

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/specialization/{specialization_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitSchedulerSpecialization(@PathVariable Integer visitscheduler_id, @PathVariable Integer related_specialization_id) {
		visitSchedulerService.deleteVisitSchedulerSpecialization(visitscheduler_id, related_specialization_id);
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newVisitSchedulerDoctor(@PathVariable Integer visitscheduler_id, @RequestBody Doctor doctor) {
		visitSchedulerService.saveVisitSchedulerDoctor(visitscheduler_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler", method = RequestMethod.POST)
	@ResponseBody
	public VisitScheduler newVisitScheduler(@RequestBody VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/specialization/{specialization_id}", method = RequestMethod.GET)
	@ResponseBody
	public Specialization loadVisitSchedulerSpecialization(@PathVariable Integer visitscheduler_id, @PathVariable Integer related_specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		return specialization;
	}

	/**
	 * Select an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}", method = RequestMethod.GET)
	@ResponseBody
	public VisitScheduler loadVisitScheduler(@PathVariable Integer visitscheduler_id) {
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id);
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/specialization", method = RequestMethod.POST)
	@ResponseBody
	public Specialization newVisitSchedulerSpecialization(@PathVariable Integer visitscheduler_id, @RequestBody Specialization specialization) {
		visitSchedulerService.saveVisitSchedulerSpecialization(visitscheduler_id, specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitScheduler(@PathVariable Integer visitscheduler_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id);
		visitSchedulerService.deleteVisitScheduler(visitscheduler);
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
	 * Get Doctor entity by VisitScheduler
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getVisitSchedulerDoctor(@PathVariable Integer visitscheduler_id) {
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id).getDoctor();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadVisitSchedulerDoctor(@PathVariable Integer visitscheduler_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitSchedulerDoctor(@PathVariable Integer visitscheduler_id, @PathVariable Integer related_doctor_id) {
		visitSchedulerService.deleteVisitSchedulerDoctor(visitscheduler_id, related_doctor_id);
	}

	/**
	 * Show all VisitScheduler entities
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler", method = RequestMethod.GET)
	@ResponseBody
	public List<VisitScheduler> listVisitSchedulers() {
		return new java.util.ArrayList<VisitScheduler>(visitSchedulerService.loadVisitSchedulers());
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveVisitSchedulerDoctor(@PathVariable Integer visitscheduler_id, @RequestBody Doctor doctor) {
		visitSchedulerService.saveVisitSchedulerDoctor(visitscheduler_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/specialization", method = RequestMethod.PUT)
	@ResponseBody
	public Specialization saveVisitSchedulerSpecialization(@PathVariable Integer visitscheduler_id, @RequestBody Specialization specialization) {
		visitSchedulerService.saveVisitSchedulerSpecialization(visitscheduler_id, specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler", method = RequestMethod.PUT)
	@ResponseBody
	public VisitScheduler saveVisitScheduler(@RequestBody VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());
	}

	/**
	 * Get Specialization entity by VisitScheduler
	 * 
	 */
	@RequestMapping(value = "/VisitScheduler/{visitscheduler_id}/specialization", method = RequestMethod.GET)
	@ResponseBody
	public Specialization getVisitSchedulerSpecialization(@PathVariable Integer visitscheduler_id) {
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id).getSpecialization();
	}
}