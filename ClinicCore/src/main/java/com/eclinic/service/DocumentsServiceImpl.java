package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.PatientDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Patient;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Documents entities
 * 
 */

@Service("DocumentsService")
@Transactional
public class DocumentsServiceImpl implements DocumentsService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

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
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * Instantiates a new DocumentsServiceImpl.
	 *
	 */
	public DocumentsServiceImpl() {
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Documents saveDocumentsPatient(Integer id, Patient related_patient) {
		Documents documents = documentsDAO.findDocumentsByPrimaryKey(id, -1, -1);
		Patient existingpatient = patientDAO.findPatientByPrimaryKey(related_patient.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatient != null) {
			existingpatient.setId(related_patient.getId());
			existingpatient.setName(related_patient.getName());
			existingpatient.setSurname(related_patient.getSurname());
			existingpatient.setDateOfBirth(related_patient.getDateOfBirth());
			existingpatient.setPhoneNr(related_patient.getPhoneNr());
			existingpatient.setConfirmed(related_patient.getConfirmed());
			related_patient = existingpatient;
		}

		documents.setPatient(related_patient);
		related_patient.getDocumentses().add(documents);
		documents = documentsDAO.store(documents);
		documentsDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return documents;
	}

	/**
	 */
	@Transactional
	public Documents findDocumentsByPrimaryKey(Integer id) {
		return documentsDAO.findDocumentsByPrimaryKey(id);
	}

	/**
	 * Save an existing Documents entity
	 * 
	 */
	@Transactional
	public void saveDocuments(Documents documents) {
		Documents existingDocuments = documentsDAO.findDocumentsByPrimaryKey(documents.getId());

		if (existingDocuments != null) {
			if (existingDocuments != documents) {
				existingDocuments.setId(documents.getId());
				existingDocuments.setDateOfDocuments(documents.getDateOfDocuments());
				existingDocuments.setDescription(documents.getDescription());
				existingDocuments.setTypeOfDocuments(documents.getTypeOfDocuments());
				existingDocuments.setDataOfDocuments(documents.getDataOfDocuments());
			}
			documents = documentsDAO.store(existingDocuments);
		} else {
			documents = documentsDAO.store(documents);
		}
		documentsDAO.flush();
	}

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	@Transactional
	public void deleteDocuments(Documents documents) {
		documentsDAO.remove(documents);
		documentsDAO.flush();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Documents saveDocumentsDoctor(Integer id, Doctor related_doctor) {
		Documents documents = documentsDAO.findDocumentsByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		documents.setDoctor(related_doctor);
		related_doctor.getDocumentses().add(documents);
		documents = documentsDAO.store(documents);
		documentsDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return documents;
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Documents deleteDocumentsDocumentsMappings(Integer documents_id, Integer related_documentsmappings_id) {
		DocumentsMapping related_documentsmappings = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmappings_id, -1, -1);

		Documents documents = documentsDAO.findDocumentsByPrimaryKey(documents_id, -1, -1);

		related_documentsmappings.setDocuments(null);
		documents.getDocumentsMappings().remove(related_documentsmappings);

		documentsMappingDAO.remove(related_documentsmappings);
		documentsMappingDAO.flush();

		return documents;
	}

	/**
	 * Load an existing Documents entity
	 * 
	 */
	@Transactional
	public Set<Documents> loadDocumentss() {
		return documentsDAO.findAllDocumentss();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public Documents deleteDocumentsPatient(Integer documents_id, Integer related_patient_id) {
		Documents documents = documentsDAO.findDocumentsByPrimaryKey(documents_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		documents.setPatient(null);
		related_patient.getDocumentses().remove(documents);
		documents = documentsDAO.store(documents);
		documentsDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return documents;
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Documents saveDocumentsDocumentsMappings(Integer id, DocumentsMapping related_documentsmappings) {
		Documents documents = documentsDAO.findDocumentsByPrimaryKey(id, -1, -1);
		DocumentsMapping existingdocumentsMappings = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmappings.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentsMappings != null) {
			existingdocumentsMappings.setId(related_documentsmappings.getId());
			related_documentsmappings = existingdocumentsMappings;
		}

		related_documentsmappings.setDocuments(documents);
		documents.getDocumentsMappings().add(related_documentsmappings);
		related_documentsmappings = documentsMappingDAO.store(related_documentsmappings);
		documentsMappingDAO.flush();

		documents = documentsDAO.store(documents);
		documentsDAO.flush();

		return documents;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Documents deleteDocumentsDoctor(Integer documents_id, Integer related_doctor_id) {
		Documents documents = documentsDAO.findDocumentsByPrimaryKey(documents_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		documents.setDoctor(null);
		related_doctor.getDocumentses().remove(documents);
		documents = documentsDAO.store(documents);
		documentsDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return documents;
	}

	/**
	 * Return a count of all Documents entity
	 * 
	 */
	@Transactional
	public Integer countDocumentss() {
		return ((Long) documentsDAO.createQuerySingleResult("select count(o) from Documents o").getSingleResult()).intValue();
	}

	/**
	 * Return all Documents entity
	 * 
	 */
	@Transactional
	public List<Documents> findAllDocumentss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Documents>(documentsDAO.findAllDocumentss(startResult, maxRows));
	}
}
