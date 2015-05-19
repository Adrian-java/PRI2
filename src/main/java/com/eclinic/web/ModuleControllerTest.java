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
 * Unit test for the <code>ModuleController</code> controller.
 *
 * @see com.eclinic.web.ModuleController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ModuleControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listModulePermissions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistModulePermissions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listModulePermissions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteModule()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteModule() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteModule");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>moduleControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetmoduleControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/moduleController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ModuleController controller = (ModuleController) context.getBean("ModuleController");

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