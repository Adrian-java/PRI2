package com.eclinic.dao.view;

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

import com.eclinic.domain.Patient;
import com.eclinic.domain.view.PatientView;

/**
 * DAO to manage PatientView entities.
 * 
 */
@Repository("PatientViewDAO")
@Transactional
public class PatientViewDAOImpl extends AbstractJpaDao<PatientView> implements
		PatientViewDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Patient.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PatientDAOImpl
	 *
	 */
	public PatientViewDAOImpl() {
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
	 * JPQL Query - findPatientBySurname
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientBySurname(String surname) throws DataAccessException {

		return findPatientBySurname(surname, -1, -1);
	}

	/**
	 * JPQL Query - findPatientBySurname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientBySurname(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientBySurname", startResult, maxRows, surname);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPatients
	 *
	 */
	@Transactional
	public Set<PatientView> findAllPatients() throws DataAccessException {

		return findAllPatients(-1, -1);
	}

	/**
	 * JPQL Query - findAllPatients
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findAllPatients(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("getAllPatients", startResult, maxRows);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByDateOfBirthBefore(java.util.Calendar dateOfBirth) throws DataAccessException {

		return findPatientByDateOfBirthBefore(dateOfBirth, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByDateOfBirthBefore(java.util.Calendar dateOfBirth, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByDateOfBirthBefore", startResult, maxRows, dateOfBirth);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByConfirmed(Integer confirmed) throws DataAccessException {

		return findPatientByConfirmed(confirmed, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByConfirmed(Integer confirmed, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByConfirmed", startResult, maxRows, confirmed);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByDateOfBirthAfter(java.util.Calendar dateOfBirth) throws DataAccessException {

		return findPatientByDateOfBirthAfter(dateOfBirth, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByDateOfBirthAfter(java.util.Calendar dateOfBirth, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByDateOfBirthAfter", startResult, maxRows, dateOfBirth);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientById
	 *
	 */
	@Transactional
	public PatientView findPatientById(String id) throws DataAccessException {

		return findPatientById(id, -1, -1);
	}

	/**
	 * JPQL Query - findPatientById
	 *
	 */

	@Transactional
	public PatientView findPatientById(String id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("getPatientByPesel", startResult, maxRows, id);
			return (PatientView) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByEMailContaining(String EMail) throws DataAccessException {

		return findPatientByEMailContaining(EMail, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByEMailContaining(String EMail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByEMailContaining", startResult, maxRows, EMail);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByPhoneNr(String phoneNr) throws DataAccessException {

		return findPatientByPhoneNr(phoneNr, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByPhoneNr", startResult, maxRows, phoneNr);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByNameContaining(String name) throws DataAccessException {

		return findPatientByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByEMail(String EMail) throws DataAccessException {

		return findPatientByEMail(EMail, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByEMail(String EMail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByEMail", startResult, maxRows, EMail);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByPhoneNrContaining(String phoneNr) throws DataAccessException {

		return findPatientByPhoneNrContaining(phoneNr, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByPhoneNrContaining(String phoneNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByPhoneNrContaining", startResult, maxRows, phoneNr);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByDateOfBirth(java.util.Calendar dateOfBirth) throws DataAccessException {

		return findPatientByDateOfBirth(dateOfBirth, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByDateOfBirth(java.util.Calendar dateOfBirth, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByDateOfBirth", startResult, maxRows, dateOfBirth);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	
	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */
	@Transactional
	public PatientView findPatientByPrimaryKey(Integer id) throws DataAccessException {

		return findPatientByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */

	@Transactional
	public PatientView findPatientByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPatientByPrimaryKey", startResult, maxRows, id);
			return (PatientView) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPatientByName
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientByName(String name) throws DataAccessException {

		return findPatientByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findPatientByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientByName", startResult, maxRows, name);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */
	@Transactional
	public Set<PatientView> findPatientBySurnameContaining(String surname) throws DataAccessException {

		return findPatientBySurnameContaining(surname, -1, -1);
	}

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientView> findPatientBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientBySurnameContaining", startResult, maxRows, surname);
		return new LinkedHashSet<PatientView>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(PatientView entity) {
		return true;
	}

	@SuppressWarnings("unchecked")
	public PatientView findPatientByPesel(String pesel)
			throws DataAccessException {
		Query query = createNamedQuery("getPatientByPesel", -1, -1,pesel);
		return (PatientView) query.getSingleResult();
	}

}
