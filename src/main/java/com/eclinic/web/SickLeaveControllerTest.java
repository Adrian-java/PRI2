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
 * Unit test for the <code>SickLeaveController</code> controller.
 *
 * @see com.eclinic.web.SickLeaveController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SickLeaveControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSickLeavePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSickLeavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSickLeavePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSickLeaveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSickLeaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSickLeaveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSickLeaveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSickLeaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSickLeaveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSickLeave()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSickLeave() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSickLeave");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>sickleaveControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsickleaveControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sickleaveController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SickLeaveController controller = (SickLeaveController) context.getBean("SickLeaveController");

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