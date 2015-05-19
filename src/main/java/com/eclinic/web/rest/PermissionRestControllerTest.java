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
 * Unit test for the <code>PermissionRestController</code> controller.
 *
 * @see com.eclinic.web.rest.PermissionRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PermissionRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Permissionpermission_idsystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idsystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/systemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idsystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPermissionpermission_idsystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/systemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idsystemUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPermissionpermission_idsystemUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/systemUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idsystemUsersystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePermissionpermission_idsystemUsersystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/systemUser/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idsystemUsersystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idsystemUsersystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/systemUser/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idmodule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idmodule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idmodule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPermissionpermission_idmodule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idmodule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPermissionpermission_idmodule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idmodulemodule_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePermissionpermission_idmodulemodule_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/module/{module_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idmodulemodule_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idmodulemodule_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/module/{module_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idtypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idtypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/typeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idtypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPermissionpermission_idtypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/typeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idtypeOfUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPermissionpermission_idtypeOfUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/typeOfUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idtypeOfUserstypeofuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePermissionpermission_idtypeOfUserstypeofuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/typeOfUsers/{typeofuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_idtypeOfUserstypeofuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_idtypeOfUserstypeofuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}/typeOfUsers/{typeofuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPermissionpermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permission()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPermission() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Permissionpermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePermissionpermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Permission/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PermissionRestController controller = (PermissionRestController) context.getBean("PermissionRestController");

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