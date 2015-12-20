package com.eclinic.model;

import java.util.Set;

import com.eclinic.documents.util.DocumentsModel;
import com.eclinic.domain.Certificate;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;
import com.eclinic.domain.view.DoctorView;
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.VisitView;

public class VisitInfo {

	private DoctorView doctorView;
	
	private PatientView patientView;
	
	private VisitView visitView;
	
	private Set<Referral> referral;
	
	private Set<Certificate> certificate;
	
	private Set<Prescription> prescription;
	
	private DocumentsModel documents;
	

	public DoctorView getDoctorView() {
		return doctorView;
	}

	public void setDoctorView(DoctorView doctorView) {
		this.doctorView = doctorView;
	}

	public PatientView getPatientView() {
		return patientView;
	}

	public void setPatientView(PatientView patientView) {
		this.patientView = patientView;
	}

	public VisitView getVisitView() {
		return visitView;
	}

	public void setVisitView(VisitView visitView) {
		this.visitView = visitView;
	}

	public DocumentsModel getDocuments() {
		return documents;
	}

	public void setDocuments(DocumentsModel documents) {
		this.documents = documents;
	}

	public Set<Referral> getReferral() {
		return referral;
	}

	public void setReferral(Set<Referral> referral) {
		this.referral = referral;
	}

	public Set<Certificate> getCertificate() {
		return certificate;
	}

	public void setCertificate(Set<Certificate> certificate) {
		this.certificate = certificate;
	}

	public Set<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(Set<Prescription> prescription) {
		this.prescription = prescription;
	}




}
