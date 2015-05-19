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
 * Unit test for the <code>ModuleRestController</code> controller.
 *
 * @see com.eclinic.web.rest.ModuleRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ModuleRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Modulemodule_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetModulemodule_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostModulemodule_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_idpermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutModulemodule_idpermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}/permissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_idpermissionspermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteModulemodule_idpermissionspermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}/permissions/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_idpermissionspermission_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetModulemodule_idpermissionspermission_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}/permissions/{permission_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Module()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetModulemodule_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Module()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Module()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Modulemodule_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteModulemodule_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Module/{module_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleRestController controller = (ModuleRestController) context.getBean("ModuleRestController");

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