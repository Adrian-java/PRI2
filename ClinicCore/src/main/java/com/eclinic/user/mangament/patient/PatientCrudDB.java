package com.eclinic.user.mangament.patient;

import java.io.IOException;
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

import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.view.PatientViewDAO;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.SystemUserPermissionView;
import com.eclinic.service.PatientService;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.PermissionMangament;

@Component("patientCrud")
public class PatientCrudDB implements PatientCrud {

	@Autowired
	private SystemUserDAO systemUserDAO;
	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PermissionMangament permissionMangament;
	@Autowired
	PatientViewDAO patientViewDao;

	public Response addPatient(SystemUser systemUser) {

		if (systemUser.getWorker() != null) {
			if (systemUser.getEmail() == null)
				systemUser.setEmail("em");
			Worker w = systemUser.getWorker();
			if (w.getDoctor() != null || w.getAdmin() != null
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
		// systemUser.setIsActive(true);
		// wysylka maila automatycznie
		Integer i = systemUserService.saveSystemUser(systemUser);
		systemUser.setId(i);
		permissionMangament.setUserPermission(systemUser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	public Set<SystemUserPermissionView> showPermissionByPesel(String pesel) {
		return permissionMangament.showPermissionByPesel(pesel);
	}

	public Response updatePatient(SystemUser systemUser, String pesel) {
		SystemUser su = systemUserDAO.findSystemUserByPesel(pesel);
		Integer id = su.getWorker().getPatient().getId();
		Patient p = patientDao.findPatientById(id);
		if (p instanceof HibernateProxy) {
			HibernateProxy proxy = (HibernateProxy) p;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			p = (Patient) li.getImplementation();
		}
		Integer i = patientService.savePatient(p);
		try {
			try {
				return Response.ok(
						new ObjectMapper().configure(
								Feature.FAIL_ON_EMPTY_BEANS, false)
								.writeValueAsString(
										patientDao.findPatientById(i))).build();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Response deletePatient(String pesel) {
		SystemUser su = systemUserDAO.findSystemUserByPesel(pesel);
		su.setIsActive(false);
		systemUserService.saveSystemUser(su);
		return null;
	}

	public Set<PatientView> getAllPatients() {
		return patientViewDao.findAllPatients();
	}

	public PatientView getPatientByPesel(String pesel) {
		return patientViewDao.findPatientByPesel(pesel);
	}

}
