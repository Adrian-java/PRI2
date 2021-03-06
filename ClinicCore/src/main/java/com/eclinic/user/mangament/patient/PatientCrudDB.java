package com.eclinic.user.mangament.patient;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
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
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.SystemUserPermissionView;
import com.eclinic.service.AddressService;
import com.eclinic.service.PatientService;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.PermissionMangament;

@Component("PatientCrud")
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
	@Autowired
	private AddressService addressService;

	public Response addPatient(SystemUser systemUser) {

		if (systemUser.getEmail() == null)
			systemUser.setEmail("em");
		if (systemUser.getDoctor() != null || systemUser.getAdmin() != null
				|| systemUser.getReceptionist() != null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		Map<String, String> map = new HashMap<String, String>();
		SystemUser s = systemUserDAO.findSystemUserById(systemUser.getId());
		if (s != null) {

			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		// systemUser.setIsActive(true);
		// wysylka maila automatycznie
		systemUser.getPatient().setConfirmed(0);
		systemUser.setChangedPassword(false);
		systemUser.setIsActive(true);
		systemUser.setRole("patient");
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		systemUser.setRegisterDate(c);
		try {
			String i = systemUserService.saveSystemUserPatient(systemUser,false);
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

	public Response updatePatient(Patient p, String id) {
//		if (p instanceof HibernateProxy) {
//			HibernateProxy proxy = (HibernateProxy) p;
//			LazyInitializer li = proxy.getHibernateLazyInitializer();
//			p = (Patient) li.getImplementation();
//		}
		if(p.getAddress()!=null){
			p.getAddress().setId(patientDao.findPatientById(id).getAddress().getId());
			addressService.saveAddress(p.getAddress());
		}
		p.setId(id);
		String i = patientService.savePatient(p);
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
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		Map<String, String> map = new TreeMap<String, String>();
		if (su.getRole().equalsIgnoreCase("patient")) {
			su.setIsActive(false);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			su.setUnregisterDate(c);
			systemUserService.saveSystemUserPatient(su,true);
			map.put("status", "usunieto");
			return Response.ok(map).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	public Set<PatientView> getAllPatients() {
		return patientViewDao.findAllPatients();
	}

	public PatientView getPatientById(String pesel) {
		return patientViewDao.findPatientByPesel(pesel);
	}

}
