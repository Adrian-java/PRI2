package com.eclinic.service;

import com.eclinic.domain.Clinic;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Prescription;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Prescription entities
 * 
 */
public interface PrescriptionService {

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	public void deletePrescription(Prescription prescription);

	/**
	 * Return a count of all Prescription entity
	 * 
	 */
	public Integer countPrescriptions();

	/**
	 */
	public Prescription findPrescriptionByPrimaryKey(Integer id);

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	public void savePrescription(Prescription prescription_1);

	/**
	 * Return all Prescription entity
	 * 
	 */
	public List<Prescription> findAllPrescriptions(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	public Prescription savePrescriptionClinic(Integer id_1, Clinic related_clinic);

	/**
	 * Load an existing Prescription entity
	 * 
	 */
	public Set<Prescription> loadPrescriptions();

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public Prescription savePrescriptionDocumentsMapping(Integer id_2, DocumentsMapping related_documentsmapping);

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	public Prescription deletePrescriptionClinic(Integer prescription_id, Integer related_clinic_id);

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public Prescription deletePrescriptionDocumentsMapping(Integer prescription_id_1, Integer related_documentsmapping_id);
}