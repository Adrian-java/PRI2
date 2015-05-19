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
 * Unit test for the <code>DoctorController</code> controller.
 *
 * @see com.eclinic.web.DoctorController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class DoctorControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorSpecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorSpecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorSpecializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorPatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorPatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorPatientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorRecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorRecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorRecipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorGraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorGraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorGraphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDoctorSickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDoctorSickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDoctorSickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>doctorControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdoctorControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/doctorController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorController controller = (DoctorController) context.getBean("DoctorController");

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