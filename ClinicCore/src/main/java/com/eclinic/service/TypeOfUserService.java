package com.eclinic.service;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for TypeOfUser entities
 * 
 */
public interface TypeOfUserService {

	/**
	 */
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public TypeOfUser saveTypeOfUserPermissions(Integer id_1, Permission related_permissions);

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	public TypeOfUser saveTypeOfUserTypeOfUsers(Integer id_2, TypeOfUser related_typeofusers);

	/**
	 * Load an existing TypeOfUser entity
	 * 
	 */
	public Set<TypeOfUser> loadTypeOfUsers();

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	public TypeOfUser deleteTypeOfUserTypeOfUsers(Integer typeofuser_id, Integer related_typeofusers_id);

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	public void deleteTypeOfUser(TypeOfUser typeofuser);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public TypeOfUser deleteTypeOfUserPermissions(Integer typeofuser_id_1, Integer related_permissions_id);

	/**
	 * Return all TypeOfUser entity
	 * 
	 */
	public List<TypeOfUser> findAllTypeOfUsers(Integer startResult, Integer maxRows);

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	public void saveTypeOfUser(TypeOfUser typeofuser_1);

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	public TypeOfUser deleteTypeOfUserTypeOfUser(Integer typeofuser_id_2, Integer related_typeofuser_id);

	/**
	 * Return a count of all TypeOfUser entity
	 * 
	 */
	public Integer countTypeOfUsers();

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	public TypeOfUser saveTypeOfUserTypeOfUser(Integer id_3, TypeOfUser related_typeofuser);
}