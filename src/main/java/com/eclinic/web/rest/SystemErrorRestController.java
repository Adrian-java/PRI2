package com.eclinic.web.rest;

import com.eclinic.dao.SystemErrorDAO;

import com.eclinic.domain.SystemError;

import com.eclinic.service.SystemErrorService;

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
 * Spring Rest controller that handles CRUD requests for SystemError entities
 * 
 */

@Controller("SystemErrorRestController")
public class SystemErrorRestController {

	/**
	 * DAO injected by Spring that manages SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorDAO systemErrorDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorService systemErrorService;

	/**
	 * Save an existing SystemError entity
	 * 
	 */
	@RequestMapping(value = "/SystemError", method = RequestMethod.PUT)
	@ResponseBody
	public SystemError saveSystemError(@RequestBody SystemError systemerror) {
		systemErrorService.saveSystemError(systemerror);
		return systemErrorDAO.findSystemErrorByPrimaryKey(systemerror.getId());
	}

	/**
	 * Delete an existing SystemError entity
	 * 
	 */
	@RequestMapping(value = "/SystemError/{systemerror_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSystemError(@PathVariable Integer systemerror_id) {
		SystemError systemerror = systemErrorDAO.findSystemErrorByPrimaryKey(systemerror_id);
		systemErrorService.deleteSystemError(systemerror);
	}

	/**
	 * Show all SystemError entities
	 * 
	 */
	@RequestMapping(value = "/SystemError", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemError> listSystemErrors() {
		return new java.util.ArrayList<SystemError>(systemErrorService.loadSystemErrors());
	}

	/**
	 * Create a new SystemError entity
	 * 
	 */
	@RequestMapping(value = "/SystemError", method = RequestMethod.POST)
	@ResponseBody
	public SystemError newSystemError(@RequestBody SystemError systemerror) {
		systemErrorService.saveSystemError(systemerror);
		return systemErrorDAO.findSystemErrorByPrimaryKey(systemerror.getId());
	}

	/**
	 * Select an existing SystemError entity
	 * 
	 */
	@RequestMapping(value = "/SystemError/{systemerror_id}", method = RequestMethod.GET)
	@ResponseBody
	public SystemError loadSystemError(@PathVariable Integer systemerror_id) {
		return systemErrorDAO.findSystemErrorByPrimaryKey(systemerror_id);
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