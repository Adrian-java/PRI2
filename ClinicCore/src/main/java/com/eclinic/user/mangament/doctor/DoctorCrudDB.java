package com.eclinic.user.mangament.doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.view.DoctorViewDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;
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
		Doctor d = doctorDao.findDoctorById(id);
		if (d instanceof HibernateProxy) {
			HibernateProxy proxy = (HibernateProxy) d;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			d = (Doctor) li.getImplementation();
		}
		Integer i = doctorService.saveDoctor(d);
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

	public Response deletePatient(String pesel) {
		SystemUser su = systemUserDAO.findSystemUserByPesel(pesel);
		su.setIsActive(false);
		systemUserService.saveSystemUser(su);
		return null;
	}

	public Set<DoctorView> getAllDoctors() {
		return doctorViewDao.findAllDoctors();
	}

	public DoctorView getDoctorByPesel(String pesel) {
		return doctorViewDao.findDoctorByPesel(pesel);
	}

	public Set<DoctorView> getDoctorsBySpecialization(String specialization) {
		Set<Specialization> sp = specializationDao.findSpecializationByName(specialization);
		List<DoctorView> dv = new ArrayList<DoctorView>();
		Set<DoctorView> set = new HashSet<DoctorView>();
		Iterator<Specialization> i = sp.iterator();
		while(i.hasNext()){
			Integer id = i.next().getDoctor().getId();
			DoctorView findDoctorById = doctorViewDao.findDoctorById(id);
			dv.add(findDoctorById);
		}
		set.addAll(dv);
		return set;
	}

}
