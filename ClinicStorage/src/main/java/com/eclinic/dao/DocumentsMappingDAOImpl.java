package com.eclinic.dao;

import com.eclinic.domain.DocumentsMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage DocumentsMapping entities.
 * 
 */
@Repository("DocumentsMappingDAO")
@Transactional
public class DocumentsMappingDAOImpl extends AbstractJpaDao<DocumentsMapping>
		implements DocumentsMappingDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { DocumentsMapping.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DocumentsMappingDAOImpl
	 *
	 */
	public DocumentsMappingDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAllDocumentsMappings
	 *
	 */
	@Transactional
	public Set<DocumentsMapping> findAllDocumentsMappings() throws DataAccessException {

		return findAllDocumentsMappings(-1, -1);
	}

	/**
	 * JPQL Query - findAllDocumentsMappings
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<DocumentsMapping> findAllDocumentsMappings(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllDocumentsMappings", startResult, maxRows);
		return new LinkedHashSet<DocumentsMapping>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsMappingByPrimaryKey
	 *
	 */
	@Transactional
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id) throws DataAccessException {

		return findDocumentsMappingByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsMappingByPrimaryKey
	 *
	 */

	@Transactional
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDocumentsMappingByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.DocumentsMapping) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findDocumentsMappingById
	 *
	 */
	@Transactional
	public DocumentsMapping findDocumentsMappingById(Integer id) throws DataAccessException {

		return findDocumentsMappingById(id, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsMappingById
	 *
	 */

	@Transactional
	public DocumentsMapping findDocumentsMappingById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDocumentsMappingById", startResult, maxRows, id);
			return (com.eclinic.domain.DocumentsMapping) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(DocumentsMapping entity) {
		return true;
	}
}
