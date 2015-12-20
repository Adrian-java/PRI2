package com.eclinic.documents.util;

import com.eclinic.model.IDocumentsModel;

public class ReferralModel implements IDocumentsModel {
	
	private String destination;
	private String recognition;
	private String purpose;
	private Integer visitId;
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
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer id){
		visitId = id;
	}

}
