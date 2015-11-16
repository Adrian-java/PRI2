package com.eclinic.dao.view;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.view.DoctorView;

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
 * DAO to manage Doctor entities.
 * 
 */
@Repository("DoctorViewDAO")
@Transactional
public class DoctorViewDAOImpl extends AbstractJpaDao<DoctorView> implements DoctorViewDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Doctor.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DoctorDAOImpl
	 *
	 */
	public DoctorViewDAOImpl() {
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
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	@Transactional
	public Set<DoctorView> findDoctorBySurnameContaining(String surname) throws DataAccessException {

		return findDoctorBySurnameContaining(surname, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DoctorView> findDoctorBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorBySurnameContaining", startResult, maxRows, surname);
		return new LinkedHashSet<DoctorView>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	@Transactional
	public Set<DoctorView> findDoctorBySurname(String surname) throws DataAccessException {

		return findDoctorBySurname(surname, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DoctorView> findDoctorBySurname(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorBySurname", startResult, maxRows, surname);
		return new LinkedHashSet<DoctorView>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	@Transactional
	public Set<DoctorView> findDoctorByName(String name) throws DataAccessException {

		return findDoctorByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DoctorView> findDoctorByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorByName", startResult, maxRows, name);
		return new LinkedHashSet<DoctorView>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	@Transactional
	public Set<DoctorView> findAllDoctors() throws DataAccessException {

		return findAllDoctors(-1, -1);
	}

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DoctorView> findAllDoctors(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllDoctors", startResult, maxRows);
		return new LinkedHashSet<DoctorView>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	@Transactional
	public Set<DoctorView> findDoctorByNameContaining(String name) throws DataAccessException {

		return findDoctorByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DoctorView> findDoctorByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<DoctorView>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	@Transactional
	public DoctorView findDoctorByPrimaryKey(String id) throws DataAccessException {

		return findDoctorByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */

	@Transactional
	public DoctorView findDoctorByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDoctorByPrimaryKey", startResult, maxRows, id);
			return (DoctorView) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	@Transactional
	public DoctorView findDoctorById(String id) throws DataAccessException {

		return findDoctorById(id, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorById
	 *
	 */

	@Transactional
	public DoctorView findDoctorById(String id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDoctorViewById", startResult, maxRows, id);
			return (DoctorView) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(DoctorView entity) {
		return true;
	}

	public DoctorView findDoctorByPesel(String pesel)
			throws DataAccessException {
		Query query = createNamedQuery("findDoctorByPesel", -1, -1, pesel);
		return (DoctorView) query.getSingleResult();
	}

	public Set<DoctorView> findDoctorBySpecialization(String specialization) {
		Query query = createNamedQuery("findDoctorByS", -1, -1, specialization);
		return (Set<DoctorView>) query.getSingleResult();
	}

}
