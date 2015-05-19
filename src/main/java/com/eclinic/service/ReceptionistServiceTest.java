package com.eclinic.service;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
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
public class ReceptionistServiceTest {

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
	protected ReceptionistService service;

	/**
	 * Instantiates a new ReceptionistServiceTest.
	 *
	 */
	public ReceptionistServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Receptionist entity
	 * 
	 */
	@Test
	public void loadReceptionists() {
		Set<Receptionist> response = null;
		response = service.loadReceptionists();
		// TODO: JUnit - Add assertions to test outputs of operation: loadReceptionists
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Test
	public void deleteReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: deleteReceptionist 
		Receptionist receptionist = new com.eclinic.domain.Receptionist();
		service.deleteReceptionist(receptionist);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveReceptionistVisits() {
		// TODO: JUnit - Populate test inputs for operation: saveReceptionistVisits 
		Integer id = 0;
		Visit related_visits = new com.eclinic.domain.Visit();
		Receptionist response = null;
		response = service.saveReceptionistVisits(id, related_visits);
		// TODO: JUnit - Add assertions to test outputs of operation: saveReceptionistVisits
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findReceptionistByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findReceptionistByPrimaryKey 
		Integer id_1 = 0;
		Receptionist response = null;
		response = service.findReceptionistByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findReceptionistByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveReceptionistWorkers() {
		// TODO: JUnit - Populate test inputs for operation: saveReceptionistWorkers 
		Integer id_2 = 0;
		Worker related_workers = new com.eclinic.domain.Worker();
		Receptionist response = null;
		response = service.saveReceptionistWorkers(id_2, related_workers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveReceptionistWorkers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteReceptionistVisits() {
		// TODO: JUnit - Populate test inputs for operation: deleteReceptionistVisits 
		Integer receptionist_id = 0;
		Integer related_visits_id = 0;
		Receptionist response = null;
		response = service.deleteReceptionistVisits(receptionist_id, related_visits_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteReceptionistVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing Receptionist entity
	 * 
	 */
	@Test
	public void saveReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: saveReceptionist 
		Receptionist receptionist_1 = new com.eclinic.domain.Receptionist();
		service.saveReceptionist(receptionist_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteReceptionistWorkers() {
		// TODO: JUnit - Populate test inputs for operation: deleteReceptionistWorkers 
		Integer receptionist_id_1 = 0;
		Integer related_workers_id = 0;
		Receptionist response = null;
		response = service.deleteReceptionistWorkers(receptionist_id_1, related_workers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteReceptionistWorkers
	}

	/**
	 * Operation Unit Test
	 * Return all Receptionist entity
	 * 
	 */
	@Test
	public void findAllReceptionists() {
		// TODO: JUnit - Populate test inputs for operation: findAllReceptionists 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Receptionist> response = null;
		response = service.findAllReceptionists(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllReceptionists
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Receptionist entity
	 * 
	 */
	@Test
	public void countReceptionists() {
		Integer response = null;
		response = service.countReceptionists();
		// TODO: JUnit - Add assertions to test outputs of operation: countReceptionists
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
