package com.eclinic.documents.util;

import java.util.Date;

import com.eclinic.model.IDocumentsModel;

public class PrescriptionModel  implements IDocumentsModel{
	private String department;
	private Integer idClinic;
	private Date issuedDate;
	private Date executionDate;
	private String remady;
	private String patienId;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getIdClinic() {
		return idClinic;
	}
	public void setIdClinic(Integer idClinic) {
		this.idClinic = idClinic;
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
	public String getRemady() {
		return remady;
	}
	public void setRemady(String remady) {
		this.remady = remady;
	}
	public void setPatientId(String patienId) {
		this.patienId = patienId;
	}
	public String getPatientId() {
		// TODO Auto-generated method stub
		return patienId;
	}

}
