package com.eclinic.web.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

import com.eclinic.dao.DoctorDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.service.DoctorService;
import com.eclinic.user.mangament.doctor.DoctorCrud;

/**
 * Spring Rest controller that handles CRUD requests for Doctor entities
 * 
 */

@Path("/Doctor")
@Component("DoctorRestController")
public class DoctorRestController {

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DoctorCrud doctorCrud;

	public DoctorRestController() {
	}

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

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}")
	@DELETE
	public void deleteDoctor(@PathParam("doctor_id") String doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id);
		doctorService.deleteDoctor(doctor);
	}

	/**
	 * Select an existing Doctor entity
	 * 
	 */

	@GET
	@Path("/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctor(@PathParam("doctor_id") String doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id)).build();
	}

	@GET
	@Path("/{doctor_id}/specializations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorSpecializations(
			@PathParam("doctor_id") String doctor_id) {
		return Response.ok(
				doctorDAO.findDoctorByPrimaryKey(doctor_id)
						.getSpecializations()).build();
	}


	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listDoctors() throws JsonGenerationException,
			JsonMappingException, IOException {
		return Response.ok(
				new ObjectMapper().writeValueAsString(doctorService
						.loadDoctors())).build();
	}

	@GET
	@Path("/list/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listDoctorsBySpecialization()
			throws JsonGenerationException, JsonMappingException, IOException {
		return Response.ok(
				new ObjectMapper().writeValueAsString(doctorService
						.loadDoctors())).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visitSchedulers/{visitscheduler_id}")
	public Response deleteDoctorVisitSchedulers(
			@PathParam("doctor_id") String doctor_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		return Response.ok(
				doctorService.deleteDoctorVisitSchedulers(doctor_id,
						related_visitschedulers_id)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorById(@PathParam("id") String id) {
		return Response.ok(doctorCrud.getDoctorById(id)).build();
	}

	@GET
	@Path("/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorsBySpecialization(
			@PathParam("specialization") String specialization) {
		return Response.ok(
				doctorCrud.getDoctorsBySpecialization(specialization)).build();
	}

}