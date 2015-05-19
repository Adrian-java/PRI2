package com.eclinic.service;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
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
public class SystemUserServiceTest {

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
	protected SystemUserService service;

	/**
	 * Instantiates a new SystemUserServiceTest.
	 *
	 */
	public SystemUserServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveSystemUserWorker() {
		// TODO: JUnit - Populate test inputs for operation: saveSystemUserWorker 
		Integer id = 0;
		Worker related_worker = new com.eclinic.domain.Worker();
		SystemUser response = null;
		response = service.saveSystemUserWorker(id, related_worker);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSystemUserWorker
	}

	/**
	 * Operation Unit Test
	 * Save an existing Permission entity
	 * 
	 */
	@Test
	public void saveSystemUserPermissions() {
		// TODO: JUnit - Populate test inputs for operation: saveSystemUserPermissions 
		Integer id_1 = 0;
		Permission related_permissions = new com.eclinic.domain.Permission();
		SystemUser response = null;
		response = service.saveSystemUserPermissions(id_1, related_permissions);
		// TODO: JUnit - Add assertions to test outputs of operation: saveSystemUserPermissions
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Permission entity
	 * 
	 */
	@Test
	public void deleteSystemUserPermissions() {
		// TODO: JUnit - Populate test inputs for operation: deleteSystemUserPermissions 
		Integer systemuser_id = 0;
		Integer related_permissions_id = 0;
		SystemUser response = null;
		response = service.deleteSystemUserPermissions(systemuser_id, related_permissions_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSystemUserPermissions
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteSystemUserWorker() {
		// TODO: JUnit - Populate test inputs for operation: deleteSystemUserWorker 
		Integer systemuser_id_1 = 0;
		Integer related_worker_id = 0;
		SystemUser response = null;
		response = service.deleteSystemUserWorker(systemuser_id_1, related_worker_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteSystemUserWorker
	}

	/**
	 * Operation Unit Test
	 * Return a count of all SystemUser entity
	 * 
	 */
	@Test
	public void countSystemUsers() {
		Integer response = null;
		response = service.countSystemUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: countSystemUsers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSystemUserByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSystemUserByPrimaryKey 
		Integer id_2 = 0;
		SystemUser response = null;
		response = service.findSystemUserByPrimaryKey(id_2);
		// TODO: JUnit - Add assertions to test outputs of operation: findSystemUserByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing SystemUser entity
	 * 
	 */
	@Test
	public void saveSystemUser() {
		// TODO: JUnit - Populate test inputs for operation: saveSystemUser 
		SystemUser systemuser = new com.eclinic.domain.SystemUser();
		service.saveSystemUser(systemuser);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Test
	public void deleteSystemUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteSystemUser 
		SystemUser systemuser_1 = new com.eclinic.domain.SystemUser();
		service.deleteSystemUser(systemuser_1);
	}

	/**
	 * Operation Unit Test
	 * Load an existing SystemUser entity
	 * 
	 */
	@Test
	public void loadSystemUsers() {
		Set<SystemUser> response = null;
		response = service.loadSystemUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSystemUsers
	}

	/**
	 * Operation Unit Test
	 * Return all SystemUser entity
	 * 
	 */
	@Test
	public void findAllSystemUsers() {
		// TODO: JUnit - Populate test inputs for operation: findAllSystemUsers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<SystemUser> response = null;
		response = service.findAllSystemUsers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSystemUsers
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
