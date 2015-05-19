package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Visit;

import com.eclinic.service.SickLeaveService;

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
 * Spring Rest controller that handles CRUD requests for SickLeave entities
 * 
 */

@Controller("SickLeaveRestController")
public class SickLeaveRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveService sickLeaveService;

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/visit/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadSickLeaveVisit(@PathVariable Integer sickleave_id, @PathVariable Integer related_visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visit_id, -1, -1);

		return visit;
	}

	/**
	 * Select an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}", method = RequestMethod.GET)
	@ResponseBody
	public SickLeave loadSickLeave(@PathVariable Integer sickleave_id) {
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id);
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/visit/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSickLeaveVisit(@PathVariable Integer sickleave_id, @PathVariable Integer related_visit_id) {
		sickLeaveService.deleteSickLeaveVisit(sickleave_id, related_visit_id);
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveSickLeaveDoctor(@PathVariable Integer sickleave_id, @RequestBody Doctor doctor) {
		sickLeaveService.saveSickLeaveDoctor(sickleave_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/patient/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSickLeavePatient(@PathVariable Integer sickleave_id, @PathVariable Integer related_patient_id) {
		sickLeaveService.deleteSickLeavePatient(sickleave_id, related_patient_id);
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSickLeaveDoctor(@PathVariable Integer sickleave_id, @PathVariable Integer related_doctor_id) {
		sickLeaveService.deleteSickLeaveDoctor(sickleave_id, related_doctor_id);
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave", method = RequestMethod.PUT)
	@ResponseBody
	public SickLeave saveSickLeave(@RequestBody SickLeave sickleave) {
		sickLeaveService.saveSickLeave(sickleave);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/patient", method = RequestMethod.POST)
	@ResponseBody
	public Patient newSickLeavePatient(@PathVariable Integer sickleave_id, @RequestBody Patient patient) {
		sickLeaveService.saveSickLeavePatient(sickleave_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Get Patient entity by SickLeave
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/patient", method = RequestMethod.GET)
	@ResponseBody
	public Patient getSickLeavePatient(@PathVariable Integer sickleave_id) {
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getPatient();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave", method = RequestMethod.POST)
	@ResponseBody
	public SickLeave newSickLeave(@RequestBody SickLeave sickleave) {
		sickLeaveService.saveSickLeave(sickleave);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/visit", method = RequestMethod.POST)
	@ResponseBody
	public Visit newSickLeaveVisit(@PathVariable Integer sickleave_id, @RequestBody Visit visit) {
		sickLeaveService.saveSickLeaveVisit(sickleave_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSickLeave(@PathVariable Integer sickleave_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id);
		sickLeaveService.deleteSickLeave(sickleave);
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/visit", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveSickLeaveVisit(@PathVariable Integer sickleave_id, @RequestBody Visit visit) {
		sickLeaveService.saveSickLeaveVisit(sickleave_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Get Doctor entity by SickLeave
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getSickLeaveDoctor(@PathVariable Integer sickleave_id) {
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getDoctor();
	}

	/**
	 * Get Visit entity by SickLeave
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/visit", method = RequestMethod.GET)
	@ResponseBody
	public Visit getSickLeaveVisit(@PathVariable Integer sickleave_id) {
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getVisit();
	}

	/**
	 * Show all SickLeave entities
	 * 
	 */
	@RequestMapping(value = "/SickLeave", method = RequestMethod.GET)
	@ResponseBody
	public List<SickLeave> listSickLeaves() {
		return new java.util.ArrayList<SickLeave>(sickLeaveService.loadSickLeaves());
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/patient", method = RequestMethod.PUT)
	@ResponseBody
	public Patient saveSickLeavePatient(@PathVariable Integer sickleave_id, @RequestBody Patient patient) {
		sickLeaveService.saveSickLeavePatient(sickleave_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newSickLeaveDoctor(@PathVariable Integer sickleave_id, @RequestBody Doctor doctor) {
		sickLeaveService.saveSickLeaveDoctor(sickleave_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadSickLeaveDoctor(@PathVariable Integer sickleave_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
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
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/SickLeave/{sickleave_id}/patient/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadSickLeavePatient(@PathVariable Integer sickleave_id, @PathVariable Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return patient;
	}
}