package com.eclinic.dao;

import com.eclinic.domain.Documents;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Documents entities.
 * 
 */
public interface DocumentsDAO extends JpaDao<Documents> {

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsBefore
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocumentsBefore(java.util.Calendar dateOfDocuments) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsBefore
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocumentsBefore(Calendar dateOfDocuments, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByTypeOfDocumentsContaining
	 *
	 */
	public Set<Documents> findDocumentsByTypeOfDocumentsContaining(String typeOfDocuments) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByTypeOfDocumentsContaining
	 *
	 */
	public Set<Documents> findDocumentsByTypeOfDocumentsContaining(String typeOfDocuments, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsAfter
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocumentsAfter(java.util.Calendar dateOfDocuments_1) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsAfter
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocumentsAfter(Calendar dateOfDocuments_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByTypeOfDocuments
	 *
	 */
	public Set<Documents> findDocumentsByTypeOfDocuments(String typeOfDocuments_1) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByTypeOfDocuments
	 *
	 */
	public Set<Documents> findDocumentsByTypeOfDocuments(String typeOfDocuments_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsById
	 *
	 */
	public Documents findDocumentsById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsById
	 *
	 */
	public Documents findDocumentsById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByDateOfDocuments
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocuments(java.util.Calendar dateOfDocuments_2) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByDateOfDocuments
	 *
	 */
	public Set<Documents> findDocumentsByDateOfDocuments(Calendar dateOfDocuments_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByPrimaryKey
	 *
	 */
	public Documents findDocumentsByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findDocumentsByPrimaryKey
	 *
	 */
	public Documents findDocumentsByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllDocumentss
	 *
	 */
	public Set<Documents> findAllDocumentss() throws DataAccessException;

	/**
	 * JPQL Query - findAllDocumentss
	 *
	 */
	public Set<Documents> findAllDocumentss(int startResult, int maxRows) throws DataAccessException;

}