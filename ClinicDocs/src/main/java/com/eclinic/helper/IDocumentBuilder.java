package com.eclinic.helper;

import com.eclinic.domain.Patient;
import com.eclinic.model.Certificate;
import com.eclinic.model.Prescription;
import com.eclinic.model.Referral;

public interface IDocumentBuilder {

	public Prescription createPrescription(Patient patient);
	
	public Certificate createCertificate(Patient patient);
	
	public Referral createReferaral(Patient patient);
}
