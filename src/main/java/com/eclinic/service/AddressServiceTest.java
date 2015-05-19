package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;

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
public class AddressServiceTest {

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
	protected AddressService service;

	/**
	 * Instantiates a new AddressServiceTest.
	 *
	 */
	public AddressServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Address entity
	 * 
	 */
	@Test
	public void saveAddress() {
		// TODO: JUnit - Populate test inputs for operation: saveAddress 
		Address address = new com.eclinic.domain.Address();
		service.saveAddress(address);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deleteAddressPatients() {
		// TODO: JUnit - Populate test inputs for operation: deleteAddressPatients 
		Integer address_id = 0;
		Integer related_patients_id = 0;
		Address response = null;
		response = service.deleteAddressPatients(address_id, related_patients_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteAddressPatients
	}

	/**
	 * Operation Unit Test
	 * Return all Address entity
	 * 
	 */
	@Test
	public void findAllAddresss() {
		// TODO: JUnit - Populate test inputs for operation: findAllAddresss 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Address> response = null;
		response = service.findAllAddresss(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllAddresss
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Address entity
	 * 
	 */
	@Test
	public void countAddresss() {
		Integer response = null;
		response = service.countAddresss();
		// TODO: JUnit - Add assertions to test outputs of operation: countAddresss
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Address entity
	 * 
	 */
	@Test
	public void deleteAddress() {
		// TODO: JUnit - Populate test inputs for operation: deleteAddress 
		Address address_1 = new com.eclinic.domain.Address();
		service.deleteAddress(address_1);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Address entity
	 * 
	 */
	@Test
	public void loadAddresss() {
		Set<Address> response = null;
		response = service.loadAddresss();
		// TODO: JUnit - Add assertions to test outputs of operation: loadAddresss
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void saveAddressPatients() {
		// TODO: JUnit - Populate test inputs for operation: saveAddressPatients 
		Integer id = 0;
		Patient related_patients = new com.eclinic.domain.Patient();
		Address response = null;
		response = service.saveAddressPatients(id, related_patients);
		// TODO: JUnit - Add assertions to test outputs of operation: saveAddressPatients
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findAddressByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findAddressByPrimaryKey 
		Integer id_1 = 0;
		Address response = null;
		response = service.findAddressByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findAddressByPrimaryKey
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
