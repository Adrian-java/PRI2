package com.eclinic.dao;

import com.eclinic.domain.Admin;
import com.eclinic.domain.view.AdminView;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Admin entities.
 * 
 */
public interface AdminDAO extends JpaDao<Admin> {

	/**
	 * JPQL Query - findAdminByIsSuper
	 *
	 */
	public Set<Admin> findAdminByIsSuper(Boolean isSuper) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByIsSuper
	 *
	 */
	public Set<Admin> findAdminByIsSuper(Boolean isSuper, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdminById
	 *
	 */
	public Admin findAdminById(String id) throws DataAccessException;

	/**
	 * JPQL Query - findAdminById
	 *
	 */
	public Admin findAdminById(String id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */
	public Admin findAdminByPrimaryKey(String id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */
	public Admin findAdminByPrimaryKey(String id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdmins
	 *
	 */
	public Set<AdminView> findAllAdmins() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdmins
	 *
	 */
	public Set<AdminView> findAllAdmins(int startResult, int maxRows) throws DataAccessException;

}