package com.eclinic.dao;

import java.util.Date;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.eclinic.domain.Documents;

/**
 * DAO to manage Visit entities.
 * 
 */
public interface DocumentsDAO extends JpaDao<Documents> {

	public Documents findDocumentsById(Integer id) throws DataAccessException;
	
	public Set<Documents> findDocumentsByType(String type) throws DataAccessException;
	
	public Set<Documents> findDocumentsByDate(Date d) throws DataAccessException;
	
	public Set<Documents> findDocumentsByPatient(Integer id) throws DataAccessException;
	
	public Set<Documents> findDocumentsByDoctor(Integer id) throws DataAccessException;

}