package com.eclinic.service;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.SystemUserPermissionDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.SystemUserPermission;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SystemUserPermission entities
 * 
 */

@Service("SystemUserPermissionService")
@Transactional
public class SystemUserPermissionServiceImpl implements
		SystemUserPermissionService {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages SystemUserPermission entities
	 * 
	 */
	@Autowired
	private SystemUserPermissionDAO systemUserPermissionDAO;

	/**
	 * Instantiates a new SystemUserPermissionServiceImpl.
	 *
	 */
	public SystemUserPermissionServiceImpl() {
	}

	/**
	 * Return a count of all SystemUserPermission entity
	 * 
	 */
	@Transactional
	public Integer countSystemUserPermissions() {
		return ((Long) systemUserPermissionDAO.createQuerySingleResult("select count(o) from SystemUserPermission o").getSingleResult()).intValue();
	}

	/**
	 * Return all SystemUserPermission entity
	 * 
	 */
	@Transactional
	public List<SystemUserPermission> findAllSystemUserPermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SystemUserPermission>(systemUserPermissionDAO.findAllSystemUserPermissions());
	}

	/**
	 */
	@Transactional
	public SystemUserPermission findSystemUserPermissionByPrimaryKey(Integer id) {
		return systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(id);
	}

	/**
	 * Save an existing SystemUserPermission entity
	 * 
	 */
	@Transactional
	public void saveSystemUserPermission(SystemUserPermission systemuserpermission) {
		SystemUserPermission existingSystemUserPermission = systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(systemuserpermission.getId());

		if (existingSystemUserPermission != null) {
			if (existingSystemUserPermission != systemuserpermission) {
				existingSystemUserPermission.setId(systemuserpermission.getId());
			}
			systemuserpermission = systemUserPermissionDAO.store(existingSystemUserPermission);
		} else {
			systemuserpermission = systemUserPermissionDAO.store(systemuserpermission);
		}
		systemUserPermissionDAO.flush();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public SystemUserPermission deleteSystemUserPermissionPermission(Integer systemuserpermission_id, Integer related_permission_id) {
		SystemUserPermission systemuserpermission = systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(systemuserpermission_id);
		Permission related_permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		systemuserpermission.setPermission(null);
		related_permission.getSystemUserPermission().remove(systemuserpermission);
		systemuserpermission = systemUserPermissionDAO.store(systemuserpermission);
		systemUserPermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		permissionDAO.remove(related_permission);
		permissionDAO.flush();

		return systemuserpermission;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public SystemUserPermission saveSystemUserPermissionSystemUsers(Integer id, SystemUser related_systemusers) {
		SystemUserPermission systemuserpermission = systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(id);
		SystemUser existingsystemUsers = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUsers != null) {
			existingsystemUsers.setId(related_systemusers.getId());
			existingsystemUsers.setPassword(related_systemusers.getPassword());
			existingsystemUsers.setDescription(related_systemusers.getDescription());
			existingsystemUsers.setRegisterDate(related_systemusers.getRegisterDate());
			existingsystemUsers.setIsActive(related_systemusers.getIsActive());
			existingsystemUsers.setChangedPassword(related_systemusers.getChangedPassword());
			existingsystemUsers.setEmail(related_systemusers.getEmail());
			existingsystemUsers.setUnregisterDate(related_systemusers.getUnregisterDate());
			existingsystemUsers.setRole(related_systemusers.getRole());
			related_systemusers = existingsystemUsers;
		} else {
			related_systemusers = systemUserDAO.store(related_systemusers);
			systemUserDAO.flush();
		}

		related_systemusers.setSystemUserPermission(systemuserpermission);
//		systemuserpermission.getSystemUser().add(related_systemusers);
		related_systemusers = systemUserDAO.store(related_systemusers);
		systemUserDAO.flush();

		systemuserpermission = systemUserPermissionDAO.store(systemuserpermission);
		systemUserPermissionDAO.flush();

		return systemuserpermission;
	}

	/**
	 * Delete an existing SystemUserPermission entity
	 * 
	 */
	@Transactional
	public void deleteSystemUserPermission(SystemUserPermission systemuserpermission) {
		systemUserPermissionDAO.remove(systemuserpermission);
		systemUserPermissionDAO.flush();
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public SystemUserPermission saveSystemUserPermissionPermission(Integer id, Permission related_permission) {
		SystemUserPermission systemuserpermission = systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(id);
		Permission existingpermission = permissionDAO.findPermissionByPrimaryKey(related_permission.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermission != null) {
			existingpermission.setId(related_permission.getId());
			existingpermission.setDisplay(related_permission.getDisplay());
			existingpermission.setExecute(related_permission.getExecute());
			existingpermission.setEdit(related_permission.getEdit());
			related_permission = existingpermission;
		} else {
			related_permission = permissionDAO.store(related_permission);
			permissionDAO.flush();
		}

		systemuserpermission.setPermission(related_permission);
		related_permission.getSystemUserPermission().add(systemuserpermission);
		systemuserpermission = systemUserPermissionDAO.store(systemuserpermission);
		systemUserPermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		return systemuserpermission;
	}

	/**
	 * Load an existing SystemUserPermission entity
	 * 
	 */
	@Transactional
	public Set<SystemUserPermission> loadSystemUserPermissions() {
		return systemUserPermissionDAO.findAllSystemUserPermissions();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public SystemUserPermission deleteSystemUserPermissionSystemUsers(Integer systemuserpermission_id, String related_systemusers_id) {
		SystemUser related_systemusers = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers_id, -1, -1);

		SystemUserPermission systemuserpermission = systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(systemuserpermission_id);

		related_systemusers.setSystemUserPermission(null);
//		systemuserpermission.getSystemUser().remove(related_systemusers);

		systemUserDAO.remove(related_systemusers);
		systemUserDAO.flush();

		return systemuserpermission;
	}
}
