package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.GraphicDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Documents;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Doctor entities
 * 
 */

@Service("DoctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Documents entities
	 * 
	 */
	@Autowired
	private DocumentsDAO documentsDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Instantiates a new DoctorServiceImpl.
	 *
	 */
	public DoctorServiceImpl() {
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorSpecializations(String doctor_id, Integer related_specializations_id) {
		Specialization related_specializations = specializationDAO.findSpecializationByPrimaryKey(related_specializations_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_specializations.setDoctor(null);
		doctor.getSpecializations().remove(related_specializations);

		specializationDAO.remove(related_specializations);
		specializationDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorGraphics(String doctor_id, Integer related_graphics_id) {
		Graphic related_graphics = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_graphics.setDoctor(null);
		doctor.getGraphics().remove(related_graphics);

		graphicDAO.remove(related_graphics);
		graphicDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public String saveDoctor(Doctor doctor) {
		Doctor existingDoctor = doctorDAO.findDoctorByPrimaryKey(doctor.getId());

		if (existingDoctor != null) {
			if (existingDoctor != doctor) {
				existingDoctor.setId(doctor.getId());
				existingDoctor.setName(doctor.getName());
				existingDoctor.setSurname(doctor.getSurname());
			}
			doctor = doctorDAO.store(existingDoctor);
		} else {
			doctor = doctorDAO.store(doctor);
		}
		doctorDAO.flush();
		return doctor.getId();
	}

	/**
	 * Return all Doctor entity
	 * 
	 */
	@Transactional
	public List<Doctor> findAllDoctors(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Doctor>(doctorDAO.findAllDoctors(startResult, maxRows));
	}

	/**
	 * Load an existing Doctor entity
	 * 
	 */
	@Transactional
	public Set<Doctor> loadDoctors() {
		return doctorDAO.findAllDoctors();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorVisits(String id, Visit related_visits) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Visit existingvisits = visitDAO.findVisitByPrimaryKey(related_visits.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisits != null) {
			existingvisits.setId(related_visits.getId());
			existingvisits.setDateOfVisit(related_visits.getDateOfVisit());
			existingvisits.setDescriptionOfVisit(related_visits.getDescriptionOfVisit());
			existingvisits.setIsLeave(related_visits.getIsLeave());
			existingvisits.setSpecial(related_visits.getSpecial());
			related_visits = existingvisits;
		}

		related_visits.setDoctor(doctor);
		doctor.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorVisitSchedulers(String doctor_id, Integer related_visitschedulers_id) {
		VisitScheduler related_visitschedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_visitschedulers.setDoctor(null);
		doctor.getVisitSchedulers().remove(related_visitschedulers);

		visitSchedulerDAO.remove(related_visitschedulers);
		visitSchedulerDAO.flush();

		return doctor;
	}

	/**
	 */
	@Transactional
	public Doctor findDoctorByPrimaryKey(String id) {
		return doctorDAO.findDoctorByPrimaryKey(id);
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public void deleteDoctor(Doctor doctor) {
		doctorDAO.remove(doctor);
		doctorDAO.flush();
	}

	/**
	 * Save an existing Documents entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorDocumentses(String id, Documents related_documentses) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Documents existingdocumentses = documentsDAO.findDocumentsByPrimaryKey(related_documentses.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentses != null) {
			existingdocumentses.setId(related_documentses.getId());
			existingdocumentses.setDateOfDocuments(related_documentses.getDateOfDocuments());
			existingdocumentses.setDescription(related_documentses.getDescription());
			existingdocumentses.setTypeOfDocuments(related_documentses.getTypeOfDocuments());
			existingdocumentses.setDataOfDocuments(related_documentses.getDataOfDocuments());
			related_documentses = existingdocumentses;
		}

		related_documentses.setDoctor(doctor);
		doctor.getDocumentses().add(related_documentses);
		related_documentses = documentsDAO.store(related_documentses);
		documentsDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorVisitSchedulers(String id, VisitScheduler related_visitschedulers) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		VisitScheduler existingvisitSchedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisitSchedulers != null) {
			existingvisitSchedulers.setId(related_visitschedulers.getId());
			existingvisitSchedulers.setNumberOfMonth(related_visitschedulers.getNumberOfMonth());
			existingvisitSchedulers.setDescription(related_visitschedulers.getDescription());
			existingvisitSchedulers.setTimeFrom(related_visitschedulers.getTimeFrom());
			existingvisitSchedulers.setTimeTo(related_visitschedulers.getTimeTo());
			existingvisitSchedulers.setDuration(related_visitschedulers.getDuration());
			related_visitschedulers = existingvisitSchedulers;
		}

		related_visitschedulers.setDoctor(doctor);
		doctor.getVisitSchedulers().add(related_visitschedulers);
		related_visitschedulers = visitSchedulerDAO.store(related_visitschedulers);
		visitSchedulerDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorVisits(String doctor_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_visits.setDoctor(null);
		doctor.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorGraphics(String id, Graphic related_graphics) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Graphic existinggraphics = graphicDAO.findGraphicByPrimaryKey(related_graphics.getId());

		// copy into the existing record to preserve existing relationships
		if (existinggraphics != null) {
			existinggraphics.setId(related_graphics.getId());
			existinggraphics.setAbsence(related_graphics.getAbsence());
			existinggraphics.setTimeFrom(related_graphics.getTimeFrom());
			existinggraphics.setTimeTo(related_graphics.getTimeTo());
			related_graphics = existinggraphics;
		}

		related_graphics.setDoctor(doctor);
		doctor.getGraphics().add(related_graphics);
		related_graphics = graphicDAO.store(related_graphics);
		graphicDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorSystemUser(String doctor_id, String related_systemuser_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		doctor.setSystemUser(null);
		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorDocumentses(String doctor_id, Integer related_documentses_id) {
		Documents related_documentses = documentsDAO.findDocumentsByPrimaryKey(related_documentses_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_documentses.setDoctor(null);
		doctor.getDocumentses().remove(related_documentses);

		documentsDAO.remove(related_documentses);
		documentsDAO.flush();

		return doctor;
	}

	/**
	 * Return a count of all Doctor entity
	 * 
	 */
	@Transactional
	public Integer countDoctors() {
		return ((Long) doctorDAO.createQuerySingleResult("select count(o) from Doctor o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorSpecializations(String id, Specialization related_specializations) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Specialization existingspecializations = specializationDAO.findSpecializationByPrimaryKey(related_specializations.getId());

		// copy into the existing record to preserve existing relationships
		if (existingspecializations != null) {
			existingspecializations.setId(related_specializations.getId());
			existingspecializations.setName(related_specializations.getName());
			existingspecializations.setDescription(related_specializations.getDescription());
			related_specializations = existingspecializations;
		}

		related_specializations.setDoctor(doctor);
		doctor.getSpecializations().add(related_specializations);
		related_specializations = specializationDAO.store(related_specializations);
		specializationDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorSystemUser(String id, SystemUser related_systemuser) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			existingsystemUser.setRole(related_systemuser.getRole());
			related_systemuser = existingsystemUser;
		} else {
			related_systemuser = systemUserDAO.store(related_systemuser);
			systemUserDAO.flush();
		}

		doctor.setSystemUser(related_systemuser);
		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return doctor;
	}

}
