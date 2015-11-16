package com.eclinic.web.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.service.PatientService;

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
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Patient
	 * entities
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
	 * Save an existing Recipe entity
	 * 
	 */

	/**
	 * Create a new Address entity
	 * 
	 */

	@Path("/{patient_id}/address")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientAddress(
			@PathParam("patient_id") String patient_id, Address address) {
		patientService.savePatientAddress(patient_id, address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(address.getId()))
				.build();
	}

	/**
	 * Select an existing Patient entity
	 * 
	 */

	@GET
	@Path("/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatient(@PathParam("patient_id") String patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id))
				.build();
	}

	/**
	 * Show all Patient entities
	 * 
	 */

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPatients() {
		// ObjectMapper mapper = new ObjectMapper();
		try {
			return Response.ok(
					new ObjectMapper().writeValueAsString(patientService
							.loadPatients())).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}")
	@DELETE
	public void deletePatient(@PathParam("patient_id") String patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id);
		patientService.deletePatient(patient);
	}

	/**
	 * View an existing Address entity
	 * 
	 */

	@GET
	@Path("/{patient_id}/address/{address_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientAddress(
			@PathParam("patient_id") Integer patient_id,
			@PathParam("related_address_id") Integer related_address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(
				related_address_id, -1, -1);

		return Response.ok(address).build();
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
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId()))
				.build();
	}


	/**
	 * Delete an existing Address entity
	 * 
	 */

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/address/{address_id}")
	public Response deletePatientAddress(
			@PathParam("patient_id") String patient_id,
			@PathParam("related_address_id") Integer related_address_id) {
		return Response.ok(
				patientService.deletePatientAddress(patient_id,
						related_address_id)).build();
	}

	/**
	 * Get Address entity by Patient
	 * 
	 */

	@GET
	@Path("/{patient_id}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientAddress(
			@PathParam("patient_id") String patient_id) {
		return Response.ok(
				patientDAO.findPatientByPrimaryKey(patient_id).getAddress())
				.build();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatient(Patient patient) {
		patientService.savePatient(patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId()))
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
	@Path("/{patient_id}/address")
	@PUT
	public Response confirmedPatient(@PathParam("id") String id) {
		Patient p = patientDAO.findPatientByPrimaryKey(id);
		p.setConfirmed(1);
		patientService.savePatient(p);
		Map<String, String> map = new HashMap<String, String>();
		return Response.ok(map.put("status", "zmieniono")).build();
	}
}