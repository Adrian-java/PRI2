package com.eclinic.user.mangament.doctor;

import javax.ws.rs.core.Response;

import com.eclinic.domain.SystemUser;

public interface DoctorCrud {

	public Response AddDoctor(SystemUser systemUser);
}
