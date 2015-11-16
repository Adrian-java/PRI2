package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.SystemUser;

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
	public Admin saveAdminSystemUser(Integer id, SystemUser related_systemuser);

	/**
	 * Return a count of all Admin entity
	 * 
	 */
	public Integer countAdmins();

	/**
	 */
	public Admin findAdminByPrimaryKey(Integer id_1);

	/**
	 * Save an existing Admin entity
	 * 
	 */
	public void saveAdmin(Admin admin);

	/**
	 * Load an existing Admin entity
	 * 
	 */
	public Set<Admin> loadAdmins();

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Admin deleteAdminSystemUser(Integer admin_id, Integer related_systemuser_id);

	/**
	 * Return all Admin entity
	 * 
	 */
	public List<Admin> findAllAdmins(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	public void deleteAdmin(Admin admin_1);
}