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
 * Unit test for the <code>PatientCardController</code> controller.
 *
 * @see com.eclinic.web.PatientCardController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class PatientCardControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editPatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientCardPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientCardPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientCardPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientCardDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientCardDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientCardDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPatientCardVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPatientCardVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPatientCardVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>patientcardControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetpatientcardControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/patientcardController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PatientCardController controller = (PatientCardController) context.getBean("PatientCardController");

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