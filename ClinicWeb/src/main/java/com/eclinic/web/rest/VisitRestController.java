package com.eclinic.web.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Visit;
import com.eclinic.model.VisitEdit;
import com.eclinic.visit.VisitCrud;
import com.eclinic.visit.mapper.NewVisitMapper;

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

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisit(NewVisitMapper newVisit) {
		try {
			Visit addVisit = visitCrud.addVisit(newVisit);
			return Response.ok(new ObjectMapper().writeValueAsString(addVisit))
					.build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editVisit(VisitEdit edit) {
		try {
			Visit addVisit = visitCrud.editVisit(edit);
			return Response.ok()
					.build();
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
	@Path("/all/patient/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVisitByPatient(@PathParam("id") String id) {
		return Response.ok(visitCrud.getAllVisitByPatient(id)).build();
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
	@Path("/doctor/{doctor}/date/{start_date}/{stop_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByDoctorAndDate(
			@PathParam("doctor") String doctor,
			@PathParam("start_date") String start,
			@PathParam("stop_date") String stop) throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return Response.ok(
				visitCrud.findVisitByDoctor(doctor, format.parse(start),
						format.parse(stop))).build();
	}

	@GET
	@Path("/doctor/{doctor}/specialization/{specialization}/date/{start_date}/{stop_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitByDoctor(@PathParam("doctor") String doctor,
			@PathParam("specialization") String specialization,
			@PathParam("start_date") String start,
			@PathParam("stop_date") String stop) throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return Response
				.ok(visitCrud.findVisitByDoctorAndSpecialization(doctor,
						specialization, format.parse(start), format.parse(stop)))
				.build();
	}

	@GET
	@Path("/all/date/{start_date}/{stop_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllVisitByDate(@PathParam("start_date") String start,
			@PathParam("stop_date") String stop) throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return Response.ok(
				visitCrud.findAllVisitByDate(format.parse(start),
						format.parse(stop))).build();
	}

	@GET
	@Path("/patient/done/{patient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findDoneVisitByPatient(@PathParam("patient") String id) {
		return Response.ok(visitCrud.findDoneVisitByPatient(id)).build();
	}
	
	@GET
	@Path("/patient/plane/{patient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findPlaneVisitByPatient(@PathParam("patient") String id) {
		return Response.ok(visitCrud.findPlaneVisitByPatient(id)).build();
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
		return Response.ok(
				visitCrud.findFreeTermBySpecializationAndDoctor(specialization,
						doctor)).build();
	}

	@GET
	@Path("/free/first/doctor/{id}/specialization/{specialization}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findFirstFreeVisitBySpecializationAndDoctor(
			@PathParam("id") String doctor,
			@PathParam("specialization") String specialization) {
		return Response.ok(
				visitCrud.findFirstFreeTermBySpecializationAndDoctor(
						specialization, doctor)).build();
	}

	@GET
	@Path("/specialization/{specialization}/{start_date}/{end_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitBySpecializationAndDate(
			@PathParam("specialization") String specialization,
			@PathParam("start_date") String startDate,
			@PathParam("end_date") String endDate) throws ParseException {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse(startDate);
		return Response.ok(
				visitCrud.findVisitBySpecializationAndDate(specialization,
						format.parse(startDate), format.parse(endDate)))
				.build();
	}
	
	@GET
	@Path("/info/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVisitById(
			@PathParam("id") Integer id) throws ParseException {
		return Response.ok(
				visitCrud.findVisitById(id)).build();
	}
}
