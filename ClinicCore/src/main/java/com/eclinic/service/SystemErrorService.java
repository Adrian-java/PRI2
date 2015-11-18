package com.eclinic.service;

import com.eclinic.domain.SystemError;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SystemError entities
 * 
 */
public interface SystemErrorService {

	/**
	 * Delete an existing SystemError entity
	 * 
	 */
	public void deleteSystemError(SystemError systemerror);

	/**
	 * Return all SystemError entity
	 * 
	 */
	public List<SystemError> findAllSystemErrors(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all SystemError entity
	 * 
	 */
	public Integer countSystemErrors();

	/**
	 * Save an existing SystemError entity
	 * 
	 */
	public void saveSystemError(SystemError systemerror_1);

	/**
	 */
	public SystemError findSystemErrorByPrimaryKey(Integer id);

	/**
	 * Load an existing SystemError entity
	 * 
	 */
	public Set<SystemError> loadSystemErrors();
}