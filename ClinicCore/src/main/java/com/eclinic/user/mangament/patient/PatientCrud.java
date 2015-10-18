package com.eclinic.user.mangament.patient;

import javax.ws.rs.core.Response;

import com.eclinic.domain.SystemUser;

public interface PatientCrud  {

	public Response addPatient(SystemUser systemUser);
}
