package com.eclinic.dao;

import com.eclinic.domain.Documents;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Visit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
 * DAO to manage Documents entities.
 * 
 */
@Repository("DocumentsDAO")
@Transactional
public class DocumentsDAOImpl extends AbstractJpaDao<Documents> implements
		DocumentsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Documents.class }));

	/**
	 * EntityManager injected by Spring for persistence unit local
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DocumentsDAOImpl
	 *
	 */
	public DocumentsDAOImpl() {
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
	 * JPQL Query - findDocumentsByDateOfDocumentsBefore
	 *
	 */
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocumentsBefore(java.util.Calendar dateOfDocuments) throws DataAccessException {

		return findDocumentsByDateOfDocumentsBefore(dateOfDocuments, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocumentsBefore(java.util.Calendar dateOfDocuments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByDateOfDocumentsBefore", startResult, maxRows, dateOfDocuments);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsByTypeOfDocumentsContaining
	 *
	 */
	@Transactional
	public Set<Documents> findDocumentsByTypeOfDocumentsContaining(String typeOfDocuments) throws DataAccessException {

		return findDocumentsByTypeOfDocumentsContaining(typeOfDocuments, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByTypeOfDocumentsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findDocumentsByTypeOfDocumentsContaining(String typeOfDocuments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByTypeOfDocumentsContaining", startResult, maxRows, typeOfDocuments);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsAfter
	 *
	 */
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocumentsAfter(java.util.Calendar dateOfDocuments) throws DataAccessException {

		return findDocumentsByDateOfDocumentsAfter(dateOfDocuments, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByDateOfDocumentsAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocumentsAfter(java.util.Calendar dateOfDocuments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByDateOfDocumentsAfter", startResult, maxRows, dateOfDocuments);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsByTypeOfDocuments
	 *
	 */
	@Transactional
	public Set<Documents> findDocumentsByTypeOfDocuments(String typeOfDocuments) throws DataAccessException {

		return findDocumentsByTypeOfDocuments(typeOfDocuments, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByTypeOfDocuments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findDocumentsByTypeOfDocuments(String typeOfDocuments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByTypeOfDocuments", startResult, maxRows, typeOfDocuments);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsById
	 *
	 */
	@Transactional
	public Documents findDocumentsById(Integer id) throws DataAccessException {

		return findDocumentsById(id, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsById
	 *
	 */

	@Transactional
	public Documents findDocumentsById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDocumentsById", startResult, maxRows, id);
			return (com.eclinic.domain.Documents) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findDocumentsByDateOfDocuments
	 *
	 */
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocuments(java.util.Calendar dateOfDocuments) throws DataAccessException {

		return findDocumentsByDateOfDocuments(dateOfDocuments, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByDateOfDocuments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findDocumentsByDateOfDocuments(java.util.Calendar dateOfDocuments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByDateOfDocuments", startResult, maxRows, dateOfDocuments);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * JPQL Query - findDocumentsByPrimaryKey
	 *
	 */
	@Transactional
	public Documents findDocumentsByPrimaryKey(Integer id) throws DataAccessException {

		return findDocumentsByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findDocumentsByPrimaryKey
	 *
	 */

	@Transactional
	public Documents findDocumentsByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDocumentsByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Documents) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllDocumentss
	 *
	 */
	@Transactional
	public Set<Documents> findAllDocumentss() throws DataAccessException {

		return findAllDocumentss(-1, -1);
	}

	/**
	 * JPQL Query - findAllDocumentss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Documents> findAllDocumentss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllDocumentss", startResult, maxRows);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Documents entity) {
		return true;
	}

	public Set<Documents> findDocumentsByPatient(Patient p, int startResult,
			int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByPatient", startResult, maxRows,p);
		return  new LinkedHashSet<Documents>( query.getResultList());
	}

	public Documents findDocumentsByVisit(Visit v) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByVisit", -1, -1,v);
		List<Documents>  list = query.getResultList();
		return list.get(list.size()-1);
	}
	
	public List<Documents>  findDocumentsByVisitNew(Visit v) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByVisit", -1, -1,v);
		List<Documents>  list = query.getResultList();
		return list;
	}
}
