package com.eclinic.web.rest;

import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.service.SpecalVisitFieldService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for SpecalVisitField entities
 * 
 */
@Path("/SpecalVisit")
@Component("SpecalVisitFieldRestController")
public class SpecalVisitFieldRestController {

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
	 * Service injected by Spring that provides CRUD operations for SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldService specalVisitFieldService;

	public SpecalVisitFieldRestController() {
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
	 * Show all SpecalVisitField entities
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField", method = RequestMethod.GET)
	@ResponseBody
	public List<SpecalVisitField> listSpecalVisitFields() {
		return new java.util.ArrayList<SpecalVisitField>(specalVisitFieldService.loadSpecalVisitFields());
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}/specialization/{specialization_id}", method = RequestMethod.GET)
	@ResponseBody
	public Specialization loadSpecalVisitFieldSpecialization(@PathVariable Integer specalvisitfield_id, @PathVariable Integer related_specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		return specialization;
	}

	/**
	 * Select an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}", method = RequestMethod.GET)
	@ResponseBody
	public SpecalVisitField loadSpecalVisitField(@PathVariable Integer specalvisitfield_id) {
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id);
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}/specialization", method = RequestMethod.PUT)
	@ResponseBody
	public Specialization saveSpecalVisitFieldSpecialization(@PathVariable Integer specalvisitfield_id, @RequestBody Specialization specialization) {
		specalVisitFieldService.saveSpecalVisitFieldSpecialization(specalvisitfield_id, specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField", method = RequestMethod.PUT)
	@ResponseBody
	public SpecalVisitField saveSpecalVisitField(@RequestBody SpecalVisitField specalvisitfield) {
		specalVisitFieldService.saveSpecalVisitField(specalvisitfield);
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId());
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}/specialization/{specialization_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecalVisitFieldSpecialization(@PathVariable Integer specalvisitfield_id, @PathVariable Integer related_specialization_id) {
		specalVisitFieldService.deleteSpecalVisitFieldSpecialization(specalvisitfield_id, related_specialization_id);
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecalVisitField(@PathVariable Integer specalvisitfield_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id);
		specalVisitFieldService.deleteSpecalVisitField(specalvisitfield);
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}/specialization", method = RequestMethod.POST)
	@ResponseBody
	public Specialization newSpecalVisitFieldSpecialization(@PathVariable Integer specalvisitfield_id, @RequestBody Specialization specialization) {
		specalVisitFieldService.saveSpecalVisitFieldSpecialization(specalvisitfield_id, specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}

	

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField", method = RequestMethod.POST)
	@ResponseBody
	public SpecalVisitField newSpecalVisitField(@RequestBody SpecalVisitField specalvisitfield) {
		specalVisitFieldService.saveSpecalVisitField(specalvisitfield);
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId());
	}

	/**
	 * Get Specialization entity by SpecalVisitField
	 * 
	 */
	@RequestMapping(value = "/SpecalVisitField/{specalvisitfield_id}/specialization", method = RequestMethod.GET)
	@ResponseBody
	public Specialization getSpecalVisitFieldSpecialization(@PathVariable Integer specalvisitfield_id) {
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id).getSpecialization();
	}
}