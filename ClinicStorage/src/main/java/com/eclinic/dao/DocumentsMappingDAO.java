package com.eclinic.dao;

import com.eclinic.domain.DocumentsMapping;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage DocumentsMapping entities.
 * 
 */
public interface DocumentsMappingDAO extends JpaDao<DocumentsMapping> {

	/**
	 * JPQL Query - findAllDocumentsMappings
	 *
	 */
	public Set<DocumentsMapping> findAllDocumentsMappings() throws DataAccessException;

	/**
	 * JPQL Query - findAllDocumentsMappings
	 *
	 */
	public Set<DocumentsMapping> findAllDocumentsMappings(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsMappingByPrimaryKey
	 *
	 */
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsMappingByPrimaryKey
	 *
	 */
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsMappingById
	 *
	 */
	public DocumentsMapping findDocumentsMappingById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsMappingById
	 *
	 */
	public DocumentsMapping findDocumentsMappingById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}