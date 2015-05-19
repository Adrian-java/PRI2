package com.eclinic.service;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;

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
public class ModuleServiceTest {

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
	protected ModuleService service;

	/**
	 * Instantiates a new ModuleServiceTest.
	 *
	 */
	public ModuleServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Module entity
	 * 
	 */
	@Test
	public void loadModules() {
		Set<Module> response = null;
		response = service.loadModules();
		// TODO: JUnit - Add assertions to test outputs of operation: loadModules
	}

	/**
	 * Operation Unit Test
	 * Return all Module entity
	 * 
	 */
	@Test
	public void findAllModules() {
		// TODO: JUnit - Populate test inputs for operation: findAllModules 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Module> response = null;
		response = service.findAllModules(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllModules
	}

	/**
	 * Operation Unit Test
	 * Save an existing Permission entity
	 * 
	 */
	@Test
	public void saveModulePermissions() {
		// TODO: JUnit - Populate test inputs for operation: saveModulePermissions 
		Integer id = 0;
		Permission related_permissions = new com.eclinic.domain.Permission();
		Module response = null;
		response = service.saveModulePermissions(id, related_permissions);
		// TODO: JUnit - Add assertions to test outputs of operation: saveModulePermissions
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findModuleByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findModuleByPrimaryKey 
		Integer id_1 = 0;
		Module response = null;
		response = service.findModuleByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findModuleByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Permission entity
	 * 
	 */
	@Test
	public void deleteModulePermissions() {
		// TODO: JUnit - Populate test inputs for operation: deleteModulePermissions 
		Integer module_id = 0;
		Integer related_permissions_id = 0;
		Module response = null;
		response = service.deleteModulePermissions(module_id, related_permissions_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteModulePermissions
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Module entity
	 * 
	 */
	@Test
	public void countModules() {
		Integer response = null;
		response = service.countModules();
		// TODO: JUnit - Add assertions to test outputs of operation: countModules
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Module entity
	 * 
	 */
	@Test
	public void deleteModule() {
		// TODO: JUnit - Populate test inputs for operation: deleteModule 
		Module module = new com.eclinic.domain.Module();
		service.deleteModule(module);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Module entity
	 * 
	 */
	@Test
	public void saveModule() {
		// TODO: JUnit - Populate test inputs for operation: saveModule 
		Module module_1 = new com.eclinic.domain.Module();
		service.saveModule(module_1);
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
