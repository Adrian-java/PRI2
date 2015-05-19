package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
@Transactional
public class DoctorServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected DoctorService service;

	/**
	 * Instantiates a new DoctorServiceTest.
	 *
	 */
	public DoctorServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctor 
		Doctor doctor = new com.eclinic.domain.Doctor();
		service.deleteDoctor(doctor);
	}

	/**
	 * Operation Unit Test
	 * Return all Doctor entity
	 * 
	 */
	@Test
	public void findAllDoctors() {
		// TODO: JUnit - Populate test inputs for operation: findAllDoctors 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Doctor> response = null;
		response = service.findAllDoctors(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllDoctors
	}

	/**
	 * Operation Unit Test
	 * Save an existing Specialization entity
	 * 
	 */
	@Test
	public void saveDoctorSpecializations() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorSpecializations 
		Integer id = 0;
		Specialization related_specializations = new com.eclinic.domain.Specialization();
		Doctor response = null;
		response = service.saveDoctorSpecializations(id, related_specializations);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorSpecializations
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveDoctorVisits() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorVisits 
		Integer id_1 = 0;
		Visit related_visits = new com.eclinic.domain.Visit();
		Doctor response = null;
		response = service.saveDoctorVisits(id_1, related_visits);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorVisits
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Graphic entity
	 * 
	 */
	@Test
	public void deleteDoctorGraphics() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorGraphics 
		Integer doctor_id = 0;
		Integer related_graphics_id = 0;
		Doctor response = null;
		response = service.deleteDoctorGraphics(doctor_id, related_graphics_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorGraphics
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteDoctorVisits() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorVisits 
		Integer doctor_id_1 = 0;
		Integer related_visits_id = 0;
		Doctor response = null;
		response = service.deleteDoctorVisits(doctor_id_1, related_visits_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctor 
		Doctor doctor_1 = new com.eclinic.domain.Doctor();
		service.saveDoctor(doctor_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Recipe entity
	 * 
	 */
	@Test
	public void deleteDoctorRecipes() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorRecipes 
		Integer doctor_id_2 = 0;
		Integer related_recipes_idr = 0;
		Doctor response = null;
		response = service.deleteDoctorRecipes(doctor_id_2, related_recipes_idr);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorRecipes
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteDoctorWorkers() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorWorkers 
		Integer doctor_id_3 = 0;
		Integer related_workers_id = 0;
		Doctor response = null;
		response = service.deleteDoctorWorkers(doctor_id_3, related_workers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorWorkers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveDoctorWorkers() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorWorkers 
		Integer id_2 = 0;
		Worker related_workers = new com.eclinic.domain.Worker();
		Doctor response = null;
		response = service.saveDoctorWorkers(id_2, related_workers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorWorkers
	}

	/**
	 * Operation Unit Test
	 * Save an existing SickLeave entity
	 * 
	 */
	@Test
	public void saveDoctorSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorSickLeaves 
		Integer id_3 = 0;
		SickLeave related_sickleaves = new com.eclinic.domain.SickLeave();
		Doctor response = null;
		response = service.saveDoctorSickLeaves(id_3, related_sickleaves);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void saveDoctorVisitSchedulers() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorVisitSchedulers 
		Integer id_4 = 0;
		VisitScheduler related_visitschedulers = new com.eclinic.domain.VisitScheduler();
		Doctor response = null;
		response = service.saveDoctorVisitSchedulers(id_4, related_visitschedulers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Recipe entity
	 * 
	 */
	@Test
	public void saveDoctorRecipes() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorRecipes 
		Integer id_5 = 0;
		Recipe related_recipes = new com.eclinic.domain.Recipe();
		Doctor response = null;
		response = service.saveDoctorRecipes(id_5, related_recipes);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorRecipes
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Doctor entity
	 * 
	 */
	@Test
	public void countDoctors() {
		Integer response = null;
		response = service.countDoctors();
		// TODO: JUnit - Add assertions to test outputs of operation: countDoctors
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Specialization entity
	 * 
	 */
	@Test
	public void deleteDoctorSpecializations() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorSpecializations 
		Integer doctor_id_4 = 0;
		Integer related_specializations_id = 0;
		Doctor response = null;
		response = service.deleteDoctorSpecializations(doctor_id_4, related_specializations_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorSpecializations
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findDoctorByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findDoctorByPrimaryKey 
		Integer id_6 = 0;
		Doctor response = null;
		response = service.findDoctorByPrimaryKey(id_6);
		// TODO: JUnit - Add assertions to test outputs of operation: findDoctorByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void deleteDoctorVisitSchedulers() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorVisitSchedulers 
		Integer doctor_id_5 = 0;
		Integer related_visitschedulers_id = 0;
		Doctor response = null;
		response = service.deleteDoctorVisitSchedulers(doctor_id_5, related_visitschedulers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Test
	public void deleteDoctorSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorSickLeaves 
		Integer doctor_id_6 = 0;
		Integer related_sickleaves_id = 0;
		Doctor response = null;
		response = service.deleteDoctorSickLeaves(doctor_id_6, related_sickleaves_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Test
	public void deleteDoctorPatientCards() {
		// TODO: JUnit - Populate test inputs for operation: deleteDoctorPatientCards 
		Integer doctor_id_7 = 0;
		Integer related_patientcards_id = 0;
		Doctor response = null;
		response = service.deleteDoctorPatientCards(doctor_id_7, related_patientcards_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteDoctorPatientCards
	}

	/**
	 * Operation Unit Test
	 * Save an existing Graphic entity
	 * 
	 */
	@Test
	public void saveDoctorGraphics() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorGraphics 
		Integer id_7 = 0;
		Graphic related_graphics = new com.eclinic.domain.Graphic();
		Doctor response = null;
		response = service.saveDoctorGraphics(id_7, related_graphics);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorGraphics
	}

	/**
	 * Operation Unit Test
	 * Save an existing PatientCard entity
	 * 
	 */
	@Test
	public void saveDoctorPatientCards() {
		// TODO: JUnit - Populate test inputs for operation: saveDoctorPatientCards 
		Integer id_8 = 0;
		PatientCard related_patientcards = new com.eclinic.domain.PatientCard();
		Doctor response = null;
		response = service.saveDoctorPatientCards(id_8, related_patientcards);
		// TODO: JUnit - Add assertions to test outputs of operation: saveDoctorPatientCards
	}

	/**
	 * Operation Unit Test
	 * Load an existing Doctor entity
	 * 
	 */
	@Test
	public void loadDoctors() {
		Set<Doctor> response = null;
		response = service.loadDoctors();
		// TODO: JUnit - Add assertions to test outputs of operation: loadDoctors
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
