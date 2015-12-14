package com.eclinic.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Specialization;
import com.eclinic.model.Certificate;
import com.eclinic.model.Clinic;
import com.eclinic.model.Prescription;
import com.eclinic.model.PrescriptionData;
import com.eclinic.model.Referral;
import com.eclinic.model.Remedy;

public class DocumentConverter {

//	TODO - refactor, delete comments
	public PrescriptionData getDataFrom(Prescription prescription) {
		PrescriptionData data = new PrescriptionData();
		
		Patient patient = prescription.getPatient();
		Clinic clinic = prescription.getClinic();
		Doctor doctor = prescription.getDoctor();
		
		data.setNumber(prescription.getNumber());
		
		data.setClinicName(clinic.getName());
		data.setClinicAddress(getClinicAddress(clinic));
		data.setClinicContact(getClinicContact(clinic));
		data.setClinicRegon(getClinicRegon(clinic));
		
		data.setPatientName(getPatientName(patient));
		data.setPatientAddress(getPatientAddress(patient));
		
//		TODO - add pesel to patient model data.setPesel(patient.getPesel());
		data.setPesel("01010122393");
		
		data.setDepartment(prescription.getDepartment());
		data.setPermissions(prescription.getPermissions());
		
		data.setRemedy(getRemedy(prescription));
		
		data.setIssuedDate(prescription.getIssuedDate());
		data.setExecutionDate(prescription.getExecutionDate());
		
		data.setDoctorName(getDoctorName(doctor));
		data.setDoctorSpecialization(getDoctorSpecialization(doctor));
		
		return data;
	}
	
	
	public Map<String, Object> convertToCertificate(Certificate certificate) {		
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		Clinic clinic = certificate.getClinic();
		Patient patient = certificate.getPatient();
		
		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
		
		map.put("City", clinic.getCity());
		map.put("Date", date.format(certificate.getDate()));
		map.put("BirthDate", "29.11.1990");
		map.put("Name", getPatientName(patient));
		map.put("IdNumber", patient.getId());
		map.put("Address", getPatientAddress(patient));
		map.put("Recognition", certificate.getRecognition());
		map.put("Purpose", certificate.getPurpose());
		
		return map;
	}
	
	public Map<String, Object> convertToReferral(Referral referral) {		
		HashMap<String, Object> map = new HashMap<String, Object>();

		Clinic clinic = referral.getClinic();
		Patient patient = referral.getPatient();
		
		map.put("City", clinic.getCity());
		map.put("Name", getPatientName(patient));
		map.put("Pesel", "9102012351");
		map.put("Purpose", referral.getPurpose());
		map.put("Destination", referral.getDestination());
		map.put("Recognition", referral.getRecognition());
		map.put("Date", referral.getDate().toString());
		
		return map;
	}
	
	
	public Map<String, Object> convertToPrescription(Prescription prescription) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Patient patient = prescription.getPatient();
		Clinic clinic = prescription.getClinic();
		Doctor doctor = prescription.getDoctor();
		
		map.put("PrescriptionNumber", Long.toString(prescription.getNumber()));
		map.put("ClinicName", clinic.getName());
		map.put("ClinicAddress", getClinicAddress(clinic));
		map.put("ClinicContact", getClinicContact(clinic));
		map.put("ClinicRegon", getClinicRegon(clinic));
		map.put("PatientName", getPatientName(patient));
		map.put("PatientAddress", getPatientAddress(patient));
		
//		TODO - add pesel to patient model data.setPesel(patient.getPesel());
		map.put("PatientPesel", "01010122393");

		map.put("Department", prescription.getDepartment());
		map.put("Permissions", prescription.getPermissions());
		
		setRemedies(prescription, map);
		
		map.put("IssuedDate", prescription.getIssuedDate().toString());
		map.put("ExecutionDate", prescription.getExecutionDate().toString());
		map.put("DoctorName", getDoctorName(doctor));
		map.put("DoctorSpecialization", getDoctorSpecialization(doctor));
		
		return map;
	}

	private void setRemedies(Prescription prescription, HashMap<String, Object> map) {
		int i = 0;
		for (Remedy rem : getRemedy(prescription)) {
			if (rem.getName() != null) {
				map.put("Remedy"+i, rem.getName());
				map.put("Repayment"+i, rem.getRepayment());
				i++;
			}
			else {
				map.put("Remedy"+i, "");
				map.put("Repayment"+i, "");
				i++;
			}
		}
	}
	
	private String getClinicAddress(Clinic clinic) {
		return String.format("ul. %s %s %s %s", clinic.getStreet(), clinic.getHouseNumber(), clinic.getCode(), clinic.getCity());
	}
	
	
	private String getClinicContact(Clinic clinic) {
		return String.format("tel. %s email: %s", clinic.getPhone(), clinic.getEmail());
	}
	
	private String getClinicRegon(Clinic clinic) {
		return String.format("NIP: %s REGON: %s", clinic.getNip(), clinic.getRegon());
	}
	
	private String getPatientName(Patient patient) {
		return patient.getName() + " " +patient.getSurname();
	} 
	
//	TODO - add street do Address model
	private String getPatientAddress(Patient patient) {
		Address adr = patient.getAddress();
		return String.format("ul. %s %s %s %s", adr.getStreet(), adr.getHomeNr(), adr.getCountryCodeCity(), adr.getCity());	
	}
	
	
	private List<Remedy> getRemedy(Prescription prescription) {
		List<Remedy> remedy = new ArrayList<Remedy>();
		
		String remedyText = prescription.getRemedy();
		String[] remedies = remedyText.split(";");
		
		for (int i=0; i < remedies.length; i+=2) {
			Remedy rem = new Remedy(remedies[i], remedies[i+1]);
			remedy.add(rem);
		}
		
		return remedy;
	}
	
	private String getDoctorName(Doctor doctor) {
		return doctor.getName() + " " + doctor.getSurname();
	}
	
	private String getDoctorSpecialization(Doctor doctor) {
		Set<Specialization> specializations = doctor.getSpecializations();
		String name = "";
		for (Specialization spec : specializations) {
			name = spec.getName();
			break;
		}
		return name;
	}
	
	
}
