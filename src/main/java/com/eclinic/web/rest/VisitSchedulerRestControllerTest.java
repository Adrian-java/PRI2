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
 * Unit test for the <code>VisitSchedulerRestController</code> controller.
 *
 * @see com.eclinic.web.rest.VisitSchedulerRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class VisitSchedulerRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>VisitSchedulervisitscheduler_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitSchedulervisitscheduler_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitSchedulervisitscheduler_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitSchedulervisitscheduler_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_idspecializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitSchedulervisitscheduler_idspecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_idspecializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitSchedulervisitscheduler_idspecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitSchedulervisitscheduler_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitSchedulervisitscheduler_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitSchedulervisitscheduler_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitSchedulervisitscheduler_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitSchedulervisitscheduler_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitSchedulervisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>VisitSchedulervisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitSchedulervisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/VisitScheduler/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerRestController controller = (VisitSchedulerRestController) context.getBean("VisitSchedulerRestController");

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