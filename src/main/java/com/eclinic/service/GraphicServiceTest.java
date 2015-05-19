package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

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
public class GraphicServiceTest {

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
	protected GraphicService service;

	/**
	 * Instantiates a new GraphicServiceTest.
	 *
	 */
	public GraphicServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Graphic entity
	 * 
	 */
	@Test
	public void deleteGraphic() {
		// TODO: JUnit - Populate test inputs for operation: deleteGraphic 
		Graphic graphic = new com.eclinic.domain.Graphic();
		service.deleteGraphic(graphic);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteGraphicDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteGraphicDoctor 
		Integer graphic_id = 0;
		Integer related_doctor_id = 0;
		Graphic response = null;
		response = service.deleteGraphicDoctor(graphic_id, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteGraphicDoctor
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveGraphicDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveGraphicDoctor 
		Integer id = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		Graphic response = null;
		response = service.saveGraphicDoctor(id, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveGraphicDoctor
	}

	/**
	 * Operation Unit Test
	 * Return all Graphic entity
	 * 
	 */
	@Test
	public void findAllGraphics() {
		// TODO: JUnit - Populate test inputs for operation: findAllGraphics 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Graphic> response = null;
		response = service.findAllGraphics(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllGraphics
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findGraphicByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findGraphicByPrimaryKey 
		Integer id_1 = 0;
		Graphic response = null;
		response = service.findGraphicByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findGraphicByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Graphic entity
	 * 
	 */
	@Test
	public void countGraphics() {
		Integer response = null;
		response = service.countGraphics();
		// TODO: JUnit - Add assertions to test outputs of operation: countGraphics
	}

	/**
	 * Operation Unit Test
	 * Save an existing Graphic entity
	 * 
	 */
	@Test
	public void saveGraphic() {
		// TODO: JUnit - Populate test inputs for operation: saveGraphic 
		Graphic graphic_1 = new com.eclinic.domain.Graphic();
		service.saveGraphic(graphic_1);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Graphic entity
	 * 
	 */
	@Test
	public void loadGraphics() {
		Set<Graphic> response = null;
		response = service.loadGraphics();
		// TODO: JUnit - Add assertions to test outputs of operation: loadGraphics
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
