package com.eclinic.web.rest;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Worker;
import com.eclinic.service.PatientService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Patient entities
 * 
 */
@Path("/Patient")
@Component("PatientRestController")
public class PatientRestController {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

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
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Patient entities
	 * 
	 */
	@Autowired
	private PatientService patientService;

	public PatientRestController() {
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
	 * Save an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/recipes", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe savePatientRecipes(@PathVariable Integer patient_id, @RequestBody Recipe recipes) {
		patientService.savePatientRecipes(patient_id, recipes);
		return recipeDAO.findRecipeByPrimaryKey(recipes.getIdr());
	}

	/**
	 * Show all SickLeave entities by Patient
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/sickLeaves", method = RequestMethod.GET)
	@ResponseBody
	public List<SickLeave> getPatientSickLeaves(@PathVariable Integer patient_id) {
		return new java.util.ArrayList<SickLeave>(patientDAO.findPatientByPrimaryKey(patient_id).getSickLeaves());
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/sickLeaves/{sickleave_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientSickLeaves(@PathVariable Integer patient_id, @PathVariable Integer related_sickleaves_id) {
		patientService.deletePatientSickLeaves(patient_id, related_sickleaves_id);
	}

	/**
	 * Create a new Address entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/address", method = RequestMethod.POST)
	@ResponseBody
	public Address newPatientAddress(@PathVariable Integer patient_id, @RequestBody Address address) {
		patientService.savePatientAddress(patient_id, address);
		return addressDAO.findAddressByPrimaryKey(address.getId());
	}

	/**
	 * Select an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}", method = RequestMethod.GET)
	@ResponseBody
	public Patient loadPatient(@PathVariable Integer patient_id) {
		return patientDAO.findPatientByPrimaryKey(patient_id);
	}

	/**
	 * Show all Worker entities by Patient
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/workers", method = RequestMethod.GET)
	@ResponseBody
	public List<Worker> getPatientWorkers(@PathVariable Integer patient_id) {
		return new java.util.ArrayList<Worker>(patientDAO.findPatientByPrimaryKey(patient_id).getWorkers());
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/sickLeaves", method = RequestMethod.PUT)
	@ResponseBody
	public SickLeave savePatientSickLeaves(@PathVariable Integer patient_id, @RequestBody SickLeave sickleaves) {
		patientService.savePatientSickLeaves(patient_id, sickleaves);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId());
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/patientCards/{patientcard_id}", method = RequestMethod.GET)
	@ResponseBody
	public PatientCard loadPatientPatientCards(@PathVariable Integer patient_id, @PathVariable Integer related_patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);

		return patientcard;
	}

	/**
	 * Show all Patient entities
	 * 
	 */
	@RequestMapping(value = "/Patient", method = RequestMethod.GET)
	@ResponseBody
	public List<Patient> listPatients() {
		return new java.util.ArrayList<Patient>(patientService.loadPatients());
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/sickLeaves/{sickleave_id}", method = RequestMethod.GET)
	@ResponseBody
	public SickLeave loadPatientSickLeaves(@PathVariable Integer patient_id, @PathVariable Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return sickleave;
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/recipes", method = RequestMethod.POST)
	@ResponseBody
	public Recipe newPatientRecipes(@PathVariable Integer patient_id, @RequestBody Recipe recipe) {
		patientService.savePatientRecipes(patient_id, recipe);
		return recipeDAO.findRecipeByPrimaryKey(recipe.getIdr());
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatient(@PathVariable Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id);
		patientService.deletePatient(patient);
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/workers/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadPatientWorkers(@PathVariable Integer patient_id, @PathVariable Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return worker;
	}

	/**
	 * View an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/address/{address_id}", method = RequestMethod.GET)
	@ResponseBody
	public Address loadPatientAddress(@PathVariable Integer patient_id, @PathVariable Integer related_address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(related_address_id, -1, -1);

		return address;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/workers", method = RequestMethod.PUT)
	@ResponseBody
	public Worker savePatientWorkers(@PathVariable Integer patient_id, @RequestBody Worker workers) {
		patientService.savePatientWorkers(patient_id, workers);
		return workerDAO.findWorkerByPrimaryKey(workers.getId());
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/patientCards", method = RequestMethod.POST)
	@ResponseBody
	public PatientCard newPatientPatientCards(@PathVariable Integer patient_id, @RequestBody PatientCard patientcard) {
		patientService.savePatientPatientCards(patient_id, patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/workers", method = RequestMethod.POST)
	@ResponseBody
	public Worker newPatientWorkers(@PathVariable Integer patient_id, @RequestBody Worker worker) {
		patientService.savePatientWorkers(patient_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/sickLeaves", method = RequestMethod.POST)
	@ResponseBody
	public SickLeave newPatientSickLeaves(@PathVariable Integer patient_id, @RequestBody SickLeave sickleave) {
		patientService.savePatientSickLeaves(patient_id, sickleave);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/recipes/{recipe_idr}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientRecipes(@PathVariable Integer patient_id, @PathVariable Integer related_recipes_idr) {
		patientService.deletePatientRecipes(patient_id, related_recipes_idr);
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/recipes/{recipe_idr}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe loadPatientRecipes(@PathVariable Integer patient_id, @PathVariable Integer related_recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		return recipe;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePatient(Patient patient) {
		patientService.savePatient(patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}


	/**
	 * Show all Recipe entities by Patient
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/recipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getPatientRecipes(@PathVariable Integer patient_id) {
		return new java.util.ArrayList<Recipe>(patientDAO.findPatientByPrimaryKey(patient_id).getRecipes());
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/workers/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientWorkers(@PathVariable Integer patient_id, @PathVariable Integer related_workers_id) {
		patientService.deletePatientWorkers(patient_id, related_workers_id);
	}

	/**
	 * Show all PatientCard entities by Patient
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/patientCards", method = RequestMethod.GET)
	@ResponseBody
	public List<PatientCard> getPatientPatientCards(@PathVariable Integer patient_id) {
		return new java.util.ArrayList<PatientCard>(patientDAO.findPatientByPrimaryKey(patient_id).getPatientCards());
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/patientCards", method = RequestMethod.PUT)
	@ResponseBody
	public PatientCard savePatientPatientCards(@PathVariable Integer patient_id, @RequestBody PatientCard patientcards) {
		patientService.savePatientPatientCards(patient_id, patientcards);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcards.getId());
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/patientCards/{patientcard_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientPatientCards(@PathVariable Integer patient_id, @PathVariable Integer related_patientcards_id) {
		patientService.deletePatientPatientCards(patient_id, related_patientcards_id);
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/address/{address_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePatientAddress(@PathVariable Integer patient_id, @PathVariable Integer related_address_id) {
		patientService.deletePatientAddress(patient_id, related_address_id);
	}

	/**
	 * Get Address entity by Patient
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/address", method = RequestMethod.GET)
	@ResponseBody
	public Address getPatientAddress(@PathVariable Integer patient_id) {
		return patientDAO.findPatientByPrimaryKey(patient_id).getAddress();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping(value = "/Patient", method = RequestMethod.POST)
	@ResponseBody
	public Patient newPatient(@RequestBody Patient patient) {
		patientService.savePatient(patient);
		return patientDAO.findPatientByPrimaryKey(patient.getId());
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@RequestMapping(value = "/Patient/{patient_id}/address", method = RequestMethod.PUT)
	@ResponseBody
	public Address savePatientAddress(@PathVariable Integer patient_id, @RequestBody Address address) {
		patientService.savePatientAddress(patient_id, address);
		return addressDAO.findAddressByPrimaryKey(address.getId());
	}
}