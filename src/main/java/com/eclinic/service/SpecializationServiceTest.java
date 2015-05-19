package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

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
public class SpecializationServiceTest {

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
	protected SpecializationService service;

	/**
	 * Instantiates a new SpecializationServiceTest.
	 *
	 */
	public SpecializationServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@Test
	public void deleteSpecializationSpecalVisitFields() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecializationSpecalVisitFields 
		Integer specialization_id = 0;
		Integer related_specalvisitfields_id = 0;
		Specialization response = null;
		response = service.deleteSpecializationSpecalVisitFields(specialization_id, related_specalvisitfields_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSpecializationSpecalVisitFields
	}

	/**
	 * Operation Unit Test
	 * Save an existing Specialization entity
	 * 
	 */
	@Test
	public void saveSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecialization 
		Specialization specialization = new com.eclinic.domain.Specialization();
		service.saveSpecialization(specialization);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSpecializationByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSpecializationByPrimaryKey 
		Integer id = 0;
		Specialization response = null;
		response = service.findSpecializationByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findSpecializationByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all Specialization entity
	 * 
	 */
	@Test
	public void findAllSpecializations() {
		// TODO: JUnit - Populate test inputs for operation: findAllSpecializations 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Specialization> response = null;
		response = service.findAllSpecializations(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSpecializations
	}

	/**
	 * Operation Unit Test
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void saveSpecializationVisitSchedulers() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecializationVisitSchedulers 
		Integer id_1 = 0;
		VisitScheduler related_visitschedulers = new com.eclinic.domain.VisitScheduler();
		Specialization response = null;
		response = service.saveSpecializationVisitSchedulers(id_1, related_visitschedulers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSpecializationVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Load an existing Specialization entity
	 * 
	 */
	@Test
	public void loadSpecializations() {
		Set<Specialization> response = null;
		response = service.loadSpecializations();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSpecializations
	}

	/**
	 * Operation Unit Test
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void deleteSpecializationVisitSchedulers() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecializationVisitSchedulers 
		Integer specialization_id_1 = 0;
		Integer related_visitschedulers_id = 0;
		Specialization response = null;
		response = service.deleteSpecializationVisitSchedulers(specialization_id_1, related_visitschedulers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSpecializationVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteSpecializationDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecializationDoctor 
		Integer specialization_id_2 = 0;
		Integer related_doctor_id = 0;
		Specialization response = null;
		response = service.deleteSpecializationDoctor(specialization_id_2, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSpecializationDoctor
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Specialization entity
	 * 
	 */
	@Test
	public void deleteSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecialization 
		Specialization specialization_1 = new com.eclinic.domain.Specialization();
		service.deleteSpecialization(specialization_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Specialization entity
	 * 
	 */
	@Test
	public void countSpecializations() {
		Integer response = null;
		response = service.countSpecializations();
		// TODO: JUnit - Add assertions to test outputs of operation: countSpecializations
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveSpecializationDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecializationDoctor 
		Integer id_2 = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		Specialization response = null;
		response = service.saveSpecializationDoctor(id_2, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSpecializationDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@Test
	public void saveSpecializationSpecalVisitFields() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecializationSpecalVisitFields 
		Integer id_3 = 0;
		SpecalVisitField related_specalvisitfields = new com.eclinic.domain.SpecalVisitField();
		Specialization response = null;
		response = service.saveSpecializationSpecalVisitFields(id_3, related_specalvisitfields);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSpecializationSpecalVisitFields
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
