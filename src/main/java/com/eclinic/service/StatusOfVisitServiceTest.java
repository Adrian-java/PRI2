package com.eclinic.service;

import com.eclinic.domain.StatusOfVisit;
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
public class StatusOfVisitServiceTest {

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
	protected StatusOfVisitService service;

	/**
	 * Instantiates a new StatusOfVisitServiceTest.
	 *
	 */
	public StatusOfVisitServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@Test
	public void deleteStatusOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteStatusOfVisit 
		StatusOfVisit statusofvisit = new com.eclinic.domain.StatusOfVisit();
		service.deleteStatusOfVisit(statusofvisit);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteStatusOfVisitVisits() {
		// TODO: JUnit - Populate test inputs for operation: deleteStatusOfVisitVisits 
		Integer statusofvisit_id = 0;
		Integer related_visits_id = 0;
		StatusOfVisit response = null;
		response = service.deleteStatusOfVisitVisits(statusofvisit_id, related_visits_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteStatusOfVisitVisits
	}

	/**
	 * Operation Unit Test
	 * Return a count of all StatusOfVisit entity
	 * 
	 */
	@Test
	public void countStatusOfVisits() {
		Integer response = null;
		response = service.countStatusOfVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: countStatusOfVisits
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findStatusOfVisitByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findStatusOfVisitByPrimaryKey 
		Integer id = 0;
		StatusOfVisit response = null;
		response = service.findStatusOfVisitByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findStatusOfVisitByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all StatusOfVisit entity
	 * 
	 */
	@Test
	public void findAllStatusOfVisits() {
		// TODO: JUnit - Populate test inputs for operation: findAllStatusOfVisits 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<StatusOfVisit> response = null;
		response = service.findAllStatusOfVisits(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllStatusOfVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveStatusOfVisitVisits() {
		// TODO: JUnit - Populate test inputs for operation: saveStatusOfVisitVisits 
		Integer id_1 = 0;
		Visit related_visits = new com.eclinic.domain.Visit();
		StatusOfVisit response = null;
		response = service.saveStatusOfVisitVisits(id_1, related_visits);
		// TODO: JUnit - Add assertions to test outputs of operation: saveStatusOfVisitVisits
	}

	/**
	 * Operation Unit Test
	 * Load an existing StatusOfVisit entity
	 * 
	 */
	@Test
	public void loadStatusOfVisits() {
		Set<StatusOfVisit> response = null;
		response = service.loadStatusOfVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: loadStatusOfVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@Test
	public void saveStatusOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveStatusOfVisit 
		StatusOfVisit statusofvisit_1 = new com.eclinic.domain.StatusOfVisit();
		service.saveStatusOfVisit(statusofvisit_1);
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
