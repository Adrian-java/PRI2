package com.eclinic.user.mangament.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.AdminView;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.PermissionMangament;

@Component("adminCrud")
public class AdminCrudDB implements AdminCrud {

	@Autowired
	private SystemUserDAO systemUserDAO;
	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private PermissionMangament permissionMangament;
	@Autowired
	private AdminDAO adminDao;


	public Response deleteAdmin(String pesel) {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		Map<String, String> map = new TreeMap<String, String>();
		if (su.getRole().equalsIgnoreCase("admin")) {
			su.setIsActive(false);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			su.setUnregisterDate(c);
			systemUserService.saveSystemUserAdmin(su,true);
			map.put("status", "usunieto");
			return Response.ok(map).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}


	public Set<AdminView> getAllAdmins() {
		return adminDao.findAllAdmins();
	}



}
