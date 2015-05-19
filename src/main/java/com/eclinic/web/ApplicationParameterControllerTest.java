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
 * Unit test for the <code>ApplicationParameterController</code> controller.
 *
 * @see com.eclinic.web.ApplicationParameterController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ApplicationParameterControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteApplicationParameter()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteApplicationParameter() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteApplicationParameter");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>applicationparameterControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetapplicationparameterControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/applicationparameterController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ApplicationParameterController controller = (ApplicationParameterController) context.getBean("ApplicationParameterController");

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