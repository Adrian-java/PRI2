package com.eclinic.dao.view;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.view.AdminView;

/**
 * DAO to manage Admin entities.
 * 
 */
public interface AdminViewDAO extends JpaDao<AdminView> {
	

	/**
	 * JPQL Query - findAdminByIsSuper
	 *
	 */
	public Set<AdminView> findAdminByIsSuper(Boolean isSuper) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByIsSuper
	 *
	 */
	public Set<AdminView> findAdminByIsSuper(Boolean isSuper, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdminById
	 *
	 */
	public AdminView findAdminById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findAdminById
	 *
	 */
	public AdminView findAdminById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */
	public AdminView findAdminByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */
	public AdminView findAdminByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

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