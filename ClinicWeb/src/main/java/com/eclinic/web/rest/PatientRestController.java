package com.eclinic.web.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
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

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.service.PatientService;
import com.eclinic.user.mangament.patient.PatientCrud;

/**
 * Spring Rest controller that handles CRUD requests for Patient entities
 * 
 */
@Path("/Patient")
@Component("PatientRestController")
public class PatientRestController {

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private PatientDAO patientDAO;

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientCrud patientCrud;

	public PatientRestController() {
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
	@Path("/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatient(@PathParam("patient_id") String patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id)).build();
	}

	/**
	 * Show all Patient entities
	 * 
	 */

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPatient() throws JsonGenerationException,
			JsonMappingException, IOException {
		return Response.ok(
				new ObjectMapper().writeValueAsString(patientService.loadPatients())).build();
	}

	/**
	 * Get Address entity by Patient
	 * 
	 */

	@GET
	@Path("/{patient_id}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientAddress(@PathParam("patient_id") String patient_id) {
		return Response.ok(
				patientDAO.findPatientByPrimaryKey(patient_id).getAddress())
				.build();
	}

	/**
	 * Save an existing Address entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/address")
	@PUT
	public Response savePatientAddress(
			@PathParam("patient_id") String patient_id, Address address) {
		patientService.savePatientAddress(patient_id, address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(address.getId()))
				.build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/confirm/id")
	@PUT
	public Response confirmedPatient(@PathParam("id") String id) {
		Patient p = patientDAO.findPatientByPrimaryKey(id);
		p.setConfirmed(1);
		patientService.savePatient(p);
		Map<String, String> map = new HashMap<String, String>();
		return Response.ok(map.put("status", "zmieniono")).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(@PathParam("id") String id) {
		return Response.ok(patientCrud.getPatientById(id)).build();
	}

}