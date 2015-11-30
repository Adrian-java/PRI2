package com.eclinic.web.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Permission;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.view.DoctorView;
import com.eclinic.domain.view.PatientView;
import com.eclinic.domain.view.SystemUserPermissionView;
import com.eclinic.service.DoctorService;
import com.eclinic.service.PatientService;
import com.eclinic.service.ReceptionistService;
import com.eclinic.service.SessionBean;
import com.eclinic.service.SystemUserService;
import com.eclinic.user.mangament.doctor.DoctorCrud;
import com.eclinic.user.mangament.patient.PatientCrud;
import com.eclinic.user.mangament.receptionist.ReceptionistCrud;

/**
 * Spring Rest controller that handles CRUD requests for SystemUser entities
 * 
 */
@Path("/SystemUser")
@Component("SystemUserRestController")
public class SystemUserRestController {

	@Autowired
	private PatientCrud patientCrud;

	@Autowired
	private DoctorCrud doctorCrud;
	
	@Autowired 
	private ReceptionistCrud receptonistCrud;
	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	@Autowired
	private PatientDAO patientDao;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemUser
	 * entities
	 * 
	 */
	@Autowired
	private SystemUserService systemUserService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ReceptionistService receptionistService;

	@Autowired
	private DoctorDAO doctorDao;

	@Autowired
	private SessionBean sessionBean;
	
	@Autowired
	private ReceptionistDAO receptionistDao;

	public SystemUserRestController() {
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
	 * Return actually SystemUser role
	 * 
	 */

	@GET
	@Path("/role/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoleById(@PathParam("pesel") String pesel) {
		SystemUser s = systemUserDAO.findSystemUserById(pesel);
		Map<String, String> map = new HashMap<String, String>();
		map.put("role", s.getRole());
		return Response.ok(map).build();
	}
	
	/**
	 * Return actually SystemUser role
	 * 
	 */

	@GET
	@Path("/role")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoggedRole() {
		if(sessionBean.getLoggedSystemUser()==null){
			return Response.noContent().build();
		}
		Map<String,String> m = new TreeMap<String,String>();
		m.put("role",sessionBean.getLoggedSystemUser().getRole());
		return Response.ok(m).build();
	}

	/**
	 * Return actually SystemUser
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * 
	 */

	@GET
	@Path("/get/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSystemUserById(@PathParam("pesel") String pesel)
			throws JsonGenerationException, JsonMappingException, IOException {
		SystemUser s = systemUserDAO.findSystemUserById(pesel);
		return Response.ok(
				new ObjectMapper()
						.configure(Feature.FAIL_ON_EMPTY_BEANS, false)
						.writeValueAsString(s)).build();
		// return Response.ok(s).build();
	}

	/**
	 * View an existing Permission entity
	 * 
	 */

	@GET
	@Path("/{systemuser_id}/permissions/{permission_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUserPermissions(
			@PathParam("systemuser_id") Integer systemuser_id,
			@PathParam("related_permissions_id") Integer related_permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(
				related_permissions_id, -1, -1);
		return Response.ok(permission).build();
	}

	@GET
	@Path("/permissions/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUserPermissionsById(
			@PathParam("pesel") String pesel) {
		Set<SystemUserPermissionView> showPermissionById = patientCrud
				.showPermissionById(pesel);
		return Response.ok(showPermissionById).build();
	}


//	/**
//	 * Create a new Permission entity
//	 * 
//	 * 
//	 */
//
//	@Path("/{systemuser_id}/permissions")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response newSystemUserPermissions(
//			@PathParam("systemuser_id") Integer systemuser_id,
//			Permission permission) {
//		systemUserService.deleteSystemUserSystemUserPermission(systemuser_id, permission);
//		return Response.ok(
//				permissionDAO.findPermissionByPrimaryKey(permission.getId()))
//				.build();
//	}

	/**
	 * Select an existing SystemUser entity
	 * 
	 */

	@GET
	@Path("/{systemuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUser(
			@PathParam("systemuser_id") String systemuser_id) {
		return Response.ok(
				systemUserDAO.findSystemUserByPrimaryKey(systemuser_id))
				.build();
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemUser(SystemUser systemuser) {
		String i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 * @throws IOException
	 * @throws DataAccessException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * 
	 */

	@PUT
	@Path("/savePatient/{pesel}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemUserPatient(Patient patient,
			@PathParam("pesel") String pesel) throws JsonGenerationException,
			JsonMappingException, DataAccessException, IOException {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		String id = su.getPatient().getId();
		Patient p = patientDao.findPatientById(id);
		if (p instanceof HibernateProxy) {
			// Unwrap Proxy;
			// -- loading, if necessary.
			HibernateProxy proxy = (HibernateProxy) p;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			p = (Patient) li.getImplementation();
		}
		p.copy(patient);
		String i = patientService.savePatient(p);
		return Response.ok(
				new ObjectMapper()
						.configure(Feature.FAIL_ON_EMPTY_BEANS, false)
						.writeValueAsString(patientDao.findPatientById(i)))
				.build();
	}

	@PUT
	@Path("/saveDoctor/{pesel}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemUserDoctor(Doctor doctor,
			@PathParam("pesel") String pesel) throws JsonGenerationException,
			JsonMappingException, IOException {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		String id = su.getDoctor().getId();
		Doctor d = doctorDao.findDoctorById(id);
		if (d instanceof HibernateProxy) {
			// Unwrap Proxy;
			// -- loading, if necessary.
			HibernateProxy proxy = (HibernateProxy) d;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			d = (Doctor) li.getImplementation();
		}
		d.copy(doctor);
		String i = doctorService.saveDoctor(d);
		return Response.ok(
				new ObjectMapper()
						.configure(Feature.FAIL_ON_EMPTY_BEANS, false)
						.writeValueAsString(d)).build();
	}

	@PUT
	@Path("/saveReceptionist/{pesel}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemUserReceptionist(Receptionist receptionist,
			@PathParam("pesel") String pesel) throws JsonGenerationException,
			JsonMappingException, DataAccessException, IOException {
		SystemUser su = systemUserDAO.findSystemUserById(pesel);
		String id = su.getReceptionist().getId();
		Receptionist r = receptionistDao.findReceptionistById(id);

		if (r instanceof HibernateProxy) {
			// Unwrap Proxy;
			// -- loading, if necessary.
			HibernateProxy proxy = (HibernateProxy) r;
			LazyInitializer li = proxy.getHibernateLazyInitializer();
			r = (Receptionist) li.getImplementation();
		}

		r.copy(receptionist);
		String i = receptionistService.saveReceptionist(r);
		return Response
				.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
						false).writeValueAsString(
						receptionistDao.findReceptionistByPrimaryKey(i)))
				.build();
	}

	@PUT
	@Path("/saveAdmin/{pesel}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAdmin(SystemUser systemuser,
			@PathParam("pesel") String pesel) {
		if (systemuser.getDoctor() != null || systemuser.getPatient() != null
				|| systemuser.getReceptionist() != null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		String i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	@GET
	@Path("/changed/{pesel}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmedPatient(@PathParam("pesel") String pesel)
			throws JsonGenerationException, JsonMappingException,
			DataAccessException, IOException {
		SystemUser s = systemUserDAO.findSystemUserById(pesel);
		if (s != null && s.getPatient() != null) {
			s.getPatient().setConfirmed(1);
			String i = systemUserService.saveSystemUser(s);

			return Response.ok(
					new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
							false).writeValueAsString(
							systemUserDAO.findSystemUserByPrimaryKey(i)))
					.build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */

	@POST
	@Path("/newPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatient(SystemUser systemuser) {
		return patientCrud.addPatient(systemuser);
	}

	@POST
	@Path("/newDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctor(SystemUser systemUser) {
 		return doctorCrud.addDoctor(systemUser);
	}

	@POST
	@Path("/newReceptionist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserReceptionist(SystemUser systemuser) {
			return receptonistCrud.addReceptionist(systemuser);
	}

	@POST
	@Path("/newAdmin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAdmin(SystemUser systemuser) {
			if (systemuser.getDoctor() != null || systemuser.getPatient() != null
					|| systemuser.getReceptionist() != null) {
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		SystemUser s = systemUserDAO.findSystemUserById(systemuser
				.getId());
		if (s != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		String i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("doctor/{pesel}")
	@DELETE
	public void deleteDoctor(@PathParam("pesel") String id) {
	doctorCrud.deleteDoctor(id);
	}
	
	/**
	 * Delete an existing Patient entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("patient/{pesel}")
	@DELETE
	public void deletePatient(@PathParam("pesel") String id) {
		patientCrud.deletePatient(id);
	}
	
	/**
	 * Delete an existing Receptionist entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("receptionist/{pesel}")
	@DELETE
	public void deleteReceptionist(@PathParam("pesel") String id) {
		receptonistCrud.deleteReceptionist(id);
	}



	/**
	 * Show all SystemUser entities
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * 
	 */

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSystemUsers() throws JsonGenerationException,
			JsonMappingException, IOException {
		return Response
				.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
						false).writeValueAsString(
						systemUserService.loadSystemUsers())).build();
	}

	

//	/**
//	 * Save an existing Permission entity
//	 * 
//	 */
//
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{systemuser_id}/permissions")
//	@PUT
//	public Response saveSystemUserPermissions(
//			@PathParam("systemuser_id") Integer systemuser_id,
//			Permission permissions) {
//		systemUserService.saveSystemUserPermissions(systemuser_id, permissions);
//		return Response.ok(
//				permissionDAO.findPermissionByPrimaryKey(permissions.getId()))
//				.build();
//	}

	/**
	 * Show all Permission entities by SystemUser
	 * 
	 */

	// @GET
	// @Path("/{systemuser_id}/permissions")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response getSystemUserPermissions(
	// @PathParam("systemuser_id") Integer systemuser_id) {
	// return Response.ok(
	// systemUserDAO.findSystemUserByPrimaryKey(systemuser_id)
	// .getPermissions()).build();
	// }


	@Path("/patients/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatients() {
		Set<PatientView> allPatients = patientCrud.getAllPatients();
		return Response.ok(allPatients).build();
	}

	@Path("/patient/{pesel}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(@PathParam("pesel") String pesel) {
		PatientView patient = patientCrud.getPatientById(pesel);
		return Response.ok(patient).build();
	}

	@Path("/doctors/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDoctors() throws JsonGenerationException, JsonMappingException, IOException {
		Set<DoctorView> allDoctors = doctorCrud.getAllDoctors();
//		return Response.ok(allDoctors).build();
		
		return Response.ok(new ObjectMapper().writeValueAsString(allDoctors)).build();
	}

	@Path("/doctor/{pesel}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorById(@PathParam("pesel") String pesel) {
		DoctorView doctor = doctorCrud.getDoctorById(pesel);
		return Response.ok(doctor).build();
	}

	@Path("/doctors/specialization/{specialization}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorsBySpecialization(
			@PathParam("specialization") String specialization) {
		Set<DoctorView> doctors = doctorCrud
				.getDoctorsBySpecialization(specialization);
		return Response.ok(doctors).build();
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */

}
