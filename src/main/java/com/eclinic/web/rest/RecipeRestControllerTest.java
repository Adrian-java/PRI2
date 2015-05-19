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
 * Unit test for the <code>RecipeRestController</code> controller.
 *
 * @see com.eclinic.web.rest.RecipeRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/wee-security-context.xml",
		"file:./src/main/resources/wee-service-context.xml",
		"file:./src/main/resources/wee-dao-context.xml",
		"file:./src/main/resources/wee-web-context.xml" })
public class RecipeRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Reciperecipe_idrpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReciperecipe_idrpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReciperecipe_idrpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrpatient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReciperecipe_idrpatient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/patient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReciperecipe_idrpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrpatientpatient_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReciperecipe_idrpatientpatient_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/patient/{patient_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrdoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReciperecipe_idrdoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrdoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostReciperecipe_idrdoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrdoctor()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutReciperecipe_idrdoctor() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/doctor");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrdoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReciperecipe_idrdoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idrdoctordoctor_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReciperecipe_idrdoctordoctor_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}/doctor/{doctor_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetReciperecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recipe()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecipe() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Reciperecipe_idr()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteReciperecipe_idr() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Recipe/{recipe_idr}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecipeRestController controller = (RecipeRestController) context.getBean("RecipeRestController");

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