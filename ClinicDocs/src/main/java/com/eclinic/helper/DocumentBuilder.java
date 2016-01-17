package com.eclinic.helper;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.CertificateDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.PrescriptionDAO;
import com.eclinic.dao.ReferralDAO;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Patient;
import com.eclinic.model.Certificate;
import com.eclinic.model.Clinic;
import com.eclinic.model.Prescription;
import com.eclinic.model.Referral;

@Component("DocumentBuilder")
public class DocumentBuilder implements IDocumentBuilder {

	@Autowired
	private PrescriptionDAO prescriptionDao;
	@Autowired
	private CertificateDAO certificateDao;
	@Autowired
	private ReferralDAO referralDao;
	@Autowired
	private DocumentsDAO documentsDAO;
	@Autowired
	private DocumentsMappingDAO documentsMappingDao;

	public Prescription createPrescription(Patient patient) {

		Documents findDocumentsByPatient = documentsDAO.findDocumentsByPatient(
				patient, -1, -1);
		Prescription prescription = new Prescription();

		prescription.setClinic(createClinic());
		prescription.setDepartment("02");
		prescription.setDoctor(findDocumentsByPatient.getDoctor());
		prescription.setExecutionDate(Calendar.getInstance().getTime());
		prescription.setIssuedDate(Calendar.getInstance().getTime());

		Set<DocumentsMapping> documentsMappings = findDocumentsByPatient
				.getDocumentsMappings();
		for (DocumentsMapping d : documentsMappings) {
			if (d.getPrescription() != null) {
				prescription.setRemedy(convertByteToString(d.getPrescription()
						.getRemedy()));
				break;
			}
		}
		prescription.setNumber(1000210321);
		prescription.setPatient(patient);
		prescription.setPermissions("brak");

		return prescription;
	}

	private String convertByteToString(byte[] b) {
		try {
			return new String(b, "UTF-8").toString();
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public Certificate createCertificate(Patient patient) {
		Certificate certificate = new Certificate();

		Documents findDocumentsByPatient = documentsDAO.findDocumentsByPatient(
				patient, -1, -1);
		Set<DocumentsMapping> documentsMappings = findDocumentsByPatient
				.getDocumentsMappings();
		for (DocumentsMapping d : documentsMappings) {
			if (d.getCertificate() != null) {
				certificate
						.setId(getIdNumber(d.getCertificate().getIdNumber()));
				certificate.setPurpose(convertByteToString(d.getCertificate()
						.getPurpose()));
				certificate.setRecognition(convertByteToString(d
						.getCertificate().getRecognition()));
				break;
			}
		}
		certificate.setClinic(createClinic());
		certificate.setDate(Calendar.getInstance().getTime());
		certificate.setPatient(patient);

		return certificate;
	}

	private long getIdNumber(String d) {
		try {
			return Long.valueOf(d);
		} catch (Exception e) {
			return 0;
		}
	}

	public Referral createReferaral(Patient patient) {
		Referral referral = new Referral();

		Documents findDocumentsByPatient = documentsDAO.findDocumentsByPatient(
				patient, -1, -1);
		Set<DocumentsMapping> documentsMappings = findDocumentsByPatient
				.getDocumentsMappings();
		for (DocumentsMapping d : documentsMappings) {
			if (d.getReferral() != null) {
				referral.setDestination(convertByteToString(d.getReferral()
						.getDestination()));
				referral.setPurpose(convertByteToString(d.getReferral()
						.getPurpose()));
				referral.setRecognition(convertByteToString(d.getReferral()
						.getRecognition()));
				break;
			}
		}
		referral.setClinic(createClinic());
		referral.setPatient(patient);
		referral.setDate(Calendar.getInstance().getTime());

		return referral;
	}

	// private Patient createPatient() {
	// Patient patient = new Patient();
	//
	// Address address = createAddress();
	//
	// patient.setName("Sebastian");
	// patient.setSurname("Cebula");
	// patient.setAddress(address);
	//
	// return patient;
	// }

	// private Address createAddress() {
	// Address address = new Address();
	// address.setCity("Warszawa");
	// address.setHomeNr("23");
	// address.setStreet("Wiejska");
	// address.setCountryCodeCity("00-912");
	// return address;
	// }

	// private Doctor createDoctor() {
	// Doctor doctor = new Doctor();
	//
	// doctor.setName("Janusz");
	// doctor.setSurname("Cebula");
	//
	// return doctor;
	// }

	private Clinic createClinic() {
		Clinic clinic = new Clinic();

		clinic.setCity("Poznan");
		clinic.setCode("61-142");
		clinic.setEmail("przychodnia@e-przychodnia.pl");
		clinic.setHouseNumber("22");
		clinic.setName("Przychodnia dobra nadzieja");
		clinic.setNip("1315515151");
		clinic.setPhone("2211323213");
		clinic.setRegon("243135115");
		clinic.setStreet("poznanska");

		return clinic;
	}
}
