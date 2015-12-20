package com.eclinic.documents.util;

import com.eclinic.domain.Documents;

public interface DocumentsCrud {

	public void addDocumet(DocumentsModel document);

	public void updateDocument(Documents document);
	
	public void addCertificate(CertificateModel certificate);
	
	public void addPrescription(PrescriptionModel prescription);
	
	public void addReferral(ReferralModel referral);

}
