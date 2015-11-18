package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Clinic;
import com.eclinic.domain.Prescription;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Clinic entities
 * 
 */
public interface ClinicService {

	/**
	 * Save an existing Address entity
	 * 
	 */
	public Clinic saveClinicAddress(Integer id, Address related_address);

	/**
	 * Load an existing Clinic entity
	 * 
	 */
	public Set<Clinic> loadClinics();

	/**
	 */
	public Clinic findClinicByPrimaryKey(Integer id_1);

	/**
	 * Return a count of all Clinic entity
	 * 
	 */
	public Integer countClinics();

	/**
	 * Return all Clinic entity
	 * 
	 */
	public List<Clinic> findAllClinics(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public Clinic deleteClinicAddress(Integer clinic_id, Integer related_address_id);

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	public void saveClinic(Clinic clinic);

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	public Clinic deleteClinicPrescriptions(Integer clinic_id_1, Integer related_prescriptions_id);

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	public void deleteClinic(Clinic clinic_1);

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	public Clinic saveClinicPrescriptions(Integer id_2, Prescription related_prescriptions);
}