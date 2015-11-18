package com.eclinic.dao;

import com.eclinic.domain.Clinic;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Clinic entities.
 * 
 */
public interface ClinicDAO extends JpaDao<Clinic> {

	/**
	 * JPQL Query - findClinicByNameContaining
	 *
	 */
	public Set<Clinic> findClinicByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findClinicByNameContaining
	 *
	 */
	public Set<Clinic> findClinicByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClinicByPrimaryKey
	 *
	 */
	public Clinic findClinicByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findClinicByPrimaryKey
	 *
	 */
	public Clinic findClinicByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllClinics
	 *
	 */
	public Set<Clinic> findAllClinics() throws DataAccessException;

	/**
	 * JPQL Query - findAllClinics
	 *
	 */
	public Set<Clinic> findAllClinics(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClinicById
	 *
	 */
	public Clinic findClinicById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findClinicById
	 *
	 */
	public Clinic findClinicById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClinicByName
	 *
	 */
	public Set<Clinic> findClinicByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findClinicByName
	 *
	 */
	public Set<Clinic> findClinicByName(String name_1, int startResult, int maxRows) throws DataAccessException;

}