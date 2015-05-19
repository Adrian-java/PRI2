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
 * Unit test for the <code>SpecalVisitFieldController</code> controller.
 *
 * @see com.eclinic.web.SpecalVisitFieldController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SpecalVisitFieldControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSpecalVisitFieldSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSpecalVisitFieldSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSpecalVisitFieldSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>specalvisitfieldControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetspecalvisitfieldControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/specalvisitfieldController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldController controller = (SpecalVisitFieldController) context.getBean("SpecalVisitFieldController");

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