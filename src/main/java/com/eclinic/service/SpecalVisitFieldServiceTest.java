package com.eclinic.service;

import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;

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
public class SpecalVisitFieldServiceTest {

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
	protected SpecalVisitFieldService service;

	/**
	 * Instantiates a new SpecalVisitFieldServiceTest.
	 *
	 */
	public SpecalVisitFieldServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@Test
	public void deleteSpecalVisitField() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecalVisitField 
		SpecalVisitField specalvisitfield = new com.eclinic.domain.SpecalVisitField();
		service.deleteSpecalVisitField(specalvisitfield);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Specialization entity
	 * 
	 */
	@Test
	public void deleteSpecalVisitFieldSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: deleteSpecalVisitFieldSpecialization 
		Integer specalvisitfield_id = 0;
		Integer related_specialization_id = 0;
		SpecalVisitField response = null;
		response = service.deleteSpecalVisitFieldSpecialization(specalvisitfield_id, related_specialization_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSpecalVisitFieldSpecialization
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSpecalVisitFieldByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSpecalVisitFieldByPrimaryKey 
		Integer id = 0;
		SpecalVisitField response = null;
		response = service.findSpecalVisitFieldByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findSpecalVisitFieldByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all SpecalVisitField entity
	 * 
	 */
	@Test
	public void countSpecalVisitFields() {
		Integer response = null;
		response = service.countSpecalVisitFields();
		// TODO: JUnit - Add assertions to test outputs of operation: countSpecalVisitFields
	}

	/**
	 * Operation Unit Test
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@Test
	public void saveSpecalVisitField() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecalVisitField 
		SpecalVisitField specalvisitfield_1 = new com.eclinic.domain.SpecalVisitField();
		service.saveSpecalVisitField(specalvisitfield_1);
	}

	/**
	 * Operation Unit Test
	 * Return all SpecalVisitField entity
	 * 
	 */
	@Test
	public void findAllSpecalVisitFields() {
		// TODO: JUnit - Populate test inputs for operation: findAllSpecalVisitFields 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<SpecalVisitField> response = null;
		response = service.findAllSpecalVisitFields(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSpecalVisitFields
	}

	/**
	 * Operation Unit Test
	 * Load an existing SpecalVisitField entity
	 * 
	 */
	@Test
	public void loadSpecalVisitFields() {
		Set<SpecalVisitField> response = null;
		response = service.loadSpecalVisitFields();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSpecalVisitFields
	}

	/**
	 * Operation Unit Test
	 * Save an existing Specialization entity
	 * 
	 */
	@Test
	public void saveSpecalVisitFieldSpecialization() {
		// TODO: JUnit - Populate test inputs for operation: saveSpecalVisitFieldSpecialization 
		Integer id_1 = 0;
		Specialization related_specialization = new com.eclinic.domain.Specialization();
		SpecalVisitField response = null;
		response = service.saveSpecalVisitFieldSpecialization(id_1, related_specialization);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSpecalVisitFieldSpecialization
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
