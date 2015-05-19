package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.VisitService;

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
 * Spring Rest controller that handles CRUD requests for Visit entities
 * 
 */

@Controller("VisitRestController")
public class VisitRestController {

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
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Visit entities
	 * 
	 */
	@Autowired
	private VisitService visitService;

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/typeOfVisit/{typeofvisit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitTypeOfVisit(@PathVariable Integer visit_id, @PathVariable Integer related_typeofvisit_id) {
		visitService.deleteVisitTypeOfVisit(visit_id, related_typeofvisit_id);
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/sickLeaves/{sickleave_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitSickLeaves(@PathVariable Integer visit_id, @PathVariable Integer related_sickleaves_id) {
		visitService.deleteVisitSickLeaves(visit_id, related_sickleaves_id);
	}

	/**
	 * View an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/typeOfVisit/{typeofvisit_id}", method = RequestMethod.GET)
	@ResponseBody
	public TypeOfVisit loadVisitTypeOfVisit(@PathVariable Integer visit_id, @PathVariable Integer related_typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit_id, -1, -1);

		return typeofvisit;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitDoctor(@PathVariable Integer visit_id, @PathVariable Integer related_doctor_id) {
		visitService.deleteVisitDoctor(visit_id, related_doctor_id);
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/Visit", method = RequestMethod.POST)
	@ResponseBody
	public Visit newVisit(@RequestBody Visit visit) {
		visitService.saveVisit(visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Get TypeOfVisit entity by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/typeOfVisit", method = RequestMethod.GET)
	@ResponseBody
	public TypeOfVisit getVisitTypeOfVisit(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id).getTypeOfVisit();
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/sickLeaves/{sickleave_id}", method = RequestMethod.GET)
	@ResponseBody
	public SickLeave loadVisitSickLeaves(@PathVariable Integer visit_id, @PathVariable Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return sickleave;
	}

	/**
	 * Get StatusOfVisit entity by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/statusOfVisit", method = RequestMethod.GET)
	@ResponseBody
	public StatusOfVisit getVisitStatusOfVisit(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id).getStatusOfVisit();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/receptionist/{receptionist_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitReceptionist(@PathVariable Integer visit_id, @PathVariable Integer related_receptionist_id) {
		visitService.deleteVisitReceptionist(visit_id, related_receptionist_id);
	}

	/**
	 * Show all SickLeave entities by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/sickLeaves", method = RequestMethod.GET)
	@ResponseBody
	public List<SickLeave> getVisitSickLeaves(@PathVariable Integer visit_id) {
		return new java.util.ArrayList<SickLeave>(visitDAO.findVisitByPrimaryKey(visit_id).getSickLeaves());
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/statusOfVisit", method = RequestMethod.POST)
	@ResponseBody
	public StatusOfVisit newVisitStatusOfVisit(@PathVariable Integer visit_id, @RequestBody StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId());
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/patientCard/{patientcard_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitPatientCard(@PathVariable Integer visit_id, @PathVariable Integer related_patientcard_id) {
		visitService.deleteVisitPatientCard(visit_id, related_patientcard_id);
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/sickLeaves", method = RequestMethod.PUT)
	@ResponseBody
	public SickLeave saveVisitSickLeaves(@PathVariable Integer visit_id, @RequestBody SickLeave sickleaves) {
		visitService.saveVisitSickLeaves(visit_id, sickleaves);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId());
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadVisitDoctor(@PathVariable Integer visit_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/receptionist", method = RequestMethod.PUT)
	@ResponseBody
	public Receptionist saveVisitReceptionist(@PathVariable Integer visit_id, @RequestBody Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/statusOfVisit/{statusofvisit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisitStatusOfVisit(@PathVariable Integer visit_id, @PathVariable Integer related_statusofvisit_id) {
		visitService.deleteVisitStatusOfVisit(visit_id, related_statusofvisit_id);
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVisit(@PathVariable Integer visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id);
		visitService.deleteVisit(visit);
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/patientCard", method = RequestMethod.POST)
	@ResponseBody
	public PatientCard newVisitPatientCard(@PathVariable Integer visit_id, @RequestBody PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveVisitDoctor(@PathVariable Integer visit_id, @RequestBody Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Select an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadVisit(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id);
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/typeOfVisit", method = RequestMethod.POST)
	@ResponseBody
	public TypeOfVisit newVisitTypeOfVisit(@PathVariable Integer visit_id, @RequestBody TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId());
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
	 * Show all Visit entities
	 * 
	 */
	@RequestMapping(value = "/Visit", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> listVisits() {
		return new java.util.ArrayList<Visit>(visitService.loadVisits());
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/typeOfVisit", method = RequestMethod.PUT)
	@ResponseBody
	public TypeOfVisit saveVisitTypeOfVisit(@PathVariable Integer visit_id, @RequestBody TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId());
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/patientCard/{patientcard_id}", method = RequestMethod.GET)
	@ResponseBody
	public PatientCard loadVisitPatientCard(@PathVariable Integer visit_id, @PathVariable Integer related_patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcard_id, -1, -1);

		return patientcard;
	}

	/**
	 * Get Receptionist entity by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/receptionist", method = RequestMethod.GET)
	@ResponseBody
	public Receptionist getVisitReceptionist(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id).getReceptionist();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Visit", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveVisit(@RequestBody Visit visit) {
		visitService.saveVisit(visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/sickLeaves", method = RequestMethod.POST)
	@ResponseBody
	public SickLeave newVisitSickLeaves(@PathVariable Integer visit_id, @RequestBody SickLeave sickleave) {
		visitService.saveVisitSickLeaves(visit_id, sickleave);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/statusOfVisit", method = RequestMethod.PUT)
	@ResponseBody
	public StatusOfVisit saveVisitStatusOfVisit(@PathVariable Integer visit_id, @RequestBody StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId());
	}

	/**
	 * View an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/statusOfVisit/{statusofvisit_id}", method = RequestMethod.GET)
	@ResponseBody
	public StatusOfVisit loadVisitStatusOfVisit(@PathVariable Integer visit_id, @PathVariable Integer related_statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit_id, -1, -1);

		return statusofvisit;
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/receptionist/{receptionist_id}", method = RequestMethod.GET)
	@ResponseBody
	public Receptionist loadVisitReceptionist(@PathVariable Integer visit_id, @PathVariable Integer related_receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		return receptionist;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newVisitDoctor(@PathVariable Integer visit_id, @RequestBody Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Get PatientCard entity by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/patientCard", method = RequestMethod.GET)
	@ResponseBody
	public PatientCard getVisitPatientCard(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id).getPatientCard();
	}

	/**
	 * Get Doctor entity by Visit
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getVisitDoctor(@PathVariable Integer visit_id) {
		return visitDAO.findVisitByPrimaryKey(visit_id).getDoctor();
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/receptionist", method = RequestMethod.POST)
	@ResponseBody
	public Receptionist newVisitReceptionist(@PathVariable Integer visit_id, @RequestBody Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Visit/{visit_id}/patientCard", method = RequestMethod.PUT)
	@ResponseBody
	public PatientCard saveVisitPatientCard(@PathVariable Integer visit_id, @RequestBody PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}
}