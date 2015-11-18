package com.eclinic.dao;

import com.eclinic.domain.Certificate;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Certificate entities.
 * 
 */
public interface CertificateDAO extends JpaDao<Certificate> {

	/**
	 * JPQL Query - findAllCertificates
	 *
	 */
	public Set<Certificate> findAllCertificates() throws DataAccessException;

	/**
	 * JPQL Query - findAllCertificates
	 *
	 */
	public Set<Certificate> findAllCertificates(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateById
	 *
	 */
	public Certificate findCertificateById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateById
	 *
	 */
	public Certificate findCertificateById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByPrimaryKey
	 *
	 */
	public Certificate findCertificateByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByPrimaryKey
	 *
	 */
	public Certificate findCertificateByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByIdNumberContaining
	 *
	 */
	public Set<Certificate> findCertificateByIdNumberContaining(String idNumber) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByIdNumberContaining
	 *
	 */
	public Set<Certificate> findCertificateByIdNumberContaining(String idNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByIdNumber
	 *
	 */
	public Set<Certificate> findCertificateByIdNumber(String idNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findCertificateByIdNumber
	 *
	 */
	public Set<Certificate> findCertificateByIdNumber(String idNumber_1, int startResult, int maxRows) throws DataAccessException;

}