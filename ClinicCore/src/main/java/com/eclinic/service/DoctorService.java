package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Documents;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Doctor entities
 * 
 */
public interface DoctorService {

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public Doctor deleteDoctorSpecializations(Integer doctor_id, Integer related_specializations_id);

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	public Doctor deleteDoctorGraphics(Integer doctor_id_1, Integer related_graphics_id);

	/**
	 * Save an existing Doctor entity
	 * @return 
	 * 
	 */
	public Integer saveDoctor(Doctor doctor);

	/**
	 * Return all Doctor entity
	 * 
	 */
	public List<Doctor> findAllDoctors(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Doctor entity
	 * 
	 */
	public Set<Doctor> loadDoctors();

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Doctor saveDoctorVisits(Integer id, Visit related_visits);

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public Doctor deleteDoctorVisitSchedulers(Integer doctor_id_2, Integer related_visitschedulers_id);

	/**
	 */
	public Doctor findDoctorByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public void deleteDoctor(Doctor doctor_1);

	/**
	 * Save an existing Documents entity
	 * 
	 */
	public Doctor saveDoctorDocumentses(Integer id_2, Documents related_documentses);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public Doctor saveDoctorVisitSchedulers(Integer id_3, VisitScheduler related_visitschedulers);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public Doctor deleteDoctorVisits(Integer doctor_id_3, Integer related_visits_id);

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	public Doctor saveDoctorGraphics(Integer id_4, Graphic related_graphics);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Doctor deleteDoctorSystemUser(Integer doctor_id_4, Integer related_systemuser_id);

	/**
	 * Delete an existing Documents entity
	 * 
	 */
	public Doctor deleteDoctorDocumentses(Integer doctor_id_5, Integer related_documentses_id);

	/**
	 * Return a count of all Doctor entity
	 * 
	 */
	public Integer countDoctors();

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public Doctor saveDoctorSpecializations(Integer id_5, Specialization related_specializations);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Doctor saveDoctorSystemUser(Integer id_6, SystemUser related_systemuser);
}