package com.eclinic.service;

import java.util.List;
import java.util.Set;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Worker;

/**
 * Spring service that handles CRUD requests for Patient entities
 * 
 */
public interface PatientService {

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public Patient deletePatientWorkers(Integer patient_id, Integer related_workers_id);

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public Patient deletePatientAddress(Integer patient_id_1, Integer related_address_id);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public void deletePatient(Patient patient);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public Patient savePatientWorkers(Integer id, Worker related_workers);

	/**
	 */
	public Patient findPatientByPrimaryKey(Integer id_1);


	/**
	 * Return a count of all Patient entity
	 * 
	 */
	public Integer countPatients();

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Integer savePatient(Patient patient_1);


	/**
	 * Load an existing Patient entity
	 * 
	 */
	public Set<Patient> loadPatients();

	/**
	 * Save an existing Address entity
	 * 
	 */
	public Patient savePatientAddress(Integer id_3, Address related_address);


	/**
	 * Return all Patient entity
	 * 
	 */
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows);
}