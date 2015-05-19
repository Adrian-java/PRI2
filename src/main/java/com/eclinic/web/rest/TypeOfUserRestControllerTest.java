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
 * Unit test for the <code>TypeOfUserRestController</code> controller.
 *
 * @see com.eclinic.web.rest.TypeOfUserRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class TypeOfUserRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>TypeOfUsertypeofuser_idpermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfUsertypeofuser_idpermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}/permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_idpermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostTypeOfUsertypeofuser_idpermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}/permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_idpermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutTypeOfUsertypeofuser_idpermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}/permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_idpermissionpermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteTypeOfUsertypeofuser_idpermissionpermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}/permission/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_idpermissionpermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfUsertypeofuser_idpermissionpermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}/permission/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfUsertypeofuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostTypeOfUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfUsertypeofuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteTypeOfUsertypeofuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfUser/{typeofuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfUserRestController controller = (TypeOfUserRestController) context.getBean("TypeOfUserRestController");

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