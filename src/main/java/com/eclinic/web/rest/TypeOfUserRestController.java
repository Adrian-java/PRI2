package com.eclinic.web.rest;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import com.eclinic.service.TypeOfUserService;

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
 * Spring Rest controller that handles CRUD requests for TypeOfUser entities
 * 
 */

@Controller("TypeOfUserRestController")
public class TypeOfUserRestController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserService typeOfUserService;

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTypeOfUser(@PathVariable Integer typeofuser_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id);
		typeOfUserService.deleteTypeOfUser(typeofuser);
	}

	/**
	 * Select an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public TypeOfUser loadTypeOfUser(@PathVariable Integer typeofuser_id) {
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id);
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
	 * Create a new TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser", method = RequestMethod.POST)
	@ResponseBody
	public TypeOfUser newTypeOfUser(@RequestBody TypeOfUser typeofuser) {
		typeOfUserService.saveTypeOfUser(typeofuser);
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}/permission/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTypeOfUserPermission(@PathVariable Integer typeofuser_id, @PathVariable Integer related_permission_id) {
		typeOfUserService.deleteTypeOfUserPermission(typeofuser_id, related_permission_id);
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}/permission", method = RequestMethod.POST)
	@ResponseBody
	public Permission newTypeOfUserPermission(@PathVariable Integer typeofuser_id, @RequestBody Permission permission) {
		typeOfUserService.saveTypeOfUserPermission(typeofuser_id, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}/permission", method = RequestMethod.PUT)
	@ResponseBody
	public Permission saveTypeOfUserPermission(@PathVariable Integer typeofuser_id, @RequestBody Permission permission) {
		typeOfUserService.saveTypeOfUserPermission(typeofuser_id, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Show all TypeOfUser entities
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser", method = RequestMethod.GET)
	@ResponseBody
	public List<TypeOfUser> listTypeOfUsers() {
		return new java.util.ArrayList<TypeOfUser>(typeOfUserService.loadTypeOfUsers());
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}/permission/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadTypeOfUserPermission(@PathVariable Integer typeofuser_id, @PathVariable Integer related_permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		return permission;
	}

	/**
	 * Get Permission entity by TypeOfUser
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser/{typeofuser_id}/permission", method = RequestMethod.GET)
	@ResponseBody
	public Permission getTypeOfUserPermission(@PathVariable Integer typeofuser_id) {
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id).getPermission();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping(value = "/TypeOfUser", method = RequestMethod.PUT)
	@ResponseBody
	public TypeOfUser saveTypeOfUser(@RequestBody TypeOfUser typeofuser) {
		typeOfUserService.saveTypeOfUser(typeofuser);
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId());
	}
}