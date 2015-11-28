package com.eclinic.web.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.service.VisitSchedulerService;
import com.eclinic.visit.VisitCrud;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;

/**
 * Spring Rest controller that handles CRUD requests for VisitScheduler entities
 * 
 */
@Path("/VisitScheduler")
@Component("VisitSchedulerRestController")
public class VisitSchedulerRestController {

	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	@Autowired
	private VisitSchedulerService visitSchedulerService;

	@Autowired
	private VisitCrud visitCrud;

	public VisitSchedulerRestController() {
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register
		// static
		// property
		// editors.
		binder.registerCustomEditor(java.util.Calendar.class,
				new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(
				byte[].class,
				new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						false));
		binder.registerCustomEditor(Boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						true));
		binder.registerCustomEditor(java.math.BigDecimal.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class,
				new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class,
				new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Long.class, true));
		binder.registerCustomEditor(Double.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Double.class, true));
	}

	@GET
	@Path("/{visitscheduler_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitScheduler(
			@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		return Response.ok(
				visitSchedulerDAO
						.findVisitSchedulerByPrimaryKey(visitscheduler_id))
				.build();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}")
	@DELETE
	public void deleteVisitScheduler(
			@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO
				.findVisitSchedulerByPrimaryKey(visitscheduler_id);
		visitSchedulerService.deleteVisitScheduler(visitscheduler);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listVisitSchedulers() throws JsonGenerationException,
			JsonMappingException, IOException {
		return Response.ok(
				new ObjectMapper().writeValueAsString(visitSchedulerService
						.loadVisitSchedulers())).build();
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVisitScheduler(VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return Response.ok(
				visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler
						.getId())).build();
	}

	@GET
	@Path("/{visitscheduler_id}/specialization")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitSchedulerSpecialization(
			@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		return Response.ok(
				visitSchedulerDAO.findVisitSchedulerByPrimaryKey(
						visitscheduler_id).getSpecialization()).build();
	}

	@POST
	@Path("/scheduler/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVisitScheduler(NewVisitSchedulerMapper vsm) {
		VisitScheduler addVisitScheduler = visitCrud.addVisitScheduler(vsm);
		return Response.ok(addVisitScheduler).build();
	}

	@GET
	@Path("/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitSchedulerBySpecialization(
			@PathParam("specialization") String specialization) {
		return Response.ok(
				visitCrud.findVisitSchedulerBySpecialization(specialization))
				.build();
	}
	
	@GET
	@Path("/doctor/{doctor}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitSchedulerByDoctor(
			@PathParam("doctor") String doctor) {
		return Response.ok(
				visitCrud.findVisitSchedulerByDoctor(doctor))
				.build();
	}
}
