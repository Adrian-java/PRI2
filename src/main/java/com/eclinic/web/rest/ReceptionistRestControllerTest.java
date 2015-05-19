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
 * Unit test for the <code>ReceptionistRestController</code> controller.
 *
 * @see com.eclinic.web.rest.ReceptionistRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ReceptionistRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Receptionistreceptionist_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionistreceptionist_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReceptionistreceptionist_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReceptionistreceptionist_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReceptionistreceptionist_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionistreceptionist_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionistreceptionist_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReceptionistreceptionist_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReceptionistreceptionist_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReceptionistreceptionist_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionistreceptionist_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Receptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistRestController controller = (ReceptionistRestController) context.getBean("ReceptionistRestController");

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