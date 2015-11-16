package com.eclinic.service;

import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for TypeOfVisit entities
 * 
 */
public interface TypeOfVisitService {

	/**
	 * Load an existing TypeOfVisit entity
	 * 
	 */
	public Set<TypeOfVisit> loadTypeOfVisits();

	/**
	 * Return a count of all TypeOfVisit entity
	 * 
	 */
	public Integer countTypeOfVisits();

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public TypeOfVisit saveTypeOfVisitVisits(Integer id, Visit related_visits);

	/**
	 * Return all TypeOfVisit entity
	 * 
	 */
	public List<TypeOfVisit> findAllTypeOfVisits(Integer startResult, Integer maxRows);

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	public void saveTypeOfVisit(TypeOfVisit typeofvisit);

	/**
	 */
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	public void deleteTypeOfVisit(TypeOfVisit typeofvisit_1);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public TypeOfVisit deleteTypeOfVisitVisits(Integer typeofvisit_id, Integer related_visits_id);
}