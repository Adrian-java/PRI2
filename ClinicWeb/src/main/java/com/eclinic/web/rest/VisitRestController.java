package com.eclinic.web.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.VisitDAO;
import com.eclinic.visit.VisitCrud;

/**
 * Spring Rest controller that handles CRUD requests for Visit entities
 * 
 */
@Path("/Visit")
@Component("VisitRestController")
public class VisitRestController {

	@Autowired
	private VisitDAO visitDAO;

	@Autowired
	private VisitCrud visitCrud;

	public VisitRestController() {
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

	@GET
	@Path("/new/{visitId}/{patientid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisit(@PathParam("visitId") Integer visitId,
			@PathParam("patientid") String patientId) {
		try {
			visitCrud.addVisit(patientId, visitId);
			return Response.ok(visitDAO.findVisitByPrimaryKey(visitId)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}")
	@DELETE
	public void deleteVisit(@PathParam("visit_id") Integer visit_id) {
		visitCrud.deleteVisit(visit_id);
	}

	@GET
	@Path("/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitCrud.findVisitById(visit_id)).build();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listVisits() throws JsonGenerationException,
			JsonMappingException, IOException {
		return Response.ok(visitCrud.findAllVisit()).build();
	}

	@GET
	@Path("/free/first/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFirstVisitBySpecialization(
			@PathParam("specialization") String specialization) {
		return Response.ok(
				visitCrud.findFirstFreeTermBySpecialization(specialization))
				.build();
	}

	@GET
	@Path("/free/first/doctor/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFirstVisitByDoctor(@PathParam("id") String id) {
		return Response.ok(visitCrud.findFirstFreeTermByDoctor(id)).build();
	}

	@GET
	@Path("/free/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitBySpecialization(
			@PathParam("specialization") String specialization) {
		return Response.ok(
				visitCrud.findFreeTermsBySpecialization(specialization, 10))
				.build();
	}

	@GET
	@Path("/free/doctor/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitByDoctor(@PathParam("id") String id) {
		return Response.ok(visitCrud.findFreeTermsByDoctor(id, 10)).build();
	}

	@GET
	@Path("/date/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByDate(@PathParam("date") Date date) {
		return Response.ok(visitCrud.findVisitByDate(date)).build();
	}

	@GET
	@Path("/free/doctor/{doctor}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByDoctor(@PathParam("doctor") String doctor) {
		return Response.ok(visitCrud.findVisitByDoctor(doctor)).build();
	}

	@GET
	@Path("/patient/{patient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByPatient(@PathParam("patient") String id) {
		return Response.ok(visitCrud.findVisitByPatient(id)).build();
	}

	@GET
	@Path("/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitBySpecialization(
			@PathParam("specialization") String specialization) {
		return Response.ok(visitCrud.findVisitBySpecialization(specialization))
				.build();
	}

	@GET
	@Path("/free/doctor/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByStatus(@PathParam("status") String status) {
		return Response.ok(visitCrud.findVisitByStatus(status)).build();
	}

	@GET
	@Path("/free/doctor/{id}/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findFreeVisitBySpecializationAndDoctor(
			@PathParam("id") String doctor,
			@PathParam("specialization") String specialization) {
		return Response.ok(visitCrud.findFreeTermBySpecializationAndDoctor(specialization, doctor)).build();
	}
	
	@GET
	@Path("/free/first/doctor/{id}/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findFirstFreeVisitBySpecializationAndDoctor(
			@PathParam("id") String doctor,
			@PathParam("specialization") String specialization) {
		return Response.ok(visitCrud.findFirstFreeTermBySpecializationAndDoctor(specialization, doctor)).build();
	}
	
	@GET
	@Path("/specialization/{specialization}/{start_date}/{end_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitBySpecializationAndDate(
			@PathParam("specialization") String specialization,@PathParam("start_date") String startDate,@PathParam("end_date") String endDate) throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse(startDate);
		return Response.ok(visitCrud.findVisitBySpecializationAndDate(specialization,format.parse(startDate), format.parse(endDate))).build();
	}

}
