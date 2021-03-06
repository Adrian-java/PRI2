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

import com.eclinic.domain.view.VisitSchedulerView;

/**
 * DAO to manage Doctor entities.
 * 
 */
@Repository("VisitSchedulerViewDAO")
@Transactional
public class VisitSchedulerViewDAOImpl extends AbstractJpaDao<VisitSchedulerView> implements VisitSchedulerViewDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { VisitSchedulerView.class }));

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
	public VisitSchedulerViewDAOImpl() {
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
	public Set<VisitSchedulerView> findAllVisitScheduler() throws DataAccessException {
		Query query = createNamedQuery("findAllVisitScheduler",-1,-1);
		return new LinkedHashSet<VisitSchedulerView>(query.getResultList());
	}

	@Override
	public boolean canBeMerged(VisitSchedulerView o) {
		// TODO Auto-generated method stub
		return true;
	}

	

}
