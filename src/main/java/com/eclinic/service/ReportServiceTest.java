package com.eclinic.service;

import com.eclinic.domain.Report;

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
public class ReportServiceTest {

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
	protected ReportService service;

	/**
	 * Instantiates a new ReportServiceTest.
	 *
	 */
	public ReportServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Report entity
	 * 
	 */
	@Test
	public void saveReport() {
		// TODO: JUnit - Populate test inputs for operation: saveReport 
		Report report = new com.eclinic.domain.Report();
		service.saveReport(report);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Report entity
	 * 
	 */
	@Test
	public void countReports() {
		Integer response = null;
		response = service.countReports();
		// TODO: JUnit - Add assertions to test outputs of operation: countReports
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Report entity
	 * 
	 */
	@Test
	public void deleteReport() {
		// TODO: JUnit - Populate test inputs for operation: deleteReport 
		Report report_1 = new com.eclinic.domain.Report();
		service.deleteReport(report_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findReportByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findReportByPrimaryKey 
		Integer id = 0;
		Report response = null;
		response = service.findReportByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findReportByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all Report entity
	 * 
	 */
	@Test
	public void findAllReports() {
		// TODO: JUnit - Populate test inputs for operation: findAllReports 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Report> response = null;
		response = service.findAllReports(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllReports
	}

	/**
	 * Operation Unit Test
	 * Load an existing Report entity
	 * 
	 */
	@Test
	public void loadReports() {
		Set<Report> response = null;
		response = service.loadReports();
		// TODO: JUnit - Add assertions to test outputs of operation: loadReports
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
