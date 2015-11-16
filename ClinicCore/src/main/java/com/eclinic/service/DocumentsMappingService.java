package com.eclinic.service;

import com.eclinic.domain.Certificate;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.History;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for DocumentsMapping entities
 * 
 */
public interface DocumentsMappingService {

	/**
	 * Load an existing DocumentsMapping entity
	 * 
	 */
	public Set<DocumentsMapping> loadDocumentsMappings();

	/**
	 * Return all DocumentsMapping entity
	 * 
	 */
	public List<DocumentsMapping> findAllDocumentsMappings(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing History entity
	 * 
	 */
	public DocumentsMapping deleteDocumentsMappingHistory(Integer documentsmapping_id, Integer related_history_id);

	/**
	 * Save an existing Documents entity
	 * 
	 */
	public DocumentsMapping saveDocumentsMappingDocuments(Integer id, Documents related_documents);

	/**
	 * Delete an existing Certificate entity
	 * 
	 */
	public DocumentsMapping deleteDocumentsMappingCertificate(Integer documentsmapping_id_1, Integer related_certificate_id);

	/**
	 * Save an existing Referral entity
	 * 
	 */
	public DocumentsMapping saveDocumentsMappingReferral(Integer id_1, Referral related_referral);

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	public DocumentsMapping deleteDocumentsMappingPrescription(Integer documentsmapping_id_2, Integer related_prescription_id);

	/**
	 * Return a count of all DocumentsMapping entity
	 * 
	 */
	public Integer countDocumentsMappings();

	/**
	 */
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id_2);

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public void saveDocumentsMapping(DocumentsMapping documentsmapping);

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	public DocumentsMapping saveDocumentsMappingPrescription(Integer id_3, Prescription related_prescription);

	/**
	 * Save an existing Certificate entity
	 * 
	 */
	public DocumentsMapping saveDocumentsMappingCertificate(Integer id_4, Certificate related_certificate);

	/**
	 * Delete an existing Referral entity
	 * 
	 */
	public DocumentsMapping deleteDocumentsMappingReferral(Integer documentsmapping_id_3, Integer related_referral_id);

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public void deleteDocumentsMapping(DocumentsMapping documentsmapping_1);

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	public DocumentsMapping deleteDocumentsMappingDocuments(Integer documentsmapping_id_4, Integer related_documents_id);

	/**
	 * Save an existing History entity
	 * 
	 */
	public DocumentsMapping saveDocumentsMappingHistory(Integer id_5, History related_history);
}