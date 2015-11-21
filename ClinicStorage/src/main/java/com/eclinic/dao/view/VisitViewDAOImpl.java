package com.eclinic.dao.view;

import java.util.Arrays;
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

import com.eclinic.domain.view.VisitView;

/**
 * DAO to manage Doctor entities.
 * 
 */
@Repository("VisitViewDAO")
@Transactional
public class VisitViewDAOImpl extends AbstractJpaDao<VisitView> implements VisitViewDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { VisitView.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DoctorDAOImpl
	 *
	 */
	public VisitViewDAOImpl() {
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
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitView> findAllVisit() throws DataAccessException {
		Query query = createNamedQuery("findAllVisitScheduler",-1,-1);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	@Override
	public boolean canBeMerged(VisitView o) {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<VisitView> findFreeVisitBySpecialization(String specialization,
			int numberOfVisit) throws DataAccessException {
		Query query = createNamedQuery("findFreeVisitBySpecialization",-1,numberOfVisit,specialization);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	

}
