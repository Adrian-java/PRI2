package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for VisitScheduler entities
 * 
 */
public interface VisitSchedulerService {

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public VisitScheduler deleteVisitSchedulerDoctor(Integer visitscheduler_id, Integer related_doctor_id);

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public VisitScheduler deleteVisitSchedulerSpecialization(Integer visitscheduler_id_1, Integer related_specialization_id);

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public VisitScheduler saveVisitSchedulerSpecialization(Integer id, Specialization related_specialization);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public VisitScheduler saveVisitSchedulerDoctor(Integer id_1, Doctor related_doctor);

	/**
	 * Load an existing VisitScheduler entity
	 * 
	 */
	public Set<VisitScheduler> loadVisitSchedulers();

	/**
	 * Return a count of all VisitScheduler entity
	 * 
	 */
	public Integer countVisitSchedulers();

	/**
	 * Delete an existing SevenDays entity
	 * 
	 */
	public VisitScheduler deleteVisitSchedulerSevenDays(Integer visitscheduler_id_2, Integer related_sevendays_id);

	/**
	 */
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id_2);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public void saveVisitScheduler(VisitScheduler visitscheduler);

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public void deleteVisitScheduler(VisitScheduler visitscheduler_1);

	/**
	 * Return all VisitScheduler entity
	 * 
	 */
	public List<VisitScheduler> findAllVisitSchedulers(Integer startResult, Integer maxRows);

	/**
	 * Save an existing SevenDays entity
	 * 
	 */
	public VisitScheduler saveVisitSchedulerSevenDays(Integer id_3, SevenDays related_sevendays);
}