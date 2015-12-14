package com.eclinic.helper;

import java.util.Calendar;
import java.util.Date;

import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.model.Certificate;
import com.eclinic.model.Clinic;
import com.eclinic.model.Prescription;
import com.eclinic.model.Referral;

public class DocumentBuilder {

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
		prescription.setRemedy("Atecortin;100%;Duomox;50%;Prestarium;72%;Noliprel;30%;Torvacard;92%;");
		
		return prescription;
	}
	
	public Certificate createCertificate() {
		Certificate certificate = new Certificate();
		
		certificate.setClinic(createClinic());
		certificate.setDate(Calendar.getInstance().getTime());
		certificate.setId(92134141);
		certificate.setPatient(createPatient());
		certificate.setPurpose("Zwolnienie z zajec WF");
		certificate.setRecognition("Choroba górnych dróg oddechowych");
		
		return certificate; 
	}
	
	public Referral createReferaral() {
		Referral referral = new Referral();

		referral.setClinic(createClinic());
		referral.setPatient(createPatient());
		referral.setDate(Calendar.getInstance().getTime());
		referral.setDestination("Laryngologa");
		referral.setPurpose("Dalsze leczenie specjalistyczne");
		referral.setRecognition("Zapalenie gorncyh drog oddechowych");
		
		return referral;
	}
	
	private Patient createPatient() {
		Patient patient = new Patient();
		
		Address address = createAddress();
		
		patient.setName("Sebastian");
		patient.setSurname("Cebula");
		patient.setAddress(address);
		
		return patient;
	}

	private Address createAddress() {
		Address address = new Address();
		address.setCity("Warszawa");
		address.setHomeNr("23");
		address.setStreet("Wiejska");
		address.setCountryCodeCity("00-912");
		return address;
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
		clinic.setEmail("przychodnia@e-przychodnia.pl");
		clinic.setHouseNumber("22");
		clinic.setName("Przychodnia dobra nadzieja");
		clinic.setNip("1315515151");
		clinic.setPhone("2211323213");
		clinic.setRegon("243135115");
		clinic.setStreet("poznanska");
		
		return clinic;
	}
}
