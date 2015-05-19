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
 * Unit test for the <code>PatientCardRestController</code> controller.
 *
 * @see com.eclinic.web.rest.PatientCardRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PatientCardRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>PatientCardpatientcard_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientCardpatientcard_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientCardpatientcard_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientCardpatientcard_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientCardpatientcard_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientCardpatientcard_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientCardpatientcard_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientCardpatientcard_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientCardpatientcard_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientCardpatientcard_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientCardpatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PatientCardpatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientCardpatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PatientCard/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardRestController controller = (PatientCardRestController) context.getBean("PatientCardRestController");

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