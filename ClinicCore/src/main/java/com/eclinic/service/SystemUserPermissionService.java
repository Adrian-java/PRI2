package com.eclinic.service;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.SystemUserPermission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SystemUserPermission entities
 * 
 */
public interface SystemUserPermissionService {

	/**
	 * Return a count of all SystemUserPermission entity
	 * 
	 */
	public Integer countSystemUserPermissions();

	/**
	 * Return all SystemUserPermission entity
	 * 
	 */
	public List<SystemUserPermission> findAllSystemUserPermissions(Integer startResult, Integer maxRows);

	/**
	 */
	public SystemUserPermission findSystemUserPermissionByPrimaryKey(Integer id);

	/**
	 * Save an existing SystemUserPermission entity
	 * 
	 */
	public void saveSystemUserPermission(SystemUserPermission systemuserpermission);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public SystemUserPermission deleteSystemUserPermissionPermission(Integer systemuserpermission_id, Integer related_permission_id);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public SystemUserPermission saveSystemUserPermissionSystemUsers(Integer id_1, SystemUser related_systemusers);

	/**
	 * Delete an existing SystemUserPermission entity
	 * 
	 */
	public void deleteSystemUserPermission(SystemUserPermission systemuserpermission_1);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public SystemUserPermission saveSystemUserPermissionPermission(Integer id_2, Permission related_permission);

	/**
	 * Load an existing SystemUserPermission entity
	 * 
	 */
	public Set<SystemUserPermission> loadSystemUserPermissions();

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public SystemUserPermission deleteSystemUserPermissionSystemUsers(Integer systemuserpermission_id_1, String related_systemusers_id);
}