package com.eclinic.user.mangament.patient;

import java.util.Set;

import javax.ws.rs.core.Response;

import com.eclinic.domain.Patient;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.SystemUserPermissionView;

public interface PatientCrud  {

	public Response addPatient(SystemUser systemUser);
	
	public Response updatePatient(Patient p, String pesel);
	
	public Response deletePatient(String pesel);
	
	public Set<SystemUserPermissionView> showPermissionById(String pesel);
	
	public Set<PatientView> getAllPatients();
	
	public PatientView getPatientById(String pesel);
}
