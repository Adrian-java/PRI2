package com.eclinic.documents.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.dao.CertificateDAO;
import com.eclinic.dao.ClinicDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.PrescriptionDAO;
import com.eclinic.dao.ReferralDAO;
import com.eclinic.domain.Certificate;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;
import com.eclinic.model.IDocumentsModel;
import com.eclinic.service.SessionBean;

@Component("DocumentsCrud")
@Transactional
public class DocumentsCrudImpl implements DocumentsCrud {

	@Autowired
	private DocumentsDAO documentsDAO;
	@Autowired
	private SessionBean sessionBean;
	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private DocumentsMappingDAO documentsMappingDao;
	@Autowired
	private DoctorDAO doctorDao;
	@Autowired
	private ClinicDAO clinicDao;
	@Autowired
	private CertificateDAO certificateDAO;
	@Autowired
	private PrescriptionDAO prescriptionDAO;
	@Autowired
	private ReferralDAO referralDAO;

	public void addDocument(DocumentsModel document) {
		Documents d = new Documents();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		d.setDateOfDocuments(c);
		// d.setDoctor(doctorDao.findDoctorById(document.getIdDoctor()));
		d.setDoctor(sessionBean.getLoggedSystemUser().getDoctor());
		d.setDescription(document.getDescription().getBytes());
		Patient p = patientDao.findPatientById(document.getIdPatient());
		d.setPatient(p);

		Documents merge = documentsDAO.merge(d);
		documentsDAO.flush();
		d.setId(merge.getId());
		DocumentsMapping dm = new DocumentsMapping();
		dm.setDocuments(d);
		documentsMappingDao.store(dm);
		documentsMappingDao.flush();
	}

	public void updateDocument(Documents document) {
		documentsDAO.merge(document);
	}

	public void addCertificate(CertificateModel certificate) {
		DocumentsMapping docMapping = getReatedMapping(certificate);

		Certificate c = new Certificate();
		c.setIdNumber(certificate.getPatientId());
		c.setPurpose(certificate.getPurpose().getBytes());
		c.setRecognition(certificate.getRecognition().getBytes());
		c.setId(docMapping.getId());

		certificateDAO.merge(c);
		certificateDAO.flush();

	}

	@Transactional
	public void addPrescription(PrescriptionModel prescription) {
		DocumentsMapping docMapping = getReatedMapping(prescription);

		Prescription p = new Prescription();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(prescription.getExecutionDate());
		p.setDepartment(prescription.getDepartment());
		p.setClinic(clinicDao.findClinicById(1));
		p.setIssuedDate(c);
		p.setExecutionDate(cal);
		if (!prescription.getRemady().contains(";")) {
			prescription.setRemady(prescription.getRemady() + ";100%");
		}
		p.setRemady(prescription.getRemady().getBytes());
		p.setId(docMapping.getId());
		prescriptionDAO.store(p);
		prescriptionDAO.flush();
	}

	private DocumentsMapping getReatedMapping(IDocumentsModel docModel) {
		Patient findPatientById = patientDao.findPatientById(docModel
				.getPatientId());
		Documents document = documentsDAO.findDocumentsByPatient(
				findPatientById, -1, -1);

		DocumentsMapping docMapping = new DocumentsMapping();

		docMapping.setDocuments(document);

		DocumentsMapping storeMapping = documentsMappingDao.store(docMapping);
		documentsMappingDao.flush();
		docMapping.setId(storeMapping.getId());
		return docMapping;
	}

	public void addReferral(ReferralModel referral) {
		DocumentsMapping docMapping = getReatedMapping(referral);

		Referral r = new Referral();
		r.setDestination(referral.getDestination().getBytes());
		r.setPurpose(referral.getPurpose().getBytes());
		r.setRecognition(referral.getRecognition().getBytes());
		r.setId(docMapping.getId());

		referralDAO.merge(r);
		referralDAO.flush();

	}

}
