package com.eclinic.user.mangament;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.SystemUserPermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;
import com.eclinic.dao.view.SystemUserPermissionViewDAO;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.SystemUserPermission;
import com.eclinic.domain.TypeOfUser;
import com.eclinic.domain.view.SystemUserPermissionView;

@Component("PermissionMangament")
public class PermissionMangament {

	@Autowired
	private SystemUserDAO systemUserDao;
	@Autowired
	private TypeOfUserDAO typeOfUserDao;
	@Autowired
	private PermissionDAO permissionDao;
	@Autowired
	private SystemUserPermissionDAO systemUserPermissionDao;
	@Autowired
	private SystemUserPermissionViewDAO systemUserPermissionViewDao;

	// @Autowired
	// private SystemUserP

	public void setUserPermission(SystemUser systemUser) {
		String type = "";
		if (systemUser.getDoctor() != null)
			type = "Doctor";
		if (systemUser.getReceptionist() != null)
			type = "Receptionist";
		if (systemUser.getAdmin() != null)
			type = "Admin";
		if (systemUser.getPatient() != null)
			type = "Patient";
		TypeOfUser userType = typeOfUserDao.findTypeOfUserByType(type)
				.iterator().next();
		Set<Permission> permissionByUserType = permissionDao
				.findPermissionByUserType(userType);

		Iterator<Permission> i = permissionByUserType.iterator();
		while (i.hasNext()) {
			SystemUserPermission sup = new SystemUserPermission();
			sup.setSystemUser(systemUser);
			sup.setPermission(i.next());
			systemUserPermissionDao.merge(sup);
		}
	}

	public Set<SystemUserPermissionView> showPermissionById(String pesel) {

		return systemUserPermissionViewDao
				.findSystemUserPermissionByPesel(pesel);

	}

}
