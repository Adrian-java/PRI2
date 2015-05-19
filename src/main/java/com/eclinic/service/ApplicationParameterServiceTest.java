package com.eclinic.service;

import com.eclinic.domain.ApplicationParameter;

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
public class ApplicationParameterServiceTest {

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
	protected ApplicationParameterService service;

	/**
	 * Instantiates a new ApplicationParameterServiceTest.
	 *
	 */
	public ApplicationParameterServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findApplicationParameterByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findApplicationParameterByPrimaryKey 
		Integer id = 0;
		ApplicationParameter response = null;
		response = service.findApplicationParameterByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findApplicationParameterByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	@Test
	public void saveApplicationParameter() {
		// TODO: JUnit - Populate test inputs for operation: saveApplicationParameter 
		ApplicationParameter applicationparameter = new com.eclinic.domain.ApplicationParameter();
		service.saveApplicationParameter(applicationparameter);
	}

	/**
	 * Operation Unit Test
	 * Return all ApplicationParameter entity
	 * 
	 */
	@Test
	public void findAllApplicationParameters() {
		// TODO: JUnit - Populate test inputs for operation: findAllApplicationParameters 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<ApplicationParameter> response = null;
		response = service.findAllApplicationParameters(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllApplicationParameters
	}

	/**
	 * Operation Unit Test
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	@Test
	public void deleteApplicationParameter() {
		// TODO: JUnit - Populate test inputs for operation: deleteApplicationParameter 
		ApplicationParameter applicationparameter_1 = new com.eclinic.domain.ApplicationParameter();
		service.deleteApplicationParameter(applicationparameter_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all ApplicationParameter entity
	 * 
	 */
	@Test
	public void countApplicationParameters() {
		Integer response = null;
		response = service.countApplicationParameters();
		// TODO: JUnit - Add assertions to test outputs of operation: countApplicationParameters
	}

	/**
	 * Operation Unit Test
	 * Load an existing ApplicationParameter entity
	 * 
	 */
	@Test
	public void loadApplicationParameters() {
		Set<ApplicationParameter> response = null;
		response = service.loadApplicationParameters();
		// TODO: JUnit - Add assertions to test outputs of operation: loadApplicationParameters
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
