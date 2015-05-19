package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import com.eclinic.service.SpecializationService;

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
 * Spring Rest controller that handles CRUD requests for Specialization entities
 * 
 */

@Controller("SpecializationRestController")
public class SpecializationRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldDAO specalVisitFieldDAO;

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
	 * Service injected by Spring that provides CRUD operations for Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationService specializationService;

	/**
	 * Show all SpecalVisitField entities by Specialization
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/specalVisitFields", method = RequestMethod.GET)
	@ResponseBody
	public List<SpecalVisitField> getSpecializationSpecalVisitFields(@PathVariable Integer specialization_id) {
		return new java.util.ArrayList<SpecalVisitField>(specializationDAO.findSpecializationByPrimaryKey(specialization_id).getSpecalVisitFields());
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/visitSchedulers", method = RequestMethod.POST)
	@ResponseBody
	public VisitScheduler newSpecializationVisitSchedulers(@PathVariable Integer specialization_id, @RequestBody VisitScheduler visitscheduler) {
		specializationService.saveSpecializationVisitSchedulers(specialization_id, visitscheduler);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());
	}

	/**
	 * Show all Specialization entities
	 * 
	 */
	@RequestMapping(value = "/Specialization", method = RequestMethod.GET)
	@ResponseBody
	public List<Specialization> listSpecializations() {
		return new java.util.ArrayList<Specialization>(specializationService.loadSpecializations());
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/visitSchedulers", method = RequestMethod.PUT)
	@ResponseBody
	public VisitScheduler saveSpecializationVisitSchedulers(@PathVariable Integer specialization_id, @RequestBody VisitScheduler visitschedulers) {
		specializationService.saveSpecializationVisitSchedulers(specialization_id, visitschedulers);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers.getId());
	}

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/specalVisitFields", method = RequestMethod.POST)
	@ResponseBody
	public SpecalVisitField newSpecializationSpecalVisitFields(@PathVariable Integer specialization_id, @RequestBody SpecalVisitField specalvisitfield) {
		specializationService.saveSpecializationSpecalVisitFields(specialization_id, specalvisitfield);
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId());
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/specalVisitFields", method = RequestMethod.PUT)
	@ResponseBody
	public SpecalVisitField saveSpecializationSpecalVisitFields(@PathVariable Integer specialization_id, @RequestBody SpecalVisitField specalvisitfields) {
		specializationService.saveSpecializationSpecalVisitFields(specialization_id, specalvisitfields);
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfields.getId());
	}

	/**
	 * Select an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}", method = RequestMethod.GET)
	@ResponseBody
	public Specialization loadSpecialization(@PathVariable Integer specialization_id) {
		return specializationDAO.findSpecializationByPrimaryKey(specialization_id);
	}

	/**
	 * View an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/specalVisitFields/{specalvisitfield_id}", method = RequestMethod.GET)
	@ResponseBody
	public SpecalVisitField loadSpecializationSpecalVisitFields(@PathVariable Integer specialization_id, @PathVariable Integer related_specalvisitfields_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(related_specalvisitfields_id, -1, -1);

		return specalvisitfield;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveSpecializationDoctor(@PathVariable Integer specialization_id, @RequestBody Doctor doctor) {
		specializationService.saveSpecializationDoctor(specialization_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecializationDoctor(@PathVariable Integer specialization_id, @PathVariable Integer related_doctor_id) {
		specializationService.deleteSpecializationDoctor(specialization_id, related_doctor_id);
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newSpecializationDoctor(@PathVariable Integer specialization_id, @RequestBody Doctor doctor) {
		specializationService.saveSpecializationDoctor(specialization_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecialization(@PathVariable Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id);
		specializationService.deleteSpecialization(specialization);
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/specalVisitFields/{specalvisitfield_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecializationSpecalVisitFields(@PathVariable Integer specialization_id, @PathVariable Integer related_specalvisitfields_id) {
		specializationService.deleteSpecializationSpecalVisitFields(specialization_id, related_specalvisitfields_id);
	}

	/**
	 * Get Doctor entity by Specialization
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getSpecializationDoctor(@PathVariable Integer specialization_id) {
		return specializationDAO.findSpecializationByPrimaryKey(specialization_id).getDoctor();
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping(value = "/Specialization", method = RequestMethod.POST)
	@ResponseBody
	public Specialization newSpecialization(@RequestBody Specialization specialization) {
		specializationService.saveSpecialization(specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/visitSchedulers/{visitscheduler_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecializationVisitSchedulers(@PathVariable Integer specialization_id, @PathVariable Integer related_visitschedulers_id) {
		specializationService.deleteSpecializationVisitSchedulers(specialization_id, related_visitschedulers_id);
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadSpecializationDoctor(@PathVariable Integer specialization_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Show all VisitScheduler entities by Specialization
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/visitSchedulers", method = RequestMethod.GET)
	@ResponseBody
	public List<VisitScheduler> getSpecializationVisitSchedulers(@PathVariable Integer specialization_id) {
		return new java.util.ArrayList<VisitScheduler>(specializationDAO.findSpecializationByPrimaryKey(specialization_id).getVisitSchedulers());
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/Specialization", method = RequestMethod.PUT)
	@ResponseBody
	public Specialization saveSpecialization(@RequestBody Specialization specialization) {
		specializationService.saveSpecialization(specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping(value = "/Specialization/{specialization_id}/visitSchedulers/{visitscheduler_id}", method = RequestMethod.GET)
	@ResponseBody
	public VisitScheduler loadSpecializationVisitSchedulers(@PathVariable Integer specialization_id, @PathVariable Integer related_visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		return visitscheduler;
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
}