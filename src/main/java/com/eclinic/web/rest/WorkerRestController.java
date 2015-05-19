package com.eclinic.web.rest;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import com.eclinic.service.WorkerService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Worker entities
 * 
 */

@Controller("WorkerRestController")
public class WorkerRestController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

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
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Worker entities
	 * 
	 */
	@Autowired
	private WorkerService workerService;

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/loginHistories", method = RequestMethod.PUT)
	@ResponseBody
	public LoginHistory saveWorkerLoginHistories(@PathVariable Integer worker_id, @RequestBody LoginHistory loginhistories) {
		workerService.saveWorkerLoginHistories(worker_id, loginhistories);
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistories.getId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Get Admin entity by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/admin", method = RequestMethod.GET)
	@ResponseBody
	public Admin getWorkerAdmin(@PathVariable Integer worker_id) {
		return workerDAO.findWorkerByPrimaryKey(worker_id).getAdmin();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newWorkerDoctor(@PathVariable Integer worker_id, @RequestBody Doctor doctor) {
		workerService.saveWorkerDoctor(worker_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/patient", method = RequestMethod.PUT)
	@ResponseBody
	public Patient saveWorkerPatient(@PathVariable Integer worker_id, @RequestBody Patient patient) {
		workerService.saveWorkerPatient(worker_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Get Doctor entity by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getWorkerDoctor(@PathVariable Integer worker_id) {
		return workerDAO.findWorkerByPrimaryKey(worker_id).getDoctor();
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/systemUsers", method = RequestMethod.PUT)
	@ResponseBody
	public SystemUser saveWorkerSystemUsers(@PathVariable Integer worker_id, @RequestBody SystemUser systemusers) {
		workerService.saveWorkerSystemUsers(worker_id, systemusers);
		return systemUserDAO.findSystemUserByPrimaryKey(systemusers.getId());
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Worker", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveWorker(@RequestBody Worker worker) {
		workerService.saveWorker(worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/receptionist", method = RequestMethod.POST)
	@ResponseBody
	public Receptionist newWorkerReceptionist(@PathVariable Integer worker_id, @RequestBody Receptionist receptionist) {
		workerService.saveWorkerReceptionist(worker_id, receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/admin", method = RequestMethod.PUT)
	@ResponseBody
	public Admin saveWorkerAdmin(@PathVariable Integer worker_id, @RequestBody Admin admin) {
		workerService.saveWorkerAdmin(worker_id, admin);
		return adminDAO.findAdminByPrimaryKey(admin.getId());
	}

	/**
	 * Show all Worker entities
	 * 
	 */
	@RequestMapping(value = "/Worker", method = RequestMethod.GET)
	@ResponseBody
	public List<Worker> listWorkers() {
		return new java.util.ArrayList<Worker>(workerService.loadWorkers());
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/patient", method = RequestMethod.POST)
	@ResponseBody
	public Patient newWorkerPatient(@PathVariable Integer worker_id, @RequestBody Patient patient) {
		workerService.saveWorkerPatient(worker_id, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/patient/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerPatient(@PathVariable Integer worker_id, @PathVariable Integer related_patient_id) {
		workerService.deleteWorkerPatient(worker_id, related_patient_id);
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/receptionist", method = RequestMethod.PUT)
	@ResponseBody
	public Receptionist saveWorkerReceptionist(@PathVariable Integer worker_id, @RequestBody Receptionist receptionist) {
		workerService.saveWorkerReceptionist(worker_id, receptionist);
		return receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/systemUsers/{systemuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public SystemUser loadWorkerSystemUsers(@PathVariable Integer worker_id, @PathVariable Integer related_systemusers_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers_id, -1, -1);

		return systemuser;
	}

	/**
	 * Get Receptionist entity by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/receptionist", method = RequestMethod.GET)
	@ResponseBody
	public Receptionist getWorkerReceptionist(@PathVariable Integer worker_id) {
		return workerDAO.findWorkerByPrimaryKey(worker_id).getReceptionist();
	}

	/**
	 * Show all SystemUser entities by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/systemUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemUser> getWorkerSystemUsers(@PathVariable Integer worker_id) {
		return new java.util.ArrayList<SystemUser>(workerDAO.findWorkerByPrimaryKey(worker_id).getSystemUsers());
	}

	/**
	 * Create a new LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/loginHistories", method = RequestMethod.POST)
	@ResponseBody
	public LoginHistory newWorkerLoginHistories(@PathVariable Integer worker_id, @RequestBody LoginHistory loginhistory) {
		workerService.saveWorkerLoginHistories(worker_id, loginhistory);
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId());
	}

	/**
	 * Create a new Admin entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/admin", method = RequestMethod.POST)
	@ResponseBody
	public Admin newWorkerAdmin(@PathVariable Integer worker_id, @RequestBody Admin admin) {
		workerService.saveWorkerAdmin(worker_id, admin);
		return adminDAO.findAdminByPrimaryKey(admin.getId());
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/receptionist/{receptionist_id}", method = RequestMethod.GET)
	@ResponseBody
	public Receptionist loadWorkerReceptionist(@PathVariable Integer worker_id, @PathVariable Integer related_receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		return receptionist;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerDoctor(@PathVariable Integer worker_id, @PathVariable Integer related_doctor_id) {
		workerService.deleteWorkerDoctor(worker_id, related_doctor_id);
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/admin/{admin_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerAdmin(@PathVariable Integer worker_id, @PathVariable Integer related_admin_id) {
		workerService.deleteWorkerAdmin(worker_id, related_admin_id);
	}

	/**
	 * Show all LoginHistory entities by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/loginHistories", method = RequestMethod.GET)
	@ResponseBody
	public List<LoginHistory> getWorkerLoginHistories(@PathVariable Integer worker_id) {
		return new java.util.ArrayList<LoginHistory>(workerDAO.findWorkerByPrimaryKey(worker_id).getLoginHistories());
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadWorkerDoctor(@PathVariable Integer worker_id, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveWorkerDoctor(@PathVariable Integer worker_id, @RequestBody Doctor doctor) {
		workerService.saveWorkerDoctor(worker_id, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * View an existing Admin entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/admin/{admin_id}", method = RequestMethod.GET)
	@ResponseBody
	public Admin loadWorkerAdmin(@PathVariable Integer worker_id, @PathVariable Integer related_admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(related_admin_id, -1, -1);

		return admin;
	}

	/**
	 * Select an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadWorker(@PathVariable Integer worker_id) {
		return workerDAO.findWorkerByPrimaryKey(worker_id);
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/receptionist/{receptionist_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerReceptionist(@PathVariable Integer worker_id, @PathVariable Integer related_receptionist_id) {
		workerService.deleteWorkerReceptionist(worker_id, related_receptionist_id);
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/loginHistories/{loginhistory_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerLoginHistories(@PathVariable Integer worker_id, @PathVariable Integer related_loginhistories_id) {
		workerService.deleteWorkerLoginHistories(worker_id, related_loginhistories_id);
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping(value = "/Worker", method = RequestMethod.POST)
	@ResponseBody
	public Worker newWorker(@RequestBody Worker worker) {
		workerService.saveWorker(worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * View an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/loginHistories/{loginhistory_id}", method = RequestMethod.GET)
	@ResponseBody
	public LoginHistory loadWorkerLoginHistories(@PathVariable Integer worker_id, @PathVariable Integer related_loginhistories_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistories_id, -1, -1);

		return loginhistory;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/systemUsers/{systemuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkerSystemUsers(@PathVariable Integer worker_id, @PathVariable Integer related_systemusers_id) {
		workerService.deleteWorkerSystemUsers(worker_id, related_systemusers_id);
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/systemUsers", method = RequestMethod.POST)
	@ResponseBody
	public SystemUser newWorkerSystemUsers(@PathVariable Integer worker_id, @RequestBody SystemUser systemuser) {
		workerService.saveWorkerSystemUsers(worker_id, systemuser);
		return systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId());
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorker(@PathVariable Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id);
		workerService.deleteWorker(worker);
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/patient/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadWorkerPatient(@PathVariable Integer worker_id, @PathVariable Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return patient;
	}

	/**
	 * Get Patient entity by Worker
	 * 
	 */
	@RequestMapping(value = "/Worker/{worker_id}/patient", method = RequestMethod.GET)
	@ResponseBody
	public Patient getWorkerPatient(@PathVariable Integer worker_id) {
		return workerDAO.findWorkerByPrimaryKey(worker_id).getPatient();
	}
}