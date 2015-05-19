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
 * Unit test for the <code>GraphicRestController</code> controller.
 *
 * @see com.eclinic.web.rest.GraphicRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class GraphicRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Graphicgraphic_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetGraphicgraphic_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostGraphicgraphic_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_iddoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutGraphicgraphic_iddoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteGraphicgraphic_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_iddoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetGraphicgraphic_iddoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetGraphicgraphic_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphic()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostGraphic() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Graphicgraphic_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteGraphicgraphic_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Graphic/{graphic_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GraphicRestController controller = (GraphicRestController) context.getBean("GraphicRestController");

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