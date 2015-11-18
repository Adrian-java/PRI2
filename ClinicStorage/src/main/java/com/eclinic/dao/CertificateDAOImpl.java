package com.eclinic.dao;

import com.eclinic.domain.Certificate;

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
 * DAO to manage Certificate entities.
 * 
 */
@Repository("CertificateDAO")
@Transactional
public class CertificateDAOImpl extends AbstractJpaDao<Certificate> implements
		CertificateDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Certificate.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new CertificateDAOImpl
	 *
	 */
	public CertificateDAOImpl() {
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
	 * JPQL Query - findAllCertificates
	 *
	 */
	@Transactional
	public Set<Certificate> findAllCertificates() throws DataAccessException {

		return findAllCertificates(-1, -1);
	}

	/**
	 * JPQL Query - findAllCertificates
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Certificate> findAllCertificates(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllCertificates", startResult, maxRows);
		return new LinkedHashSet<Certificate>(query.getResultList());
	}

	/**
	 * JPQL Query - findCertificateById
	 *
	 */
	@Transactional
	public Certificate findCertificateById(Integer id) throws DataAccessException {

		return findCertificateById(id, -1, -1);
	}

	/**
	 * JPQL Query - findCertificateById
	 *
	 */

	@Transactional
	public Certificate findCertificateById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCertificateById", startResult, maxRows, id);
			return (com.eclinic.domain.Certificate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCertificateByPrimaryKey
	 *
	 */
	@Transactional
	public Certificate findCertificateByPrimaryKey(Integer id) throws DataAccessException {

		return findCertificateByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findCertificateByPrimaryKey
	 *
	 */

	@Transactional
	public Certificate findCertificateByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCertificateByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Certificate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCertificateByIdNumberContaining
	 *
	 */
	@Transactional
	public Set<Certificate> findCertificateByIdNumberContaining(String idNumber) throws DataAccessException {

		return findCertificateByIdNumberContaining(idNumber, -1, -1);
	}

	/**
	 * JPQL Query - findCertificateByIdNumberContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Certificate> findCertificateByIdNumberContaining(String idNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCertificateByIdNumberContaining", startResult, maxRows, idNumber);
		return new LinkedHashSet<Certificate>(query.getResultList());
	}

	/**
	 * JPQL Query - findCertificateByIdNumber
	 *
	 */
	@Transactional
	public Set<Certificate> findCertificateByIdNumber(String idNumber) throws DataAccessException {

		return findCertificateByIdNumber(idNumber, -1, -1);
	}

	/**
	 * JPQL Query - findCertificateByIdNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Certificate> findCertificateByIdNumber(String idNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCertificateByIdNumber", startResult, maxRows, idNumber);
		return new LinkedHashSet<Certificate>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Certificate entity) {
		return true;
	}
}
