package com.eclinic.service;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUserPermission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */
public interface PermissionService {

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	public Integer countPermissions();

	/**
	 * Delete an existing Module entity
	 * 
	 */
	public Permission deletePermissionModule(Integer permission_id, Integer related_module_id);

	/**
	 * Load an existing Permission entity
	 * 
	 */
	public Set<Permission> loadPermissions();



	/**
	 */
	public Permission findPermissionByPrimaryKey(Integer id_1);

	/**
	 * Save an existing Module entity
	 * 
	 */
	public Permission savePermissionModule(Integer id_2, Module related_module);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public void deletePermission(Permission permission);


	/**
	 * Return all Permission entity
	 * 
	 */
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows);


	/**
	 * Save an existing Permission entity
	 * 
	 */
	public void savePermission(Permission permission_1);
}