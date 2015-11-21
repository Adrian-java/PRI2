package com.eclinic.dao.view;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.view.PatientView;

/**
 * DAO to manage PatientView entities.
 * 
 */
public interface PatientViewDAO extends JpaDao<PatientView> {

	/**
	 * JPQL Query - findPatientBySurname
	 *
	 */
	public Set<PatientView> findPatientBySurname(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurname
	 *
	 */
	public Set<PatientView> findPatientBySurname(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPatients
	 *
	 */
	public Set<PatientView> findAllPatients() throws DataAccessException;

	public PatientView findPatientByPesel(String pesel) throws DataAccessException;
	/**
	 * JPQL Query - findAllPatients
	 *
	 */
	public Set<PatientView> findAllPatients(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirthBefore(java.util.Calendar dateOfBirth) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirthBefore(Calendar dateOfBirth, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */
	public Set<PatientView> findPatientByConfirmed(Integer confirmed) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */
	public Set<PatientView> findPatientByConfirmed(Integer confirmed, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirthAfter(java.util.Calendar dateOfBirth_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirthAfter(Calendar dateOfBirth_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientById
	 *
	 */
	public PatientView findPatientById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPatientById
	 *
	 */
	public PatientView findPatientById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */
	public Set<PatientView> findPatientByEMailContaining(String EMail) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */
	public Set<PatientView> findPatientByEMailContaining(String EMail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */
	public Set<PatientView> findPatientByPhoneNr(String phoneNr) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */
	public Set<PatientView> findPatientByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */
	public Set<PatientView> findPatientByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */
	public Set<PatientView> findPatientByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */
	public Set<PatientView> findPatientByEMail(String EMail_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */
	public Set<PatientView> findPatientByEMail(String EMail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */
	public Set<PatientView> findPatientByPhoneNrContaining(String phoneNr_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */
	public Set<PatientView> findPatientByPhoneNrContaining(String phoneNr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirth(java.util.Calendar dateOfBirth_2) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */
	public Set<PatientView> findPatientByDateOfBirth(Calendar dateOfBirth_2, int startResult, int maxRows) throws DataAccessException;


	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */
	public PatientView findPatientByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */
	public PatientView findPatientByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByName
	 *
	 */
	public Set<PatientView> findPatientByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByName
	 *
	 */
	public Set<PatientView> findPatientByName(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */
	public Set<PatientView> findPatientBySurnameContaining(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */
	public Set<PatientView> findPatientBySurnameContaining(String surname_1, int startResult, int maxRows) throws DataAccessException;

}