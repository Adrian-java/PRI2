package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
@Transactional
public class WorkerServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected WorkerService service;

	/**
	 * Instantiates a new WorkerServiceTest.
	 *
	 */
	public WorkerServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Test
	public void deleteWorkerLoginHistories() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerLoginHistories 
		Integer worker_id = 0;
		Integer related_loginhistories_id = 0;
		Worker response = null;
		response = service.deleteWorkerLoginHistories(worker_id, related_loginhistories_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerLoginHistories
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteWorkerDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerDoctor 
		Integer worker_id_1 = 0;
		Integer related_doctor_id = 0;
		Worker response = null;
		response = service.deleteWorkerDoctor(worker_id_1, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing LoginHistory entity
	 * 
	 */
	@Test
	public void saveWorkerLoginHistories() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerLoginHistories 
		Integer id = 0;
		LoginHistory related_loginhistories = new com.eclinic.domain.LoginHistory();
		Worker response = null;
		response = service.saveWorkerLoginHistories(id, related_loginhistories);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerLoginHistories
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Worker entity
	 * 
	 */
	@Test
	public void deleteWorker() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorker 
		Worker worker = new com.eclinic.domain.Worker();
		service.deleteWorker(worker);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Admin entity
	 * 
	 */
	@Test
	public void saveWorkerAdmin() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerAdmin 
		Integer id_1 = 0;
		Admin related_admin = new com.eclinic.domain.Admin();
		Worker response = null;
		response = service.saveWorkerAdmin(id_1, related_admin);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerAdmin
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void saveWorkerPatient() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerPatient 
		Integer id_2 = 0;
		Patient related_patient = new com.eclinic.domain.Patient();
		Worker response = null;
		response = service.saveWorkerPatient(id_2, related_patient);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerPatient
	}

	/**
	 * Operation Unit Test
	 * Save an existing Worker entity
	 * 
	 */
	@Test
	public void saveWorker() {
		// TODO: JUnit - Populate test inputs for operation: saveWorker 
		Worker worker_1 = new com.eclinic.domain.Worker();
		service.saveWorker(worker_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Worker entity
	 * 
	 */
	@Test
	public void countWorkers() {
		Integer response = null;
		response = service.countWorkers();
		// TODO: JUnit - Add assertions to test outputs of operation: countWorkers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Test
	public void deleteWorkerReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerReceptionist 
		Integer worker_id_2 = 0;
		Integer related_receptionist_id = 0;
		Worker response = null;
		response = service.deleteWorkerReceptionist(worker_id_2, related_receptionist_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerReceptionist
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveWorkerDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerDoctor 
		Integer id_3 = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		Worker response = null;
		response = service.saveWorkerDoctor(id_3, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerDoctor
	}

	/**
	 * Operation Unit Test
	 * Load an existing Worker entity
	 * 
	 */
	@Test
	public void loadWorkers() {
		Set<Worker> response = null;
		response = service.loadWorkers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadWorkers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Admin entity
	 * 
	 */
	@Test
	public void deleteWorkerAdmin() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerAdmin 
		Integer worker_id_3 = 0;
		Integer related_admin_id = 0;
		Worker response = null;
		response = service.deleteWorkerAdmin(worker_id_3, related_admin_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerAdmin
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Test
	public void deleteWorkerSystemUsers() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerSystemUsers 
		Integer worker_id_4 = 0;
		Integer related_systemusers_id = 0;
		Worker response = null;
		response = service.deleteWorkerSystemUsers(worker_id_4, related_systemusers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerSystemUsers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findWorkerByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findWorkerByPrimaryKey 
		Integer id_4 = 0;
		Worker response = null;
		response = service.findWorkerByPrimaryKey(id_4);
		// TODO: JUnit - Add assertions to test outputs of operation: findWorkerByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deleteWorkerPatient() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkerPatient 
		Integer worker_id_5 = 0;
		Integer related_patient_id = 0;
		Worker response = null;
		response = service.deleteWorkerPatient(worker_id_5, related_patient_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteWorkerPatient
	}

	/**
	 * Operation Unit Test
	 * Save an existing Receptionist entity
	 * 
	 */
	@Test
	public void saveWorkerReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerReceptionist 
		Integer id_5 = 0;
		Receptionist related_receptionist = new com.eclinic.domain.Receptionist();
		Worker response = null;
		response = service.saveWorkerReceptionist(id_5, related_receptionist);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerReceptionist
	}

	/**
	 * Operation Unit Test
	 * Return all Worker entity
	 * 
	 */
	@Test
	public void findAllWorkers() {
		// TODO: JUnit - Populate test inputs for operation: findAllWorkers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Worker> response = null;
		response = service.findAllWorkers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllWorkers
	}

	/**
	 * Operation Unit Test
	 * Save an existing SystemUser entity
	 * 
	 */
	@Test
	public void saveWorkerSystemUsers() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkerSystemUsers 
		Integer id_6 = 0;
		SystemUser related_systemusers = new com.eclinic.domain.SystemUser();
		Worker response = null;
		response = service.saveWorkerSystemUsers(id_6, related_systemusers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveWorkerSystemUsers
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
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
