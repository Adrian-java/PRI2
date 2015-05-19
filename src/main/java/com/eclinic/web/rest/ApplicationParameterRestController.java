package com.eclinic.web.rest;

import com.eclinic.dao.ApplicationParameterDAO;

import com.eclinic.domain.ApplicationParameter;

import com.eclinic.service.ApplicationParameterService;

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
 * Spring Rest controller that handles CRUD requests for ApplicationParameter entities
 * 
 */

@Controller("ApplicationParameterRestController")
public class ApplicationParameterRestController {

	/**
	 * DAO injected by Spring that manages ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterDAO applicationParameterDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterService applicationParameterService;

	/**
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.PUT)
	@ResponseBody
	public ApplicationParameter saveApplicationParameter(@RequestBody ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId());
	}

	/**
	 * Create a new ApplicationParameter entity
	 * 
	 */
	@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.POST)
	@ResponseBody
	public ApplicationParameter newApplicationParameter(@RequestBody ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId());
	}

	/**
	 * Show all ApplicationParameter entities
	 * 
	 */
	@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<ApplicationParameter> listApplicationParameters() {
		return new java.util.ArrayList<ApplicationParameter>(applicationParameterService.loadApplicationParameters());
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
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping(value = "/ApplicationParameter/{applicationparameter_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteApplicationParameter(@PathVariable Integer applicationparameter_id) {
		ApplicationParameter applicationparameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
		applicationParameterService.deleteApplicationParameter(applicationparameter);
	}

	/**
	 * Select an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping(value = "/ApplicationParameter/{applicationparameter_id}", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationParameter loadApplicationParameter(@PathVariable Integer applicationparameter_id) {
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
	}
}