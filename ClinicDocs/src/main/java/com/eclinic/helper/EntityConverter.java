package com.eclinic.helper;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.view.PatientView;

public class EntityConverter {

	public Patient convertToPatient(PatientView view) {
		Patient patient = new Patient();
		
		patient.setAddress(createAddress(view));
		patient.setId(view.getId());
		patient.setDateOfBirth(view.getDateOfBirth());
		patient.setName(view.getName());
		patient.setPhoneNr(view.getPhoneNr());
		patient.setSurname(view.getSurname());
		
		return patient;
	}
	
	
	private Address createAddress(PatientView view) {
		Address address = new Address();
		
		address.setCity(view.getCity());
		address.setCountry(view.getCountry());
		address.setCountryCode(view.getCountryCode());
		address.setCountryCodeCity(view.getCountryCodeCity());
		address.setHomeNr(view.getHomeNr());
		address.setProvince(view.getProvince());
		address.setStreet("Add street in EntityConverter");
		
		return address;
	} 
}
