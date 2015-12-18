package com.eclinic.service;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.ClinicDAO;
import com.eclinic.dao.PatientDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Clinic;
import com.eclinic.domain.Patient;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Address entities
 * 
 */

@Service("AddressService")
@Transactional
public class AddressServiceImpl implements AddressService {

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
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * Instantiates a new AddressServiceImpl.
	 *
	 */
	public AddressServiceImpl() {
	}

	/**
	 * Return all Address entity
	 * 
	 */
	@Transactional
	public List<Address> findAllAddresss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Address>(addressDAO.findAllAddresss(
				startResult, maxRows));
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Transactional
	public void deleteAddress(Address address) {
		addressDAO.remove(address);
		addressDAO.flush();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public Address deleteAddressPatients(Integer address_id,
			String related_patients_id) {
		Patient related_patients = patientDAO.findPatientByPrimaryKey(
				related_patients_id, -1, -1);

		Address address = addressDAO
				.findAddressByPrimaryKey(address_id, -1, -1);

		related_patients.setAddress(null);
		address.getPatients().remove(related_patients);

		patientDAO.remove(related_patients);
		patientDAO.flush();

		return address;
	}

	/**
	 * Load an existing Address entity
	 * 
	 */
	@Transactional
	public Set<Address> loadAddresss() {
		return addressDAO.findAllAddresss();
	}

	/**
	 * Return a count of all Address entity
	 * 
	 */
	@Transactional
	public Integer countAddresss() {
		return ((Long) addressDAO.createQuerySingleResult(
				"select count(o) from Address o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	@Transactional
	public Address saveAddressClinics(Integer id, Clinic related_clinics) {
		Address address = addressDAO.findAddressByPrimaryKey(id, -1, -1);
		Clinic existingclinics = clinicDAO
				.findClinicByPrimaryKey(related_clinics.getId());

		// copy into the existing record to preserve existing relationships
		if (existingclinics != null) {
			existingclinics.setId(related_clinics.getId());
			existingclinics.setName(related_clinics.getName());
			related_clinics = existingclinics;
		}

		related_clinics.setAddress(address);
		address.getClinics().add(related_clinics);
		related_clinics = clinicDAO.store(related_clinics);
		clinicDAO.flush();

		address = addressDAO.store(address);
		addressDAO.flush();

		return address;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Address saveAddressPatients(Integer id, Patient related_patients) {
		Address address = addressDAO.findAddressByPrimaryKey(id, -1, -1);
		Patient existingpatients = patientDAO
				.findPatientByPrimaryKey(related_patients.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatients != null) {
			existingpatients.setId(related_patients.getId());
			existingpatients.setName(related_patients.getName());
			existingpatients.setSurname(related_patients.getSurname());
			existingpatients.setDateOfBirth(related_patients.getDateOfBirth());
			existingpatients.setPhoneNr(related_patients.getPhoneNr());
			existingpatients.setConfirmed(related_patients.getConfirmed());
			related_patients = existingpatients;
		}

		related_patients.setAddress(address);
		address.getPatients().add(related_patients);
		related_patients = patientDAO.store(related_patients);
		patientDAO.flush();

		address = addressDAO.store(address);
		addressDAO.flush();

		return address;
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@Transactional
	public Integer saveAddress(Address address) {
		Address existingAddress = addressDAO.findAddressByPrimaryKey(address
				.getId());

		if (existingAddress != null) {
			if (existingAddress != address) {
				if (!address.getCity().isEmpty())
					existingAddress.setCity(address.getCity());
				if (!address.getCountryCode().isEmpty())
					existingAddress.setCountryCode(address.getCountryCode());
				if (!address.getProvince().isEmpty())
					existingAddress.setProvince(address.getProvince());
				if (!address.getCountry().isEmpty())
					existingAddress.setCountry(address.getCountry());
				if (!address.getCountryCodeCity().isEmpty())
					existingAddress.setCountryCodeCity(address
							.getCountryCodeCity());
				if (!address.getHomeNr().isEmpty())
					existingAddress.setHomeNr(address.getHomeNr());
				if (!address.getStreet().isEmpty())
					existingAddress.setStreet(address.getStreet());
			}
			address = addressDAO.store(existingAddress);
		} else {
			address = addressDAO.store(address);
		}
		addressDAO.flush();
		return address.getId();
	}

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	@Transactional
	public Address deleteAddressClinics(Integer address_id,
			Integer related_clinics_id) {
		Clinic related_clinics = clinicDAO.findClinicByPrimaryKey(
				related_clinics_id, -1, -1);

		Address address = addressDAO
				.findAddressByPrimaryKey(address_id, -1, -1);

		related_clinics.setAddress(null);
		address.getClinics().remove(related_clinics);

		clinicDAO.remove(related_clinics);
		clinicDAO.flush();

		return address;
	}

	/**
	 */
	@Transactional
	public Address findAddressByPrimaryKey(Integer id) {
		return addressDAO.findAddressByPrimaryKey(id);
	}
}
