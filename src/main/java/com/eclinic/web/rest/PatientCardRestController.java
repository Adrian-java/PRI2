package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;

import com.eclinic.service.PatientCardService;

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
 * Spring Rest controller that handles CRUD requests for PatientCard entities
 * 
 */

@Controller("PatientCardRestController")
public class PatientCardRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardService patientCardService;

	/**
	 * Show all PatientCard entities
	 * 
	 */
	@RequestMapping(value = "/PatientCard", method = RequestMethod.GET)
	@ResponseBody
	public List<PatientCard> listPatientCards() {
		return new java.util.ArrayList<PatientCard>(patientCardService.loadPatientCards());
	}

	/**
	 * Get Doctor entity by PatientCard
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getPatientCardDoctor(@PathVariable Integer patientcard_id) {
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getDoctor();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newPatientCardDoctor(@PathVariable Integer patientcard_id, @RequestBody Doctor doctor) {
		patientCardService.savePatientCardDoctor(patientcard_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientCard(@PathVariable Integer patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id);
		patientCardService.deletePatientCard(patientcard);
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/patient", method = RequestMethod.PUT)
	@ResponseBody
	public Patient savePatientCardPatient(@PathVariable Integer patientcard_id, @RequestBody Patient patient) {
		patientCardService.savePatientCardPatient(patientcard_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/visits", method = RequestMethod.POST)
	@ResponseBody
	public Visit newPatientCardVisits(@PathVariable Integer patientcard_id, @RequestBody Visit visit) {
		patientCardService.savePatientCardVisits(patientcard_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/patient/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientCardPatient(@PathVariable Integer patientcard_id, @PathVariable Integer related_patient_id) {
		patientCardService.deletePatientCardPatient(patientcard_id, related_patient_id);
	}

	/**
	 * Show all Visit entities by PatientCard
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/visits", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> getPatientCardVisits(@PathVariable Integer patientcard_id) {
		return new java.util.ArrayList<Visit>(patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getVisits());
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor savePatientCardDoctor(@PathVariable Integer patientcard_id, @RequestBody Doctor doctor) {
		patientCardService.savePatientCardDoctor(patientcard_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit savePatientCardVisits(@PathVariable Integer patientcard_id, @RequestBody Visit visits) {
		patientCardService.savePatientCardVisits(patientcard_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/visits/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientCardVisits(@PathVariable Integer patientcard_id, @PathVariable Integer related_visits_id) {
		patientCardService.deletePatientCardVisits(patientcard_id, related_visits_id);
	}

	/**
	 * Select an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}", method = RequestMethod.GET)
	@ResponseBody
	public PatientCard loadPatientCard(@PathVariable Integer patientcard_id) {
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard_id);
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard", method = RequestMethod.POST)
	@ResponseBody
	public PatientCard newPatientCard(@RequestBody PatientCard patientcard) {
		patientCardService.savePatientCard(patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadPatientCardDoctor(@PathVariable Integer patientcard_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/visits/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadPatientCardVisits(@PathVariable Integer patientcard_id, @PathVariable Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return visit;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientCardDoctor(@PathVariable Integer patientcard_id, @PathVariable Integer related_doctor_id) {
		patientCardService.deletePatientCardDoctor(patientcard_id, related_doctor_id);
	}

	/**
	 * Get Patient entity by PatientCard
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/patient", method = RequestMethod.GET)
	@ResponseBody
	public Patient getPatientCardPatient(@PathVariable Integer patientcard_id) {
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getPatient();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard/{patientcard_id}/patient", method = RequestMethod.POST)
	@ResponseBody
	public Patient newPatientCardPatient(@PathVariable Integer patientcard_id, @RequestBody Patient patient) {
		patientCardService.savePatientCardPatient(patientcard_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
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
	@RequestMapping(value = "/PatientCard/{patientcard_id}/patient/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadPatientCardPatient(@PathVariable Integer patientcard_id, @PathVariable Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return patient;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/PatientCard", method = RequestMethod.PUT)
	@ResponseBody
	public PatientCard savePatientCard(@RequestBody PatientCard patientcard) {
		patientCardService.savePatientCard(patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}
}