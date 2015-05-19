package com.eclinic.service;

import com.eclinic.domain.Admin;
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
public class AdminServiceTest {

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
	protected AdminService service;

	/**
	 * Instantiates a new AdminServiceTest.
	 *
	 */
	public AdminServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Admin entity
	 * 
	 */
	@Test
	public void saveAdmin() {
		// TODO: JUnit - Populate test inputs for operation: saveAdmin 
		Admin admin = new com.eclinic.domain.Admin();
		service.saveAdmin(admin);
	}

	/**
	 * Operation Unit Test
	 * Return all Admin entity
	 * 
	 */
	@Test
	public void findAllAdmins() {
		// TODO: JUnit - Populate test inputs for operation: findAllAdmins 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Admin> response = null;
		response = service.findAllAdmins(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllAdmins
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveAdminWorkers() {
		// TODO: JUnit - Populate test inputs for operation: saveAdminWorkers 
		Integer id = 0;
		Worker related_workers = new com.eclinic.domain.Worker();
		Admin response = null;
		response = service.saveAdminWorkers(id, related_workers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveAdminWorkers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Admin entity
	 * 
	 */
	@Test
	public void deleteAdmin() {
		// TODO: JUnit - Populate test inputs for operation: deleteAdmin 
		Admin admin_1 = new com.eclinic.domain.Admin();
		service.deleteAdmin(admin_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Admin entity
	 * 
	 */
	@Test
	public void countAdmins() {
		Integer response = null;
		response = service.countAdmins();
		// TODO: JUnit - Add assertions to test outputs of operation: countAdmins
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteAdminWorkers() {
		// TODO: JUnit - Populate test inputs for operation: deleteAdminWorkers 
		Integer admin_id = 0;
		Integer related_workers_id = 0;
		Admin response = null;
		response = service.deleteAdminWorkers(admin_id, related_workers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteAdminWorkers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findAdminByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findAdminByPrimaryKey 
		Integer id_1 = 0;
		Admin response = null;
		response = service.findAdminByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findAdminByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing Admin entity
	 * 
	 */
	@Test
	public void loadAdmins() {
		Set<Admin> response = null;
		response = service.loadAdmins();
		// TODO: JUnit - Add assertions to test outputs of operation: loadAdmins
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
