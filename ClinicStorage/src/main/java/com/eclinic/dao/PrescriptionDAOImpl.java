package com.eclinic.dao;

import com.eclinic.domain.Prescription;

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
 * DAO to manage Prescription entities.
 * 
 */
@Repository("PrescriptionDAO")
@Transactional
public class PrescriptionDAOImpl extends AbstractJpaDao<Prescription> implements
		PrescriptionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Prescription.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PrescriptionDAOImpl
	 *
	 */
	public PrescriptionDAOImpl() {
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
	 * JPQL Query - findPrescriptionByExecutionDateBefore
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDateBefore(java.util.Calendar executionDate) throws DataAccessException {

		return findPrescriptionByExecutionDateBefore(executionDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByExecutionDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDateBefore(java.util.Calendar executionDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByExecutionDateBefore", startResult, maxRows, executionDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByDepartmentContaining
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByDepartmentContaining(String department) throws DataAccessException {

		return findPrescriptionByDepartmentContaining(department, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByDepartmentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByDepartmentContaining(String department, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByDepartmentContaining", startResult, maxRows, department);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPrescriptions
	 *
	 */
	@Transactional
	public Set<Prescription> findAllPrescriptions() throws DataAccessException {

		return findAllPrescriptions(-1, -1);
	}

	/**
	 * JPQL Query - findAllPrescriptions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findAllPrescriptions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPrescriptions", startResult, maxRows);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByDepartment
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByDepartment(String department) throws DataAccessException {

		return findPrescriptionByDepartment(department, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByDepartment
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByDepartment(String department, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByDepartment", startResult, maxRows, department);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionById
	 *
	 */
	@Transactional
	public Prescription findPrescriptionById(Integer id) throws DataAccessException {

		return findPrescriptionById(id, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionById
	 *
	 */

	@Transactional
	public Prescription findPrescriptionById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPrescriptionById", startResult, maxRows, id);
			return (com.eclinic.domain.Prescription) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPrescriptionByExecutionDateAfter
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDateAfter(java.util.Calendar executionDate) throws DataAccessException {

		return findPrescriptionByExecutionDateAfter(executionDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByExecutionDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDateAfter(java.util.Calendar executionDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByExecutionDateAfter", startResult, maxRows, executionDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDate
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDate(java.util.Calendar issuedDate) throws DataAccessException {

		return findPrescriptionByIssuedDate(issuedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDate(java.util.Calendar issuedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByIssuedDate", startResult, maxRows, issuedDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByExecutionDate
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDate(java.util.Calendar executionDate) throws DataAccessException {

		return findPrescriptionByExecutionDate(executionDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByExecutionDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByExecutionDate(java.util.Calendar executionDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByExecutionDate", startResult, maxRows, executionDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDateBefore
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDateBefore(java.util.Calendar issuedDate) throws DataAccessException {

		return findPrescriptionByIssuedDateBefore(issuedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDateBefore(java.util.Calendar issuedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByIssuedDateBefore", startResult, maxRows, issuedDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDateAfter
	 *
	 */
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDateAfter(java.util.Calendar issuedDate) throws DataAccessException {

		return findPrescriptionByIssuedDateAfter(issuedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByIssuedDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Prescription> findPrescriptionByIssuedDateAfter(java.util.Calendar issuedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPrescriptionByIssuedDateAfter", startResult, maxRows, issuedDate);
		return new LinkedHashSet<Prescription>(query.getResultList());
	}

	/**
	 * JPQL Query - findPrescriptionByPrimaryKey
	 *
	 */
	@Transactional
	public Prescription findPrescriptionByPrimaryKey(Integer id) throws DataAccessException {

		return findPrescriptionByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findPrescriptionByPrimaryKey
	 *
	 */

	@Transactional
	public Prescription findPrescriptionByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPrescriptionByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Prescription) query.getSingleResult();
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
	public boolean canBeMerged(Prescription entity) {
		return true;
	}
}
