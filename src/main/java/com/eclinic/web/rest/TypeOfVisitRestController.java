package com.eclinic.web.rest;

import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.TypeOfVisitService;

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
 * Spring Rest controller that handles CRUD requests for TypeOfVisit entities
 * 
 */

@Controller("TypeOfVisitRestController")
public class TypeOfVisitRestController {

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
	 * Service injected by Spring that provides CRUD operations for TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitService typeOfVisitService;

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}/visits/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadTypeOfVisitVisits(@PathVariable Integer typeofvisit_id, @PathVariable Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return visit;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}/visits/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTypeOfVisitVisits(@PathVariable Integer typeofvisit_id, @PathVariable Integer related_visits_id) {
		typeOfVisitService.deleteTypeOfVisitVisits(typeofvisit_id, related_visits_id);
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
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTypeOfVisit(@PathVariable Integer typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id);
		typeOfVisitService.deleteTypeOfVisit(typeofvisit);
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit", method = RequestMethod.PUT)
	@ResponseBody
	public TypeOfVisit saveTypeOfVisit(@RequestBody TypeOfVisit typeofvisit) {
		typeOfVisitService.saveTypeOfVisit(typeofvisit);
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId());
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit", method = RequestMethod.POST)
	@ResponseBody
	public TypeOfVisit newTypeOfVisit(@RequestBody TypeOfVisit typeofvisit) {
		typeOfVisitService.saveTypeOfVisit(typeofvisit);
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId());
	}

	/**
	 * Show all Visit entities by TypeOfVisit
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}/visits", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> getTypeOfVisitVisits(@PathVariable Integer typeofvisit_id) {
		return new java.util.ArrayList<Visit>(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id).getVisits());
	}

	/**
	 * Show all TypeOfVisit entities
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit", method = RequestMethod.GET)
	@ResponseBody
	public List<TypeOfVisit> listTypeOfVisits() {
		return new java.util.ArrayList<TypeOfVisit>(typeOfVisitService.loadTypeOfVisits());
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}/visits", method = RequestMethod.POST)
	@ResponseBody
	public Visit newTypeOfVisitVisits(@PathVariable Integer typeofvisit_id, @RequestBody Visit visit) {
		typeOfVisitService.saveTypeOfVisitVisits(typeofvisit_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}

	/**
	 * Select an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}", method = RequestMethod.GET)
	@ResponseBody
	public TypeOfVisit loadTypeOfVisit(@PathVariable Integer typeofvisit_id) {
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id);
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfVisit/{typeofvisit_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveTypeOfVisitVisits(@PathVariable Integer typeofvisit_id, @RequestBody Visit visits) {
		typeOfVisitService.saveTypeOfVisitVisits(typeofvisit_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
	}
}