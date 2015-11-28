package com.eclinic.helper;

import java.util.Calendar;

import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.model.Clinic;
import com.eclinic.model.Prescription;

public class PrescriptionBuilder {

	public Prescription createPresctiption() {
		Prescription prescription = new Prescription();
		
		prescription.setClinic(createClinic());
		prescription.setDepartment("02");
		prescription.setDoctor(createDoctor());
		prescription.setExecutionDate(Calendar.getInstance().getTime());
		prescription.setIssuedDate(Calendar.getInstance().getTime());
		prescription.setNumber(1000210321);
		prescription.setPatient(createPatient());
		prescription.setPermissions("brak");
		prescription.setRemedy("lek1;100%;lek2;50%;lek3;72%;lek4;30%;lek5;92%;");
		
		return prescription;
	}
	
	private Patient createPatient() {
		Patient patient = new Patient();
		
		Address address = new Address();
		address.setCity("Warszawa");
		
		patient.setName("Seba");
		patient.setSurname("Cebula");
		patient.setAddress(address);
		
		return patient;
	}
	
	private Doctor createDoctor() {
		Doctor doctor = new Doctor();
		
		doctor.setName("Janusz");
		doctor.setSurname("Cebula");
		
		return doctor;
	}
	
	private Clinic createClinic() {
		Clinic clinic = new Clinic();

		clinic.setCity("Poznan");
		clinic.setCode("61-142");
		clinic.setEmail("aadasd@asdad.pl");
		clinic.setHouseNumber("22");
		clinic.setName("Przychodnia dobra nadzieja");
		clinic.setNip("1315515151");
		clinic.setPhone("2211323213");
		clinic.setRegon("243135115");
		clinic.setStreet("poznanska");
		
		return clinic;
	}
}
