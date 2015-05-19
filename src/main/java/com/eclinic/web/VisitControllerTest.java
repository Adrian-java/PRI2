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
 * Unit test for the <code>VisitController</code> controller.
 *
 * @see com.eclinic.web.VisitController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class VisitControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitPatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitPatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitPatientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitTypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitTypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitTypeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitStatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitStatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listVisitSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistVisitSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listVisitSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>visitControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetvisitControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/visitController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitController controller = (VisitController) context.getBean("VisitController");

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