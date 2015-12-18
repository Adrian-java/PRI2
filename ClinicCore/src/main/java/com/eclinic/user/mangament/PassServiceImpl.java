package com.eclinic.user.mangament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eclinic.dao.SystemUserDAO;
import com.eclinic.domain.SystemUser;
import com.eclinic.service.SystemUserService;

@Component("PassService")
public class PassServiceImpl implements PassService {

	@Autowired
	private SystemUserDAO systemUserDao;

	@Autowired
	private SystemUserService SystemUserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean checkOldPassword(PassModel pm) {
		SystemUser findSystemUserById = systemUserDao.findSystemUserById(pm
				.getId());
		if (findSystemUserById != null) {
			return passwordEncoder.matches(pm.getOldPass(), findSystemUserById.getPassword()
					);
		}

		return false;
	}

	public boolean checkPassAndRepeatPass(PassModel pm) {
		if (pm.getNewPass().equals(pm.getRepeatNewPass()))
			return true;
		return false;
	}

	public boolean changePassword(PassModel pm) {
		SystemUser findSystemUserById = systemUserDao.findSystemUserById(pm
				.getId());
		findSystemUserById.setPassword(pm.getNewPass());
		findSystemUserById.setChangedPassword(true);
		try {
			if (findSystemUserById.getRole().equalsIgnoreCase("patient")) {
				SystemUserService.saveSystemUserPatient(findSystemUserById,
						false);
			} else if (findSystemUserById.getRole().equalsIgnoreCase("doctor")) {
				SystemUserService.saveSystemUserDoctor(findSystemUserById,
						false);
			} else if (findSystemUserById.getRole().equalsIgnoreCase(
					"receptionist")) {
				SystemUserService.saveSystemUserReceptionist(
						findSystemUserById, false);
			} else if (findSystemUserById.getRole().equalsIgnoreCase("admin")) {
				SystemUserService
						.saveSystemUserAdmin(findSystemUserById, false);
			} else {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
