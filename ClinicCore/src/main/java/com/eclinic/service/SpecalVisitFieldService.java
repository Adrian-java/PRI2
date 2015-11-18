package com.eclinic.service;

import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SpecalVisitField entities
 * 
 */
public interface SpecalVisitFieldService {

	/**
	 */
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id);

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	public void deleteSpecalVisitField(SpecalVisitField specalvisitfield);

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	public void saveSpecalVisitField(SpecalVisitField specalvisitfield_1);

	/**
	 * Return a count of all SpecalVisitField entity
	 * 
	 */
	public Integer countSpecalVisitFields();

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public SpecalVisitField deleteSpecalVisitFieldSpecialization(Integer specalvisitfield_id, Integer related_specialization_id);

	/**
	 * Load an existing SpecalVisitField entity
	 * 
	 */
	public Set<SpecalVisitField> loadSpecalVisitFields();

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public SpecalVisitField saveSpecalVisitFieldSpecialization(Integer id_1, Specialization related_specialization);

	/**
	 * Return all SpecalVisitField entity
	 * 
	 */
	public List<SpecalVisitField> findAllSpecalVisitFields(Integer startResult, Integer maxRows);
}