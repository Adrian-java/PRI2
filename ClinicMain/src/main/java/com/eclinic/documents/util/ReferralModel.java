package com.eclinic.documents.util;

import com.eclinic.model.IDocumentsModel;

public class ReferralModel implements IDocumentsModel {
	
	private String destination;
	private String recognition;
	private String purpose;
	private String patientId;
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String id){
		patientId = id;
	}

}
