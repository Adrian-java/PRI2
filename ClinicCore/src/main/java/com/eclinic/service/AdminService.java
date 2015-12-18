package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.AdminView;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Admin entities
 * 
 */
public interface AdminService {

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Admin saveAdminSystemUser(String id, SystemUser related_systemuser);

	/**
	 * Return a count of all Admin entity
	 * 
	 */
	public Integer countAdmins();

	/**
	 */
	public Admin findAdminByPrimaryKey(String id_1);

	/**
	 * Save an existing Admin entity
	 * 
	 */
	public void saveAdmin(Admin admin);

	/**
	 * Load an existing Admin entity
	 * 
	 */
	public Set<AdminView> loadAdmins();

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Admin deleteAdminSystemUser(String admin_id, String related_systemuser_id);

	/**
	 * Return all Admin entity
	 * 
	 */
	public List<AdminView> findAllAdmins(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	public void deleteAdmin(Admin admin_1);
}