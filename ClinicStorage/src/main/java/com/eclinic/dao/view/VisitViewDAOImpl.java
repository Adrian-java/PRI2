package com.eclinic.dao.view;

import java.util.Arrays;
import java.util.Calendar;
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

import com.eclinic.domain.view.VisitView;

/**
 * DAO to manage Doctor entities.
 * 
 */
@Repository("VisitViewDAO")
@Transactional
public class VisitViewDAOImpl extends AbstractJpaDao<VisitView> implements
		VisitViewDAO {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { VisitView.class }));

	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	public VisitViewDAOImpl() {
		super();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitView> findAllVisit() throws DataAccessException {
		Query query = createNamedQuery("findAllVisitView", -1, -1);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	@Override
	public boolean canBeMerged(VisitView o) {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<VisitView> findFreeVisitBySpecialization(String specialization,
			int numberOfVisit) throws DataAccessException {
		Query query = createNamedQuery("findFreeVisitViewBySpecialization", -1,
				numberOfVisit, specialization);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findFreeVisitByDoctor(String doctorId,
			int numberOfVisit) throws DataAccessException {
		Query query = createNamedQuery("findFreeVisitViewByDoctor", -1,
				numberOfVisit, doctorId);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public VisitView findVisitById(Integer visitId) throws DataAccessException {
		Query query = createNamedQuery("findFreeVisitViewById", -1, -1, visitId);
		return (VisitView) query.getSingleResult();
	}

	public Set<VisitView> findVisitByDateOfVisit(Calendar calendar) {
		Query query = createNamedQuery("findVisitViewByDateOfVisit", -1, -1,
				calendar.getTime());
		// ((org.hibernate.ejb.QueryImpl)getEntityManager().createNativeQuery("select * from Visit_View where date_of_visit like '2016-01-15%' and specialization='Psycholog'")).getResultList();

		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findVisitByDoctor(String doctor, int i, int j) {
		Query query = createNamedQuery("findVisitViewByDoctor", -1, -1, doctor);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findVisitByPatient(String id) {
		Query query = createNamedQuery("findVisitViewByPatient", -1, -1, id);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findVisitByStatus(String status) {
		Query query = createNamedQuery("findVisitViewByStatus", -1, -1, status);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findVisitBySpecialization(String s) {
		Query query = createNamedQuery("findVisitViewBySpecialization", -1, -1,
				s);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

	public Set<VisitView> findVisitBySpecializationAndDate(String s,
			Date start, Date stop) {
		Query query = createNamedQuery("findVisitViewBySpecializationAndDate",
				-1, -1, s, start, stop);
		return new LinkedHashSet<VisitView>(query.getResultList());
	}

}
