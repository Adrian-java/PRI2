package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Patient;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Documents entities
 * 
 */
public interface DocumentsService {

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Documents saveDocumentsPatient(Integer id, Patient related_patient);

	/**
	 */
	public Documents findDocumentsByPrimaryKey(Integer id_1);

	/**
	 * Save an existing Documents entity
	 * 
	 */
	public void saveDocuments(Documents documents);

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	public void deleteDocuments(Documents documents_1);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Documents saveDocumentsDoctor(Integer id_2, Doctor related_doctor);

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public Documents deleteDocumentsDocumentsMappings(Integer documents_id, Integer related_documentsmappings_id);

	/**
	 * Load an existing Documents entity
	 * 
	 */
	public Set<Documents> loadDocumentss();

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Documents deleteDocumentsPatient(Integer documents_id_1, String related_patient_id);

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public Documents saveDocumentsDocumentsMappings(Integer id_3, DocumentsMapping related_documentsmappings);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Documents deleteDocumentsDoctor(Integer documents_id_2, String related_doctor_id);

	/**
	 * Return a count of all Documents entity
	 * 
	 */
	public Integer countDocumentss();

	/**
	 * Return all Documents entity
	 * 
	 */
	public List<Documents> findAllDocumentss(Integer startResult, Integer maxRows);
}