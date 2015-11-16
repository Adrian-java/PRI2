package com.eclinic.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.SystemUserPermission;

public interface SystemUserPermissionDAO extends JpaDao<SystemUserPermission> {

	public SystemUserPermission findSystemUserPermissionByPrimaryKey(Integer id);

	public Set<SystemUserPermission> findSickLeaveByDateFromAfter(
			java.util.Calendar dateFrom) throws DataAccessException;

	//
	// /**
	// * JPQL Query - findSickLeaveByDateFromAfter
	// *
	// */
	public Set<SystemUserPermission> findSickLeaveByDateFromAfter(
			Calendar dateFrom, int startResult, int maxRows)
			throws DataAccessException;

	//
	// /**
	// * JPQL Query - findSickLeaveByPrimaryKey
	// *
	// */
	public SystemUserPermission findSickLeaveByPrimaryKey(Integer id)
			throws DataAccessException;

	public Set<SystemUserPermission> findAllSystemUserPermissions();
}
