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
 * Unit test for the <code>TypeOfVisitRestController</code> controller.
 *
 * @see com.eclinic.web.rest.TypeOfVisitRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class TypeOfVisitRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>TypeOfVisittypeofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfVisittypeofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostTypeOfVisittypeofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutTypeOfVisittypeofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteTypeOfVisittypeofvisit_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfVisittypeofvisit_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetTypeOfVisittypeofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>TypeOfVisittypeofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteTypeOfVisittypeofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/TypeOfVisit/{typeofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitRestController controller = (TypeOfVisitRestController) context.getBean("TypeOfVisitRestController");

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