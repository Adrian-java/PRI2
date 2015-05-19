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
 * Unit test for the <code>WorkerController</code> controller.
 *
 * @see com.eclinic.web.WorkerController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class WorkerControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerPatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerPatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerPatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerAdmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerAdmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerAdmin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerReceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerReceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerReceptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerLoginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerLoginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerLoginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkerSystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkerSystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkerSystemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>workerControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetworkerControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/workerController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerController controller = (WorkerController) context.getBean("WorkerController");

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