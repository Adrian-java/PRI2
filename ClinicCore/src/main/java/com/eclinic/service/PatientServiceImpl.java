package com.eclinic.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Worker;

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
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;


	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;
	

	/**
	 * Instantiates a new PatientServiceImpl.
	 *
	 */
	public PatientServiceImpl() {
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public Patient deletePatientWorkers(Integer patient_id, Integer related_workers_id) {
		Worker related_workers = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_workers.setPatient(null);
		patient.getWorkers().remove(related_workers);

		workerDAO.remove(related_workers);
		workerDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Transactional
	public Patient deletePatientAddress(Integer patient_id, Integer related_address_id) {
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
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public void deletePatient(Patient patient) {
		patientDAO.remove(patient);
		patientDAO.flush();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public Patient savePatientWorkers(Integer id, Worker related_workers) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Worker existingworkers = workerDAO.findWorkerByPrimaryKey(related_workers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworkers != null) {
			existingworkers.setId(related_workers.getId());
			related_workers = existingworkers;
		} else {
			related_workers = workerDAO.store(related_workers);
			workerDAO.flush();
		}

		related_workers.setPatient(patient);
		patient.getWorkers().add(related_workers);
		related_workers = workerDAO.store(related_workers);
		workerDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 */
	@Transactional
	public Patient findPatientByPrimaryKey(Integer id) {
		return patientDAO.findPatientByPrimaryKey(id);
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
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Integer savePatient(Patient patient) {
		Patient existingPatient = patientDAO.findPatientByPrimaryKey(patient.getId());

		if (existingPatient != null) {
			if (existingPatient != patient) {
				existingPatient.setId(patient.getId());
				existingPatient.setName(patient.getName());
				existingPatient.setSurname(patient.getSurname());
				existingPatient.setDateOfBirth(patient.getDateOfBirth());
//				existingPatient.setEMail(patient.getEMail());
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
	 * Load an existing Patient entity
	 * 
	 */
	@Transactional
	public Set<Patient> loadPatients() {
		return patientDAO.findAllPatients();
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@Transactional
	public Patient savePatientAddress(Integer id, Address related_address) {
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
	 * Return all Patient entity
	 * 
	 */
	@Transactional
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Patient>(patientDAO.findAllPatients(startResult, maxRows));
	}
}
