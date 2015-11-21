package com.eclinic.service;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for TypeOfUser entities
 * 
 */

@Service("TypeOfUserService")
@Transactional
public class TypeOfUserServiceImpl implements TypeOfUserService {

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
	 * Instantiates a new TypeOfUserServiceImpl.
	 *
	 */
	public TypeOfUserServiceImpl() {
	}

	/**
	 */
	@Transactional
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id) {
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(id);
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public TypeOfUser saveTypeOfUserPermissions(Integer id, Permission related_permissions) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(id, -1, -1);
		Permission existingpermissions = permissionDAO.findPermissionByPrimaryKey(related_permissions.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermissions != null) {
			existingpermissions.setId(related_permissions.getId());
			existingpermissions.setDisplay(related_permissions.getDisplay());
			existingpermissions.setExecute(related_permissions.getExecute());
			existingpermissions.setEdit(related_permissions.getEdit());
			related_permissions = existingpermissions;
		}

		related_permissions.setTypeOfUser(typeofuser);
		typeofuser.getPermission().add(related_permissions);
		related_permissions = permissionDAO.store(related_permissions);
		permissionDAO.flush();

		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		return typeofuser;
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public TypeOfUser saveTypeOfUserTypeOfUsers(Integer id, TypeOfUser related_typeofusers) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(id, -1, -1);
		TypeOfUser existingtypeOfUsers = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingtypeOfUsers != null) {
			existingtypeOfUsers.setId(related_typeofusers.getId());
			existingtypeOfUsers.setType(related_typeofusers.getType());
			existingtypeOfUsers.setDescription(related_typeofusers.getDescription());
			related_typeofusers = existingtypeOfUsers;
		} else {
			related_typeofusers = typeOfUserDAO.store(related_typeofusers);
			typeOfUserDAO.flush();
		}

//		typeofuser.setTypeOfUser(related_typeofusers);
//		related_typeofusers.getTypeOfUsers().add(typeofuser);
		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		related_typeofusers = typeOfUserDAO.store(related_typeofusers);
		typeOfUserDAO.flush();

		return typeofuser;
	}

	/**
	 * Load an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public Set<TypeOfUser> loadTypeOfUsers() {
		return typeOfUserDAO.findAllTypeOfUsers();
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public TypeOfUser deleteTypeOfUserTypeOfUsers(Integer typeofuser_id, Integer related_typeofusers_id) {
		TypeOfUser related_typeofusers = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers_id, -1, -1);

		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id, -1, -1);

//		typeofuser.setTypeOfUser(null);
//		related_typeofusers.getTypeOfUsers().remove(typeofuser);

		typeOfUserDAO.remove(related_typeofusers);
		typeOfUserDAO.flush();

		return typeofuser;
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public void deleteTypeOfUser(TypeOfUser typeofuser) {
		typeOfUserDAO.remove(typeofuser);
		typeOfUserDAO.flush();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public TypeOfUser deleteTypeOfUserPermissions(Integer typeofuser_id, Integer related_permissions_id) {
		Permission related_permissions = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);

		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id, -1, -1);

		related_permissions.setTypeOfUser(null);
		typeofuser.getPermission().remove(related_permissions);

		permissionDAO.remove(related_permissions);
		permissionDAO.flush();

		return typeofuser;
	}

	/**
	 * Return all TypeOfUser entity
	 * 
	 */
	@Transactional
	public List<TypeOfUser> findAllTypeOfUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<TypeOfUser>(typeOfUserDAO.findAllTypeOfUsers(startResult, maxRows));
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public void saveTypeOfUser(TypeOfUser typeofuser) {
		TypeOfUser existingTypeOfUser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId());

		if (existingTypeOfUser != null) {
			if (existingTypeOfUser != typeofuser) {
				existingTypeOfUser.setId(typeofuser.getId());
				existingTypeOfUser.setType(typeofuser.getType());
				existingTypeOfUser.setDescription(typeofuser.getDescription());
			}
			typeofuser = typeOfUserDAO.store(existingTypeOfUser);
		} else {
			typeofuser = typeOfUserDAO.store(typeofuser);
		}
		typeOfUserDAO.flush();
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public TypeOfUser deleteTypeOfUserTypeOfUser(Integer typeofuser_id, Integer related_typeofuser_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id, -1, -1);
		TypeOfUser related_typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofuser_id, -1, -1);

//		typeofuser.setTypeOfUser(null);
//		related_typeofuser.getTypeOfUsers().remove(typeofuser);
		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		related_typeofuser = typeOfUserDAO.store(related_typeofuser);
		typeOfUserDAO.flush();

		typeOfUserDAO.remove(related_typeofuser);
		typeOfUserDAO.flush();

		return typeofuser;
	}

	/**
	 * Return a count of all TypeOfUser entity
	 * 
	 */
	@Transactional
	public Integer countTypeOfUsers() {
		return ((Long) typeOfUserDAO.createQuerySingleResult("select count(o) from TypeOfUser o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public TypeOfUser saveTypeOfUserTypeOfUser(Integer id, TypeOfUser related_typeofuser) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(id, -1, -1);
		TypeOfUser existingtypeOfUser = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingtypeOfUser != null) {
			existingtypeOfUser.setId(related_typeofuser.getId());
			existingtypeOfUser.setType(related_typeofuser.getType());
			existingtypeOfUser.setDescription(related_typeofuser.getDescription());
			related_typeofuser = existingtypeOfUser;
		} else {
			related_typeofuser = typeOfUserDAO.store(related_typeofuser);
			typeOfUserDAO.flush();
		}

//		typeofuser.setTypeOfUser(related_typeofuser);
//		related_typeofuser.getTypeOfUsers().add(typeofuser);
		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		related_typeofuser = typeOfUserDAO.store(related_typeofuser);
		typeOfUserDAO.flush();

		return typeofuser;
	}
}
