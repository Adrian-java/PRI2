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
 * Unit test for the <code>SickLeaveRestController</code> controller.
 *
 * @see com.eclinic.web.rest.SickLeaveRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SickLeaveRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>SickLeavesickleave_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSickLeavesickleave_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSickLeavesickleave_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSickLeavesickleave_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idvisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_idvisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idvisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSickLeavesickleave_idvisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idvisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSickLeavesickleave_idvisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idvisitvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSickLeavesickleave_idvisitvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/visit/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_idvisitvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_idvisitvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/visit/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSickLeavesickleave_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSickLeavesickleave_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSickLeavesickleave_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSickLeavesickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SickLeavesickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSickLeavesickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SickLeave/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveRestController controller = (SickLeaveRestController) context.getBean("SickLeaveRestController");

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