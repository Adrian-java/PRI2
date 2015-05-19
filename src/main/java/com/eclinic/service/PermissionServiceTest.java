package com.eclinic.service;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfUser;

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
public class PermissionServiceTest {

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
	protected PermissionService service;

	/**
	 * Instantiates a new PermissionServiceTest.
	 *
	 */
	public PermissionServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Permission entity
	 * 
	 */
	@Test
	public void countPermissions() {
		Integer response = null;
		response = service.countPermissions();
		// TODO: JUnit - Add assertions to test outputs of operation: countPermissions
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Permission entity
	 * 
	 */
	@Test
	public void deletePermission() {
		// TODO: JUnit - Populate test inputs for operation: deletePermission 
		Permission permission = new com.eclinic.domain.Permission();
		service.deletePermission(permission);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Test
	public void deletePermissionTypeOfUsers() {
		// TODO: JUnit - Populate test inputs for operation: deletePermissionTypeOfUsers 
		Integer permission_id = 0;
		Integer related_typeofusers_id = 0;
		Permission response = null;
		response = service.deletePermissionTypeOfUsers(permission_id, related_typeofusers_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePermissionTypeOfUsers
	}

	/**
	 * Operation Unit Test
	 * Return all Permission entity
	 * 
	 */
	@Test
	public void findAllPermissions() {
		// TODO: JUnit - Populate test inputs for operation: findAllPermissions 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Permission> response = null;
		response = service.findAllPermissions(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllPermissions
	}

	/**
	 * Operation Unit Test
	 * Save an existing Permission entity
	 * 
	 */
	@Test
	public void savePermission() {
		// TODO: JUnit - Populate test inputs for operation: savePermission 
		Permission permission_1 = new com.eclinic.domain.Permission();
		service.savePermission(permission_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Module entity
	 * 
	 */
	@Test
	public void deletePermissionModule() {
		// TODO: JUnit - Populate test inputs for operation: deletePermissionModule 
		Integer permission_id_1 = 0;
		Integer related_module_id = 0;
		Permission response = null;
		response = service.deletePermissionModule(permission_id_1, related_module_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePermissionModule
	}

	/**
	 * Operation Unit Test
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Test
	public void savePermissionTypeOfUsers() {
		// TODO: JUnit - Populate test inputs for operation: savePermissionTypeOfUsers 
		Integer id = 0;
		TypeOfUser related_typeofusers = new com.eclinic.domain.TypeOfUser();
		Permission response = null;
		response = service.savePermissionTypeOfUsers(id, related_typeofusers);
		// TODO: JUnit - Add assertions to test outputs of operation: savePermissionTypeOfUsers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Test
	public void deletePermissionSystemUser() {
		// TODO: JUnit - Populate test inputs for operation: deletePermissionSystemUser 
		Integer permission_id_2 = 0;
		Integer related_systemuser_id = 0;
		Permission response = null;
		response = service.deletePermissionSystemUser(permission_id_2, related_systemuser_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deletePermissionSystemUser
	}

	/**
	 * Operation Unit Test
	 * Load an existing Permission entity
	 * 
	 */
	@Test
	public void loadPermissions() {
		Set<Permission> response = null;
		response = service.loadPermissions();
		// TODO: JUnit - Add assertions to test outputs of operation: loadPermissions
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findPermissionByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findPermissionByPrimaryKey 
		Integer id_1 = 0;
		Permission response = null;
		response = service.findPermissionByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findPermissionByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing SystemUser entity
	 * 
	 */
	@Test
	public void savePermissionSystemUser() {
		// TODO: JUnit - Populate test inputs for operation: savePermissionSystemUser 
		Integer id_2 = 0;
		SystemUser related_systemuser = new com.eclinic.domain.SystemUser();
		Permission response = null;
		response = service.savePermissionSystemUser(id_2, related_systemuser);
		// TODO: JUnit - Add assertions to test outputs of operation: savePermissionSystemUser
	}

	/**
	 * Operation Unit Test
	 * Save an existing Module entity
	 * 
	 */
	@Test
	public void savePermissionModule() {
		// TODO: JUnit - Populate test inputs for operation: savePermissionModule 
		Integer id_3 = 0;
		Module related_module = new com.eclinic.domain.Module();
		Permission response = null;
		response = service.savePermissionModule(id_3, related_module);
		// TODO: JUnit - Add assertions to test outputs of operation: savePermissionModule
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
