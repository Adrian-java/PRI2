package com.eclinic.web.rest;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;

import com.eclinic.service.ModuleService;

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
 * Spring Rest controller that handles CRUD requests for Module entities
 * 
 */

@Controller("ModuleRestController")
public class ModuleRestController {

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
	 * Service injected by Spring that provides CRUD operations for Module entities
	 * 
	 */
	@Autowired
	private ModuleService moduleService;

	/**
	 * Save an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Module", method = RequestMethod.PUT)
	@ResponseBody
	public Module saveModule(@RequestBody Module module) {
		moduleService.saveModule(module);
		return moduleDAO.findModuleByPrimaryKey(module.getId());
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}/permissions", method = RequestMethod.PUT)
	@ResponseBody
	public Permission saveModulePermissions(@PathVariable Integer module_id, @RequestBody Permission permissions) {
		moduleService.saveModulePermissions(module_id, permissions);
		return permissionDAO.findPermissionByPrimaryKey(permissions.getId());
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}/permissions/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadModulePermissions(@PathVariable Integer module_id, @PathVariable Integer related_permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);

		return permission;
	}

	/**
	 * Show all Module entities
	 * 
	 */
	@RequestMapping(value = "/Module", method = RequestMethod.GET)
	@ResponseBody
	public List<Module> listModules() {
		return new java.util.ArrayList<Module>(moduleService.loadModules());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}/permissions/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteModulePermissions(@PathVariable Integer module_id, @PathVariable Integer related_permissions_id) {
		moduleService.deleteModulePermissions(module_id, related_permissions_id);
	}

	/**
	 * Show all Permission entities by Module
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}/permissions", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> getModulePermissions(@PathVariable Integer module_id) {
		return new java.util.ArrayList<Permission>(moduleDAO.findModuleByPrimaryKey(module_id).getPermissions());
	}

	/**
	 * Select an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}", method = RequestMethod.GET)
	@ResponseBody
	public Module loadModule(@PathVariable Integer module_id) {
		return moduleDAO.findModuleByPrimaryKey(module_id);
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

	/**
	 * Create a new Module entity
	 * 
	 */
	@RequestMapping(value = "/Module", method = RequestMethod.POST)
	@ResponseBody
	public Module newModule(@RequestBody Module module) {
		moduleService.saveModule(module);
		return moduleDAO.findModuleByPrimaryKey(module.getId());
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteModule(@PathVariable Integer module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(module_id);
		moduleService.deleteModule(module);
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/Module/{module_id}/permissions", method = RequestMethod.POST)
	@ResponseBody
	public Permission newModulePermissions(@PathVariable Integer module_id, @RequestBody Permission permission) {
		moduleService.saveModulePermissions(module_id, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}
}