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
 * Unit test for the <code>LoginHistoryController</code> controller.
 *
 * @see com.eclinic.web.LoginHistoryController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class LoginHistoryControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listLoginHistoryWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistLoginHistoryWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listLoginHistoryWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteLoginHistory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteLoginHistory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteLoginHistory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>loginhistoryControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetloginhistoryControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/loginhistoryController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		LoginHistoryController controller = (LoginHistoryController) context.getBean("LoginHistoryController");

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