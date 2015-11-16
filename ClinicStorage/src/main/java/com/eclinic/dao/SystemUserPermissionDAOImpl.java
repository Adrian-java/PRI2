package com.eclinic.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.domain.SystemUserPermission;

@Repository("SystemUserPermissionDAO")
@Transactional
public class SystemUserPermissionDAOImpl extends
		AbstractJpaDao<SystemUserPermission> implements SystemUserPermissionDAO {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { SystemUserPermission.class }));

	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Set<Class<?>> getTypes() {
		// TODO Auto-generated method stub
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(SystemUserPermission o) {
		// TODO Auto-generated method stub
		return false;
	}

	public SystemUserPermission findSystemUserPermissionByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<SystemUserPermission> findSickLeaveByDateFromAfter(
			Calendar dateFrom) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<SystemUserPermission> findSickLeaveByDateFromAfter(
			Calendar dateFrom, int startResult, int maxRows)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public SystemUserPermission findSickLeaveByPrimaryKey(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<SystemUserPermission> findAllSystemUserPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

}
