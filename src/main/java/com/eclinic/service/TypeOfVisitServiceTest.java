package com.eclinic.service;

import com.eclinic.domain.TypeOfVisit;
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
public class TypeOfVisitServiceTest {

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
	protected TypeOfVisitService service;

	/**
	 * Instantiates a new TypeOfVisitServiceTest.
	 *
	 */
	public TypeOfVisitServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@Test
	public void deleteTypeOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteTypeOfVisit 
		TypeOfVisit typeofvisit = new com.eclinic.domain.TypeOfVisit();
		service.deleteTypeOfVisit(typeofvisit);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findTypeOfVisitByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findTypeOfVisitByPrimaryKey 
		Integer id = 0;
		TypeOfVisit response = null;
		response = service.findTypeOfVisitByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findTypeOfVisitByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing TypeOfVisit entity
	 * 
	 */
	@Test
	public void loadTypeOfVisits() {
		Set<TypeOfVisit> response = null;
		response = service.loadTypeOfVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: loadTypeOfVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveTypeOfVisitVisits() {
		// TODO: JUnit - Populate test inputs for operation: saveTypeOfVisitVisits 
		Integer id_1 = 0;
		Visit related_visits = new com.eclinic.domain.Visit();
		TypeOfVisit response = null;
		response = service.saveTypeOfVisitVisits(id_1, related_visits);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTypeOfVisitVisits
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteTypeOfVisitVisits() {
		// TODO: JUnit - Populate test inputs for operation: deleteTypeOfVisitVisits 
		Integer typeofvisit_id = 0;
		Integer related_visits_id = 0;
		TypeOfVisit response = null;
		response = service.deleteTypeOfVisitVisits(typeofvisit_id, related_visits_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTypeOfVisitVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@Test
	public void saveTypeOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveTypeOfVisit 
		TypeOfVisit typeofvisit_1 = new com.eclinic.domain.TypeOfVisit();
		service.saveTypeOfVisit(typeofvisit_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all TypeOfVisit entity
	 * 
	 */
	@Test
	public void countTypeOfVisits() {
		Integer response = null;
		response = service.countTypeOfVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: countTypeOfVisits
	}

	/**
	 * Operation Unit Test
	 * Return all TypeOfVisit entity
	 * 
	 */
	@Test
	public void findAllTypeOfVisits() {
		// TODO: JUnit - Populate test inputs for operation: findAllTypeOfVisits 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<TypeOfVisit> response = null;
		response = service.findAllTypeOfVisits(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllTypeOfVisits
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
