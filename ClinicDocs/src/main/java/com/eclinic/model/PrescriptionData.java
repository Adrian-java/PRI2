package com.eclinic.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrescriptionData {
	
	private long number;
	
	private String clinicName;
	
	private String clinicAddress;
	
	private String clinicContact;
	
	private String clinicRegon;
	
	private String patientName;
	
	private String patientAddress;
	
	private String pesel;
	
	private String department;
	
	private String permissions;
	
	private List<Remedy> remedy;
	
	private Date issuedDate;
	
	private Date executionDate;
	
	private String doctorName;
	
	private String doctorSpecialization;

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getClinicContact() {
		return clinicContact;
	}

	public void setClinicContact(String clinicContact) {
		this.clinicContact = clinicContact;
	}

	public String getClinicRegon() {
		return clinicRegon;
	}

	public void setClinicRegon(String clinicRegon) {
		this.clinicRegon = clinicRegon;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public List<Remedy> getRemedy() {
		return remedy;
	}

	public void setRemedy(List<Remedy> remedy) {
		this.remedy = remedy;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctor) {
		this.doctorName = doctor;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

}
