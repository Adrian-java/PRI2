package com.eclinic.service;

import com.eclinic.dao.ClinicDAO;
import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.PrescriptionDAO;

import com.eclinic.domain.Clinic;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Prescription;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Prescription entities
 * 
 */

@Service("PrescriptionService")
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

	/**
	 * DAO injected by Spring that manages Clinic entities
	 * 
	 */
	@Autowired
	private ClinicDAO clinicDAO;

	/**
	 * DAO injected by Spring that manages DocumentsMapping entities
	 * 
	 */
	@Autowired
	private DocumentsMappingDAO documentsMappingDAO;

	/**
	 * DAO injected by Spring that manages Prescription entities
	 * 
	 */
	@Autowired
	private PrescriptionDAO prescriptionDAO;

	/**
	 * Instantiates a new PrescriptionServiceImpl.
	 *
	 */
	public PrescriptionServiceImpl() {
	}

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	@Transactional
	public void deletePrescription(Prescription prescription) {
		prescriptionDAO.remove(prescription);
		prescriptionDAO.flush();
	}

	/**
	 * Return a count of all Prescription entity
	 * 
	 */
	@Transactional
	public Integer countPrescriptions() {
		return ((Long) prescriptionDAO.createQuerySingleResult("select count(o) from Prescription o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Prescription findPrescriptionByPrimaryKey(Integer id) {
		return prescriptionDAO.findPrescriptionByPrimaryKey(id);
	}

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	@Transactional
	public void savePrescription(Prescription prescription) {
		Prescription existingPrescription = prescriptionDAO.findPrescriptionByPrimaryKey(prescription.getId());

		if (existingPrescription != null) {
			if (existingPrescription != prescription) {
				existingPrescription.setId(prescription.getId());
				existingPrescription.setDepartment(prescription.getDepartment());
				existingPrescription.setIssuedDate(prescription.getIssuedDate());
				existingPrescription.setExecutionDate(prescription.getExecutionDate());
				existingPrescription.setRemady(prescription.getRemady());
			}
			prescription = prescriptionDAO.store(existingPrescription);
		} else {
			prescription = prescriptionDAO.store(prescription);
		}
		prescriptionDAO.flush();
	}

	/**
	 * Return all Prescription entity
	 * 
	 */
	@Transactional
	public List<Prescription> findAllPrescriptions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Prescription>(prescriptionDAO.findAllPrescriptions(startResult, maxRows));
	}

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	@Transactional
	public Prescription savePrescriptionClinic(Integer id, Clinic related_clinic) {
		Prescription prescription = prescriptionDAO.findPrescriptionByPrimaryKey(id, -1, -1);
		Clinic existingclinic = clinicDAO.findClinicByPrimaryKey(related_clinic.getId());

		// copy into the existing record to preserve existing relationships
		if (existingclinic != null) {
			existingclinic.setId(related_clinic.getId());
			existingclinic.setName(related_clinic.getName());
			related_clinic = existingclinic;
		}

		prescription.setClinic(related_clinic);
		related_clinic.getPrescriptions().add(prescription);
		prescription = prescriptionDAO.store(prescription);
		prescriptionDAO.flush();

		related_clinic = clinicDAO.store(related_clinic);
		clinicDAO.flush();

		return prescription;
	}

	/**
	 * Load an existing Prescription entity
	 * 
	 */
	@Transactional
	public Set<Prescription> loadPrescriptions() {
		return prescriptionDAO.findAllPrescriptions();
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Prescription savePrescriptionDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping) {
		Prescription prescription = prescriptionDAO.findPrescriptionByPrimaryKey(id, -1, -1);
		DocumentsMapping existingdocumentsMapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentsMapping != null) {
			existingdocumentsMapping.setId(related_documentsmapping.getId());
			related_documentsmapping = existingdocumentsMapping;
		} else {
			related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
			documentsMappingDAO.flush();
		}

		prescription.setDocumentsMapping(related_documentsmapping);
		prescription = prescriptionDAO.store(prescription);
		prescriptionDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		return prescription;
	}

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	@Transactional
	public Prescription deletePrescriptionClinic(Integer prescription_id, Integer related_clinic_id) {
		Prescription prescription = prescriptionDAO.findPrescriptionByPrimaryKey(prescription_id, -1, -1);
		Clinic related_clinic = clinicDAO.findClinicByPrimaryKey(related_clinic_id, -1, -1);

		prescription.setClinic(null);
		related_clinic.getPrescriptions().remove(prescription);
		prescription = prescriptionDAO.store(prescription);
		prescriptionDAO.flush();

		related_clinic = clinicDAO.store(related_clinic);
		clinicDAO.flush();

		clinicDAO.remove(related_clinic);
		clinicDAO.flush();

		return prescription;
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Prescription deletePrescriptionDocumentsMapping(Integer prescription_id, Integer related_documentsmapping_id) {
		Prescription prescription = prescriptionDAO.findPrescriptionByPrimaryKey(prescription_id, -1, -1);
		DocumentsMapping related_documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping_id, -1, -1);

		prescription.setDocumentsMapping(null);
		prescription = prescriptionDAO.store(prescription);
		prescriptionDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		documentsMappingDAO.remove(related_documentsmapping);
		documentsMappingDAO.flush();

		return prescription;
	}
}
