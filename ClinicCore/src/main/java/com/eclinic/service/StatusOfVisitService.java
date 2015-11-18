package com.eclinic.service;

import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for StatusOfVisit entities
 * 
 */
public interface StatusOfVisitService {

	/**
	 * Return a count of all StatusOfVisit entity
	 * 
	 */
	public Integer countStatusOfVisits();

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public StatusOfVisit saveStatusOfVisitVisits(Integer id, Visit related_visits);

	/**
	 */
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id_1);

	/**
	 * Return all StatusOfVisit entity
	 * 
	 */
	public List<StatusOfVisit> findAllStatusOfVisits(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public StatusOfVisit deleteStatusOfVisitVisits(Integer statusofvisit_id, Integer related_visits_id);

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	public void deleteStatusOfVisit(StatusOfVisit statusofvisit);

	/**
	 * Load an existing StatusOfVisit entity
	 * 
	 */
	public Set<StatusOfVisit> loadStatusOfVisits();

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	public void saveStatusOfVisit(StatusOfVisit statusofvisit_1);
}