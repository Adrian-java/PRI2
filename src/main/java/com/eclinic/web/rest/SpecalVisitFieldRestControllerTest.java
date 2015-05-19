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
 * Unit test for the <code>SpecalVisitFieldRestController</code> controller.
 *
 * @see com.eclinic.web.rest.SpecalVisitFieldRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SpecalVisitFieldRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecalVisitFieldspecalvisitfield_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecalVisitFieldspecalvisitfield_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_idspecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecalVisitFieldspecalvisitfield_idspecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}/specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_idspecializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecalVisitFieldspecalvisitfield_idspecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}/specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_idspecializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecalVisitFieldspecalvisitfield_idspecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}/specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecalVisitFieldspecalvisitfield_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitField()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecalVisitField() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>SpecalVisitFieldspecalvisitfield_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecalVisitFieldspecalvisitfield_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/SpecalVisitField/{specalvisitfield_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecalVisitFieldRestController controller = (SpecalVisitFieldRestController) context.getBean("SpecalVisitFieldRestController");

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