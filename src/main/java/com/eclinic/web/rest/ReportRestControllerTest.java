package com.eclinic.web.rest;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>ReportRestController</code> controller.
 *
 * @see com.eclinic.web.rest.ReportRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ReportRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Report()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Report");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReportRestController controller = (ReportRestController) context.getBean("ReportRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reportreport_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReportreport_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Report/{report_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReportRestController controller = (ReportRestController) context.getBean("ReportRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Report()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Report");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReportRestController controller = (ReportRestController) context.getBean("ReportRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Report()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Report");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReportRestController controller = (ReportRestController) context.getBean("ReportRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reportreport_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReportreport_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Report/{report_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReportRestController controller = (ReportRestController) context.getBean("ReportRestController");

		// TODO Invoke method and Assert return values

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
	 * Returns a mock HttpServletRequest object.
	 *
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}