package com.eclinic.service;

import com.eclinic.domain.Report;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Report entities
 * 
 */
public interface ReportService {

	/**
	 * Save an existing Report entity
	 * 
	 */
	public void saveReport(Report report);

	/**
	 */
	public Report findReportByPrimaryKey(Integer id);

	/**
	 * Load an existing Report entity
	 * 
	 */
	public Set<Report> loadReports();

	/**
	 * Delete an existing Report entity
	 * 
	 */
	public void deleteReport(Report report_1);

	/**
	 * Return a count of all Report entity
	 * 
	 */
	public Integer countReports();

	/**
	 * Return all Report entity
	 * 
	 */
	public List<Report> findAllReports(Integer startResult, Integer maxRows);
}