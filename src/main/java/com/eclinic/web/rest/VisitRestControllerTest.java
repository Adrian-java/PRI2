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
 * Unit test for the <code>VisitRestController</code> controller.
 *
 * @see com.eclinic.web.rest.VisitRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class VisitRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Visitvisit_idpatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idpatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/patientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idpatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_idpatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/patientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idpatientCard()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_idpatientCard() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/patientCard");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idpatientCardpatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_idpatientCardpatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/patientCard/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idpatientCardpatientcard_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idpatientCardpatientcard_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/patientCard/{patientcard_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idtypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idtypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/typeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idtypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_idtypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/typeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idtypeOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_idtypeOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/typeOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idtypeOfVisittypeofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_idtypeOfVisittypeofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/typeOfVisit/{typeofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idtypeOfVisittypeofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idtypeOfVisittypeofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/typeOfVisit/{typeofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idreceptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_idreceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idreceptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idreceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idstatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idstatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/statusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idstatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_idstatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/statusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idstatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_idstatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/statusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idstatusOfVisitstatusofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_idstatusOfVisitstatusofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/statusOfVisit/{statusofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idstatusOfVisitstatusofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idstatusOfVisitstatusofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/statusOfVisit/{statusofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisitvisit_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idsickLeaves()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisitvisit_idsickLeaves() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/sickLeaves");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_idsickLeavessickleave_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_idsickLeavessickleave_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}/sickLeaves/{sickleave_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetVisitvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Visitvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteVisitvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Visit/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		VisitRestController controller = (VisitRestController) context.getBean("VisitRestController");

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