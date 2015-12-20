package com.eclinic.service;

import com.eclinic.dao.CertificateDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.HistoryDAO;
import com.eclinic.dao.PrescriptionDAO;
import com.eclinic.dao.ReferralDAO;

import com.eclinic.domain.Certificate;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.History;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for DocumentsMapping entities
 * 
 */

@Service("DocumentsMappingService")
@Transactional
public class DocumentsMappingServiceImpl implements DocumentsMappingService {

	/**
	 * DAO injected by Spring that manages Certificate entities
	 * 
	 */
	@Autowired
	private CertificateDAO certificateDAO;

	/**
	 * DAO injected by Spring that manages Documents entities
	 * 
	 */
	@Autowired
	private DocumentsDAO documentsDAO;

	/**
	 * DAO injected by Spring that manages DocumentsMapping entities
	 * 
	 */
	@Autowired
	private DocumentsMappingDAO documentsMappingDAO;

	/**
	 * DAO injected by Spring that manages History entities
	 * 
	 */
	@Autowired
	private HistoryDAO historyDAO;

	/**
	 * DAO injected by Spring that manages Prescription entities
	 * 
	 */
	@Autowired
	private PrescriptionDAO prescriptionDAO;

	/**
	 * DAO injected by Spring that manages Referral entities
	 * 
	 */
	@Autowired
	private ReferralDAO referralDAO;

	/**
	 * Instantiates a new DocumentsMappingServiceImpl.
	 *
	 */
	public DocumentsMappingServiceImpl() {
	}

	/**
	 * Load an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Set<DocumentsMapping> loadDocumentsMappings() {
		return documentsMappingDAO.findAllDocumentsMappings();
	}

	/**
	 * Return all DocumentsMapping entity
	 * 
	 */
	@Transactional
	public List<DocumentsMapping> findAllDocumentsMappings(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<DocumentsMapping>(documentsMappingDAO.findAllDocumentsMappings(startResult, maxRows));
	}

	/**
	 * Delete an existing History entity
	 * 
	 */
	@Transactional
	public DocumentsMapping deleteDocumentsMappingHistory(Integer documentsmapping_id, Integer related_history_id) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping_id, -1, -1);
		History related_history = historyDAO.findHistoryByPrimaryKey(related_history_id, -1, -1);

		documentsmapping.setHistory(null);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_history = historyDAO.store(related_history);
		historyDAO.flush();

		historyDAO.remove(related_history);
		historyDAO.flush();

		return documentsmapping;
	}

	/**
	 * Save an existing Documents entity
	 * 
	 */
	@Transactional
	public DocumentsMapping saveDocumentsMappingDocuments(Integer id, Documents related_documents) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(id, -1, -1);
		Documents existingdocuments = documentsDAO.findDocumentsByPrimaryKey(related_documents.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocuments != null) {
			existingdocuments.setId(related_documents.getId());
			existingdocuments.setDateOfDocuments(related_documents.getDateOfDocuments());
			existingdocuments.setDescription(related_documents.getDescription());
			existingdocuments.setTypeOfDocuments(related_documents.getTypeOfDocuments());
			existingdocuments.setDataOfDocuments(related_documents.getDataOfDocuments());
			related_documents = existingdocuments;
		}

		documentsmapping.setDocuments(related_documents);
		related_documents.getDocumentsMappings().add(documentsmapping);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_documents = documentsDAO.store(related_documents);
		documentsDAO.flush();

		return documentsmapping;
	}

	/**
	 * Delete an existing Certificate entity
	 * 
	 */
	@Transactional
	public DocumentsMapping deleteDocumentsMappingCertificate(Integer documentsmapping_id, Integer related_certificate_id) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping_id, -1, -1);
		Certificate related_certificate = certificateDAO.findCertificateByPrimaryKey(related_certificate_id, -1, -1);

		documentsmapping.setCertificate(null);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_certificate = certificateDAO.store(related_certificate);
		certificateDAO.flush();

		certificateDAO.remove(related_certificate);
		certificateDAO.flush();

		return documentsmapping;
	}

	/**
	 * Save an existing Referral entity
	 * 
	 */
	@Transactional
	public DocumentsMapping saveDocumentsMappingReferral(Integer id, Referral related_referral) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(id, -1, -1);
		Referral existingreferral = referralDAO.findReferralByPrimaryKey(related_referral.getId());

		// copy into the existing record to preserve existing relationships
		if (existingreferral != null) {
			existingreferral.setId(related_referral.getId());
			existingreferral.setDestination(related_referral.getDestination());
			existingreferral.setRecognition(related_referral.getRecognition());
			existingreferral.setPurpose(related_referral.getPurpose());
			related_referral = existingreferral;
		} else {
			related_referral = referralDAO.store(related_referral);
			referralDAO.flush();
		}

		documentsmapping.setReferral(related_referral);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_referral = referralDAO.store(related_referral);
		referralDAO.flush();

		return documentsmapping;
	}

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	@Transactional
	public DocumentsMapping deleteDocumentsMappingPrescription(Integer documentsmapping_id, Integer related_prescription_id) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping_id, -1, -1);
		Prescription related_prescription = prescriptionDAO.findPrescriptionByPrimaryKey(related_prescription_id, -1, -1);

		documentsmapping.setPrescription(null);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_prescription = prescriptionDAO.store(related_prescription);
		prescriptionDAO.flush();

		prescriptionDAO.remove(related_prescription);
		prescriptionDAO.flush();

		return documentsmapping;
	}

	/**
	 * Return a count of all DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Integer countDocumentsMappings() {
		return ((Long) documentsMappingDAO.createQuerySingleResult("select count(o) from DocumentsMapping o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public DocumentsMapping findDocumentsMappingByPrimaryKey(Integer id) {
		return documentsMappingDAO.findDocumentsMappingByPrimaryKey(id);
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public void saveDocumentsMapping(DocumentsMapping documentsmapping) {
		DocumentsMapping existingDocumentsMapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping.getId());

		if (existingDocumentsMapping != null) {
			if (existingDocumentsMapping != documentsmapping) {
				existingDocumentsMapping.setId(documentsmapping.getId());
			}
			documentsmapping = documentsMappingDAO.store(existingDocumentsMapping);
		} else {
			documentsmapping = documentsMappingDAO.store(documentsmapping);
		}
		documentsMappingDAO.flush();
	}

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	@Transactional
	public DocumentsMapping saveDocumentsMappingPrescription(Integer id, Prescription related_prescription) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(id, -1, -1);
		Prescription existingprescription = prescriptionDAO.findPrescriptionByPrimaryKey(related_prescription.getId());

		// copy into the existing record to preserve existing relationships
		if (existingprescription != null) {
			existingprescription.setId(related_prescription.getId());
			existingprescription.setDepartment(related_prescription.getDepartment());
			existingprescription.setIssuedDate(related_prescription.getIssuedDate());
			existingprescription.setExecutionDate(related_prescription.getExecutionDate());
			existingprescription.setRemady(related_prescription.getRemedy());
			related_prescription = existingprescription;
		} else {
			related_prescription = prescriptionDAO.store(related_prescription);
			prescriptionDAO.flush();
		}

		documentsmapping.setPrescription(related_prescription);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_prescription = prescriptionDAO.store(related_prescription);
		prescriptionDAO.flush();

		return documentsmapping;
	}

	/**
	 * Save an existing Certificate entity
	 * 
	 */
	@Transactional
	public DocumentsMapping saveDocumentsMappingCertificate(Integer id, Certificate related_certificate) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(id, -1, -1);
		Certificate existingcertificate = certificateDAO.findCertificateByPrimaryKey(related_certificate.getId());

		// copy into the existing record to preserve existing relationships
		if (existingcertificate != null) {
			existingcertificate.setId(related_certificate.getId());
			existingcertificate.setRecognition(related_certificate.getRecognition());
			existingcertificate.setIdNumber(related_certificate.getIdNumber());
			existingcertificate.setPurpose(related_certificate.getPurpose());
			related_certificate = existingcertificate;
		} else {
			related_certificate = certificateDAO.store(related_certificate);
			certificateDAO.flush();
		}

		documentsmapping.setCertificate(related_certificate);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_certificate = certificateDAO.store(related_certificate);
		certificateDAO.flush();

		return documentsmapping;
	}

	/**
	 * Delete an existing Referral entity
	 * 
	 */
	@Transactional
	public DocumentsMapping deleteDocumentsMappingReferral(Integer documentsmapping_id, Integer related_referral_id) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping_id, -1, -1);
		Referral related_referral = referralDAO.findReferralByPrimaryKey(related_referral_id, -1, -1);

		documentsmapping.setReferral(null);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_referral = referralDAO.store(related_referral);
		referralDAO.flush();

		referralDAO.remove(related_referral);
		referralDAO.flush();

		return documentsmapping;
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public void deleteDocumentsMapping(DocumentsMapping documentsmapping) {
		documentsMappingDAO.remove(documentsmapping);
		documentsMappingDAO.flush();
	}

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	@Transactional
	public DocumentsMapping deleteDocumentsMappingDocuments(Integer documentsmapping_id, Integer related_documents_id) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(documentsmapping_id, -1, -1);
		Documents related_documents = documentsDAO.findDocumentsByPrimaryKey(related_documents_id, -1, -1);

		documentsmapping.setDocuments(null);
		related_documents.getDocumentsMappings().remove(documentsmapping);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_documents = documentsDAO.store(related_documents);
		documentsDAO.flush();

		documentsDAO.remove(related_documents);
		documentsDAO.flush();

		return documentsmapping;
	}

	/**
	 * Save an existing History entity
	 * 
	 */
	@Transactional
	public DocumentsMapping saveDocumentsMappingHistory(Integer id, History related_history) {
		DocumentsMapping documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(id, -1, -1);
		History existinghistory = historyDAO.findHistoryByPrimaryKey(related_history.getId());

		// copy into the existing record to preserve existing relationships
		if (existinghistory != null) {
			existinghistory.setId(related_history.getId());
			existinghistory.setRecognition(related_history.getRecognition());
			existinghistory.setStatisticNumber(related_history.getStatisticNumber());
			existinghistory.setFirstIllness(related_history.getFirstIllness());
			existinghistory.setDateFrom(related_history.getDateFrom());
			existinghistory.setDateTo(related_history.getDateTo());
			related_history = existinghistory;
		} else {
			related_history = historyDAO.store(related_history);
			historyDAO.flush();
		}

		documentsmapping.setHistory(related_history);
		documentsmapping = documentsMappingDAO.store(documentsmapping);
		documentsMappingDAO.flush();

		related_history = historyDAO.store(related_history);
		historyDAO.flush();

		return documentsmapping;
	}
}
