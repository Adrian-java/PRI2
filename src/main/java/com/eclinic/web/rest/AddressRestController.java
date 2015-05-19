package com.eclinic.web.rest;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;

import com.eclinic.service.AddressService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Address entities
 * 
 */

@Controller("AddressRestController")
public class AddressRestController {

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
	 * Service injected by Spring that provides CRUD operations for Address entities
	 * 
	 */
	@Autowired
	private AddressService addressService;

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Select an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}", method = RequestMethod.GET)
	@ResponseBody
	public Address loadAddress(@PathVariable Integer address_id) {
		return addressDAO.findAddressByPrimaryKey(address_id);
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}/patients", method = RequestMethod.POST)
	@ResponseBody
	public Patient newAddressPatients(@PathVariable Integer address_id, @RequestBody Patient patient) {
		addressService.saveAddressPatients(address_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Address", method = RequestMethod.PUT)
	@ResponseBody
	public Address saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return addressDAO.findAddressByPrimaryKey(address.getId());
	}

	/**
	 * Show all Address entities
	 * 
	 */
	@RequestMapping(value = "/Address", method = RequestMethod.GET)
	@ResponseBody
	public List<Address> listAddresss() {
		return new java.util.ArrayList<Address>(addressService.loadAddresss());
	}

	/**
	 * Create a new Address entity
	 * 
	 */
	@RequestMapping(value = "/Address", method = RequestMethod.POST)
	@ResponseBody
	public Address newAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return addressDAO.findAddressByPrimaryKey(address.getId());
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}/patients/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadAddressPatients(@PathVariable Integer address_id, @PathVariable Integer related_patients_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patients_id, -1, -1);

		return patient;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}/patients/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAddressPatients(@PathVariable Integer address_id, @PathVariable Integer related_patients_id) {
		addressService.deleteAddressPatients(address_id, related_patients_id);
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}/patients", method = RequestMethod.PUT)
	@ResponseBody
	public Patient saveAddressPatients(@PathVariable Integer address_id, @RequestBody Patient patients) {
		addressService.saveAddressPatients(address_id, patients);
		return patientDAO.findPatientByPrimaryKey(patients.getId());
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAddress(@PathVariable Integer address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(address_id);
		addressService.deleteAddress(address);
	}

	/**
	 * Show all Patient entities by Address
	 * 
	 */
	@RequestMapping(value = "/Address/{address_id}/patients", method = RequestMethod.GET)
	@ResponseBody
	public List<Patient> getAddressPatients(@PathVariable Integer address_id) {
		return new java.util.ArrayList<Patient>(addressDAO.findAddressByPrimaryKey(address_id).getPatients());
	}
}