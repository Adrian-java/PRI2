package com.eclinic.documents.util;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.CertificateDAO;
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
import com.eclinic.service.SessionBean;
import com.eclinic.dao.ClinicDAO;

@Component("DocumentsCrud")
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
	
	public void addDocumet(DocumentsModel document) {
		Documents d = new Documents();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		d.setDateOfDocuments(c);
		d.setDoctor(doctorDao.findDoctorById(document.getIdDoctor()));
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
		Certificate c = new Certificate();
		c.setIdNumber(certificate.getIdNumber());
		c.setPurpose(certificate.getPurpose().getBytes());
		c.setRecognition(certificate.getRecognition().getBytes());
		
		Certificate merge = certificateDAO.merge(c);
		certificateDAO.flush();
		c.setId(merge.getId());
		//DocumentsMapping dm = new DocumentsMapping();
		//dm.setDocuments(c);
		//documentsMappingDao.store(dm);
		//documentsMappingDao.flush();
		
	}

	public void addPrescription(PrescriptionModel prescription) {
		Prescription p = new Prescription();	
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(prescription.getExecutionDate());
		p.setDepartment(prescription.getDepartment());
		p.setClinic(clinicDao.findClinicById(prescription.getIdClinic()));
		p.setIssuedDate(c);
		p.setExecutionDate(cal);
		p.setRemady(prescription.getRemady().getBytes());
		
		Prescription merge = prescriptionDAO.merge(p);
		prescriptionDAO.flush();
		p.setId(merge.getId());
	}

	public void addReferral(ReferralModel referral) {
		Referral r = new Referral();
		r.setDestination(referral.getDestination().getBytes());
		r.setPurpose(referral.getPurpose().getBytes());
		r.setRecognition(referral.getRecognition().getBytes());
		
		Referral merge = referralDAO.merge(r);
		referralDAO.flush();
		r.setId(merge.getId());
		
	}
	
	

}
