package com.eclinic.dao.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.view.SystemUserPermissionView;

@Repository("SystemUserPermissionViewDAO")
@Transactional
public class SystemUserPermissionViewDAOImpl extends
		AbstractJpaDao<SystemUserPermissionView> implements
		SystemUserPermissionViewDAO {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Receptionist.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	public SystemUserPermissionView store(SystemUserPermissionView obj) {
		return null;
	}

	public SystemUserPermissionView merge(SystemUserPermissionView obj) {
		return null;
	}

	public boolean canBeMerged(SystemUserPermissionView o) {
		return true;
	}

	public SystemUserPermissionView executeQueryByNameSingleResult(
			String queryName) {
		return null;
	}

	public SystemUserPermissionView executeQueryByNameSingleResult(
			String queryName, Object... parameters) {
		return null;
	}

	public SystemUserPermissionView executeQuerySingleResult(
			String queryString, Object... parameters) {
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@SuppressWarnings("unchecked")
	public Set<SystemUserPermissionView> findSystemUserPermissionByPesel(
			String pesel) {
		Query query= createNamedQuery("findSystemUserPermissionByPesel", -1, -1, pesel);
		return new LinkedHashSet<SystemUserPermissionView>(query.getResultList());
	}

}
