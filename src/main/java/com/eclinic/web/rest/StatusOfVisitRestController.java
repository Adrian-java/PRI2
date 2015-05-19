package com.eclinic.web.rest;

import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.StatusOfVisitService;

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
 * Spring Rest controller that handles CRUD requests for StatusOfVisit entities
 * 
 */

@Controller("StatusOfVisitRestController")
public class StatusOfVisitRestController {

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitService statusOfVisitService;

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveStatusOfVisitVisits(@PathVariable Integer statusofvisit_id, @RequestBody Visit visits) {
		statusOfVisitService.saveStatusOfVisitVisits(statusofvisit_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
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
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteStatusOfVisitVisits(@PathVariable Integer statusofvisit_id, @PathVariable Integer related_visits_id) {
		statusOfVisitService.deleteStatusOfVisitVisits(statusofvisit_id, related_visits_id);
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit", method = RequestMethod.POST)
	@ResponseBody
	public StatusOfVisit newStatusOfVisit(@RequestBody StatusOfVisit statusofvisit) {
		statusOfVisitService.saveStatusOfVisit(statusofvisit);
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId());
	}

	/**
	 * Select an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}", method = RequestMethod.GET)
	@ResponseBody
	public StatusOfVisit loadStatusOfVisit(@PathVariable Integer statusofvisit_id) {
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id);
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits", method = RequestMethod.POST)
	@ResponseBody
	public Visit newStatusOfVisitVisits(@PathVariable Integer statusofvisit_id, @RequestBody Visit visit) {
		statusOfVisitService.saveStatusOfVisitVisits(statusofvisit_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Show all StatusOfVisit entities
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit", method = RequestMethod.GET)
	@ResponseBody
	public List<StatusOfVisit> listStatusOfVisits() {
		return new java.util.ArrayList<StatusOfVisit>(statusOfVisitService.loadStatusOfVisits());
	}

	/**
	 * Show all Visit entities by StatusOfVisit
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> getStatusOfVisitVisits(@PathVariable Integer statusofvisit_id) {
		return new java.util.ArrayList<Visit>(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id).getVisits());
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteStatusOfVisit(@PathVariable Integer statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id);
		statusOfVisitService.deleteStatusOfVisit(statusofvisit);
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadStatusOfVisitVisits(@PathVariable Integer statusofvisit_id, @PathVariable Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return visit;
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit", method = RequestMethod.PUT)
	@ResponseBody
	public StatusOfVisit saveStatusOfVisit(@RequestBody StatusOfVisit statusofvisit) {
		statusOfVisitService.saveStatusOfVisit(statusofvisit);
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId());
	}
}