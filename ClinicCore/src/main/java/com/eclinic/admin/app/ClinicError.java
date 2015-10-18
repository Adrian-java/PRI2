package com.eclinic.admin.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.eclinic.dao.SystemErrorDAO;
import com.eclinic.dao.SystemErrorDAOImpl;
import com.eclinic.domain.SystemError;

public class ClinicError {

	private SystemErrorDAO dao;

	public void setFixed(SystemError error) {
		error.setFixed(String.valueOf(1).getBytes());
		dao = new SystemErrorDAOImpl();
		dao.merge(error);
	}

	public List<SystemError> getErrorByDate(Date from, Date to) {

		dao = new SystemErrorDAOImpl();
		Set<SystemError> findAllSystemErrors = dao.findAllSystemErrors();
		List<SystemError> error = new ArrayList<SystemError>();
		for (SystemError er : findAllSystemErrors) {
			if (er.getDate().after(to) && er.getDate().before(from))
				error.add(er);
		}
		return error;
	}
}
