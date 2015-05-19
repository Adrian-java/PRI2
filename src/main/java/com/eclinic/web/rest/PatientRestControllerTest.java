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
 * Unit test for the <code>PatientRestController</code> controller.
 *
 * @see com.eclinic.web.rest.PatientRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PatientRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Patientpatient_idaddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idaddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idaddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientpatient_idaddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idaddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientpatient_idaddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idaddressaddress_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_idaddressaddress_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/address/{address_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idaddressaddress_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idaddressaddress_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/address/{address_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientpatient_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientpatient_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idpatientCardspatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_idpatientCardspatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/patientCards/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idpatientCardspatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idpatientCardspatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/patientCards/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientpatient_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientpatient_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idrecipesrecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_idrecipesrecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/recipes/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idrecipesrecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idrecipesrecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/recipes/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientpatient_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientpatient_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatientpatient_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatientpatient_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Patientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientRestController controller = (PatientRestController) context.getBean("PatientRestController");

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