package com.eclinic.service;

import com.eclinic.dao.CertificateDAO;
import com.eclinic.dao.DocumentsMappingDAO;

import com.eclinic.domain.Certificate;
import com.eclinic.domain.DocumentsMapping;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Certificate entities
 * 
 */

@Service("CertificateService")
@Transactional
public class CertificateServiceImpl implements CertificateService {

	/**
	 * DAO injected by Spring that manages Certificate entities
	 * 
	 */
	@Autowired
	private CertificateDAO certificateDAO;

	/**
	 * DAO injected by Spring that manages DocumentsMapping entities
	 * 
	 */
	@Autowired
	private DocumentsMappingDAO documentsMappingDAO;

	/**
	 * Instantiates a new CertificateServiceImpl.
	 *
	 */
	public CertificateServiceImpl() {
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Certificate saveCertificateDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping) {
		Certificate certificate = certificateDAO.findCertificateByPrimaryKey(id, -1, -1);
		DocumentsMapping existingdocumentsMapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentsMapping != null) {
			existingdocumentsMapping.setId(related_documentsmapping.getId());
			related_documentsmapping = existingdocumentsMapping;
		} else {
			related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
			documentsMappingDAO.flush();
		}

		certificate.setDocumentsMapping(related_documentsmapping);
		certificate = certificateDAO.store(certificate);
		certificateDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		return certificate;
	}

	/**
	 */
	@Transactional
	public Certificate findCertificateByPrimaryKey(Integer id) {
		return certificateDAO.findCertificateByPrimaryKey(id);
	}

	/**
	 * Return a count of all Certificate entity
	 * 
	 */
	@Transactional
	public Integer countCertificates() {
		return ((Long) certificateDAO.createQuerySingleResult("select count(o) from Certificate o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Certificate deleteCertificateDocumentsMapping(Integer certificate_id, Integer related_documentsmapping_id) {
		Certificate certificate = certificateDAO.findCertificateByPrimaryKey(certificate_id, -1, -1);
		DocumentsMapping related_documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping_id, -1, -1);

		certificate.setDocumentsMapping(null);
		certificate = certificateDAO.store(certificate);
		certificateDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		documentsMappingDAO.remove(related_documentsmapping);
		documentsMappingDAO.flush();

		return certificate;
	}

	/**
	 * Return all Certificate entity
	 * 
	 */
	@Transactional
	public List<Certificate> findAllCertificates(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Certificate>(certificateDAO.findAllCertificates(startResult, maxRows));
	}

	/**
	 * Load an existing Certificate entity
	 * 
	 */
	@Transactional
	public Set<Certificate> loadCertificates() {
		return certificateDAO.findAllCertificates();
	}

	/**
	 * Delete an existing Certificate entity
	 * 
	 */
	@Transactional
	public void deleteCertificate(Certificate certificate) {
		certificateDAO.remove(certificate);
		certificateDAO.flush();
	}

	/**
	 * Save an existing Certificate entity
	 * 
	 */
	@Transactional
	public void saveCertificate(Certificate certificate) {
		Certificate existingCertificate = certificateDAO.findCertificateByPrimaryKey(certificate.getId());

		if (existingCertificate != null) {
			if (existingCertificate != certificate) {
				existingCertificate.setId(certificate.getId());
				existingCertificate.setRecognition(certificate.getRecognition());
				existingCertificate.setIdNumber(certificate.getIdNumber());
				existingCertificate.setPurpose(certificate.getPurpose());
			}
			certificate = certificateDAO.store(existingCertificate);
		} else {
			certificate = certificateDAO.store(certificate);
		}
		certificateDAO.flush();
	}
}
