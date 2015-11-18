package com.eclinic.user.mangament.receptionist;

import java.util.Set;

import javax.ws.rs.core.Response;

import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.ReceptionistView;
import com.eclinic.domain.view.SystemUserPermissionView;

public interface ReceptionistCrud  {

	public Response addReceptionist(SystemUser systemUser);
	
	public Response updateReceptionist(SystemUser systemUser, String pesel);
	
	public Response deleteReceptionist(String pesel);
	
	public Set<SystemUserPermissionView> showPermissionById(String pesel);
	
	public Set<ReceptionistView> getAllReceptionists();
	
	public ReceptionistView getReceptionistById(String pesel);
}
