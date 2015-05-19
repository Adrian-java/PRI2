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
 * Unit test for the <code>StatusOfVisitRestController</code> controller.
 *
 * @see com.eclinic.web.rest.StatusOfVisitRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class StatusOfVisitRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>StatusOfVisitstatusofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetStatusOfVisitstatusofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostStatusOfVisitstatusofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_idvisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutStatusOfVisitstatusofvisit_idvisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}/visits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteStatusOfVisitstatusofvisit_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_idvisitsvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetStatusOfVisitstatusofvisit_idvisitsvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}/visits/{visit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetStatusOfVisitstatusofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisit()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostStatusOfVisit() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>StatusOfVisitstatusofvisit_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteStatusOfVisitstatusofvisit_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/StatusOfVisit/{statusofvisit_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusOfVisitRestController controller = (StatusOfVisitRestController) context.getBean("StatusOfVisitRestController");

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