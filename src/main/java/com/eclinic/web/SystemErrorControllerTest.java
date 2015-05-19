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
 * Unit test for the <code>SystemErrorController</code> controller.
 *
 * @see com.eclinic.web.SystemErrorController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SystemErrorControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSystemError()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSystemError() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSystemError");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>systemerrorControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsystemerrorControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/systemerrorController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemErrorController controller = (SystemErrorController) context.getBean("SystemErrorController");

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