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
 * Unit test for the <code>WorkerRestController</code> controller.
 *
 * @see com.eclinic.web.rest.WorkerRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class WorkerRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Workerworker_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_idpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idadmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idadmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idadmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_idadmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idadmin()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_idadmin() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/admin");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idadminadmin_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_idadminadmin_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/admin/{admin_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idadminadmin_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idadminadmin_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/admin/{admin_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idreceptionist()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_idreceptionist() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/receptionist");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idreceptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_idreceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idreceptionistreceptionist_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idreceptionistreceptionist_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/receptionist/{receptionist_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idloginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idloginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/loginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idloginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_idloginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/loginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idloginHistories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_idloginHistories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/loginHistories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idloginHistoriesloginhistory_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_idloginHistoriesloginhistory_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/loginHistories/{loginhistory_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idloginHistoriesloginhistory_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idloginHistoriesloginhistory_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/loginHistories/{loginhistory_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idsystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idsystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/systemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idsystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkerworker_idsystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/systemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idsystemUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkerworker_idsystemUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/systemUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idsystemUserssystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_idsystemUserssystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/systemUsers/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_idsystemUserssystemuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_idsystemUserssystemuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}/systemUsers/{systemuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Worker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Worker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Worker()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorker() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Workerworker_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkerworker_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Worker/{worker_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkerRestController controller = (WorkerRestController) context.getBean("WorkerRestController");

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