package com.eclinic.model;

import java.util.Calendar;

import com.eclinic.domain.Patient;

public class Prescription {

//	name, surname, address, pesel, age (<18)
	private Patient patient;
	
	private Clinic clinic;
	
	private String department;
	
	private Calendar issuedDate;
	
	private Calendar executionDate;
}