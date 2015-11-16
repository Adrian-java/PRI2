package com.eclinic.service;

import com.eclinic.domain.Certificate;
import com.eclinic.domain.DocumentsMapping;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Certificate entities
 * 
 */
public interface CertificateService {

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public Certificate saveCertificateDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping);

	/**
	 */
	public Certificate findCertificateByPrimaryKey(Integer id_1);

	/**
	 * Return a count of all Certificate entity
	 * 
	 */
	public Integer countCertificates();

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public Certificate deleteCertificateDocumentsMapping(Integer certificate_id, Integer related_documentsmapping_id);

	/**
	 * Return all Certificate entity
	 * 
	 */
	public List<Certificate> findAllCertificates(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Certificate entity
	 * 
	 */
	public Set<Certificate> loadCertificates();

	/**
	 * Delete an existing Certificate entity
	 * 
	 */
	public void deleteCertificate(Certificate certificate);

	/**
	 * Save an existing Certificate entity
	 * 
	 */
	public void saveCertificate(Certificate certificate_1);
}