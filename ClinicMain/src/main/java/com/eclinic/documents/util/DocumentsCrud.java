package com.eclinic.documents.util;

import java.util.Set;

import com.eclinic.domain.Certificate;
import com.eclinic.domain.Documents;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;

public interface DocumentsCrud {

	public void addDocument(DocumentsModel document);

	public void updateDocument(Documents document);

	public void addCertificate(CertificateModel certificate);

	public void addPrescription(PrescriptionModel prescription);

	public void addReferral(ReferralModel referral);

	public Set<Prescription> getPrescriptionByVisit(Integer id);

	public Set<Referral> getReferralByVisit(Integer id);

	public Set<Certificate> getCertificateByVisit(Integer id);

}
