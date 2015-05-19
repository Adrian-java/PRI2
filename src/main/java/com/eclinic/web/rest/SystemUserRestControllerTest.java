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
 * Unit test for the <code>SystemUserRestController</code> controller.
 *
 * @see com.eclinic.web.rest.SystemUserRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SystemUserRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>SystemUsersystemuser_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUsersystemuser_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSystemUsersystemuser_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idworker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSystemUsersystemuser_idworker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idworkerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSystemUsersystemuser_idworkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idworkerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUsersystemuser_idworkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUsersystemuser_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSystemUsersystemuser_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSystemUsersystemuser_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idpermissionspermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSystemUsersystemuser_idpermissionspermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/permissions/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_idpermissionspermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUsersystemuser_idpermissionspermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}/permissions/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSystemUsersystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SystemUsersystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSystemUsersystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SystemUser/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserRestController controller = (SystemUserRestController) context.getBean("SystemUserRestController");

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