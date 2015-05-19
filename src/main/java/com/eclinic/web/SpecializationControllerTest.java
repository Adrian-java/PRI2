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
 * Unit test for the <code>SpecializationController</code> controller.
 *
 * @see com.eclinic.web.SpecializationController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class SpecializationControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSpecializationDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSpecializationDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSpecializationDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSpecializationSpecalVisitFields()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSpecializationSpecalVisitFields() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSpecializationSpecalVisitFields");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSpecializationVisitSchedulers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSpecializationVisitSchedulers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSpecializationVisitSchedulers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSpecialization()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSpecialization() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSpecialization");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>specializationControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetspecializationControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/specializationController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SpecializationController controller = (SpecializationController) context.getBean("SpecializationController");

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