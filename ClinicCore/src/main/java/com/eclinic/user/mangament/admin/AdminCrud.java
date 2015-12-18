package com.eclinic.user.mangament.admin;

import java.util.Set;

import javax.ws.rs.core.Response;

import com.eclinic.domain.view.AdminView;

public interface AdminCrud {

//	public Response addDoctor(SystemUser systemUser);
	
	public Set<AdminView> getAllAdmins();
	
	//public DoctorView getDoctorById(String pesel);
	
	//public Set<DoctorView> getDoctorsBySpecialization(String specialization);
	
	public Response deleteAdmin(String id);
}
