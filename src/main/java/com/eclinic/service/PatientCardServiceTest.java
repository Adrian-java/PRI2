package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;

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
public class PatientCardServiceTest {

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
	protected PatientCardService service;

	/**
	 * Instantiates a new PatientCardServiceTest.
	 *
	 */
	public PatientCardServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void savePatientCardPatient() {
		// TODO: JUnit - Populate test inputs for operation: savePatientCardPatient 
		Integer id = 0;
		Patient related_patient = new com.eclinic.domain.Patient();
		PatientCard response = null;
		response = service.savePatientCardPatient(id, related_patient);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientCardPatient
	}

	/**
	 * Operation Unit Test
	 * Return a count of all PatientCard entity
	 * 
	 */
	@Test
	public void countPatientCards() {
		Integer response = null;
		response = service.countPatientCards();
		// TODO: JUnit - Add assertions to test outputs of operation: countPatientCards
	}

	/**
	 * Operation Unit Test
	 * Return all PatientCard entity
	 * 
	 */
	@Test
	public void findAllPatientCards() {
		// TODO: JUnit - Populate test inputs for operation: findAllPatientCards 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<PatientCard> response = null;
		response = service.findAllPatientCards(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllPatientCards
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deletePatientCardPatient() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientCardPatient 
		Integer patientcard_id = 0;
		Integer related_patient_id = 0;
		PatientCard response = null;
		response = service.deletePatientCardPatient(patientcard_id, related_patient_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientCardPatient
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deletePatientCardDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientCardDoctor 
		Integer patientcard_id_1 = 0;
		Integer related_doctor_id = 0;
		PatientCard response = null;
		response = service.deletePatientCardDoctor(patientcard_id_1, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientCardDoctor
	}

	/**
	 * Operation Unit Test
	 * Load an existing PatientCard entity
	 * 
	 */
	@Test
	public void loadPatientCards() {
		Set<PatientCard> response = null;
		response = service.loadPatientCards();
		// TODO: JUnit - Add assertions to test outputs of operation: loadPatientCards
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Test
	public void deletePatientCard() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientCard 
		PatientCard patientcard = new com.eclinic.domain.PatientCard();
		service.deletePatientCard(patientcard);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void savePatientCardDoctor() {
		// TODO: JUnit - Populate test inputs for operation: savePatientCardDoctor 
		Integer id_1 = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		PatientCard response = null;
		response = service.savePatientCardDoctor(id_1, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientCardDoctor
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deletePatientCardVisits() {
		// TODO: JUnit - Populate test inputs for operation: deletePatientCardVisits 
		Integer patientcard_id_2 = 0;
		Integer related_visits_id = 0;
		PatientCard response = null;
		response = service.deletePatientCardVisits(patientcard_id_2, related_visits_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePatientCardVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void savePatientCardVisits() {
		// TODO: JUnit - Populate test inputs for operation: savePatientCardVisits 
		Integer id_2 = 0;
		Visit related_visits = new com.eclinic.domain.Visit();
		PatientCard response = null;
		response = service.savePatientCardVisits(id_2, related_visits);
		// TODO: JUnit - Add assertions to test outputs of operation: savePatientCardVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing PatientCard entity
	 * 
	 */
	@Test
	public void savePatientCard() {
		// TODO: JUnit - Populate test inputs for operation: savePatientCard 
		PatientCard patientcard_1 = new com.eclinic.domain.PatientCard();
		service.savePatientCard(patientcard_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findPatientCardByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findPatientCardByPrimaryKey 
		Integer id_3 = 0;
		PatientCard response = null;
		response = service.findPatientCardByPrimaryKey(id_3);
		// TODO: JUnit - Add assertions to test outputs of operation: findPatientCardByPrimaryKey
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
