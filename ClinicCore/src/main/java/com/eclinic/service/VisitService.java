package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Visit entities
 * 
 */
public interface VisitService {

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	public Visit saveVisitReceptionist(Integer id, Receptionist related_receptionist);

	/**
	 * Return all Visit entity
	 * 
	 */
	public List<Visit> findAllVisits(Integer startResult, Integer maxRows);

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	public Visit saveVisitTypeOfVisit(Integer id_1, TypeOfVisit related_typeofvisit);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Visit deleteVisitDoctor(Integer visit_id, Integer related_doctor_id);

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	public Visit saveVisitStatusOfVisit(Integer id_2, StatusOfVisit related_statusofvisit);

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public Visit deleteVisitReceptionist(Integer visit_id_1, Integer related_receptionist_id);

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	public Visit deleteVisitTypeOfVisit(Integer visit_id_2, Integer related_typeofvisit_id);

	/**
	 * Load an existing Visit entity
	 * 
	 */
	public Set<Visit> loadVisits();

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	public Visit deleteVisitStatusOfVisit(Integer visit_id_3, Integer related_statusofvisit_id);

	/**
	 */
	public Visit findVisitByPrimaryKey(Integer id_3);

	/**
	 * Return a count of all Visit entity
	 * 
	 */
	public Integer countVisits();

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Visit saveVisitDoctor(Integer id_4, Doctor related_doctor);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public void deleteVisit(Visit visit);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Visit deleteVisitPatient(Integer visit_id_4, Integer related_patient_id);

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Visit saveVisitPatient(Integer id_5, Patient related_patient);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Integer saveVisit(Visit visit_1);
}