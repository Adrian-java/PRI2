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
 * Unit test for the <code>StatusOfVisitController</code> controller.
 *
 * @see com.eclinic.web.StatusOfVisitController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class StatusOfVisitControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusOfVisitVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusOfVisitVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusOfVisitVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>statusofvisitControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetstatusofvisitControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/statusofvisitController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitController controller = (StatusOfVisitController) context.getBean("StatusOfVisitController");

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