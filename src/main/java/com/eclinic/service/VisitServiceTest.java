package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

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
public class VisitServiceTest {

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
	protected VisitService service;

	/**
	 * Instantiates a new VisitServiceTest.
	 *
	 */
	public VisitServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Visit entity
	 * 
	 */
	@Test
	public void loadVisits() {
		Set<Visit> response = null;
		response = service.loadVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: loadVisits
	}

	/**
	 * Operation Unit Test
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@Test
	public void deleteVisitTypeOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitTypeOfVisit 
		Integer visit_id = 0;
		Integer related_typeofvisit_id = 0;
		Visit response = null;
		response = service.deleteVisitTypeOfVisit(visit_id, related_typeofvisit_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitTypeOfVisit
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Visit entity
	 * 
	 */
	@Test
	public void deleteVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisit 
		Visit visit = new com.eclinic.domain.Visit();
		service.deleteVisit(visit);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Test
	public void deleteVisitPatientCard() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitPatientCard 
		Integer visit_id_1 = 0;
		Integer related_patientcard_id = 0;
		Visit response = null;
		response = service.deleteVisitPatientCard(visit_id_1, related_patientcard_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitPatientCard
	}

	/**
	 * Operation Unit Test
	 * Return all Visit entity
	 * 
	 */
	@Test
	public void findAllVisits() {
		// TODO: JUnit - Populate test inputs for operation: findAllVisits 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Visit> response = null;
		response = service.findAllVisits(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllVisits
	}

	/**
	 * Operation Unit Test
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@Test
	public void saveVisitTypeOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitTypeOfVisit 
		Integer id = 0;
		TypeOfVisit related_typeofvisit = new com.eclinic.domain.TypeOfVisit();
		Visit response = null;
		response = service.saveVisitTypeOfVisit(id, related_typeofvisit);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitTypeOfVisit
	}

	/**
	 * Operation Unit Test
	 * Save an existing Visit entity
	 * 
	 */
	@Test
	public void saveVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveVisit 
		Visit visit_1 = new com.eclinic.domain.Visit();
		service.saveVisit(visit_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Visit entity
	 * 
	 */
	@Test
	public void countVisits() {
		Integer response = null;
		response = service.countVisits();
		// TODO: JUnit - Add assertions to test outputs of operation: countVisits
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Test
	public void deleteVisitReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitReceptionist 
		Integer visit_id_2 = 0;
		Integer related_receptionist_id = 0;
		Visit response = null;
		response = service.deleteVisitReceptionist(visit_id_2, related_receptionist_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitReceptionist
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveVisitDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitDoctor 
		Integer id_1 = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		Visit response = null;
		response = service.saveVisitDoctor(id_1, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@Test
	public void saveVisitStatusOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitStatusOfVisit 
		Integer id_2 = 0;
		StatusOfVisit related_statusofvisit = new com.eclinic.domain.StatusOfVisit();
		Visit response = null;
		response = service.saveVisitStatusOfVisit(id_2, related_statusofvisit);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitStatusOfVisit
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findVisitByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findVisitByPrimaryKey 
		Integer id_3 = 0;
		Visit response = null;
		response = service.findVisitByPrimaryKey(id_3);
		// TODO: JUnit - Add assertions to test outputs of operation: findVisitByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Test
	public void deleteVisitSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitSickLeaves 
		Integer visit_id_3 = 0;
		Integer related_sickleaves_id = 0;
		Visit response = null;
		response = service.deleteVisitSickLeaves(visit_id_3, related_sickleaves_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@Test
	public void deleteVisitStatusOfVisit() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitStatusOfVisit 
		Integer visit_id_4 = 0;
		Integer related_statusofvisit_id = 0;
		Visit response = null;
		response = service.deleteVisitStatusOfVisit(visit_id_4, related_statusofvisit_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitStatusOfVisit
	}

	/**
	 * Operation Unit Test
	 * Save an existing SickLeave entity
	 * 
	 */
	@Test
	public void saveVisitSickLeaves() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitSickLeaves 
		Integer id_4 = 0;
		SickLeave related_sickleaves = new com.eclinic.domain.SickLeave();
		Visit response = null;
		response = service.saveVisitSickLeaves(id_4, related_sickleaves);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitSickLeaves
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteVisitDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteVisitDoctor 
		Integer visit_id_5 = 0;
		Integer related_doctor_id = 0;
		Visit response = null;
		response = service.deleteVisitDoctor(visit_id_5, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteVisitDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing PatientCard entity
	 * 
	 */
	@Test
	public void saveVisitPatientCard() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitPatientCard 
		Integer id_5 = 0;
		PatientCard related_patientcard = new com.eclinic.domain.PatientCard();
		Visit response = null;
		response = service.saveVisitPatientCard(id_5, related_patientcard);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitPatientCard
	}

	/**
	 * Operation Unit Test
	 * Save an existing Receptionist entity
	 * 
	 */
	@Test
	public void saveVisitReceptionist() {
		// TODO: JUnit - Populate test inputs for operation: saveVisitReceptionist 
		Integer id_6 = 0;
		Receptionist related_receptionist = new com.eclinic.domain.Receptionist();
		Visit response = null;
		response = service.saveVisitReceptionist(id_6, related_receptionist);
		// TODO: JUnit - Add assertions to test outputs of operation: saveVisitReceptionist
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
