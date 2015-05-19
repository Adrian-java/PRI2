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
 * Unit test for the <code>ReceptionistController</code> controller.
 *
 * @see com.eclinic.web.ReceptionistController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class ReceptionistControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReceptionistVisits()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReceptionistVisits() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReceptionistVisits");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReceptionistWorkers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReceptionistWorkers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReceptionistWorkers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>receptionistControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetreceptionistControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/receptionistController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReceptionistController controller = (ReceptionistController) context.getBean("ReceptionistController");

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