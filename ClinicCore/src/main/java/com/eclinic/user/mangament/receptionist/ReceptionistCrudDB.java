package com.eclinic.user.mangament.receptionist;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.view.ReceptionistViewDAO;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.ReceptionistView;
import com.eclinic.domain.view.SystemUserPermissionView;
import com.eclinic.service.ReceptionistService;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.PermissionMangament;

@Component("ReceptionistCrud")
public class ReceptionistCrudDB implements ReceptionistCrud {

	@Autowired
	private SystemUserDAO systemUserDAO;
	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private ReceptionistDAO ReceptionistDao;
	@Autowired
	private ReceptionistService ReceptionistService;
	@Autowired
	private PermissionMangament permissionMangament;
	@Autowired
	ReceptionistViewDAO ReceptionistViewDao;

	public Response addReceptionist(SystemUser systemUser) {

		if (systemUser.getEmail() == null)
			systemUser.setEmail("em");
		if (systemUser.getDoctor() != null || systemUser.getAdmin() != null
				|| systemUser.getPatient() != null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		Map<String, String> map = new HashMap<String, String>();
		SystemUser s = systemUserDAO.findSystemUserById(systemUser
				.getId());
		if (s != null) {

			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		systemUser.setChangedPassword(false);
		systemUser.setIsActive(true);
		systemUser.setRole("patient");
		systemUser.getReceptionist().setAccess(new String("access").getBytes());
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		systemUser.setRegisterDate(c);
		try {
			String i = systemUserService.saveSystemUserReceptionist(systemUser);
			systemUser.setId(i);
			// permissionMangament.setUserPermission(systemUser);
			map.put("status", "ok");
			return Response.ok(map).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	public Set<SystemUserPermissionView> showPermissionById(String pesel) {
		return permissionMangament.showPermissionById(pesel);
	}

	public Response updateReceptionist(SystemUser systemUser, String pesel) {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		String id = su.getReceptionist().getId();
		Receptionist p = ReceptionistDao.findReceptionistById(id);
		if (p instanceof HibernateProxy) {
			HibernateProxy proxy = (HibernateProxy) p;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			p = (Receptionist) li.getImplementation();
		}
		String i = ReceptionistService.saveReceptionist(p);
		try {
			try {
				return Response.ok(
						new ObjectMapper().configure(
								Feature.FAIL_ON_EMPTY_BEANS, false)
								.writeValueAsString(
										ReceptionistDao.findReceptionistById(i))).build();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Response deleteReceptionist(String pesel) {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		su.setIsActive(false);
		systemUserService.saveSystemUser(su);
		return null;
	}

	public Set<ReceptionistView> getAllReceptionists() {
		return ReceptionistViewDao.findAllReceptionists();
	}

	public ReceptionistView getReceptionistById(String pesel) {
		return new ReceptionistView(); //ReceptionistViewDao.findReceptionistById(pesel);
	}

}
