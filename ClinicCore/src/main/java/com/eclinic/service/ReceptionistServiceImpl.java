package com.eclinic.service;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Receptionist entities
 * 
 */

@Service("ReceptionistService")
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new ReceptionistServiceImpl.
	 *
	 */
	public ReceptionistServiceImpl() {
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public Receptionist deleteReceptionistVisits(Integer receptionist_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		related_visits.setReceptionist(null);
		receptionist.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return receptionist;
	}

	/**
	 * Return a count of all Receptionist entity
	 * 
	 */
	@Transactional
	public Integer countReceptionists() {
		return ((Long) receptionistDAO.createQuerySingleResult("select count(o) from Receptionist o").getSingleResult()).intValue();
	}

	/**
	 * Return all Receptionist entity
	 * 
	 */
	@Transactional
	public List<Receptionist> findAllReceptionists(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Receptionist>(receptionistDAO.findAllReceptionists(startResult, maxRows));
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Transactional
	public void deleteReceptionist(Receptionist receptionist) {
		receptionistDAO.remove(receptionist);
		receptionistDAO.flush();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Receptionist saveReceptionistVisits(Integer id, Visit related_visits) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(id, -1, -1);
		Visit existingvisits = visitDAO.findVisitByPrimaryKey(related_visits.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisits != null) {
			existingvisits.setId(related_visits.getId());
			existingvisits.setDateOfVisit(related_visits.getDateOfVisit());
			existingvisits.setDescriptionOfVisit(related_visits.getDescriptionOfVisit());
			existingvisits.setIsLeave(related_visits.getIsLeave());
			existingvisits.setSpecial(related_visits.getSpecial());
			related_visits = existingvisits;
		}

		related_visits.setReceptionist(receptionist);
		receptionist.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		receptionist = receptionistDAO.store(receptionist);
		receptionistDAO.flush();

		return receptionist;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Receptionist saveReceptionistSystemUser(Integer id, SystemUser related_systemuser) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			existingsystemUser.setRole(related_systemuser.getRole());
			existingsystemUser.setPesel(related_systemuser.getPesel());
			related_systemuser = existingsystemUser;
		} else {
			related_systemuser = systemUserDAO.store(related_systemuser);
			systemUserDAO.flush();
		}

		receptionist.setSystemUser(related_systemuser);
		receptionist = receptionistDAO.store(receptionist);
		receptionistDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return receptionist;
	}

	/**
	 * Load an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Set<Receptionist> loadReceptionists() {
		return receptionistDAO.findAllReceptionists();
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Integer saveReceptionist(Receptionist receptionist) {
		Receptionist existingReceptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());

		if (existingReceptionist != null) {
			if (existingReceptionist != receptionist) {
				existingReceptionist.setId(receptionist.getId());
				existingReceptionist.setName(receptionist.getName());
				existingReceptionist.setSurname(receptionist.getSurname());
				existingReceptionist.setPhoneNr(receptionist.getPhoneNr());
				existingReceptionist.setAccess(receptionist.getAccess());
			}
			receptionist = receptionistDAO.store(existingReceptionist);
		} else {
			receptionist = receptionistDAO.store(receptionist);
		}
		receptionistDAO.flush();
		return receptionist.getId();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Receptionist deleteReceptionistSystemUser(Integer receptionist_id, Integer related_systemuser_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		receptionist.setSystemUser(null);
		receptionist = receptionistDAO.store(receptionist);
		receptionistDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return receptionist;
	}

	/**
	 */
	@Transactional
	public Receptionist findReceptionistByPrimaryKey(Integer id) {
		return receptionistDAO.findReceptionistByPrimaryKey(id);
	}
}
