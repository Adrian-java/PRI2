package com.eclinic.user.mangament.doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.view.DoctorViewDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.DoctorView;
import com.eclinic.domain.view.SystemUserPermissionView;
import com.eclinic.service.DoctorService;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.PermissionMangament;

@Component("doctorCrud")
public class DoctorCrudDB implements DoctorCrud {

	@Autowired
	private SystemUserDAO systemUserDAO;
	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private PermissionMangament permissionMangament;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DoctorDAO doctorDao;
	@Autowired
	private DoctorViewDAO doctorViewDao;
	@Autowired
	private SpecializationDAO specializationDao;

	public Response addDoctor(SystemUser systemUser) {
		if (systemUser.getPatient() != null || systemUser.getAdmin() != null
				|| systemUser.getReceptionist() != null) {
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
		systemUser.setRole("doctor");
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		systemUser.setRegisterDate(c);
		try {
			map.put("status","ok");
			String i = systemUserService.saveSystemUserDoctor(systemUser,false);
			Specialization sp = systemUser.getDoctor().getSpecializations().iterator().next();
			sp.setDoctor(doctorDao.findDoctorById(i));
			specializationDao.merge(sp);
			specializationDao.flush();
			return Response.ok(map)
					.build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	public Set<SystemUserPermissionView> showPermissionByPesel(String pesel) {
		return permissionMangament.showPermissionById(pesel);
	}

	public Response updateDoctor(Doctor doctor, String id) {
//		if (d instanceof HibernateProxy) {
//			HibernateProxy proxy = (HibernateProxy) d;
//			LazyInitializer li = proxy.getHibernateLazyInitializer();
//			d = (Doctor) li.getImplementation();
//		}
		doctor.setId(id);
		String i = doctorService.saveDoctor(doctor);
		try {
			try {
				return Response
						.ok(new ObjectMapper()
								.configure(Feature.FAIL_ON_EMPTY_BEANS, false)
								.writeValueAsString(doctorDao.findDoctorById(i)))
						.build();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Response deleteDoctor(String pesel) {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		Map<String, String> map = new TreeMap<String, String>();
		if (su.getRole().equalsIgnoreCase("doctor")) {
			su.setIsActive(false);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			su.setUnregisterDate(c);
			systemUserService.saveSystemUserDoctor(su,true);
			map.put("status", "usunieto");
			return Response.ok(map).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	public Set<DoctorView> getAllDoctors() {
		return doctorViewDao.findAllDoctors();
	}

	public DoctorView getDoctorById(String pesel) {
		return doctorViewDao.findDoctorByPesel(pesel);
	}

	public Set<DoctorView> getDoctorsBySpecialization(String specialization) {
		Set<Specialization> sp = specializationDao
				.findSpecializationByName(specialization);
		List<DoctorView> dv = new ArrayList<DoctorView>();
		Set<DoctorView> set = new HashSet<DoctorView>();
		Iterator<Specialization> i = sp.iterator();
		while (i.hasNext()) {
			String id = i.next().getDoctor().getId();
			DoctorView findDoctorById = doctorViewDao.findDoctorById(id);
			dv.add(findDoctorById);
		}
		set.addAll(dv);
		return set;
	}

}
