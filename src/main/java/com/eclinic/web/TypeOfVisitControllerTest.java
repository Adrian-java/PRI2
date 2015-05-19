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
 * Unit test for the <code>TypeOfVisitController</code> controller.
 *
 * @see com.eclinic.web.TypeOfVisitController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class TypeOfVisitControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTypeOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTypeOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTypeOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>typeofvisitControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettypeofvisitControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/typeofvisitController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TypeOfVisitController controller = (TypeOfVisitController) context.getBean("TypeOfVisitController");

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