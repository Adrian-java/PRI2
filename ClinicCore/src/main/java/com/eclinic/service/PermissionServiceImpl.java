package com.eclinic.service;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserPermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;
import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUserPermission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */

@Service("PermissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

	/**
	 * DAO injected by Spring that manages Module entities
	 * 
	 */
	@Autowired
	private ModuleDAO moduleDAO;

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages SystemUserPermission entities
	 * 
	 */
	@Autowired
	private SystemUserPermissionDAO systemUserPermissionDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Instantiates a new PermissionServiceImpl.
	 *
	 */
	public PermissionServiceImpl() {
	}

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	@Transactional
	public Integer countPermissions() {
		return ((Long) permissionDAO.createQuerySingleResult("select count(o) from Permission o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionModule(Integer permission_id, Integer related_module_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);
		Module related_module = moduleDAO.findModuleByPrimaryKey(related_module_id, -1, -1);

		permission.setModule(null);
		related_module.getPermissions().remove(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_module = moduleDAO.store(related_module);
		moduleDAO.flush();

		moduleDAO.remove(related_module);
		moduleDAO.flush();

		return permission;
	}

	/**
	 * Load an existing Permission entity
	 * 
	 */
	@Transactional
	public Set<Permission> loadPermissions() {
		return permissionDAO.findAllPermissions();
	}



	/**
	 */
	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id) {
		return permissionDAO.findPermissionByPrimaryKey(id);
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@Transactional
	public Permission savePermissionModule(Integer id, Module related_module) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
		Module existingmodule = moduleDAO.findModuleByPrimaryKey(related_module.getId());

		// copy into the existing record to preserve existing relationships
		if (existingmodule != null) {
			existingmodule.setId(related_module.getId());
			existingmodule.setName(related_module.getName());
			existingmodule.setVisibility(related_module.getVisibility());
			related_module = existingmodule;
		}

		permission.setModule(related_module);
		related_module.getPermissions().add(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_module = moduleDAO.store(related_module);
		moduleDAO.flush();

		return permission;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public void deletePermission(Permission permission) {
		permissionDAO.remove(permission);
		permissionDAO.flush();
	}

	/**
	 * Return all Permission entity
	 * 
	 */
	@Transactional
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Permission>(permissionDAO.findAllPermissions(startResult, maxRows));
	}


	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public void savePermission(Permission permission) {
		Permission existingPermission = permissionDAO.findPermissionByPrimaryKey(permission.getId());

		if (existingPermission != null) {
			if (existingPermission != permission) {
				existingPermission.setId(permission.getId());
				existingPermission.setDisplay(permission.getDisplay());
				existingPermission.setExecute(permission.getExecute());
				existingPermission.setEdit(permission.getEdit());
			}
			permission = permissionDAO.store(existingPermission);
		} else {
			permission = permissionDAO.store(permission);
		}
		permissionDAO.flush();
	}

}
