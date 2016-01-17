package com.eclinic.documents.util;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Certificate;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;
import com.eclinic.domain.Visit;
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
	@Autowired
	private VisitDAO visitDao;
	private Visit findVisitById;

	public void addDocument(DocumentsModel document) {
		Documents d = new Documents();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		d.setDateOfDocuments(c);
		d.setDescription(document.getDescription().getBytes());
		Visit visit = visitDao.findVisitById(document.getVisitId());
		d.setDoctor(visit.getDoctor());
		d.setVisit(visit);
		d.setPatient(visit.getPatient());

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
		c.setIdNumber(findVisitById.getPatient().getId());
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
		p.setRemady(prescription.getRemady());
		p.setId(docMapping.getId());
		prescriptionDAO.store(p);
		prescriptionDAO.flush();
	}

	private DocumentsMapping getReatedMapping(IDocumentsModel docModel) {
		findVisitById = visitDao.findVisitById(docModel.getVisitId());
		Documents document = documentsDAO.findDocumentsByVisit(findVisitById);

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

	public Set<Prescription> getPrescriptionByVisit(Integer id) {
		Visit findVisitById = visitDao.findVisitById(id);
		List<Documents> documents = documentsDAO
				.findDocumentsByVisitNew(findVisitById);
		Set<Prescription> set = new HashSet<Prescription>();
		for (Documents d : documents) {
			Iterator<DocumentsMapping> mapp = d.getDocumentsMappings()
					.iterator();
			while (mapp.hasNext()) {
				DocumentsMapping next = mapp.next();
				if (next.getPrescription() != null) {
//					next.getPrescription().setClinic(null);
					set.add(next.getPrescription());
				}
			}
			if(!set.isEmpty()){
				break;
			}

		}
		
		return set;
	}

	public Set<Referral> getReferralByVisit(Integer id) {
		Visit findVisitById = visitDao.findVisitById(id);
		List<Documents> documents = documentsDAO
				.findDocumentsByVisitNew(findVisitById);
		Set<Referral> set = new HashSet<Referral>();
		for (Documents d : documents) {
			Iterator<DocumentsMapping> mapp = d.getDocumentsMappings()
					.iterator();
			while (mapp.hasNext()) {
				DocumentsMapping next = mapp.next();
				if (next.getReferral() != null) {
					set.add(next.getReferral());
				}
			}
			if(!set.isEmpty()){
				break;
			}

		}
		
		return set;
	}

	public Set<Certificate> getCertificateByVisit(Integer id) {
		Visit findVisitById = visitDao.findVisitById(id);
		List<Documents> documents = documentsDAO
				.findDocumentsByVisitNew(findVisitById);
		Set<Certificate> set = new HashSet<Certificate>();
		for (Documents d : documents) {
			Iterator<DocumentsMapping> mapp = d.getDocumentsMappings()
					.iterator();
			while (mapp.hasNext()) {
				DocumentsMapping next = mapp.next();
				if (next.getCertificate() != null) {
					set.add(next.getCertificate());
				}
			}
			if(!set.isEmpty()){
				break;
			}

		}
		
		return set;
	}

	public boolean isDocumentByVisit(Integer visitId) {
		Visit findVisitById2 = visitDao.findVisitById(visitId);
		 List<Documents> findDocumentsByVisitNew = documentsDAO.findDocumentsByVisitNew(findVisitById2);
		 if(findDocumentsByVisitNew==null || findDocumentsByVisitNew.isEmpty())
			 return false; else return true;
				 
	}

}
