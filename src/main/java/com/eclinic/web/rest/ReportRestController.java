package com.eclinic.web.rest;

import com.eclinic.dao.ReportDAO;

import com.eclinic.domain.Report;

import com.eclinic.service.ReportService;

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
 * Spring Rest controller that handles CRUD requests for Report entities
 * 
 */

@Controller("ReportRestController")
public class ReportRestController {

	/**
	 * DAO injected by Spring that manages Report entities
	 * 
	 */
	@Autowired
	private ReportDAO reportDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Report entities
	 * 
	 */
	@Autowired
	private ReportService reportService;

	/**
	 * Save an existing Report entity
	 * 
	 */
	@RequestMapping(value = "/Report", method = RequestMethod.PUT)
	@ResponseBody
	public Report saveReport(@RequestBody Report report) {
		reportService.saveReport(report);
		return reportDAO.findReportByPrimaryKey(report.getId());
	}

	/**
	 * Create a new Report entity
	 * 
	 */
	@RequestMapping(value = "/Report", method = RequestMethod.POST)
	@ResponseBody
	public Report newReport(@RequestBody Report report) {
		reportService.saveReport(report);
		return reportDAO.findReportByPrimaryKey(report.getId());
	}

	/**
	 * Show all Report entities
	 * 
	 */
	@RequestMapping(value = "/Report", method = RequestMethod.GET)
	@ResponseBody
	public List<Report> listReports() {
		return new java.util.ArrayList<Report>(reportService.loadReports());
	}

	/**
	 * Select an existing Report entity
	 * 
	 */
	@RequestMapping(value = "/Report/{report_id}", method = RequestMethod.GET)
	@ResponseBody
	public Report loadReport(@PathVariable Integer report_id) {
		return reportDAO.findReportByPrimaryKey(report_id);
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
	 * Delete an existing Report entity
	 * 
	 */
	@RequestMapping(value = "/Report/{report_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteReport(@PathVariable Integer report_id) {
		Report report = reportDAO.findReportByPrimaryKey(report_id);
		reportService.deleteReport(report);
	}
}