package com.eclinic.dao.view;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.view.DoctorView;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Doctor entities.
 * 
 */
public interface DoctorViewDAO extends JpaDao<DoctorView> {

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	public Set<DoctorView> findDoctorBySurnameContaining(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	public Set<DoctorView> findDoctorBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	public Set<DoctorView> findDoctorBySurname(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	public Set<DoctorView> findDoctorBySurname(String surname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	public Set<DoctorView> findDoctorByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	public Set<DoctorView> findDoctorByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	public Set<DoctorView> findAllDoctors() throws DataAccessException;

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	public Set<DoctorView> findAllDoctors(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	public Set<DoctorView> findDoctorByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	public Set<DoctorView> findDoctorByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	public DoctorView findDoctorByPrimaryKey(String id) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	public DoctorView findDoctorByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	public DoctorView findDoctorById(String id) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	public DoctorView findDoctorById(String id_1, int startResult, int maxRows) throws DataAccessException;

	public DoctorView findDoctorByPesel(String pesel) throws DataAccessException;
	
	public Set<DoctorView> findDoctorBySpecialization(String specialization);
}