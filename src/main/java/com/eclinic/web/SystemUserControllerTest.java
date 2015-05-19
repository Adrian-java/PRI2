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
 * Unit test for the <code>SystemUserController</code> controller.
 *
 * @see com.eclinic.web.SystemUserController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SystemUserControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSystemUserWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSystemUserWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSystemUserWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSystemUserPermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSystemUserPermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSystemUserPermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>systemuserControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsystemuserControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/systemuserController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SystemUserController controller = (SystemUserController) context.getBean("SystemUserController");

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