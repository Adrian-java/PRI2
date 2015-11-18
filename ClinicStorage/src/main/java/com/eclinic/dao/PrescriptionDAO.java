package com.eclinic.dao;

import com.eclinic.domain.Prescription;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Prescription entities.
 * 
 */
public interface PrescriptionDAO extends JpaDao<Prescription> {

	/**
	 * JPQL Query - findPrescriptionByExecutionDateBefore
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDateBefore(java.util.Calendar executionDate) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByExecutionDateBefore
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDateBefore(Calendar executionDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByDepartmentContaining
	 *
	 */
	public Set<Prescription> findPrescriptionByDepartmentContaining(String department) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByDepartmentContaining
	 *
	 */
	public Set<Prescription> findPrescriptionByDepartmentContaining(String department, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrescriptions
	 *
	 */
	public Set<Prescription> findAllPrescriptions() throws DataAccessException;

	/**
	 * JPQL Query - findAllPrescriptions
	 *
	 */
	public Set<Prescription> findAllPrescriptions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByDepartment
	 *
	 */
	public Set<Prescription> findPrescriptionByDepartment(String department_1) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByDepartment
	 *
	 */
	public Set<Prescription> findPrescriptionByDepartment(String department_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionById
	 *
	 */
	public Prescription findPrescriptionById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionById
	 *
	 */
	public Prescription findPrescriptionById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByExecutionDateAfter
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDateAfter(java.util.Calendar executionDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByExecutionDateAfter
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDateAfter(Calendar executionDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDate
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDate(java.util.Calendar issuedDate) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDate
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDate(Calendar issuedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByExecutionDate
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDate(java.util.Calendar executionDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByExecutionDate
	 *
	 */
	public Set<Prescription> findPrescriptionByExecutionDate(Calendar executionDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDateBefore
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDateBefore(java.util.Calendar issuedDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDateBefore
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDateBefore(Calendar issuedDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDateAfter
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDateAfter(java.util.Calendar issuedDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByIssuedDateAfter
	 *
	 */
	public Set<Prescription> findPrescriptionByIssuedDateAfter(Calendar issuedDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByPrimaryKey
	 *
	 */
	public Prescription findPrescriptionByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPrescriptionByPrimaryKey
	 *
	 */
	public Prescription findPrescriptionByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}