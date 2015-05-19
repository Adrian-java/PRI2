package com.eclinic.service;

import com.eclinic.domain.SystemError;

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
public class SystemErrorServiceTest {

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
	protected SystemErrorService service;

	/**
	 * Instantiates a new SystemErrorServiceTest.
	 *
	 */
	public SystemErrorServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSystemErrorByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSystemErrorByPrimaryKey 
		Integer id = 0;
		SystemError response = null;
		response = service.findSystemErrorByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findSystemErrorByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing SystemError entity
	 * 
	 */
	@Test
	public void saveSystemError() {
		// TODO: JUnit - Populate test inputs for operation: saveSystemError 
		SystemError systemerror = new com.eclinic.domain.SystemError();
		service.saveSystemError(systemerror);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SystemError entity
	 * 
	 */
	@Test
	public void deleteSystemError() {
		// TODO: JUnit - Populate test inputs for operation: deleteSystemError 
		SystemError systemerror_1 = new com.eclinic.domain.SystemError();
		service.deleteSystemError(systemerror_1);
	}

	/**
	 * Operation Unit Test
	 * Load an existing SystemError entity
	 * 
	 */
	@Test
	public void loadSystemErrors() {
		Set<SystemError> response = null;
		response = service.loadSystemErrors();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSystemErrors
	}

	/**
	 * Operation Unit Test
	 * Return all SystemError entity
	 * 
	 */
	@Test
	public void findAllSystemErrors() {
		// TODO: JUnit - Populate test inputs for operation: findAllSystemErrors 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<SystemError> response = null;
		response = service.findAllSystemErrors(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSystemErrors
	}

	/**
	 * Operation Unit Test
	 * Return a count of all SystemError entity
	 * 
	 */
	@Test
	public void countSystemErrors() {
		Integer response = null;
		response = service.countSystemErrors();
		// TODO: JUnit - Add assertions to test outputs of operation: countSystemErrors
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
