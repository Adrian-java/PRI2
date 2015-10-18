package com.eclinic.exception;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.eclinic.dao.SystemErrorDAO;
import com.eclinic.dao.SystemErrorDAOImpl;
import com.eclinic.domain.SystemError;

public class ClinicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClinicException(String messge) {
		super(messge);
	}

	 public ClinicException() {
		super();
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		SystemError systemError = new SystemError();
		Calendar cal = new GregorianCalendar();
		systemError.setDate(cal);
		systemError.setFixed(String.valueOf(0).getBytes());
		systemError.setGeneratedErrorDescription(getMessage().getBytes());
		SystemErrorDAO systemErrorDAO = new SystemErrorDAOImpl();
		systemErrorDAO.merge(systemError);

	}

}
