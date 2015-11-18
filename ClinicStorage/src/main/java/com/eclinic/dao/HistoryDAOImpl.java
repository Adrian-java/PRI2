package com.eclinic.dao;

import com.eclinic.domain.History;

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

@Repository("HistoryDAO")
@Transactional
public class HistoryDAOImpl extends AbstractJpaDao<History> implements
		HistoryDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { History.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new HistoryDAOImpl
	 *
	 */
	public HistoryDAOImpl() {
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
	 * JPQL Query - findHistoryByDateFrom
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateFrom(java.util.Calendar dateFrom) throws DataAccessException {

		return findHistoryByDateFrom(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateFrom
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateFrom(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateFrom", startResult, maxRows, dateFrom);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByDateFromBefore
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateFromBefore(java.util.Calendar dateFrom) throws DataAccessException {

		return findHistoryByDateFromBefore(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateFromBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateFromBefore(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateFromBefore", startResult, maxRows, dateFrom);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByStatisticNumberContaining
	 *
	 */
	@Transactional
	public Set<History> findHistoryByStatisticNumberContaining(String statisticNumber) throws DataAccessException {

		return findHistoryByStatisticNumberContaining(statisticNumber, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByStatisticNumberContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByStatisticNumberContaining(String statisticNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByStatisticNumberContaining", startResult, maxRows, statisticNumber);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByDateToBefore
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateToBefore(java.util.Calendar dateTo) throws DataAccessException {

		return findHistoryByDateToBefore(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateToBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateToBefore(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateToBefore", startResult, maxRows, dateTo);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByDateFromAfter
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateFromAfter(java.util.Calendar dateFrom) throws DataAccessException {

		return findHistoryByDateFromAfter(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateFromAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateFromAfter(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateFromAfter", startResult, maxRows, dateFrom);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByDateTo
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateTo(java.util.Calendar dateTo) throws DataAccessException {

		return findHistoryByDateTo(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateTo
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateTo(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateTo", startResult, maxRows, dateTo);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByStatisticNumber
	 *
	 */
	@Transactional
	public Set<History> findHistoryByStatisticNumber(String statisticNumber) throws DataAccessException {

		return findHistoryByStatisticNumber(statisticNumber, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByStatisticNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByStatisticNumber(String statisticNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByStatisticNumber", startResult, maxRows, statisticNumber);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByFirstIllness
	 *
	 */
	@Transactional
	public Set<History> findHistoryByFirstIllness(Boolean firstIllness) throws DataAccessException {

		return findHistoryByFirstIllness(firstIllness, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByFirstIllness
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByFirstIllness(Boolean firstIllness, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByFirstIllness", startResult, maxRows, firstIllness);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllHistorys
	 *
	 */
	@Transactional
	public Set<History> findAllHistorys() throws DataAccessException {

		return findAllHistorys(-1, -1);
	}

	/**
	 * JPQL Query - findAllHistorys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findAllHistorys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllHistorys", startResult, maxRows);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryById
	 *
	 */
	@Transactional
	public History findHistoryById(Integer id) throws DataAccessException {

		return findHistoryById(id, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryById
	 *
	 */

	@Transactional
	public History findHistoryById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findHistoryById", startResult, maxRows, id);
			return (com.eclinic.domain.History) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findHistoryByDateToAfter
	 *
	 */
	@Transactional
	public Set<History> findHistoryByDateToAfter(java.util.Calendar dateTo) throws DataAccessException {

		return findHistoryByDateToAfter(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByDateToAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<History> findHistoryByDateToAfter(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findHistoryByDateToAfter", startResult, maxRows, dateTo);
		return new LinkedHashSet<History>(query.getResultList());
	}

	/**
	 * JPQL Query - findHistoryByPrimaryKey
	 *
	 */
	@Transactional
	public History findHistoryByPrimaryKey(Integer id) throws DataAccessException {

		return findHistoryByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findHistoryByPrimaryKey
	 *
	 */

	@Transactional
	public History findHistoryByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findHistoryByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.History) query.getSingleResult();
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
	public boolean canBeMerged(History entity) {
		return true;
	}
}
