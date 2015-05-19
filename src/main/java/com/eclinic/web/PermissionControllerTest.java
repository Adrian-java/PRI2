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
 * Unit test for the <code>PermissionController</code> controller.
 *
 * @see com.eclinic.web.PermissionController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PermissionControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editPermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPermissionSystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPermissionSystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPermissionSystemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPermissionModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPermissionModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPermissionModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPermissionTypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPermissionTypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPermissionTypeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePermission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePermission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>permissionControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetpermissionControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/permissionController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionController controller = (PermissionController) context.getBean("PermissionController");

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