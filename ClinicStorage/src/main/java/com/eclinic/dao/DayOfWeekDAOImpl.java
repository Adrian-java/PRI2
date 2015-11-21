package com.eclinic.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.domain.Address;
import com.eclinic.domain.DayOfWeek;

/**
 * DAO to manage Address entities.
 * 
 */
@Repository("DayOfWeekDAO")
@Transactional
public class DayOfWeekDAOImpl extends AbstractJpaDao<DayOfWeek> implements
		DayOfWeekDAO {

	/**
	 * Set of entity classes managed by this DAO. Typically a DAO manages a
	 * single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Address.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AddressDAOImpl
	 *
	 */
	public DayOfWeekDAOImpl() {
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
	public DayOfWeek findDayOfWeekById(Integer id) throws DataAccessException {
		Query query = createNamedQuery("findDayOfWeekById", -1, -1, id);
		return (DayOfWeek) query.getSingleResult();
	}

	@Override
	public boolean canBeMerged(DayOfWeek o) {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<DayOfWeek> findAllDayOfWeeks(Integer startResult, Integer maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<DayOfWeek> findAllDayOfWeeks() {
		// TODO Auto-generated method stub
		return null;
	}
}
