package com.eclinic.user.mangament;

import org.apache.log4j.Logger;

import com.eclinic.admin.app.Application;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.SystemUserDAOImpl;
import com.eclinic.domain.SystemUser;
import com.eclinic.exception.ClinicException;

public class SystemRoles {
	private Logger logger = Logger.getLogger(SystemRoles.class);

	public void setOrChangeRoleBySystemUser(SystemUser systemUser, String role)
			throws ClinicException {
		checkAccess(systemUser);

		SystemUserDAO sudao = new SystemUserDAOImpl();
		systemUser.setRole(role);
		sudao.merge(systemUser);
	}

	public void lockUser(SystemUser su) throws ClinicException {
		checkAccess(su);
		su.setIsActive(false);
	}

	private void checkAccess(SystemUser systemUser) throws ClinicException {
		if (systemUser == null)
			return;
		if (!Application.isSuperAdminLogged())
			throw new ClinicException("Brak uprawnien administratora");
	}

}
