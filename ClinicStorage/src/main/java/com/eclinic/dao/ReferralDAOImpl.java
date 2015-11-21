package com.eclinic.dao;

import com.eclinic.domain.Referral;

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
 * DAO to manage Referral entities.
 * 
 */
@Repository("ReferralDAO")
@Transactional
public class ReferralDAOImpl extends AbstractJpaDao<Referral> implements
		ReferralDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Referral.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ReferralDAOImpl
	 *
	 */
	public ReferralDAOImpl() {
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
	 * JPQL Query - findReferralByPrimaryKey
	 *
	 */
	@Transactional
	public Referral findReferralByPrimaryKey(Integer id) throws DataAccessException {

		return findReferralByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findReferralByPrimaryKey
	 *
	 */

	@Transactional
	public Referral findReferralByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReferralByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Referral) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReferralById
	 *
	 */
	@Transactional
	public Referral findReferralById(Integer id) throws DataAccessException {

		return findReferralById(id, -1, -1);
	}

	/**
	 * JPQL Query - findReferralById
	 *
	 */

	@Transactional
	public Referral findReferralById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReferralById", startResult, maxRows, id);
			return (com.eclinic.domain.Referral) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllReferrals
	 *
	 */
	@Transactional
	public Set<Referral> findAllReferrals() throws DataAccessException {

		return findAllReferrals(-1, -1);
	}

	/**
	 * JPQL Query - findAllReferrals
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Referral> findAllReferrals(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllReferrals", startResult, maxRows);
		return new LinkedHashSet<Referral>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Referral entity) {
		return true;
	}
}
