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
 * Unit test for the <code>AddressRestController</code> controller.
 *
 * @see com.eclinic.web.rest.AddressRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class AddressRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Addressaddress_idpatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAddressaddress_idpatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}/patients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_idpatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostAddressaddress_idpatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}/patients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_idpatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutAddressaddress_idpatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}/patients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_idpatientspatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteAddressaddress_idpatientspatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}/patients/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_idpatientspatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAddressaddress_idpatientspatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}/patients/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Address()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetAddressaddress_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Address()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Address()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Addressaddress_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteAddressaddress_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Address/{address_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressRestController controller = (AddressRestController) context.getBean("AddressRestController");

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