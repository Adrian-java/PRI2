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
 * Unit test for the <code>TypeOfUserController</code> controller.
 *
 * @see com.eclinic.web.TypeOfUserController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class TypeOfUserControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTypeOfUserPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTypeOfUserPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTypeOfUserPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>typeofuserControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettypeofuserControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/typeofuserController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserController controller = (TypeOfUserController) context.getBean("TypeOfUserController");

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