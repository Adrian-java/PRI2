package com.eclinic.user.mangament.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.SystemUserDAO;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;
import com.eclinic.service.SystemUserService;

@Component("doctorCrud")
public class DoctorCrudDB implements DoctorCrud {
	
	@Autowired
	private SystemUserDAO systemUserDAO;

	@Autowired
	private SystemUserService systemUserService;

	public Response AddDoctor(SystemUser systemUser) {
		if (systemUser.getWorker() != null) {
			Worker w = systemUser.getWorker();
			if (w.getPatient() != null || w.getAdmin() != null
					|| w.getReceptionist() != null) {
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		SystemUser s = systemUserDAO.findSystemUserByPesel(systemUser
				.getPesel());
		if (s != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		Integer i = systemUserService.saveSystemUser(systemUser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

}
