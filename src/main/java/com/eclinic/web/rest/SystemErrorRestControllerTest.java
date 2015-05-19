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
 * Unit test for the <code>SystemErrorRestController</code> controller.
 *
 * @see com.eclinic.web.rest.SystemErrorRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SystemErrorRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>SystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorRestController controller = (SystemErrorRestController) context.getBean("SystemErrorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemErrorsystemerror_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemErrorsystemerror_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemError/{systemerror_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorRestController controller = (SystemErrorRestController) context.getBean("SystemErrorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorRestController controller = (SystemErrorRestController) context.getBean("SystemErrorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorRestController controller = (SystemErrorRestController) context.getBean("SystemErrorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemErrorsystemerror_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSystemErrorsystemerror_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemError/{systemerror_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorRestController controller = (SystemErrorRestController) context.getBean("SystemErrorRestController");

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