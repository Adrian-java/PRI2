package com.eclinic.service;

import com.eclinic.domain.LoginHistory;
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
public class LoginHistoryServiceTest {

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
	protected LoginHistoryService service;

	/**
	 * Instantiates a new LoginHistoryServiceTest.
	 *
	 */
	public LoginHistoryServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing LoginHistory entity
	 * 
	 */
	@Test
	public void loadLoginHistorys() {
		Set<LoginHistory> response = null;
		response = service.loadLoginHistorys();
		// TODO: JUnit - Add assertions to test outputs of operation: loadLoginHistorys
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteLoginHistoryWorker() {
		// TODO: JUnit - Populate test inputs for operation: deleteLoginHistoryWorker 
		Integer loginhistory_id = 0;
		Integer related_worker_id = 0;
		LoginHistory response = null;
		response = service.deleteLoginHistoryWorker(loginhistory_id, related_worker_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteLoginHistoryWorker
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveLoginHistoryWorker() {
		// TODO: JUnit - Populate test inputs for operation: saveLoginHistoryWorker 
		Integer id = 0;
		Worker related_worker = new com.eclinic.domain.Worker();
		LoginHistory response = null;
		response = service.saveLoginHistoryWorker(id, related_worker);
		// TODO: JUnit - Add assertions to test outputs of operation: saveLoginHistoryWorker
	}

	/**
	 * Operation Unit Test
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Test
	public void deleteLoginHistory() {
		// TODO: JUnit - Populate test inputs for operation: deleteLoginHistory 
		LoginHistory loginhistory = new com.eclinic.domain.LoginHistory();
		service.deleteLoginHistory(loginhistory);
	}

	/**
	 * Operation Unit Test
	 * Save an existing LoginHistory entity
	 * 
	 */
	@Test
	public void saveLoginHistory() {
		// TODO: JUnit - Populate test inputs for operation: saveLoginHistory 
		LoginHistory loginhistory_1 = new com.eclinic.domain.LoginHistory();
		service.saveLoginHistory(loginhistory_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all LoginHistory entity
	 * 
	 */
	@Test
	public void countLoginHistorys() {
		Integer response = null;
		response = service.countLoginHistorys();
		// TODO: JUnit - Add assertions to test outputs of operation: countLoginHistorys
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findLoginHistoryByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findLoginHistoryByPrimaryKey 
		Integer id_1 = 0;
		LoginHistory response = null;
		response = service.findLoginHistoryByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findLoginHistoryByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all LoginHistory entity
	 * 
	 */
	@Test
	public void findAllLoginHistorys() {
		// TODO: JUnit - Populate test inputs for operation: findAllLoginHistorys 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<LoginHistory> response = null;
		response = service.findAllLoginHistorys(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllLoginHistorys
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
