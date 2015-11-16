package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Documents;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Patient entities
 * 
 */
public interface PatientService {

	/**
	 * Save an existing Address entity
	 * 
	 */
	public Patient savePatientAddress(String id, Address related_address);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public Patient deletePatientVisits(String patient_id, Integer related_visits_id);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Patient savePatientVisits(String id_1, Visit related_visits);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public void deletePatient(Patient patient);

	/**
	 * Save an existing Documents entity
	 * 
	 */
	public Patient savePatientDocumentses(String id_2, Documents related_documentses);

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public Patient deletePatientAddress(String patient_id_1, Integer related_address_id);

	/**
	 * Return a count of all Patient entity
	 * 
	 */
	public Integer countPatients();

	/**
	 */
	public Patient findPatientByPrimaryKey(String id_3);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Patient deletePatientSystemUser(String patient_id_2, String related_systemuser_id);

	/**
	 * Save an existing Patient entity
	 * @return 
	 * 
	 */
	public String savePatient(Patient patient_1);

	/**
	 * Return all Patient entity
	 * 
	 */
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	public Patient deletePatientDocumentses(String patient_id_3, Integer related_documentses_id);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Patient savePatientSystemUser(String id_4, SystemUser related_systemuser);

	/**
	 * Load an existing Patient entity
	 * 
	 */
	public Set<Patient> loadPatients();
}