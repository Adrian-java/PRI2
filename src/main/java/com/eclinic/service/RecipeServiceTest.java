package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;

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
public class RecipeServiceTest {

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
	protected RecipeService service;

	/**
	 * Instantiates a new RecipeServiceTest.
	 *
	 */
	public RecipeServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all Recipe entity
	 * 
	 */
	@Test
	public void findAllRecipes() {
		// TODO: JUnit - Populate test inputs for operation: findAllRecipes 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Recipe> response = null;
		response = service.findAllRecipes(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllRecipes
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Recipe entity
	 * 
	 */
	@Test
	public void deleteRecipe() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecipe 
		Recipe recipe = new com.eclinic.domain.Recipe();
		service.deleteRecipe(recipe);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Recipe entity
	 * 
	 */
	@Test
	public void saveRecipe() {
		// TODO: JUnit - Populate test inputs for operation: saveRecipe 
		Recipe recipe_1 = new com.eclinic.domain.Recipe();
		service.saveRecipe(recipe_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findRecipeByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findRecipeByPrimaryKey 
		Integer idr = 0;
		Recipe response = null;
		response = service.findRecipeByPrimaryKey(idr);
		// TODO: JUnit - Add assertions to test outputs of operation: findRecipeByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Patient entity
	 * 
	 */
	@Test
	public void saveRecipePatient() {
		// TODO: JUnit - Populate test inputs for operation: saveRecipePatient 
		Integer idr_1 = 0;
		Patient related_patient = new com.eclinic.domain.Patient();
		Recipe response = null;
		response = service.saveRecipePatient(idr_1, related_patient);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecipePatient
	}

	/**
	 * Operation Unit Test
	 * Load an existing Recipe entity
	 * 
	 */
	@Test
	public void loadRecipes() {
		Set<Recipe> response = null;
		response = service.loadRecipes();
		// TODO: JUnit - Add assertions to test outputs of operation: loadRecipes
	}

	/**
	 * Operation Unit Test
	 * Save an existing Doctor entity
	 * 
	 */
	@Test
	public void saveRecipeDoctor() {
		// TODO: JUnit - Populate test inputs for operation: saveRecipeDoctor 
		Integer idr_2 = 0;
		Doctor related_doctor = new com.eclinic.domain.Doctor();
		Recipe response = null;
		response = service.saveRecipeDoctor(idr_2, related_doctor);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecipeDoctor
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Recipe entity
	 * 
	 */
	@Test
	public void countRecipes() {
		Integer response = null;
		response = service.countRecipes();
		// TODO: JUnit - Add assertions to test outputs of operation: countRecipes
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Doctor entity
	 * 
	 */
	@Test
	public void deleteRecipeDoctor() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecipeDoctor 
		Integer recipe_idr = 0;
		Integer related_doctor_id = 0;
		Recipe response = null;
		response = service.deleteRecipeDoctor(recipe_idr, related_doctor_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecipeDoctor
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Patient entity
	 * 
	 */
	@Test
	public void deleteRecipePatient() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecipePatient 
		Integer recipe_idr_1 = 0;
		Integer related_patient_id = 0;
		Recipe response = null;
		response = service.deleteRecipePatient(recipe_idr_1, related_patient_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecipePatient
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
