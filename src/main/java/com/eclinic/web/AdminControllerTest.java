package com.eclinic.web;

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
 * Unit test for the <code>AdminController</code> controller.
 *
 * @see com.eclinic.web.AdminController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class AdminControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAdminWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAdminWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAdminWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>adminControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetadminControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/adminController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AdminController controller = (AdminController) context.getBean("AdminController");

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