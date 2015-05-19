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
 * Unit test for the <code>LoginHistoryRestController</code> controller.
 *
 * @see com.eclinic.web.rest.LoginHistoryRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class LoginHistoryRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>LoginHistoryloginhistory_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetLoginHistoryloginhistory_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostLoginHistoryloginhistory_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutLoginHistoryloginhistory_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_idworkerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteLoginHistoryloginhistory_idworkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}/worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_idworkerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetLoginHistoryloginhistory_idworkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}/worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetLoginHistoryloginhistory_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>LoginHistoryloginhistory_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteLoginHistoryloginhistory_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/LoginHistory/{loginhistory_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryRestController controller = (LoginHistoryRestController) context.getBean("LoginHistoryRestController");

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