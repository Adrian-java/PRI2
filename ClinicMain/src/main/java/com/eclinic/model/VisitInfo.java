package com.eclinic.model;

import com.eclinic.domain.view.DoctorView;
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.VisitView;

public class VisitInfo {

	private DoctorView doctorView;
	
	private PatientView patientView;
	
	private VisitView visitView;

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
	
	
}
