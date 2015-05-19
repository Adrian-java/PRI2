package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
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
public class SickLeaveServiceTest {

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
	protected SickLeaveService service;

	/**
	 * Instantiates a new SickLeaveServiceTest.
	 *
	 */
	public SickLeaveServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteSickLeaveDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteSickLeaveDoctor 
		Integer sickleave_id = 0;
		Integer related_doctor_id = 0;
		SickLeave response = null;
		response = service.deleteSickLeaveDoctor(sickleave_id, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSickLeaveDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveSickLeaveDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveSickLeaveDoctor 
		Integer id = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		SickLeave response = null;
		response = service.saveSickLeaveDoctor(id, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSickLeaveDoctor
	}

	/**
	 * Operation Unit Test
	 * Load an existing SickLeave entity
	 * 
	 */
	@Test
	public void loadSickLeaves() {
		Set<SickLeave> response = null;
		response = service.loadSickLeaves();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSickLeaves
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSickLeaveByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSickLeaveByPrimaryKey 
		Integer id_1 = 0;
		SickLeave response = null;
		response = service.findSickLeaveByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findSickLeaveByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deleteSickLeavePatient() {
		// TODO: JUnit - Populate test inputs for operation: deleteSickLeavePatient 
		Integer sickleave_id_1 = 0;
		Integer related_patient_id = 0;
		SickLeave response = null;
		response = service.deleteSickLeavePatient(sickleave_id_1, related_patient_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSickLeavePatient
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteSickLeaveVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteSickLeaveVisit 
		Integer sickleave_id_2 = 0;
		Integer related_visit_id = 0;
		SickLeave response = null;
		response = service.deleteSickLeaveVisit(sickleave_id_2, related_visit_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSickLeaveVisit
	}

	/**
	 * Operation Unit Test
	 * Return a count of all SickLeave entity
	 * 
	 */
	@Test
	public void countSickLeaves() {
		Integer response = null;
		response = service.countSickLeaves();
		// TODO: JUnit - Add assertions to test outputs of operation: countSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveSickLeaveVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveSickLeaveVisit 
		Integer id_2 = 0;
		Visit related_visit = new com.eclinic.domain.Visit();
		SickLeave response = null;
		response = service.saveSickLeaveVisit(id_2, related_visit);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSickLeaveVisit
	}

	/**
	 * Operation Unit Test
	 * Save an existing SickLeave entity
	 * 
	 */
	@Test
	public void saveSickLeave() {
		// TODO: JUnit - Populate test inputs for operation: saveSickLeave 
		SickLeave sickleave = new com.eclinic.domain.SickLeave();
		service.saveSickLeave(sickleave);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Test
	public void deleteSickLeave() {
		// TODO: JUnit - Populate test inputs for operation: deleteSickLeave 
		SickLeave sickleave_1 = new com.eclinic.domain.SickLeave();
		service.deleteSickLeave(sickleave_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void saveSickLeavePatient() {
		// TODO: JUnit - Populate test inputs for operation: saveSickLeavePatient 
		Integer id_3 = 0;
		Patient related_patient = new com.eclinic.domain.Patient();
		SickLeave response = null;
		response = service.saveSickLeavePatient(id_3, related_patient);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSickLeavePatient
	}

	/**
	 * Operation Unit Test
	 * Return all SickLeave entity
	 * 
	 */
	@Test
	public void findAllSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: findAllSickLeaves 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<SickLeave> response = null;
		response = service.findAllSickLeaves(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSickLeaves
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
