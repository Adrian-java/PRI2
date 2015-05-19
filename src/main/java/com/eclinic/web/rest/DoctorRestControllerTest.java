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
 * Unit test for the <code>DoctorRestController</code> controller.
 *
 * @see com.eclinic.web.rest.DoctorRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class DoctorRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Doctordoctor_idspecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idspecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/specializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idspecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idspecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/specializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idspecializations()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idspecializations() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/specializations");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idspecializationsspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idspecializationsspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/specializations/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idspecializationsspecialization_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idspecializationsspecialization_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/specializations/{specialization_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idpatientCards()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idpatientCards() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/patientCards");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idpatientCardspatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idpatientCardspatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/patientCards/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idpatientCardspatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idpatientCardspatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/patientCards/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idrecipes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idrecipes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/recipes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idrecipesrecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idrecipesrecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/recipes/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idrecipesrecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idrecipesrecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/recipes/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idgraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idgraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/graphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idgraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idgraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/graphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idgraphics()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idgraphics() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/graphics");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idgraphicsgraphic_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idgraphicsgraphic_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/graphics/{graphic_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idgraphicsgraphic_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idgraphicsgraphic_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/graphics/{graphic_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idworkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idworkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/workers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idworkersworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idworkersworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/workers/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idvisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitSchedulersvisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idvisitSchedulersvisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visitSchedulers/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idvisitSchedulersvisitscheduler_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idvisitSchedulersvisitscheduler_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/visitSchedulers/{visitscheduler_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctordoctor_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctordoctor_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetDoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Doctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteDoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DoctorRestController controller = (DoctorRestController) context.getBean("DoctorRestController");

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