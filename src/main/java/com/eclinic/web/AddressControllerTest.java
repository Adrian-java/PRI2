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
 * Unit test for the <code>AddressController</code> controller.
 *
 * @see com.eclinic.web.AddressController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class AddressControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAddressPatients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAddressPatients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAddressPatients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAddress()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAddress() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAddress");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>addressControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetaddressControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/addressController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AddressController controller = (AddressController) context.getBean("AddressController");

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