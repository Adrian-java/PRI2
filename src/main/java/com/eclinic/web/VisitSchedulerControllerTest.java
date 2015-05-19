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
 * Unit test for the <code>VisitSchedulerController</code> controller.
 *
 * @see com.eclinic.web.VisitSchedulerController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class VisitSchedulerControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitSchedulerSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitSchedulerSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitSchedulerSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitSchedulerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitSchedulerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitSchedulerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitScheduler()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitScheduler() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitScheduler");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>visitschedulerControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetvisitschedulerControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/visitschedulerController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitSchedulerController controller = (VisitSchedulerController) context.getBean("VisitSchedulerController");

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