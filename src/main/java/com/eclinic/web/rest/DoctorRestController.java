package com.eclinic.web.rest;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.Worker;
import com.eclinic.service.DoctorService;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
 * Spring Rest controller that handles CRUD requests for Doctor entities
 * 
 */

//@Controller("DoctorRestController")
@Component
@Path("/Doctor")
public class DoctorRestController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("wee-dao-context.xml");
	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

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
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Doctor entities
	 * 
	 */
	@Autowired
	private DoctorService doctorService;

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
	
	@PostConstruct
	public void init(){
		doctorDAO =  (DoctorDAO) context.getBean("DoctorDAO");
		
	}
	
	
	/**
	 * Create a new Graphic entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/graphics", method = RequestMethod.POST)
	@ResponseBody
	public Graphic newDoctorGraphics(@PathVariable Integer doctor_id, @RequestBody Graphic graphic) {
		doctorService.saveDoctorGraphics(doctor_id, graphic);
		return graphicDAO.findGraphicByPrimaryKey(graphic.getId());
	}
	*/
	@Path("/{doctor_id}/graphics")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			Graphic graphic) {
		doctorService.saveDoctorGraphics(doctor_id, graphic);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic.getId())).build();
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	/*@RequestMapping(value = "/Doctor/{doctor_id}/visitSchedulers", method = RequestMethod.POST)
	@ResponseBody
	public VisitScheduler newDoctorVisitSchedulers(@PathVariable Integer doctor_id, @RequestBody VisitScheduler visitscheduler) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitscheduler);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());
	}*/
	@Path("/{doctor_id}/visitSchedulers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			VisitScheduler visitScheduler) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitScheduler);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitScheduler.getId())).build();
	}
	

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	/*@RequestMapping(value = "/Doctor/{doctor_id}/graphics", method = RequestMethod.PUT)
	@ResponseBody
	public Graphic saveDoctorGraphics(@PathVariable Integer doctor_id, @RequestBody Graphic graphics) {
		doctorService.saveDoctorGraphics(doctor_id, graphics);
		return graphicDAO.findGraphicByPrimaryKey(graphics.getId());
	}*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address_id}/patients")
	@PUT
	public Response saveDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			Graphic graphics) {
		doctorService.saveDoctorGraphics(doctor_id, graphics);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphics.getId())).build();
	}
	

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctor(@PathVariable Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id);
		doctorService.deleteDoctor(doctor);
	}
*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}")
	@DELETE
	public void deleteDoctor(@PathParam("doctor_id") Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id);
		doctorService.deleteDoctor(doctor);
	}
	/**
	 * Select an existing Doctor entity
	 * 
	 */
	/* @RequestMapping(value = "/Doctor/{doctor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor loadDoctor(@PathVariable Integer doctor_id) {
		return doctorDAO.findDoctorByPrimaryKey(doctor_id);
	}
	*/
	
	@GET
	@Path("/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctor(@PathParam("doctor_id") Integer doctor_id) {
		doctorDAO =  (DoctorDAO) context.getBean("DoctorDAO");
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id)).build();
	}


	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visitSchedulers", method = RequestMethod.PUT)
	@ResponseBody
	public VisitScheduler saveDoctorVisitSchedulers(@PathVariable Integer doctor_id, @RequestBody VisitScheduler visitschedulers) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitschedulers);
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers.getId());
	}
	
	*/
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visitSchedulers")
	@PUT
	public Response saveDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			VisitScheduler visitSchedulers) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitSchedulers);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitSchedulers.getId())).build();
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */
	/* @RequestMapping(value = "/Doctor/{doctor_id}/visitSchedulers/{visitscheduler_id}", method = RequestMethod.GET)
	@ResponseBody
	public VisitScheduler loadDoctorVisitSchedulers(@PathVariable Integer doctor_id, @PathVariable Integer related_visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		return visitscheduler;
	}
	*/
	@GET
	@Path("/{doctor_id}/visitSchedulers/{visitscheduler_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		return Response.ok(visitscheduler).build();
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/recipes/{recipe_idr}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe loadDoctorRecipes(@PathVariable Integer doctor_id, @PathVariable Integer related_recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		return recipe;
	}
	*/
	@GET
	@Path("/{doctor_id}/recipes/{recipe_idr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		return Response.ok(recipe).build();
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/recipes/{recipe_idr}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorRecipes(@PathVariable Integer doctor_id, @PathVariable Integer related_recipes_idr) {
		doctorService.deleteDoctorRecipes(doctor_id, related_recipes_idr);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/recipes/{recipe_idr}")
	public Response deleteDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		return Response.ok(doctorService.deleteDoctorRecipes(doctor_id, related_recipes_idr)).build();
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/patientCards/{patientcard_id}", method = RequestMethod.GET)
	@ResponseBody
	public PatientCard loadDoctorPatientCards(@PathVariable Integer doctor_id, @PathVariable Integer related_patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);

		return patientcard;
	}
	*/
	
	@GET
	@Path("/{doctor_id}/patientCards/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);

		return Response.ok(patientcard).build();
	}

	/**
	 * Show all PatientCard entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/patientCards", method = RequestMethod.GET)
	@ResponseBody
	public List<PatientCard> getDoctorPatientCards(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<PatientCard>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getPatientCards());
	}
	*/
	@GET
	@Path("/{doctor_id}/patientCards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getPatientCards()).build();
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visits/{visit_id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit loadDoctorVisits(@PathVariable Integer doctor_id, @PathVariable Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return visit;
	}
	*/
	
	@GET
	@Path("/{doctor_id}/visits/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return Response.ok(visit).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/workers", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveDoctorWorkers(@PathVariable Integer doctor_id, @RequestBody Worker workers) {
		doctorService.saveDoctorWorkers(doctor_id, workers);
		return workerDAO.findWorkerByPrimaryKey(workers.getId());
	}
	*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/workers")
	@PUT
	public Response saveDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			Worker workers) {
		doctorService.saveDoctorWorkers(doctor_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}
	

	/**
	 * Show all Specialization entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/specializations", method = RequestMethod.GET)
	@ResponseBody
	public List<Specialization> getDoctorSpecializations(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<Specialization>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSpecializations());
	}
	*/
	
	@GET
	@Path("/{doctor_id}/specializations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSpecializations()).build();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/patientCards/{patientcard_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorPatientCards(@PathVariable Integer doctor_id, @PathVariable Integer related_patientcards_id) {
		doctorService.deleteDoctorPatientCards(doctor_id, related_patientcards_id);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/patientCards/{patientcard_id}")
	public Response deleteDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		return Response.ok(doctorService.deleteDoctorPatientCards(doctor_id, related_patientcards_id)).build();
	}

	/**
	 * Show all Graphic entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/graphics", method = RequestMethod.GET)
	@ResponseBody
	public List<Graphic> getDoctorGraphics(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<Graphic>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getGraphics());
	}
	*/
	
	@GET
	@Path("/{doctor_id}/graphics")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorGraphics(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getGraphics()).build();
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/specializations/{specialization_id}", method = RequestMethod.GET)
	@ResponseBody
	public Specialization loadDoctorSpecializations(@PathVariable Integer doctor_id, @PathVariable Integer related_specializations_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specializations_id, -1, -1);

		return specialization;
	}
	*/
	@GET
	@Path("/{doctor_id}/specializations/{specialization_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_specializations_id") Integer related_specializations_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specializations_id, -1, -1);

		return Response.ok(specialization).build();
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/sickLeaves/{sickleave_id}", method = RequestMethod.GET)
	@ResponseBody
	public SickLeave loadDoctorSickLeaves(@PathVariable Integer doctor_id, @PathVariable Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return sickleave;
	}
	*/
	@GET
	@Path("/{doctor_id}/sickLeaves/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return Response.ok(sickleave).build();
	}
	/**
	 * Create a new Recipe entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/recipes", method = RequestMethod.POST)
	@ResponseBody
	public Recipe newDoctorRecipes(@PathVariable Integer doctor_id, @RequestBody Recipe recipe) {
		doctorService.saveDoctorRecipes(doctor_id, recipe);
		return recipeDAO.findRecipeByPrimaryKey(recipe.getIdr());
	}
	*/
	
	@Path("/{doctor_id}/recipes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			Recipe recipe) {
		doctorService.saveDoctorRecipes(doctor_id, recipe);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe.getIdr())).build();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveDoctorVisits(@PathVariable Integer doctor_id, @RequestBody Visit visits) {
		doctorService.saveDoctorVisits(doctor_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
	}
	*/

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visits")
	@PUT
	public Response saveDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			Visit visits) {
		doctorService.saveDoctorVisits(doctor_id, visits);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visits.getId())).build();
	}
	/**
	 * Create a new Specialization entity
	 * 
	 */
	/*	@RequestMapping(value = "/Doctor/{doctor_id}/specializations", method = RequestMethod.POST)
	@ResponseBody
	public Specialization newDoctorSpecializations(@PathVariable Integer doctor_id, @RequestBody Specialization specialization) {
		doctorService.saveDoctorSpecializations(doctor_id, specialization);
		return specializationDAO.findSpecializationByPrimaryKey(specialization.getId());
	}
	*/
	
	@Path("/{doctor_id}/specializations")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			Specialization specialization) {
		doctorService.saveDoctorSpecializations(doctor_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/patientCards", method = RequestMethod.POST)
	@ResponseBody
	public PatientCard newDoctorPatientCards(@PathVariable Integer doctor_id, @RequestBody PatientCard patientcard) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcard);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());
	}
	*/
	
	@Path("/{doctor_id}/patientCards")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			PatientCard patientcard) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

	/**
	 * Show all Doctor entities
	 * 
	 */
/*	@RequestMapping(value = "/Doctor", method = RequestMethod.GET)
	@ResponseBody
	public List<Doctor> listDoctors() {
		return new java.util.ArrayList<Doctor>(doctorService.loadDoctors());
	}
	*/
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listDoctors() {
		return  Response.ok(doctorService.loadDoctors()).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor newDoctor(@RequestBody Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}
	*/
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctor( Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}


	/**
	 * Delete an existing Specialization entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/specializations/{specialization_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorSpecializations(@PathVariable Integer doctor_id, @PathVariable Integer related_specializations_id) {
		doctorService.deleteDoctorSpecializations(doctor_id, related_specializations_id);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/specializations/{specialization_id}")
	public Response deleteDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_specializations_id") Integer related_specializations_id) {
		return Response.ok(doctorService.deleteDoctorSpecializations(doctor_id, related_specializations_id)).build();
	}
	

	/**
	 * Save an existing Specialization entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/specializations", method = RequestMethod.PUT)
	@ResponseBody
	public Specialization saveDoctorSpecializations(@PathVariable Integer doctor_id, @RequestBody Specialization specializations) {
		doctorService.saveDoctorSpecializations(doctor_id, specializations);
		return specializationDAO.findSpecializationByPrimaryKey(specializations.getId());
	}*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/specializations")
	@PUT
	public Response saveDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			Specialization specializations) {
		doctorService.saveDoctorSpecializations(doctor_id, specializations);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specializations.getId())).build();
	}

	/**
	 * Show all Recipe entities by Doctor
	 * 
	 */
	/*@RequestMapping(value = "/Doctor/{doctor_id}/recipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getDoctorRecipes(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<Recipe>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getRecipes());
	}*/
	
	@GET
	@Path("/{doctor_id}/recipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorRecipes(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getRecipes()).build();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/sickLeaves", method = RequestMethod.POST)
	@ResponseBody
	public SickLeave newDoctorSickLeaves(@PathVariable Integer doctor_id, @RequestBody SickLeave sickleave) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleave);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());
	}
	*/
	
	@Path("/{doctor_id}/sickLeaves")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			SickLeave sickleave) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visits/{visit_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorVisits(@PathVariable Integer doctor_id, @PathVariable Integer related_visits_id) {
		doctorService.deleteDoctorVisits(doctor_id, related_visits_id);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visits/{visit_id}")
	public Response deleteDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(doctorService.deleteDoctorVisits(doctor_id, related_visits_id)).build();
	}

	/**
	 * View an existing Graphic entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/graphics/{graphic_id}", method = RequestMethod.GET)
	@ResponseBody
	public Graphic loadDoctorGraphics(@PathVariable Integer doctor_id, @PathVariable Integer related_graphics_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		return graphic;
	}
	*/
	@GET
	@Path("/{doctor_id}/graphics/{graphic_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_graphics_id") Integer related_graphics_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		return Response.ok(graphic).build();
	}


	/**
	 * Create a new Visit entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visits", method = RequestMethod.POST)
	@ResponseBody
	public Visit newDoctorVisits(@PathVariable Integer doctor_id, @RequestBody Visit visit) {
		doctorService.saveDoctorVisits(doctor_id, visit);
		return visitDAO.findVisitByPrimaryKey(visit.getId());
	}
	*/
	
	@Path("/{doctor_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			Visit visit) {
		doctorService.saveDoctorVisits(doctor_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/patientCards", method = RequestMethod.PUT)
	@ResponseBody
	public PatientCard saveDoctorPatientCards(@PathVariable Integer doctor_id, @RequestBody PatientCard patientcards) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcards);
		return patientCardDAO.findPatientCardByPrimaryKey(patientcards.getId());
	}
	*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/patientCards")
	@PUT
	public Response saveDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			PatientCard patientcards) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcards);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcards.getId())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor", method = RequestMethod.PUT)
	@ResponseBody
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return doctorDAO.findDoctorByPrimaryKey(doctor.getId());
	}
	*/
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveDoctor(Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Show all VisitScheduler entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visitSchedulers", method = RequestMethod.GET)
	@ResponseBody
	public List<VisitScheduler> getDoctorVisitSchedulers(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<VisitScheduler>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisitSchedulers());
	}
	*/
	
	@GET
	@Path("/{doctor_id}/visitSchedulers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisitSchedulers()).build();
	}


	/**
	 * View an existing Worker entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/workers/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadDoctorWorkers(@PathVariable Integer doctor_id, @PathVariable Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return worker;
	}
	*/
	
	@GET
	@Path("/{doctor_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);
		return Response.ok(worker).build();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/sickLeaves/{sickleave_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorSickLeaves(@PathVariable Integer doctor_id, @PathVariable Integer related_sickleaves_id) {
		doctorService.deleteDoctorSickLeaves(doctor_id, related_sickleaves_id);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/sickLeaves/{sickleave_id}")
	public Response deleteDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		return Response.ok(doctorService.deleteDoctorSickLeaves(doctor_id, related_sickleaves_id)).build();
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/recipes", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe saveDoctorRecipes(@PathVariable Integer doctor_id, @RequestBody Recipe recipes) {
		doctorService.saveDoctorRecipes(doctor_id, recipes);
		return recipeDAO.findRecipeByPrimaryKey(recipes.getIdr());
	}
	*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/recipes")
	@PUT
	public Response saveDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			Recipe recipes) {
		doctorService.saveDoctorRecipes(doctor_id, recipes);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipes.getIdr())).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/workers", method = RequestMethod.POST)
	@ResponseBody
	public Worker newDoctorWorkers(@PathVariable Integer doctor_id, @RequestBody Worker worker) {
		doctorService.saveDoctorWorkers(doctor_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}
	*/
	@Path("/{doctor_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			Worker worker) {
		doctorService.saveDoctorWorkers(doctor_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/graphics/{graphic_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorGraphics(@PathVariable Integer doctor_id, @PathVariable Integer related_graphics_id) {
		doctorService.deleteDoctorGraphics(doctor_id, related_graphics_id);
	}
	*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/graphics/{graphic_id}")
	public Response deleteDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_graphics_id") Integer related_graphics_id) {
		return Response.ok(doctorService.deleteDoctorGraphics(doctor_id, related_graphics_id)).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	/*@RequestMapping(value = "/Doctor/{doctor_id}/workers/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorWorkers(@PathVariable Integer doctor_id, @PathVariable Integer related_workers_id) {
		doctorService.deleteDoctorWorkers(doctor_id, related_workers_id);
	}*/
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/workers/{worker_id}")
	public Response deleteDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(doctorService.deleteDoctorWorkers(doctor_id, related_workers_id)).build();
	}

	/**
	 * Show all Visit entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visits", method = RequestMethod.GET)
	@ResponseBody
	public List<Visit> getDoctorVisits(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<Visit>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisits());
	}
	*/
	
	@GET
	@Path("/{doctor_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorVisits(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisits()).build();
	}

	

	/**
	 * Show all Worker entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/workers", method = RequestMethod.GET)
	@ResponseBody
	public List<Worker> getDoctorWorkers(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<Worker>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getWorkers());
	}
	*/
	
	
	@GET
	@Path("/{doctor_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorWorkers(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getWorkers()).build();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/sickLeaves", method = RequestMethod.PUT)
	@ResponseBody
	public SickLeave saveDoctorSickLeaves(@PathVariable Integer doctor_id, @RequestBody SickLeave sickleaves) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleaves);
		return sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId());
	}
	*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/sickLeaves")
	@PUT
	public Response saveDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			SickLeave sickleaves) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleaves);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId())).build();
	}


	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/visitSchedulers/{visitscheduler_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoctorVisitSchedulers(@PathVariable Integer doctor_id, @PathVariable Integer related_visitschedulers_id) {
		doctorService.deleteDoctorVisitSchedulers(doctor_id, related_visitschedulers_id);
	}
	*/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visitSchedulers/{visitscheduler_id}")
	public Response deleteDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		return Response.ok(doctorService.deleteDoctorVisitSchedulers(doctor_id, related_visitschedulers_id)).build();
	}

	/**
	 * Show all SickLeave entities by Doctor
	 * 
	 */
/*	@RequestMapping(value = "/Doctor/{doctor_id}/sickLeaves", method = RequestMethod.GET)
	@ResponseBody
	public List<SickLeave> getDoctorSickLeaves(@PathVariable Integer doctor_id) {
		return new java.util.ArrayList<SickLeave>(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSickLeaves());
	}
	*/
	
	@GET
	@Path("/{doctor_id}/sickLeaves")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSickLeaves()).build();
	}
}