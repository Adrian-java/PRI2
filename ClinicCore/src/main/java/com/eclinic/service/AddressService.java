package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Clinic;
import com.eclinic.domain.Patient;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Address entities
 * 
 */
public interface AddressService {

	/**
	 * Return all Address entity
	 * 
	 */
	public List<Address> findAllAddresss(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public void deleteAddress(Address address);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Address deleteAddressPatients(Integer address_id, String related_patients_id);

	/**
	 * Load an existing Address entity
	 * 
	 */
	public Set<Address> loadAddresss();

	/**
	 * Return a count of all Address entity
	 * 
	 */
	public Integer countAddresss();

	/**
	 * Save an existing Clinic entity
	 * 
	 */
	public Address saveAddressClinics(Integer id, Clinic related_clinics);

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Address saveAddressPatients(Integer id_1, Patient related_patients);

	/**
	 * Save an existing Address entity
	 * @return 
	 * 
	 */
	public Integer saveAddress(Address address_1);

	/**
	 * Delete an existing Clinic entity
	 * 
	 */
	public Address deleteAddressClinics(Integer address_id_1, Integer related_clinics_id);

	/**
	 */
	public Address findAddressByPrimaryKey(Integer id_2);
}