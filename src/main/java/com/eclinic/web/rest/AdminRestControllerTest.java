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
 * Unit test for the <code>AdminRestController</code> controller.
 *
 * @see com.eclinic.web.rest.AdminRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class AdminRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Adminadmin_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAdminadmin_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostAdminadmin_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutAdminadmin_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteAdminadmin_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAdminadmin_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Admin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAdminadmin_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Admin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Admin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Adminadmin_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteAdminadmin_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Admin/{admin_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminRestController controller = (AdminRestController) context.getBean("AdminRestController");

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