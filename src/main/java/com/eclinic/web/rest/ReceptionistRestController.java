package com.eclinic.web.rest;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
import com.eclinic.domain.Worker;

import com.eclinic.service.ReceptionistService;

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
 * Spring Rest controller that handles CRUD requests for Receptionist entities
 * 
 */

@Controller("ReceptionistRestController")
public class ReceptionistRestController {

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistService receptionistService;

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/workers", method = RequestMethod.POST)
	@ResponseBody
	public Worker newReceptionistWorkers(@PathVariable Integer receptionist_id, @RequestBody Worker worker) {
		receptionistService.saveReceptionistWorkers(receptionist_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/visits/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadReceptionistVisits(@PathVariable Integer receptionist_id, @PathVariable Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return visit;
	}

	/**
	 * Show all Receptionist entities
	 * 
	 */
	@RequestMapping(value = "/Receptionist", method = RequestMethod.GET)
	@ResponseBody
	public List<Receptionist> listReceptionists() {
		return new java.util.ArrayList<Receptionist>(receptionistService.loadReceptionists());
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/workers/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteReceptionistWorkers(@PathVariable Integer receptionist_id, @PathVariable Integer related_workers_id) {
		receptionistService.deleteReceptionistWorkers(receptionist_id, related_workers_id);
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist", method = RequestMethod.POST)
	@ResponseBody
	public Receptionist newReceptionist(@RequestBody Receptionist receptionist) {
		receptionistService.saveReceptionist(receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * Select an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}", method = RequestMethod.GET)
	@ResponseBody
	public Receptionist loadReceptionist(@PathVariable Integer receptionist_id) {
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist_id);
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteReceptionist(@PathVariable Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id);
		receptionistService.deleteReceptionist(receptionist);
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/visits", method = RequestMethod.POST)
	@ResponseBody
	public Visit newReceptionistVisits(@PathVariable Integer receptionist_id, @RequestBody Visit visit) {
		receptionistService.saveReceptionistVisits(receptionist_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist", method = RequestMethod.PUT)
	@ResponseBody
	public Receptionist saveReceptionist(@RequestBody Receptionist receptionist) {
		receptionistService.saveReceptionist(receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/workers", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveReceptionistWorkers(@PathVariable Integer receptionist_id, @RequestBody Worker workers) {
		receptionistService.saveReceptionistWorkers(receptionist_id, workers);
		return workerDAO.findWorkerByPrimaryKey(workers.getId());
	}

	/**
	 * Show all Visit entities by Receptionist
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/visits", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> getReceptionistVisits(@PathVariable Integer receptionist_id) {
		return new java.util.ArrayList<Visit>(receptionistDAO.findReceptionistByPrimaryKey(receptionist_id).getVisits());
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
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/visits/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteReceptionistVisits(@PathVariable Integer receptionist_id, @PathVariable Integer related_visits_id) {
		receptionistService.deleteReceptionistVisits(receptionist_id, related_visits_id);
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveReceptionistVisits(@PathVariable Integer receptionist_id, @RequestBody Visit visits) {
		receptionistService.saveReceptionistVisits(receptionist_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
	}

	/**
	 * Show all Worker entities by Receptionist
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/workers", method = RequestMethod.GET)
	@ResponseBody
	public List<Worker> getReceptionistWorkers(@PathVariable Integer receptionist_id) {
		return new java.util.ArrayList<Worker>(receptionistDAO.findReceptionistByPrimaryKey(receptionist_id).getWorkers());
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Receptionist/{receptionist_id}/workers/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadReceptionistWorkers(@PathVariable Integer receptionist_id, @PathVariable Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return worker;
	}
}