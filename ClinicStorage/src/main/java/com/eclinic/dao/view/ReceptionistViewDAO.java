package com.eclinic.dao.view;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.view.ReceptionistView;

/**
 * DAO to manage ReceptionistView entities.
 * 
 */
public interface ReceptionistViewDAO extends JpaDao<ReceptionistView> {

	/**
	 * JPQL Query - findAllReceptionists
	 *
	 */
	public Set<ReceptionistView> findAllReceptionists() throws DataAccessException;

	/**
	 * JPQL Query - findAllReceptionists
	 *
	 */
	public Set<ReceptionistView> findAllReceptionists(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */
	public ReceptionistView findReceptionistById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */
	public ReceptionistView findReceptionistById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */
	public Set<ReceptionistView> findReceptionistBySurname(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */
	public Set<ReceptionistView> findReceptionistBySurname(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */
	public Set<ReceptionistView> findReceptionistByPhoneNr(String phoneNr) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */
	public Set<ReceptionistView> findReceptionistByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */
	public Set<ReceptionistView> findReceptionistByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */
	public Set<ReceptionistView> findReceptionistByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistByPhoneNrContaining(String phoneNr_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistByPhoneNrContaining(String phoneNr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistBySurnameContaining(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */
	public Set<ReceptionistView> findReceptionistBySurnameContaining(String surname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */
	public ReceptionistView findReceptionistByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */
	public ReceptionistView findReceptionistByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}