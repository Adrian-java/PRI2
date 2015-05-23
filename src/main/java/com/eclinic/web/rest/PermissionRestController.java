package com.eclinic.web.rest;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.TypeOfUserDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfUser;
import com.eclinic.service.PermissionService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Permission entities
 * 
 */
@Path("/Permission")
@Component("PermissionRestController")
public class PermissionRestController {

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
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Permission entities
	 * 
	 */
	@Autowired
	private PermissionService permissionService;

	
	public PermissionRestController() {
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
	 * View an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/typeOfUsers/{typeofuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public TypeOfUser loadPermissionTypeOfUsers(@PathVariable Integer permission_id, @PathVariable Integer related_typeofusers_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers_id, -1, -1);

		return typeofuser;
	}

	/**
	 * Show all Permission entities
	 * 
	 */
	@RequestMapping(value = "/Permission", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> listPermissions() {
		return new java.util.ArrayList<Permission>(permissionService.loadPermissions());
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/systemUser/{systemuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermissionSystemUser(@PathVariable Integer permission_id, @PathVariable Integer related_systemuser_id) {
		permissionService.deletePermissionSystemUser(permission_id, related_systemuser_id);
	}

	/**
	 * Show all TypeOfUser entities by Permission
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/typeOfUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<TypeOfUser> getPermissionTypeOfUsers(@PathVariable Integer permission_id) {
		return new java.util.ArrayList<TypeOfUser>(permissionDAO.findPermissionByPrimaryKey(permission_id).getTypeOfUsers());
	}

	/**
	 * Select an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadPermission(@PathVariable Integer permission_id) {
		return permissionDAO.findPermissionByPrimaryKey(permission_id);
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePermission(Permission permission) {
		permissionService.savePermission(permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}


	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/systemUser", method = RequestMethod.POST)
	@ResponseBody
	public SystemUser newPermissionSystemUser(@PathVariable Integer permission_id, @RequestBody SystemUser systemuser) {
		permissionService.savePermissionSystemUser(permission_id, systemuser);
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermission(@PathVariable Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id);
		permissionService.deletePermission(permission);
	}

	

	/**
	 * View an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/module/{module_id}", method = RequestMethod.GET)
	@ResponseBody
	public Module loadPermissionModule(@PathVariable Integer permission_id, @PathVariable Integer related_module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(related_module_id, -1, -1);

		return module;
	}

	/**
	 * Create a new Module entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/module", method = RequestMethod.POST)
	@ResponseBody
	public Module newPermissionModule(@PathVariable Integer permission_id, @RequestBody Module module) {
		permissionService.savePermissionModule(permission_id, module);
		return moduleDAO.findModuleByPrimaryKey(module.getId());
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/typeOfUsers/{typeofuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermissionTypeOfUsers(@PathVariable Integer permission_id, @PathVariable Integer related_typeofusers_id) {
		permissionService.deletePermissionTypeOfUsers(permission_id, related_typeofusers_id);
	}

	/**
	 * Create a new TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/typeOfUsers", method = RequestMethod.POST)
	@ResponseBody
	public TypeOfUser newPermissionTypeOfUsers(@PathVariable Integer permission_id, @RequestBody TypeOfUser typeofuser) {
		permissionService.savePermissionTypeOfUsers(permission_id, typeofuser);
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId());
	}

	/**
	 * Get SystemUser entity by Permission
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/systemUser", method = RequestMethod.GET)
	@ResponseBody
	public SystemUser getPermissionSystemUser(@PathVariable Integer permission_id) {
		return permissionDAO.findPermissionByPrimaryKey(permission_id).getSystemUser();
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission", method = RequestMethod.POST)
	@ResponseBody
	public Permission newPermission(@RequestBody Permission permission) {
		permissionService.savePermission(permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/module/{module_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermissionModule(@PathVariable Integer permission_id, @PathVariable Integer related_module_id) {
		permissionService.deletePermissionModule(permission_id, related_module_id);
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/systemUser", method = RequestMethod.PUT)
	@ResponseBody
	public SystemUser savePermissionSystemUser(@PathVariable Integer permission_id, @RequestBody SystemUser systemuser) {
		permissionService.savePermissionSystemUser(permission_id, systemuser);
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId());
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/module", method = RequestMethod.PUT)
	@ResponseBody
	public Module savePermissionModule(@PathVariable Integer permission_id, @RequestBody Module module) {
		permissionService.savePermissionModule(permission_id, module);
		return moduleDAO.findModuleByPrimaryKey(module.getId());
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/systemUser/{systemuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public SystemUser loadPermissionSystemUser(@PathVariable Integer permission_id, @PathVariable Integer related_systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		return systemuser;
	}

	/**
	 * Get Module entity by Permission
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/module", method = RequestMethod.GET)
	@ResponseBody
	public Module getPermissionModule(@PathVariable Integer permission_id) {
		return permissionDAO.findPermissionByPrimaryKey(permission_id).getModule();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/typeOfUsers", method = RequestMethod.PUT)
	@ResponseBody
	public TypeOfUser savePermissionTypeOfUsers(@PathVariable Integer permission_id, @RequestBody TypeOfUser typeofusers) {
		permissionService.savePermissionTypeOfUsers(permission_id, typeofusers);
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofusers.getId());
	}
}