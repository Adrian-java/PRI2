package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
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
public class PatientServiceTest {

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
	protected PatientService service;

	/**
	 * Instantiates a new PatientServiceTest.
	 *
	 */
	public PatientServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deletePatientWorkers() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientWorkers 
		Integer patient_id = 0;
		Integer related_workers_id = 0;
		Patient response = null;
		response = service.deletePatientWorkers(patient_id, related_workers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientWorkers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Address entity
	 * 
	 */
	@Test
	public void deletePatientAddress() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientAddress 
		Integer patient_id_1 = 0;
		Integer related_address_id = 0;
		Patient response = null;
		response = service.deletePatientAddress(patient_id_1, related_address_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientAddress
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deletePatient() {
		// TODO: JUnit - Populate test inputs for operation: deletePatient 
		Patient patient = new com.eclinic.domain.Patient();
		service.deletePatient(patient);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void savePatientWorkers() {
		// TODO: JUnit - Populate test inputs for operation: savePatientWorkers 
		Integer id = 0;
		Worker related_workers = new com.eclinic.domain.Worker();
		Patient response = null;
		response = service.savePatientWorkers(id, related_workers);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientWorkers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findPatientByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findPatientByPrimaryKey 
		Integer id_1 = 0;
		Patient response = null;
		response = service.findPatientByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findPatientByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Recipe entity
	 * 
	 */
	@Test
	public void deletePatientRecipes() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientRecipes 
		Integer patient_id_2 = 0;
		Integer related_recipes_idr = 0;
		Patient response = null;
		response = service.deletePatientRecipes(patient_id_2, related_recipes_idr);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientRecipes
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Patient entity
	 * 
	 */
	@Test
	public void countPatients() {
		Integer response = null;
		response = service.countPatients();
		// TODO: JUnit - Add assertions to test outputs of operation: countPatients
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void savePatient() {
		// TODO: JUnit - Populate test inputs for operation: savePatient 
		Patient patient_1 = new com.eclinic.domain.Patient();
		service.savePatient(patient_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing SickLeave entity
	 * 
	 */
	@Test
	public void savePatientSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: savePatientSickLeaves 
		Integer id_2 = 0;
		SickLeave related_sickleaves = new com.eclinic.domain.SickLeave();
		Patient response = null;
		response = service.savePatientSickLeaves(id_2, related_sickleaves);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Load an existing Patient entity
	 * 
	 */
	@Test
	public void loadPatients() {
		Set<Patient> response = null;
		response = service.loadPatients();
		// TODO: JUnit - Add assertions to test outputs of operation: loadPatients
	}

	/**
	 * Operation Unit Test
	 * Save an existing Address entity
	 * 
	 */
	@Test
	public void savePatientAddress() {
		// TODO: JUnit - Populate test inputs for operation: savePatientAddress 
		Integer id_3 = 0;
		Address related_address = new com.eclinic.domain.Address();
		Patient response = null;
		response = service.savePatientAddress(id_3, related_address);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientAddress
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Test
	public void deletePatientPatientCards() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientPatientCards 
		Integer patient_id_3 = 0;
		Integer related_patientcards_id = 0;
		Patient response = null;
		response = service.deletePatientPatientCards(patient_id_3, related_patientcards_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientPatientCards
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Test
	public void deletePatientSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientSickLeaves 
		Integer patient_id_4 = 0;
		Integer related_sickleaves_id = 0;
		Patient response = null;
		response = service.deletePatientSickLeaves(patient_id_4, related_sickleaves_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Save an existing PatientCard entity
	 * 
	 */
	@Test
	public void savePatientPatientCards() {
		// TODO: JUnit - Populate test inputs for operation: savePatientPatientCards 
		Integer id_4 = 0;
		PatientCard related_patientcards = new com.eclinic.domain.PatientCard();
		Patient response = null;
		response = service.savePatientPatientCards(id_4, related_patientcards);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientPatientCards
	}

	/**
	 * Operation Unit Test
	 * Save an existing Recipe entity
	 * 
	 */
	@Test
	public void savePatientRecipes() {
		// TODO: JUnit - Populate test inputs for operation: savePatientRecipes 
		Integer id_5 = 0;
		Recipe related_recipes = new com.eclinic.domain.Recipe();
		Patient response = null;
		response = service.savePatientRecipes(id_5, related_recipes);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientRecipes
	}

	/**
	 * Operation Unit Test
	 * Return all Patient entity
	 * 
	 */
	@Test
	public void findAllPatients() {
		// TODO: JUnit - Populate test inputs for operation: findAllPatients 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Patient> response = null;
		response = service.findAllPatients(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllPatients
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
