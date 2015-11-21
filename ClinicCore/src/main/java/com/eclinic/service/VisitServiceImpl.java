package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Visit entities
 * 
 */

@Service("VisitService")
@Transactional
public class VisitServiceImpl implements VisitService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new VisitServiceImpl.
	 *
	 */
	public VisitServiceImpl() {
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Visit saveVisitReceptionist(Integer id, Receptionist related_receptionist) {
		Visit visit = visitDAO.findVisitByPrimaryKey(id, -1, -1);
		Receptionist existingreceptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist.getId());

		// copy into the existing record to preserve existing relationships
		if (existingreceptionist != null) {
			existingreceptionist.setId(related_receptionist.getId());
			existingreceptionist.setName(related_receptionist.getName());
			existingreceptionist.setSurname(related_receptionist.getSurname());
			existingreceptionist.setPhoneNr(related_receptionist.getPhoneNr());
			existingreceptionist.setAccess(related_receptionist.getAccess());
			related_receptionist = existingreceptionist;
		}

		visit.setReceptionist(related_receptionist);
		related_receptionist.getVisits().add(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_receptionist = receptionistDAO.store(related_receptionist);
		receptionistDAO.flush();

		return visit;
	}

	/**
	 * Return all Visit entity
	 * 
	 */
	@Transactional
	public List<Visit> findAllVisits(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Visit>(visitDAO.findAllVisits(startResult, maxRows));
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@Transactional
	public Visit saveVisitTypeOfVisit(Integer id, TypeOfVisit related_typeofvisit) {
		Visit visit = visitDAO.findVisitByPrimaryKey(id, -1, -1);
		TypeOfVisit existingtypeOfVisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit.getId());

		// copy into the existing record to preserve existing relationships
		if (existingtypeOfVisit != null) {
			existingtypeOfVisit.setId(related_typeofvisit.getId());
			existingtypeOfVisit.setName(related_typeofvisit.getName());
			existingtypeOfVisit.setDescription(related_typeofvisit.getDescription());
			existingtypeOfVisit.setDuration(related_typeofvisit.getDuration());
			related_typeofvisit = existingtypeOfVisit;
		}

		visit.setTypeOfVisit(related_typeofvisit);
		related_typeofvisit.getVisits().add(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_typeofvisit = typeOfVisitDAO.store(related_typeofvisit);
		typeOfVisitDAO.flush();

		return visit;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Visit deleteVisitDoctor(Integer visit_id, String related_doctor_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		visit.setDoctor(null);
		related_doctor.getVisits().remove(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return visit;
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@Transactional
	public Visit saveVisitStatusOfVisit(Integer id, StatusOfVisit related_statusofvisit) {
		Visit visit = visitDAO.findVisitByPrimaryKey(id, -1, -1);
		StatusOfVisit existingstatusOfVisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit.getId());

		// copy into the existing record to preserve existing relationships
		if (existingstatusOfVisit != null) {
			existingstatusOfVisit.setId(related_statusofvisit.getId());
			existingstatusOfVisit.setType(related_statusofvisit.getType());
			related_statusofvisit = existingstatusOfVisit;
		}

		visit.setStatusOfVisit(related_statusofvisit);
		related_statusofvisit.getVisits().add(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_statusofvisit = statusOfVisitDAO.store(related_statusofvisit);
		statusOfVisitDAO.flush();

		return visit;
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Visit deleteVisitReceptionist(Integer visit_id, String related_receptionist_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);
		Receptionist related_receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		visit.setReceptionist(null);
		related_receptionist.getVisits().remove(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_receptionist = receptionistDAO.store(related_receptionist);
		receptionistDAO.flush();

		receptionistDAO.remove(related_receptionist);
		receptionistDAO.flush();

		return visit;
	}

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@Transactional
	public Visit deleteVisitTypeOfVisit(Integer visit_id, Integer related_typeofvisit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);
		TypeOfVisit related_typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit_id, -1, -1);

		visit.setTypeOfVisit(null);
		related_typeofvisit.getVisits().remove(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_typeofvisit = typeOfVisitDAO.store(related_typeofvisit);
		typeOfVisitDAO.flush();

		typeOfVisitDAO.remove(related_typeofvisit);
		typeOfVisitDAO.flush();

		return visit;
	}

	/**
	 * Load an existing Visit entity
	 * 
	 */
	@Transactional
	public Set<Visit> loadVisits() {
		return visitDAO.findAllVisits();
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@Transactional
	public Visit deleteVisitStatusOfVisit(Integer visit_id, Integer related_statusofvisit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);
		StatusOfVisit related_statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit_id, -1, -1);

		visit.setStatusOfVisit(null);
		related_statusofvisit.getVisits().remove(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_statusofvisit = statusOfVisitDAO.store(related_statusofvisit);
		statusOfVisitDAO.flush();

		statusOfVisitDAO.remove(related_statusofvisit);
		statusOfVisitDAO.flush();

		return visit;
	}

	/**
	 */
	@Transactional
	public Visit findVisitByPrimaryKey(Integer id) {
		return visitDAO.findVisitByPrimaryKey(id);
	}

	/**
	 * Return a count of all Visit entity
	 * 
	 */
	@Transactional
	public Integer countVisits() {
		return ((Long) visitDAO.createQuerySingleResult("select count(o) from Visit o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Visit saveVisitDoctor(Integer id, Doctor related_doctor) {
		Visit visit = visitDAO.findVisitByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		visit.setDoctor(related_doctor);
		related_doctor.getVisits().add(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return visit;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public void deleteVisit(Visit visit) {
		visitDAO.remove(visit);
		visitDAO.flush();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public Visit deleteVisitPatient(Integer visit_id, String related_patient_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		visit.setPatient(null);
		related_patient.getVisits().remove(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return visit;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Visit saveVisitPatient(Integer id, Patient related_patient) {
		Visit visit = visitDAO.findVisitByPrimaryKey(id, -1, -1);
		Patient existingpatient = patientDAO.findPatientByPrimaryKey(related_patient.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatient != null) {
			existingpatient.setId(related_patient.getId());
			existingpatient.setName(related_patient.getName());
			existingpatient.setSurname(related_patient.getSurname());
			existingpatient.setDateOfBirth(related_patient.getDateOfBirth());
			existingpatient.setPhoneNr(related_patient.getPhoneNr());
			existingpatient.setConfirmed(related_patient.getConfirmed());
			related_patient = existingpatient;
		}

		visit.setPatient(related_patient);
		related_patient.getVisits().add(visit);
		visit = visitDAO.store(visit);
		visitDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return visit;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Integer saveVisit(Visit visit) {
		Visit existingVisit = visitDAO.findVisitByPrimaryKey(visit.getId());

		if (existingVisit != null) {
			if (existingVisit != visit) {
				existingVisit.setId(visit.getId());
				existingVisit.setDateOfVisit(visit.getDateOfVisit());
				existingVisit.setDescriptionOfVisit(visit.getDescriptionOfVisit());
				existingVisit.setIsLeave(visit.getIsLeave());
				existingVisit.setSpecial(visit.getSpecial());
			}
			visit = visitDAO.store(existingVisit);
		} else {
			visit = visitDAO.store(visit);
		}
		visitDAO.flush();
		return visit.getId();
	}
}
