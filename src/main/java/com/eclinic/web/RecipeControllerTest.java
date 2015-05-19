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
 * Unit test for the <code>RecipeController</code> controller.
 *
 * @see com.eclinic.web.RecipeController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class RecipeControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecipePatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecipePatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecipePatient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecipeDoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecipeDoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecipeDoctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>recipeControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetrecipeControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/recipeController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeController controller = (RecipeController) context.getBean("RecipeController");

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