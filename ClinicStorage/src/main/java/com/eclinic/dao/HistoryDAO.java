package com.eclinic.dao;

import com.eclinic.domain.History;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage History entities.
 * 
 */
public interface HistoryDAO extends JpaDao<History> {

	/**
	 * JPQL Query - findHistoryByDateFrom
	 *
	 */
	public Set<History> findHistoryByDateFrom(java.util.Calendar dateFrom) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateFrom
	 *
	 */
	public Set<History> findHistoryByDateFrom(Calendar dateFrom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateFromBefore
	 *
	 */
	public Set<History> findHistoryByDateFromBefore(java.util.Calendar dateFrom_1) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateFromBefore
	 *
	 */
	public Set<History> findHistoryByDateFromBefore(Calendar dateFrom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByStatisticNumberContaining
	 *
	 */
	public Set<History> findHistoryByStatisticNumberContaining(String statisticNumber) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByStatisticNumberContaining
	 *
	 */
	public Set<History> findHistoryByStatisticNumberContaining(String statisticNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateToBefore
	 *
	 */
	public Set<History> findHistoryByDateToBefore(java.util.Calendar dateTo) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateToBefore
	 *
	 */
	public Set<History> findHistoryByDateToBefore(Calendar dateTo, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateFromAfter
	 *
	 */
	public Set<History> findHistoryByDateFromAfter(java.util.Calendar dateFrom_2) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateFromAfter
	 *
	 */
	public Set<History> findHistoryByDateFromAfter(Calendar dateFrom_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateTo
	 *
	 */
	public Set<History> findHistoryByDateTo(java.util.Calendar dateTo_1) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateTo
	 *
	 */
	public Set<History> findHistoryByDateTo(Calendar dateTo_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByStatisticNumber
	 *
	 */
	public Set<History> findHistoryByStatisticNumber(String statisticNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByStatisticNumber
	 *
	 */
	public Set<History> findHistoryByStatisticNumber(String statisticNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByFirstIllness
	 *
	 */
	public Set<History> findHistoryByFirstIllness(Boolean firstIllness) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByFirstIllness
	 *
	 */
	public Set<History> findHistoryByFirstIllness(Boolean firstIllness, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllHistorys
	 *
	 */
	public Set<History> findAllHistorys() throws DataAccessException;

	/**
	 * JPQL Query - findAllHistorys
	 *
	 */
	public Set<History> findAllHistorys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryById
	 *
	 */
	public History findHistoryById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryById
	 *
	 */
	public History findHistoryById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateToAfter
	 *
	 */
	public Set<History> findHistoryByDateToAfter(java.util.Calendar dateTo_2) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByDateToAfter
	 *
	 */
	public Set<History> findHistoryByDateToAfter(Calendar dateTo_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByPrimaryKey
	 *
	 */
	public History findHistoryByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findHistoryByPrimaryKey
	 *
	 */
	public History findHistoryByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}