package com.eclinic.service;

import com.eclinic.domain.Permission;
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
public class TypeOfUserServiceTest {

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
	protected TypeOfUserService service;

	/**
	 * Instantiates a new TypeOfUserServiceTest.
	 *
	 */
	public TypeOfUserServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Permission entity
	 * 
	 */
	@Test
	public void saveTypeOfUserPermission() {
		// TODO: JUnit - Populate test inputs for operation: saveTypeOfUserPermission 
		Integer id = 0;
		Permission related_permission = new com.eclinic.domain.Permission();
		TypeOfUser response = null;
		response = service.saveTypeOfUserPermission(id, related_permission);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTypeOfUserPermission
	}

	/**
	 * Operation Unit Test
	 * Return a count of all TypeOfUser entity
	 * 
	 */
	@Test
	public void countTypeOfUsers() {
		Integer response = null;
		response = service.countTypeOfUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: countTypeOfUsers
	}

	/**
	 * Operation Unit Test
	 * Return all TypeOfUser entity
	 * 
	 */
	@Test
	public void findAllTypeOfUsers() {
		// TODO: JUnit - Populate test inputs for operation: findAllTypeOfUsers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<TypeOfUser> response = null;
		response = service.findAllTypeOfUsers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllTypeOfUsers
	}

	/**
	 * Operation Unit Test
	 * Load an existing TypeOfUser entity
	 * 
	 */
	@Test
	public void loadTypeOfUsers() {
		Set<TypeOfUser> response = null;
		response = service.loadTypeOfUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadTypeOfUsers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Permission entity
	 * 
	 */
	@Test
	public void deleteTypeOfUserPermission() {
		// TODO: JUnit - Populate test inputs for operation: deleteTypeOfUserPermission 
		Integer typeofuser_id = 0;
		Integer related_permission_id = 0;
		TypeOfUser response = null;
		response = service.deleteTypeOfUserPermission(typeofuser_id, related_permission_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTypeOfUserPermission
	}

	/**
	 * Operation Unit Test
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Test
	public void deleteTypeOfUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteTypeOfUser 
		TypeOfUser typeofuser = new com.eclinic.domain.TypeOfUser();
		service.deleteTypeOfUser(typeofuser);
	}

	/**
	 * Operation Unit Test
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Test
	public void saveTypeOfUser() {
		// TODO: JUnit - Populate test inputs for operation: saveTypeOfUser 
		TypeOfUser typeofuser_1 = new com.eclinic.domain.TypeOfUser();
		service.saveTypeOfUser(typeofuser_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findTypeOfUserByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findTypeOfUserByPrimaryKey 
		Integer id_1 = 0;
		TypeOfUser response = null;
		response = service.findTypeOfUserByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findTypeOfUserByPrimaryKey
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
