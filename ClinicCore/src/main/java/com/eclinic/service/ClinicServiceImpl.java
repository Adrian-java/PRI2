package com.eclinic.service;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.ClinicDAO;
import com.eclinic.dao.PrescriptionDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Clinic;
import com.eclinic.domain.Prescription;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Clinic entities
 * 
 */

@Service("ClinicService")
@Transactional
public class ClinicServiceImpl implements ClinicService {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * DAO injected by Spring that manages Clinic entities
	 * 
	 */
	@Autowired
	private ClinicDAO clinicDAO;

	/**
	 * DAO injected by Spring that manages Prescription entities
	 * 
	 */
	@Autowired
	private PrescriptionDAO prescriptionDAO;

	/**
	 * Instantiates a new ClinicServiceImpl.
	 *
	 */
	public ClinicServiceImpl() {
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@Transactional
	public Clinic saveClinicAddress(Integer id, Address related_address) {
		Clinic clinic = clinicDAO.findClinicByPrimaryKey(id, -1, -1);
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

		clinic.setAddress(related_address);
		related_address.getClinics().add(clinic);
		clinic = clinicDAO.store(clinic);
		clinicDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		return clinic;
	}

	/**
	 * Load an existing Clinic entity
	 * 
	 */
	@Transactional
	public Set<Clinic> loadClinics() {
		return clinicDAO.findAllClinics();
	}

	/**
	 */
	@Transactional
	public Clinic findClinicByPrimaryKey(Integer id) {
		return clinicDAO.findClinicByPrimaryKey(id);
	}

	/**
	 * Return a count of all Clinic entity
	 * 
	 */
	@Transactional
	public Integer countClinics() {
		return ((Long) clinicDAO.createQuerySingleResult("select count(o) from Clinic o").getSingleResult()).intValue();
	}

	/**
	 * Return all Clinic entity
	 * 
	 */
	@Transactional
	public List<Clinic> findAllClinics(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Clinic>(clinicDAO.findAllClinics(startResult, maxRows));
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Transactional
	public Clinic deleteClinicAddress(Integer clinic_id, Integer related_address_id) {
		Clinic clinic = clinicDAO.findClinicByPrimaryKey(clinic_id, -1, -1);
		Address related_address = addressDAO.findAddressByPrimaryKey(related_address_id, -1, -1);

		clinic.setAddress(null);
		related_address.getClinics().remove(clinic);
		clinic = clinicDAO.store(clinic);
		clinicDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		addressDAO.remove(related_address);
		addressDAO.flush();

		return clinic;
	}

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	@Transactional
	public void saveClinic(Clinic clinic) {
		Clinic existingClinic = clinicDAO.findClinicByPrimaryKey(clinic.getId());

		if (existingClinic != null) {
			if (existingClinic != clinic) {
				existingClinic.setId(clinic.getId());
				existingClinic.setName(clinic.getName());
			}
			clinic = clinicDAO.store(existingClinic);
		} else {
			clinic = clinicDAO.store(clinic);
		}
		clinicDAO.flush();
	}

	/**
	 * Delete an existing Prescription entity
	 * 
	 */
	@Transactional
	public Clinic deleteClinicPrescriptions(Integer clinic_id, Integer related_prescriptions_id) {
		Prescription related_prescriptions = prescriptionDAO.findPrescriptionByPrimaryKey(related_prescriptions_id, -1, -1);

		Clinic clinic = clinicDAO.findClinicByPrimaryKey(clinic_id, -1, -1);

		related_prescriptions.setClinic(null);
		clinic.getPrescriptions().remove(related_prescriptions);

		prescriptionDAO.remove(related_prescriptions);
		prescriptionDAO.flush();

		return clinic;
	}

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	@Transactional
	public void deleteClinic(Clinic clinic) {
		clinicDAO.remove(clinic);
		clinicDAO.flush();
	}

	/**
	 * Save an existing Prescription entity
	 * 
	 */
	@Transactional
	public Clinic saveClinicPrescriptions(Integer id, Prescription related_prescriptions) {
		Clinic clinic = clinicDAO.findClinicByPrimaryKey(id, -1, -1);
		Prescription existingprescriptions = prescriptionDAO.findPrescriptionByPrimaryKey(related_prescriptions.getId());

		// copy into the existing record to preserve existing relationships
		if (existingprescriptions != null) {
			existingprescriptions.setId(related_prescriptions.getId());
			existingprescriptions.setDepartment(related_prescriptions.getDepartment());
			existingprescriptions.setIssuedDate(related_prescriptions.getIssuedDate());
			existingprescriptions.setExecutionDate(related_prescriptions.getExecutionDate());
			existingprescriptions.setRemady(related_prescriptions.getRemady());
			related_prescriptions = existingprescriptions;
		}

		related_prescriptions.setClinic(clinic);
		clinic.getPrescriptions().add(related_prescriptions);
		related_prescriptions = prescriptionDAO.store(related_prescriptions);
		prescriptionDAO.flush();

		clinic = clinicDAO.store(clinic);
		clinicDAO.flush();

		return clinic;
	}
}
