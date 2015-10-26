package com.eclinic.user.mangament.doctor;

import java.util.Set;

import javax.ws.rs.core.Response;

import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.DoctorView;

public interface DoctorCrud {

	public Response AddDoctor(SystemUser systemUser);
	
	public Set<DoctorView> getAllDoctors();
	
	public DoctorView getDoctorByPesel(String pesel);
	
	public Set<DoctorView> getDoctorsBySpecialization(String specialization);
}
