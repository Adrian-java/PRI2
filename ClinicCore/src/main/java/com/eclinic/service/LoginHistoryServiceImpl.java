package com.eclinic.service;

import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.SystemUserDAO;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.SystemUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for LoginHistory entities
 * 
 */

@Service("LoginHistoryService")
@Transactional
public class LoginHistoryServiceImpl implements LoginHistoryService {

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * Instantiates a new LoginHistoryServiceImpl.
	 *
	 */
	public LoginHistoryServiceImpl() {
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public LoginHistory deleteLoginHistorySystemUser(Integer loginhistory_id, Integer related_systemuser_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		loginhistory = loginHistoryDAO.store(loginhistory);
		loginHistoryDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return loginhistory;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public LoginHistory saveLoginHistorySystemUser(Integer id, SystemUser related_systemuser) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			existingsystemUser.setRole(related_systemuser.getRole());
			existingsystemUser.setPesel(related_systemuser.getPesel());
			related_systemuser = existingsystemUser;
		} else {
			related_systemuser = systemUserDAO.store(related_systemuser);
			systemUserDAO.flush();
		}

		loginhistory = loginHistoryDAO.store(loginhistory);
		loginHistoryDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return loginhistory;
	}

	/**
	 */
	@Transactional
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id) {
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(id);
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public void saveLoginHistory(LoginHistory loginhistory) {
		LoginHistory existingLoginHistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId());

		if (existingLoginHistory != null) {
			if (existingLoginHistory != loginhistory) {
				existingLoginHistory.setId(loginhistory.getId());
				existingLoginHistory.setDateLogin(loginhistory.getDateLogin());
				existingLoginHistory.setSessionNumber(loginhistory.getSessionNumber());
				existingLoginHistory.setDateLogout(loginhistory.getDateLogout());
			}
			loginhistory = loginHistoryDAO.store(existingLoginHistory);
		} else {
			loginhistory = loginHistoryDAO.store(loginhistory);
		}
		loginHistoryDAO.flush();
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public void deleteLoginHistory(LoginHistory loginhistory) {
		loginHistoryDAO.remove(loginhistory);
		loginHistoryDAO.flush();
	}

	/**
	 * Load an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public Set<LoginHistory> loadLoginHistorys() {
		return loginHistoryDAO.findAllLoginHistorys();
	}

	/**
	 * Return a count of all LoginHistory entity
	 * 
	 */
	@Transactional
	public Integer countLoginHistorys() {
		return ((Long) loginHistoryDAO.createQuerySingleResult("select count(o) from LoginHistory o").getSingleResult()).intValue();
	}

	/**
	 * Return all LoginHistory entity
	 * 
	 */
	@Transactional
	public List<LoginHistory> findAllLoginHistorys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<LoginHistory>(loginHistoryDAO.findAllLoginHistorys(startResult, maxRows));
	}
}
