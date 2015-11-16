package com.eclinic.service;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.SystemUser;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for LoginHistory entities
 * 
 */
public interface LoginHistoryService {

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public LoginHistory deleteLoginHistorySystemUser(Integer loginhistory_id, Integer related_systemuser_id);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public LoginHistory saveLoginHistorySystemUser(Integer id, SystemUser related_systemuser);

	/**
	 */
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id_1);

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	public void saveLoginHistory(LoginHistory loginhistory);

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	public void deleteLoginHistory(LoginHistory loginhistory_1);

	/**
	 * Load an existing LoginHistory entity
	 * 
	 */
	public Set<LoginHistory> loadLoginHistorys();

	/**
	 * Return a count of all LoginHistory entity
	 * 
	 */
	public Integer countLoginHistorys();

	/**
	 * Return all LoginHistory entity
	 * 
	 */
	public List<LoginHistory> findAllLoginHistorys(Integer startResult, Integer maxRows);
}