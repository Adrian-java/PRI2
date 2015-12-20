package com.eclinic.documents.util;

import java.util.Date;

public class DocumentsModel {
	
	private String description;
	private String idPatient;
	private String idDoctor;
	private Date date;
	private Integer visitId;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}
	public String getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getIdVisit() {
		return visitId;
	}
	public void setIdVisit(Integer idVisit) {
		this.visitId = idVisit;
	}
		

}
