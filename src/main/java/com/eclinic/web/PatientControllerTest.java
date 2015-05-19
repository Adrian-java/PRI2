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
 * Unit test for the <code>PatientController</code> controller.
 *
 * @see com.eclinic.web.PatientController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PatientControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editPatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>patientControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetpatientControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/patientController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientController controller = (PatientController) context.getBean("PatientController");

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