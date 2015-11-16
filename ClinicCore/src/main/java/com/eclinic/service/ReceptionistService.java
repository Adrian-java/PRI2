package com.eclinic.service;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Receptionist entities
 * 
 */
public interface ReceptionistService {

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public Receptionist deleteReceptionistVisits(Integer receptionist_id, Integer related_visits_id);

	/**
	 * Return a count of all Receptionist entity
	 * 
	 */
	public Integer countReceptionists();

	/**
	 * Return all Receptionist entity
	 * 
	 */
	public List<Receptionist> findAllReceptionists(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public void deleteReceptionist(Receptionist receptionist);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Receptionist saveReceptionistVisits(Integer id, Visit related_visits);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Receptionist saveReceptionistSystemUser(Integer id_1, SystemUser related_systemuser);

	/**
	 * Load an existing Receptionist entity
	 * 
	 */
	public Set<Receptionist> loadReceptionists();

	/**
	 * Save an existing Receptionist entity
	 * @return 
	 * 
	 */
	public Integer saveReceptionist(Receptionist receptionist_1);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Receptionist deleteReceptionistSystemUser(Integer receptionist_id_1, Integer related_systemuser_id);

	/**
	 */
	public Receptionist findReceptionistByPrimaryKey(Integer id_2);
}