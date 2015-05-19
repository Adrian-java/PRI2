package com.eclinic.web.rest;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;

import com.eclinic.service.RecipeService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Recipe entities
 * 
 */

@Controller("RecipeRestController")
public class RecipeRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Recipe entities
	 * 
	 */
	@Autowired
	private RecipeDAO recipeDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Recipe entities
	 * 
	 */
	@Autowired
	private RecipeService recipeService;

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadRecipeDoctor(@PathVariable Integer recipe_idr, @PathVariable Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return doctor;
	}

	/**
	 * Get Patient entity by Recipe
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/patient", method = RequestMethod.GET)
	@ResponseBody
	public Patient getRecipePatient(@PathVariable Integer recipe_idr) {
		return recipeDAO.findRecipeByPrimaryKey(recipe_idr).getPatient();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecipeDoctor(@PathVariable Integer recipe_idr, @PathVariable Integer related_doctor_id) {
		recipeService.deleteRecipeDoctor(recipe_idr, related_doctor_id);
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/patient/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecipePatient(@PathVariable Integer recipe_idr, @PathVariable Integer related_patient_id) {
		recipeService.deleteRecipePatient(recipe_idr, related_patient_id);
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/patient/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadRecipePatient(@PathVariable Integer recipe_idr, @PathVariable Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return patient;
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecipe(@PathVariable Integer recipe_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipe_idr);
		recipeService.deleteRecipe(recipe);
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/patient", method = RequestMethod.POST)
	@ResponseBody
	public Patient newRecipePatient(@PathVariable Integer recipe_idr, @RequestBody Patient patient) {
		recipeService.saveRecipePatient(recipe_idr, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newRecipeDoctor(@PathVariable Integer recipe_idr, @RequestBody Doctor doctor) {
		recipeService.saveRecipeDoctor(recipe_idr, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Recipe", method = RequestMethod.POST)
	@ResponseBody
	public Recipe newRecipe(@RequestBody Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return recipeDAO.findRecipeByPrimaryKey(recipe.getIdr());
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/patient", method = RequestMethod.PUT)
	@ResponseBody
	public Patient saveRecipePatient(@PathVariable Integer recipe_idr, @RequestBody Patient patient) {
		recipeService.saveRecipePatient(recipe_idr, patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Show all Recipe entities
	 * 
	 */
	@RequestMapping(value = "/Recipe", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> listRecipes() {
		return new java.util.ArrayList<Recipe>(recipeService.loadRecipes());
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveRecipeDoctor(@PathVariable Integer recipe_idr, @RequestBody Doctor doctor) {
		recipeService.saveRecipeDoctor(recipe_idr, doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Recipe", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe saveRecipe(@RequestBody Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return recipeDAO.findRecipeByPrimaryKey(recipe.getIdr());
	}

	/**
	 * Select an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe loadRecipe(@PathVariable Integer recipe_idr) {
		return recipeDAO.findRecipeByPrimaryKey(recipe_idr);
	}

	/**
	 * Get Doctor entity by Recipe
	 * 
	 */
	@RequestMapping(value = "/Recipe/{recipe_idr}/doctor", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getRecipeDoctor(@PathVariable Integer recipe_idr) {
		return recipeDAO.findRecipeByPrimaryKey(recipe_idr).getDoctor();
	}
}