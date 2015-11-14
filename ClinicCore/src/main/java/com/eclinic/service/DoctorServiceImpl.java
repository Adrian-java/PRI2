package com.eclinic.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.Worker;

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
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Instantiates a new DoctorServiceImpl.
	 *
	 */
	public DoctorServiceImpl() {
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
	 * Return all Doctor entity
	 * 
	 */
	@Transactional
	public List<Doctor> findAllDoctors(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Doctor>(doctorDAO.findAllDoctors(startResult, maxRows));
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorSpecializations(Integer id, Specialization related_specializations) {
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
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorVisits(Integer id, Visit related_visits) {
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
	 * Delete an existing Graphic entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorGraphics(Integer doctor_id, Integer related_graphics_id) {
		Graphic related_graphics = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_graphics.setDoctor(null);
		doctor.getGraphics().remove(related_graphics);

		graphicDAO.remove(related_graphics);
		graphicDAO.flush();

		return doctor;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorVisits(Integer doctor_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_visits.setDoctor(null);
		doctor.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Integer saveDoctor(Doctor doctor) {
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
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorWorkers(Integer doctor_id, Integer related_workers_id) {
		Worker related_workers = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_workers.setDoctor(null);
		doctor.getWorkers().remove(related_workers);

		workerDAO.remove(related_workers);
		workerDAO.flush();

		return doctor;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorWorkers(Integer id, Worker related_workers) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Worker existingworkers = workerDAO.findWorkerByPrimaryKey(related_workers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworkers != null) {
			existingworkers.setId(related_workers.getId());
			related_workers = existingworkers;
		} else {
			related_workers = workerDAO.store(related_workers);
			workerDAO.flush();
		}

		related_workers.setDoctor(doctor);
		doctor.getWorkers().add(related_workers);
		related_workers = workerDAO.store(related_workers);
		workerDAO.flush();

		doctor = doctorDAO.store(doctor);
		doctorDAO.flush();

		return doctor;
	}


	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorVisitSchedulers(Integer id, VisitScheduler related_visitschedulers) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		VisitScheduler existingvisitSchedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisitSchedulers != null) {
			existingvisitSchedulers.setId(related_visitschedulers.getId());
//			existingvisitSchedulers.setNumberOfDay(related_visitschedulers.getNumberOfDay());
			existingvisitSchedulers.setNumberOfMonth(related_visitschedulers.getNumberOfMonth());
			existingvisitSchedulers.setDescription(related_visitschedulers.getDescription());
//			existingvisitSchedulers.setTimeOfVisit(related_visitschedulers.getTimeOfVisit());
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
	 * Return a count of all Doctor entity
	 * 
	 */
	@Transactional
	public Integer countDoctors() {
		return ((Long) doctorDAO.createQuerySingleResult("select count(o) from Doctor o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorSpecializations(Integer doctor_id, Integer related_specializations_id) {
		Specialization related_specializations = specializationDAO.findSpecializationByPrimaryKey(related_specializations_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_specializations.setDoctor(null);
		doctor.getSpecializations().remove(related_specializations);

		specializationDAO.remove(related_specializations);
		specializationDAO.flush();

		return doctor;
	}

	/**
	 */
	@Transactional
	public Doctor findDoctorByPrimaryKey(Integer id) {
		return doctorDAO.findDoctorByPrimaryKey(id);
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Doctor deleteDoctorVisitSchedulers(Integer doctor_id, Integer related_visitschedulers_id) {
		VisitScheduler related_visitschedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		related_visitschedulers.setDoctor(null);
		doctor.getVisitSchedulers().remove(related_visitschedulers);

		visitSchedulerDAO.remove(related_visitschedulers);
		visitSchedulerDAO.flush();

		return doctor;
	}



	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@Transactional
	public Doctor saveDoctorGraphics(Integer id, Graphic related_graphics) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(id, -1, -1);
		Graphic existinggraphics = graphicDAO.findGraphicByPrimaryKey(related_graphics.getId());

		// copy into the existing record to preserve existing relationships
		if (existinggraphics != null) {
			existinggraphics.setId(related_graphics.getId());
			existinggraphics.setAbsence(related_graphics.getAbsence());
//			existinggraphics.setDay(related_graphics.getDay());
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
	 * Load an existing Doctor entity
	 * 
	 */
	@Transactional
	public Set<Doctor> loadDoctors() {
		return doctorDAO.findAllDoctors();
	}
}
