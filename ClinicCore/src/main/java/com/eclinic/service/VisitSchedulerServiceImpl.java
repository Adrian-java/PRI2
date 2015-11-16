package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SevenDaysDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VisitScheduler entities
 * 
 */

@Service("VisitSchedulerService")
@Transactional
public class VisitSchedulerServiceImpl implements VisitSchedulerService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages SevenDays entities
	 * 
	 */
	@Autowired
	private SevenDaysDAO sevenDaysDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Instantiates a new VisitSchedulerServiceImpl.
	 *
	 */
	public VisitSchedulerServiceImpl() {
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public VisitScheduler deleteVisitSchedulerDoctor(Integer visitscheduler_id, Integer related_doctor_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		visitscheduler.setDoctor(null);
		related_doctor.getVisitSchedulers().remove(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return visitscheduler;
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public VisitScheduler deleteVisitSchedulerSpecialization(Integer visitscheduler_id, Integer related_specialization_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id, -1, -1);
		Specialization related_specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		visitscheduler.setSpecialization(null);
		related_specialization.getVisitSchedulers().remove(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		specializationDAO.remove(related_specialization);
		specializationDAO.flush();

		return visitscheduler;
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public VisitScheduler saveVisitSchedulerSpecialization(Integer id, Specialization related_specialization) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id, -1, -1);
		Specialization existingspecialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization.getId());

		// copy into the existing record to preserve existing relationships
		if (existingspecialization != null) {
			existingspecialization.setId(related_specialization.getId());
			existingspecialization.setName(related_specialization.getName());
			existingspecialization.setDescription(related_specialization.getDescription());
			related_specialization = existingspecialization;
		}

		visitscheduler.setSpecialization(related_specialization);
		related_specialization.getVisitSchedulers().add(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		return visitscheduler;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public VisitScheduler saveVisitSchedulerDoctor(Integer id, Doctor related_doctor) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		visitscheduler.setDoctor(related_doctor);
		related_doctor.getVisitSchedulers().add(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return visitscheduler;
	}

	/**
	 * Load an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Set<VisitScheduler> loadVisitSchedulers() {
		return visitSchedulerDAO.findAllVisitSchedulers();
	}

	/**
	 * Return a count of all VisitScheduler entity
	 * 
	 */
	@Transactional
	public Integer countVisitSchedulers() {
		return ((Long) visitSchedulerDAO.createQuerySingleResult("select count(o) from VisitScheduler o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing SevenDays entity
	 * 
	 */
	@Transactional
	public VisitScheduler deleteVisitSchedulerSevenDays(Integer visitscheduler_id, Integer related_sevendays_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id, -1, -1);
		SevenDays related_sevendays = sevenDaysDAO.findSevenDaysById(related_sevendays_id);

		visitscheduler.setSevenDays(null);
		related_sevendays.getVisitScheduler().remove(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_sevendays = sevenDaysDAO.store(related_sevendays);
		sevenDaysDAO.flush();

		sevenDaysDAO.remove(related_sevendays);
		sevenDaysDAO.flush();

		return visitscheduler;
	}

	/**
	 */
	@Transactional
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id) {
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id);
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public void saveVisitScheduler(VisitScheduler visitscheduler) {
		VisitScheduler existingVisitScheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());

		if (existingVisitScheduler != null) {
			if (existingVisitScheduler != visitscheduler) {
				existingVisitScheduler.setId(visitscheduler.getId());
				existingVisitScheduler.setNumberOfMonth(visitscheduler.getNumberOfMonth());
				existingVisitScheduler.setDescription(visitscheduler.getDescription());
				existingVisitScheduler.setTimeFrom(visitscheduler.getTimeFrom());
				existingVisitScheduler.setTimeTo(visitscheduler.getTimeTo());
				existingVisitScheduler.setDuration(visitscheduler.getDuration());
			}
			visitscheduler = visitSchedulerDAO.store(existingVisitScheduler);
		} else {
			visitscheduler = visitSchedulerDAO.store(visitscheduler);
		}
		visitSchedulerDAO.flush();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public void deleteVisitScheduler(VisitScheduler visitscheduler) {
		visitSchedulerDAO.remove(visitscheduler);
		visitSchedulerDAO.flush();
	}

	/**
	 * Return all VisitScheduler entity
	 * 
	 */
	@Transactional
	public List<VisitScheduler> findAllVisitSchedulers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<VisitScheduler>(visitSchedulerDAO.findAllVisitSchedulers(startResult, maxRows));
	}

	/**
	 * Save an existing SevenDays entity
	 * 
	 */
	@Transactional
	public VisitScheduler saveVisitSchedulerSevenDays(Integer id, SevenDays related_sevendays) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id, -1, -1);
		SevenDays existingsevenDays = sevenDaysDAO.findSevenDaysById(related_sevendays.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsevenDays != null) {
			existingsevenDays.setId(related_sevendays.getId());
			existingsevenDays.setMon(related_sevendays.getMon());
			existingsevenDays.setTue(related_sevendays.getTue());
			existingsevenDays.setWen(related_sevendays.getWen());
			existingsevenDays.setThu(related_sevendays.getThu());
			existingsevenDays.setFri(related_sevendays.getFri());
			existingsevenDays.setSat(related_sevendays.getSat());
			existingsevenDays.setSun(related_sevendays.getSun());
			related_sevendays = existingsevenDays;
		} else {
			related_sevendays = sevenDaysDAO.store(related_sevendays);
			sevenDaysDAO.flush();
		}

		visitscheduler.setSevenDays(related_sevendays);
		related_sevendays.getVisitScheduler().add(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_sevendays = sevenDaysDAO.store(related_sevendays);
		sevenDaysDAO.flush();

		return visitscheduler;
	}
}
