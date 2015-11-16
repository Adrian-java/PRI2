package com.eclinic.service;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Documents;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Patient entities
 * 
 */

@Service("PatientService")
@Transactional
public class PatientServiceImpl implements PatientService {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * DAO injected by Spring that manages Documents entities
	 * 
	 */
	@Autowired
	private DocumentsDAO documentsDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new PatientServiceImpl.
	 *
	 */
	public PatientServiceImpl() {
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@Transactional
	public Patient savePatientAddress(String id, Address related_address) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Address existingaddress = addressDAO.findAddressByPrimaryKey(related_address.getId());

		// copy into the existing record to preserve existing relationships
		if (existingaddress != null) {
			existingaddress.setId(related_address.getId());
			existingaddress.setCity(related_address.getCity());
			existingaddress.setCountryCode(related_address.getCountryCode());
			existingaddress.setProvince(related_address.getProvince());
			existingaddress.setCountry(related_address.getCountry());
			existingaddress.setCountryCodeCity(related_address.getCountryCodeCity());
			existingaddress.setHomeNr(related_address.getHomeNr());
			related_address = existingaddress;
		}

		patient.setAddress(related_address);
		related_address.getPatients().add(patient);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public Patient deletePatientVisits(String patient_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_visits.setPatient(null);
		patient.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return patient;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Patient savePatientVisits(String id, Visit related_visits) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Visit existingvisits = visitDAO.findVisitByPrimaryKey(related_visits.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisits != null) {
			existingvisits.setId(related_visits.getId());
			existingvisits.setDateOfVisit(related_visits.getDateOfVisit());
			existingvisits.setDescriptionOfVisit(related_visits.getDescriptionOfVisit());
			existingvisits.setIsLeave(related_visits.getIsLeave());
			existingvisits.setSpecial(related_visits.getSpecial());
			related_visits = existingvisits;
		}

		related_visits.setPatient(patient);
		patient.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public void deletePatient(Patient patient) {
		patientDAO.remove(patient);
		patientDAO.flush();
	}

	/**
	 * Save an existing Documents entity
	 * 
	 */
	@Transactional
	public Patient savePatientDocumentses(String id, Documents related_documentses) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Documents existingdocumentses = documentsDAO.findDocumentsByPrimaryKey(related_documentses.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentses != null) {
			existingdocumentses.setId(related_documentses.getId());
			existingdocumentses.setDateOfDocuments(related_documentses.getDateOfDocuments());
			existingdocumentses.setDescription(related_documentses.getDescription());
			existingdocumentses.setTypeOfDocuments(related_documentses.getTypeOfDocuments());
			existingdocumentses.setDataOfDocuments(related_documentses.getDataOfDocuments());
			related_documentses = existingdocumentses;
		}

		related_documentses.setPatient(patient);
		patient.getDocumentses().add(related_documentses);
		related_documentses = documentsDAO.store(related_documentses);
		documentsDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Transactional
	public Patient deletePatientAddress(String patient_id, Integer related_address_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);
		Address related_address = addressDAO.findAddressByPrimaryKey(related_address_id, -1, -1);

		patient.setAddress(null);
		related_address.getPatients().remove(patient);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		addressDAO.remove(related_address);
		addressDAO.flush();

		return patient;
	}

	/**
	 * Return a count of all Patient entity
	 * 
	 */
	@Transactional
	public Integer countPatients() {
		return ((Long) patientDAO.createQuerySingleResult("select count(o) from Patient o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Patient findPatientByPrimaryKey(String id) {
		return patientDAO.findPatientByPrimaryKey(id);
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Patient deletePatientSystemUser(String patient_id, String related_systemuser_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		patient.setSystemUser(null);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return patient;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public String savePatient(Patient patient) {
		Patient existingPatient = patientDAO.findPatientByPrimaryKey(patient.getId());

		if (existingPatient != null) {
			if (existingPatient != patient) {
				existingPatient.setId(patient.getId());
				existingPatient.setName(patient.getName());
				existingPatient.setSurname(patient.getSurname());
				existingPatient.setDateOfBirth(patient.getDateOfBirth());
				existingPatient.setPhoneNr(patient.getPhoneNr());
				existingPatient.setConfirmed(patient.getConfirmed());
			}
			patient = patientDAO.store(existingPatient);
		} else {
			patient = patientDAO.store(patient);
		}
		patientDAO.flush();
		return patient.getId();
	}

	/**
	 * Return all Patient entity
	 * 
	 */
	@Transactional
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Patient>(patientDAO.findAllPatients(startResult, maxRows));
	}

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	@Transactional
	public Patient deletePatientDocumentses(String patient_id, Integer related_documentses_id) {
		Documents related_documentses = documentsDAO.findDocumentsByPrimaryKey(related_documentses_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_documentses.setPatient(null);
		patient.getDocumentses().remove(related_documentses);

		documentsDAO.remove(related_documentses);
		documentsDAO.flush();

		return patient;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Patient savePatientSystemUser(String id, SystemUser related_systemuser) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			existingsystemUser.setRole(related_systemuser.getRole());
			related_systemuser = existingsystemUser;
		} else {
			related_systemuser = systemUserDAO.store(related_systemuser);
			systemUserDAO.flush();
		}

		patient.setSystemUser(related_systemuser);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return patient;
	}

	/**
	 * Load an existing Patient entity
	 * 
	 */
	@Transactional
	public Set<Patient> loadPatients() {
		return patientDAO.findAllPatients();
	}
}
