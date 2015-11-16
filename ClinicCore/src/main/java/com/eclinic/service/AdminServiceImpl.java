package com.eclinic.service;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.SystemUserDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.SystemUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Admin entities
 * 
 */

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * Instantiates a new AdminServiceImpl.
	 *
	 */
	public AdminServiceImpl() {
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Admin saveAdminSystemUser(String id, SystemUser related_systemuser) {
		Admin admin = adminDAO.findAdminByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			existingsystemUser.setRole(related_systemuser.getRole());
			related_systemuser = existingsystemUser;
		} else {
			related_systemuser = systemUserDAO.store(related_systemuser);
			systemUserDAO.flush();
		}

		admin.setSystemUser(related_systemuser);
		admin = adminDAO.store(admin);
		adminDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return admin;
	}

	/**
	 * Return a count of all Admin entity
	 * 
	 */
	@Transactional
	public Integer countAdmins() {
		return ((Long) adminDAO.createQuerySingleResult("select count(o) from Admin o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Admin findAdminByPrimaryKey(String id) {
		return adminDAO.findAdminByPrimaryKey(id);
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	@Transactional
	public void saveAdmin(Admin admin) {
		Admin existingAdmin = adminDAO.findAdminByPrimaryKey(admin.getId());

		if (existingAdmin != null) {
			if (existingAdmin != admin) {
				existingAdmin.setId(admin.getId());
				existingAdmin.setIsSuper(admin.getIsSuper());
			}
			admin = adminDAO.store(existingAdmin);
		} else {
			admin = adminDAO.store(admin);
		}
		adminDAO.flush();
	}

	/**
	 * Load an existing Admin entity
	 * 
	 */
	@Transactional
	public Set<Admin> loadAdmins() {
		return adminDAO.findAllAdmins();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Admin deleteAdminSystemUser(String admin_id, String related_systemuser_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		admin.setSystemUser(null);
		admin = adminDAO.store(admin);
		adminDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return admin;
	}

	/**
	 * Return all Admin entity
	 * 
	 */
	@Transactional
	public List<Admin> findAllAdmins(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Admin>(adminDAO.findAllAdmins(startResult, maxRows));
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@Transactional
	public void deleteAdmin(Admin admin) {
		adminDAO.remove(admin);
		adminDAO.flush();
	}
}
