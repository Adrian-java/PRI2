package com.eclinic.web.rest;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import com.eclinic.service.SystemUserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for SystemUser entities
 * 
 */

@Controller("SystemUserRestController")
public class SystemUserRestController {

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
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserService systemUserService;

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/permissions/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadSystemUserPermissions(@PathVariable Integer systemuser_id, @PathVariable Integer related_permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);

		return permission;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/permissions/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSystemUserPermissions(@PathVariable Integer systemuser_id, @PathVariable Integer related_permissions_id) {
		systemUserService.deleteSystemUserPermissions(systemuser_id, related_permissions_id);
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/permissions", method = RequestMethod.POST)
	@ResponseBody
	public Permission newSystemUserPermissions(@PathVariable Integer systemuser_id, @RequestBody Permission permission) {
		systemUserService.saveSystemUserPermissions(systemuser_id, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/worker/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadSystemUserWorker(@PathVariable Integer systemuser_id, @PathVariable Integer related_worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);

		return worker;
	}

	/**
	 * Select an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public SystemUser loadSystemUser(@PathVariable Integer systemuser_id) {
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser_id);
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser", method = RequestMethod.PUT)
	@ResponseBody
	public SystemUser saveSystemUser(@RequestBody SystemUser systemuser) {
		systemUserService.saveSystemUser(systemuser);
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId());
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser", method = RequestMethod.POST)
	@ResponseBody
	public SystemUser newSystemUser(@RequestBody SystemUser systemuser) {
		systemUserService.saveSystemUser(systemuser);
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId());
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSystemUser(@PathVariable Integer systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id);
		systemUserService.deleteSystemUser(systemuser);
	}

	/**
	 * Get Worker entity by SystemUser
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/worker", method = RequestMethod.GET)
	@ResponseBody
	public Worker getSystemUserWorker(@PathVariable Integer systemuser_id) {
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser_id).getWorker();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/worker", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveSystemUserWorker(@PathVariable Integer systemuser_id, @RequestBody Worker worker) {
		systemUserService.saveSystemUserWorker(systemuser_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Show all SystemUser entities
	 * 
	 */
	@RequestMapping(value = "/SystemUser", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemUser> listSystemUsers() {
		return new java.util.ArrayList<SystemUser>(systemUserService.loadSystemUsers());
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/worker/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSystemUserWorker(@PathVariable Integer systemuser_id, @PathVariable Integer related_worker_id) {
		systemUserService.deleteSystemUserWorker(systemuser_id, related_worker_id);
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/permissions", method = RequestMethod.PUT)
	@ResponseBody
	public Permission saveSystemUserPermissions(@PathVariable Integer systemuser_id, @RequestBody Permission permissions) {
		systemUserService.saveSystemUserPermissions(systemuser_id, permissions);
		return permissionDAO.findPermissionByPrimaryKey(permissions.getId());
	}

	/**
	 * Show all Permission entities by SystemUser
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/permissions", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> getSystemUserPermissions(@PathVariable Integer systemuser_id) {
		return new java.util.ArrayList<Permission>(systemUserDAO.findSystemUserByPrimaryKey(systemuser_id).getPermissions());
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping(value = "/SystemUser/{systemuser_id}/worker", method = RequestMethod.POST)
	@ResponseBody
	public Worker newSystemUserWorker(@PathVariable Integer systemuser_id, @RequestBody Worker worker) {
		systemUserService.saveSystemUserWorker(systemuser_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
}