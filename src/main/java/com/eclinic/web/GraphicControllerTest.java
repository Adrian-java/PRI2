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
 * Unit test for the <code>GraphicController</code> controller.
 *
 * @see com.eclinic.web.GraphicController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class GraphicControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGraphicDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGraphicDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGraphicDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGraphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGraphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>graphicControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetgraphicControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/graphicController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicController controller = (GraphicController) context.getBean("GraphicController");

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