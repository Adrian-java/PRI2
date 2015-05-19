package com.eclinic.service;

import com.eclinic.domain.Doctor;
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
public class VisitSchedulerServiceTest {

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
	protected VisitSchedulerService service;

	/**
	 * Instantiates a new VisitSchedulerServiceTest.
	 *
	 */
	public VisitSchedulerServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveVisitSchedulerDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitSchedulerDoctor 
		Integer id = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		VisitScheduler response = null;
		response = service.saveVisitSchedulerDoctor(id, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitSchedulerDoctor
	}

	/**
	 * Operation Unit Test
	 * Return all VisitScheduler entity
	 * 
	 */
	@Test
	public void findAllVisitSchedulers() {
		// TODO: JUnit - Populate test inputs for operation: findAllVisitSchedulers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<VisitScheduler> response = null;
		response = service.findAllVisitSchedulers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Load an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void loadVisitSchedulers() {
		Set<VisitScheduler> response = null;
		response = service.loadVisitSchedulers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findVisitSchedulerByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findVisitSchedulerByPrimaryKey 
		Integer id_1 = 0;
		VisitScheduler response = null;
		response = service.findVisitSchedulerByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findVisitSchedulerByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Specialization entity
	 * 
	 */
	@Test
	public void saveVisitSchedulerSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitSchedulerSpecialization 
		Integer id_2 = 0;
		Specialization related_specialization = new com.eclinic.domain.Specialization();
		VisitScheduler response = null;
		response = service.saveVisitSchedulerSpecialization(id_2, related_specialization);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitSchedulerSpecialization
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteVisitSchedulerDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitSchedulerDoctor 
		Integer visitscheduler_id = 0;
		Integer related_doctor_id = 0;
		VisitScheduler response = null;
		response = service.deleteVisitSchedulerDoctor(visitscheduler_id, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitSchedulerDoctor
	}

	/**
	 * Operation Unit Test
	 * Return a count of all VisitScheduler entity
	 * 
	 */
	@Test
	public void countVisitSchedulers() {
		Integer response = null;
		response = service.countVisitSchedulers();
		// TODO: JUnit - Add assertions to test outputs of operation: countVisitSchedulers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void deleteVisitScheduler() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitScheduler 
		VisitScheduler visitscheduler = new com.eclinic.domain.VisitScheduler();
		service.deleteVisitScheduler(visitscheduler);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Specialization entity
	 * 
	 */
	@Test
	public void deleteVisitSchedulerSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitSchedulerSpecialization 
		Integer visitscheduler_id_1 = 0;
		Integer related_specialization_id = 0;
		VisitScheduler response = null;
		response = service.deleteVisitSchedulerSpecialization(visitscheduler_id_1, related_specialization_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitSchedulerSpecialization
	}

	/**
	 * Operation Unit Test
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Test
	public void saveVisitScheduler() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitScheduler 
		VisitScheduler visitscheduler_1 = new com.eclinic.domain.VisitScheduler();
		service.saveVisitScheduler(visitscheduler_1);
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
