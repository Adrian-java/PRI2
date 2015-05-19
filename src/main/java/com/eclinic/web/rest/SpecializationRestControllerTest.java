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
 * Unit test for the <code>SpecializationRestController</code> controller.
 *
 * @see com.eclinic.web.rest.SpecializationRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SpecializationRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Specializationspecialization_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecializationspecialization_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecializationspecialization_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecializationspecialization_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idspecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_idspecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/specalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idspecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecializationspecialization_idspecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/specalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idspecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecializationspecialization_idspecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/specalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idspecalVisitFieldsspecalvisitfield_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecializationspecialization_idspecalVisitFieldsspecalvisitfield_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/specalVisitFields/{specalvisitfield_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idspecalVisitFieldsspecalvisitfield_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_idspecalVisitFieldsspecalvisitfield_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/specalVisitFields/{specalvisitfield_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecializationspecialization_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecializationspecialization_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idvisitSchedulersvisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecializationspecialization_idvisitSchedulersvisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/visitSchedulers/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_idvisitSchedulersvisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_idvisitSchedulersvisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}/visitSchedulers/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSpecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Specializationspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSpecializationspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Specialization/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationRestController controller = (SpecializationRestController) context.getBean("SpecializationRestController");

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