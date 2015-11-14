package com.eclinic.dao;

import com.eclinic.domain.Referral;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Referral entities.
 * 
 */
public interface ReferralDAO extends JpaDao<Referral> {

	/**
	 * JPQL Query - findReferralByPrimaryKey
	 *
	 */
	public Referral findReferralByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findReferralByPrimaryKey
	 *
	 */
	public Referral findReferralByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReferralById
	 *
	 */
	public Referral findReferralById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findReferralById
	 *
	 */
	public Referral findReferralById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllReferrals
	 *
	 */
	public Set<Referral> findAllReferrals() throws DataAccessException;

	/**
	 * JPQL Query - findAllReferrals
	 *
	 */
	public Set<Referral> findAllReferrals(int startResult, int maxRows) throws DataAccessException;

}