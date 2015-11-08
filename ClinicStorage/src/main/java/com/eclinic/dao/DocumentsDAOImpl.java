package com.eclinic.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.domain.Documents;
import com.eclinic.domain.Visit;

/**
 * DAO to manage Visit entities.
 * 
 */
@Repository("DocumentsDAO")
@Transactional
public class DocumentsDAOImpl extends AbstractJpaDao<Documents> implements
		DocumentsDAO {

	/**
	 * Set of entity classes managed by this DAO. Typically a DAO manages a
	 * single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Visit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new VisitDAOImpl
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

	@Transactional
	public Documents findDocumentsById(Integer id) throws DataAccessException {
		Query query = createNamedQuery("findDocumentsById", -1, -1, id);
		return (Documents) query.getSingleResult();
	}

	@Transactional
	public Set<Documents> findDocumentsByType(String type)
			throws DataAccessException {
		Query query = createNamedQuery("findDocumentsByType", -1, -1, type);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	@Transactional
	public Set<Documents> findDocumentsByDate(Date d)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = createNamedQuery("findDocumentsByDate", -1, -1, d);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	@Transactional
	public Set<Documents> findDocumentsByPatient(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = createNamedQuery("findDocumentsByPatient", -1, -1, id);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	@Transactional
	public Set<Documents> findDocumentsByDoctor(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = createNamedQuery("findDocumentsByDoctor", -1, -1, id);
		return new LinkedHashSet<Documents>(query.getResultList());
	}

	@Override
	public boolean canBeMerged(Documents o) {
		return true;
	}
}
