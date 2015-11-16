package com.eclinic.service;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.SystemUserPermissionDAO;
import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.SystemUserPermission;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SystemUser entities
 * 
 */

@Service("SystemUserService")
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

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
	 * Instantiates a new SystemUserServiceImpl.
	 *
	 */
	public SystemUserServiceImpl() {
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public String saveSystemUserPatient(SystemUser systemuser) {
		systemuser.getPatient().setSystemUser(systemuser);
		systemuser
				.setPassword(passwordEncoder.encode(systemuser.getPassword()));
		SystemUser su = systemUserDAO.store(systemuser);
		systemUserDAO.flush();
		return su.getId();

	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserReceptionist(String systemuser_id,
			String related_receptionist_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(
				systemuser_id, -1, -1);
		Receptionist related_receptionist = receptionistDAO
				.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		systemuser.setReceptionist(null);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_receptionist = receptionistDAO.store(related_receptionist);
		receptionistDAO.flush();

		receptionistDAO.remove(related_receptionist);
		receptionistDAO.flush();

		return systemuser;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public String saveSystemUserDoctor(SystemUser systemuser) {
		systemuser
		.setPassword(passwordEncoder.encode(systemuser.getPassword()));
		systemuser.getDoctor().setSystemUser(systemuser);
		SystemUser su = systemUserDAO.store(systemuser);
		systemUserDAO.flush();
		return su.getId();
	}

	// /**
	// * Save an existing SystemUserPermission entity
	// *
	// */
	// @Transactional
	// public SystemUser saveSystemUserSystemUserPermission(Integer id,
	// SystemUserPermission related_systemuserpermission) {
	// SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(id, -1,
	// -1);
	// SystemUserPermission existingsystemUserPermission =
	// systemUserPermissionDAO.findSystemUserPermissionByI(related_systemuserpermission.getId());
	//
	// // copy into the existing record to preserve existing relationships
	// if (existingsystemUserPermission != null) {
	// existingsystemUserPermission.setId(related_systemuserpermission.getId());
	// related_systemuserpermission = existingsystemUserPermission;
	// } else {
	// related_systemuserpermission =
	// systemUserPermissionDAO.store(related_systemuserpermission);
	// systemUserPermissionDAO.flush();
	// }
	//
	// systemuser.setSystemUserPermission(related_systemuserpermission);
	// related_systemuserpermission.getSystemUser().add(systemuser);
	// systemuser = systemUserDAO.store(systemuser);
	// systemUserDAO.flush();
	//
	// related_systemuserpermission =
	// systemUserPermissionDAO.store(related_systemuserpermission);
	// systemUserPermissionDAO.flush();
	//
	// return systemuser;
	// }

	/**
	 * Load an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Set<SystemUser> loadSystemUsers() {
		return systemUserDAO.findAllSystemUsers();
	}

	// /**
	// * Delete an existing SystemUserPermission entity
	// *
	// */
	// @Transactional
	// public SystemUser deleteSystemUserSystemUserPermission(Integer
	// systemuser_id, Integer related_systemuserpermission_id) {
	// SystemUser systemuser =
	// systemUserDAO.findSystemUserByPrimaryKey(systemuser_id, -1, -1);
	// SystemUserPermission related_systemuserpermission =
	// systemUserPermissionDAO.findSystemUserPermissionByPrimaryKey(related_systemuserpermission_id,
	// -1, -1);
	//
	// systemuser.setSystemUserPermission(null);
	// related_systemuserpermission.getSystemUser().remove(systemuser);
	// systemuser = systemUserDAO.store(systemuser);
	// systemUserDAO.flush();
	//
	// related_systemuserpermission =
	// systemUserPermissionDAO.store(related_systemuserpermission);
	// systemUserPermissionDAO.flush();
	//
	// systemUserPermissionDAO.remove(related_systemuserpermission);
	// systemUserPermissionDAO.flush();
	//
	// return systemuser;
	// }

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserDoctor(String systemuser_id,
			String related_doctor_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(
				systemuser_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(
				related_doctor_id, -1, -1);

		systemuser.setDoctor(null);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return systemuser;
	}

	// /**
	// * Save an existing LoginHistory entity
	// *
	// */
	// @Transactional
	// public SystemUser saveSystemUserLoginHistory(Integer id, LoginHistory
	// related_loginhistory) {
	// SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(id, -1,
	// -1);
	// LoginHistory existingloginHistory =
	// loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistory.getId());
	//
	// // copy into the existing record to preserve existing relationships
	// if (existingloginHistory != null) {
	// existingloginHistory.setId(related_loginhistory.getId());
	// existingloginHistory.setIdWorker(related_loginhistory.getIdWorker());
	// existingloginHistory.setDateLogin(related_loginhistory.getDateLogin());
	// existingloginHistory.setSessionNumber(related_loginhistory.getSessionNumber());
	// existingloginHistory.setDateLogout(related_loginhistory.getDateLogout());
	// related_loginhistory = existingloginHistory;
	// } else {
	// related_loginhistory = loginHistoryDAO.store(related_loginhistory);
	// loginHistoryDAO.flush();
	// }
	//
	// systemuser.setLoginHistory(related_loginhistory);
	// systemuser = systemUserDAO.store(systemuser);
	// systemUserDAO.flush();
	//
	// related_loginhistory = loginHistoryDAO.store(related_loginhistory);
	// loginHistoryDAO.flush();
	//
	// return systemuser;
	// }

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@Transactional
	public String saveSystemUserReceptionist(SystemUser systemuser) {
		systemuser
		.setPassword(passwordEncoder.encode(systemuser.getPassword()));
		systemuser.getReceptionist().setSystemUser(systemuser);
		SystemUser su = systemUserDAO.store(systemuser);
		systemUserDAO.flush();
		return su.getId();
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	@Transactional
	public SystemUser saveSystemUserAdmin(String id, Admin related_admin) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(id,
				-1, -1);
		Admin existingadmin = adminDAO.findAdminByPrimaryKey(related_admin
				.getId());

		// copy into the existing record to preserve existing relationships
		if (existingadmin != null) {
			existingadmin.setId(related_admin.getId());
			existingadmin.setIsSuper(related_admin.getIsSuper());
			related_admin = existingadmin;
		} else {
			related_admin = adminDAO.store(related_admin);
			adminDAO.flush();
		}

		systemuser.setAdmin(related_admin);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_admin = adminDAO.store(related_admin);
		adminDAO.flush();

		return systemuser;
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserAdmin(String systemuser_id,
			String related_admin_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(
				systemuser_id, -1, -1);
		Admin related_admin = adminDAO.findAdminByPrimaryKey(related_admin_id,
				-1, -1);

		systemuser.setAdmin(null);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_admin = adminDAO.store(related_admin);
		adminDAO.flush();

		adminDAO.remove(related_admin);
		adminDAO.flush();

		return systemuser;
	}

	/**
	 */
	@Transactional
	public SystemUser findSystemUserByPrimaryKey(String id) {
		return systemUserDAO.findSystemUserByPrimaryKey(id);
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public void deleteSystemUser(SystemUser systemuser) {
		systemUserDAO.remove(systemuser);
		systemUserDAO.flush();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserPatient(String systemuser_id,
			String related_patient_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(
				systemuser_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(
				related_patient_id, -1, -1);

		systemuser.setPatient(null);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return systemuser;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public String saveSystemUser(SystemUser systemuser) {
		SystemUser existingSystemUser = systemUserDAO
				.findSystemUserByPrimaryKey(systemuser.getId());
		SystemUser su = null;
		if (existingSystemUser != null) {
			if (existingSystemUser != systemuser) {
				existingSystemUser.setId(systemuser.getId());
				existingSystemUser.setPassword(systemuser.getPassword());
				existingSystemUser.setDescription(systemuser.getDescription());
				existingSystemUser
						.setRegisterDate(systemuser.getRegisterDate());
				existingSystemUser.setIsActive(systemuser.getIsActive());
				existingSystemUser.setChangedPassword(systemuser
						.getChangedPassword());
				existingSystemUser.setEmail(systemuser.getEmail());
				existingSystemUser.setUnregisterDate(systemuser
						.getUnregisterDate());
				existingSystemUser.setRole(systemuser.getRole());
			}
			systemuser = systemUserDAO.store(existingSystemUser);
		} else {
			systemuser.getDoctor().setSystemUser(systemuser);
			su = systemUserDAO.store(systemuser);
		}
		systemUserDAO.flush();
		return su.getId();
	}

	/**
	 * Return a count of all SystemUser entity
	 * 
	 */
	@Transactional
	public Integer countSystemUsers() {
		return ((Long) systemUserDAO.createQuerySingleResult(
				"select count(o) from SystemUser o").getSingleResult())
				.intValue();
	}

	/**
	 * Return all SystemUser entity
	 * 
	 */
	@Transactional
	public List<SystemUser> findAllSystemUsers(Integer startResult,
			Integer maxRows) {
		return new java.util.ArrayList<SystemUser>(
				systemUserDAO.findAllSystemUsers(startResult, maxRows));
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserLoginHistory(String systemuser_id,
			Integer related_loginhistory_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(
				systemuser_id, -1, -1);
		LoginHistory related_loginhistory = loginHistoryDAO
				.findLoginHistoryByPrimaryKey(related_loginhistory_id, -1, -1);

		systemuser.setLoginHistory(null);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_loginhistory = loginHistoryDAO.store(related_loginhistory);
		loginHistoryDAO.flush();

		loginHistoryDAO.remove(related_loginhistory);
		loginHistoryDAO.flush();

		return systemuser;
	}

}
