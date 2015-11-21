package com.eclinic.dao;

import com.eclinic.domain.Clinic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Clinic entities.
 * 
 */
@Repository("ClinicDAO")
@Transactional
public class ClinicDAOImpl extends AbstractJpaDao<Clinic> implements ClinicDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Clinic.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ClinicDAOImpl
	 *
	 */
	public ClinicDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findClinicByNameContaining
	 *
	 */
	@Transactional
	public Set<Clinic> findClinicByNameContaining(String name) throws DataAccessException {

		return findClinicByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findClinicByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Clinic> findClinicByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClinicByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Clinic>(query.getResultList());
	}

	/**
	 * JPQL Query - findClinicByPrimaryKey
	 *
	 */
	@Transactional
	public Clinic findClinicByPrimaryKey(Integer id) throws DataAccessException {

		return findClinicByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findClinicByPrimaryKey
	 *
	 */

	@Transactional
	public Clinic findClinicByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClinicByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Clinic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllClinics
	 *
	 */
	@Transactional
	public Set<Clinic> findAllClinics() throws DataAccessException {

		return findAllClinics(-1, -1);
	}

	/**
	 * JPQL Query - findAllClinics
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Clinic> findAllClinics(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllClinics", startResult, maxRows);
		return new LinkedHashSet<Clinic>(query.getResultList());
	}

	/**
	 * JPQL Query - findClinicById
	 *
	 */
	@Transactional
	public Clinic findClinicById(Integer id) throws DataAccessException {

		return findClinicById(id, -1, -1);
	}

	/**
	 * JPQL Query - findClinicById
	 *
	 */

	@Transactional
	public Clinic findClinicById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClinicById", startResult, maxRows, id);
			return (com.eclinic.domain.Clinic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findClinicByName
	 *
	 */
	@Transactional
	public Set<Clinic> findClinicByName(String name) throws DataAccessException {

		return findClinicByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findClinicByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Clinic> findClinicByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClinicByName", startResult, maxRows, name);
		return new LinkedHashSet<Clinic>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Clinic entity) {
		return true;
	}
}
