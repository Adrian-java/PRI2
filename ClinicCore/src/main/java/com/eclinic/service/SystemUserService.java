package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.SystemUserPermission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SystemUser entities
 * 
 */
public interface SystemUserService {

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public String saveSystemUserPatient(SystemUser su);

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public SystemUser deleteSystemUserReceptionist(String systemuser_id, String related_receptionist_id);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public String saveSystemUserDoctor(SystemUser su);

	/**
	 * Save an existing SystemUserPermission entity
	 * 
	 */
//	public SystemUser saveSystemUserSystemUserPermission(Integer id_2, SystemUserPermission related_systemuserpermission);

	/**
	 * Load an existing SystemUser entity
	 * 
	 */
	public Set<SystemUser> loadSystemUsers();

	/**
	 * Delete an existing SystemUserPermission entity
	 * 
	 */
//	public SystemUser deleteSystemUserSystemUserPermission(Integer systemuser_id_1, Integer related_systemuserpermission_id);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public SystemUser deleteSystemUserDoctor(String systemuser_id_2, String related_doctor_id);

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
//	public SystemUser saveSystemUserLoginHistory(Integer id_3, LoginHistory related_loginhistory);

	/**
	 * Save an existing Receptionist entity
	 * 
	 */

	/**
	 * Save an existing Admin entity
	 * 
	 */
	public String saveSystemUserAdmin(SystemUser su);

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	public SystemUser deleteSystemUserAdmin(String systemuser_id_3, String related_admin_id);

	/**
	 */
	public SystemUser findSystemUserByPrimaryKey(String id_6);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public void deleteSystemUser(SystemUser systemuser);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public SystemUser deleteSystemUserPatient(String systemuser_id_4, String related_patient_id);

	/**
	 * Save an existing SystemUser entity
	 * @return 
	 * 
	 */
	public String saveSystemUser(SystemUser systemuser_1);

	/**
	 * Return a count of all SystemUser entity
	 * 
	 */
	public Integer countSystemUsers();

	/**
	 * Return all SystemUser entity
	 * 
	 */
	public List<SystemUser> findAllSystemUsers(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	public SystemUser deleteSystemUserLoginHistory(String systemuser_id_5, Integer related_loginhistory_id);

	public String saveSystemUserReceptionist(SystemUser systemuser);
}