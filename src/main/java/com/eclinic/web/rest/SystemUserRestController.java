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
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;
import com.eclinic.service.SystemUserService;


/**
 * Spring Rest controller that handles CRUD requests for SystemUser entities
 * 
 */
@Path("/SystemUser")
@Component("SystemUserRestController")
public class SystemUserRestController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserService systemUserService;

	
	public SystemUserRestController(){}
	
	
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
	 * Return actually SystemUser role
	 * 
	 */

	@GET
	@Path("/role/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoleByPesel(@PathParam("pesel") String pesel) {
		SystemUser s = systemUserDAO.findSystemUserByPesel(pesel);
		Map<String,String> map = new HashMap<String,String>();
		map.put("role", s.getRole());
		return Response.ok(map).build();
	}
	
	/**
	 * View an existing Permission entity
	 * 
	 */

	
	@GET
	@Path("/{systemuser_id}/permissions/{permission_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUserPermissions(@PathParam("systemuser_id") Integer systemuser_id,
			@PathParam("related_permissions_id") Integer related_permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);
		return Response.ok(permission).build();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemuser_id}/permissions/{permission_id}")
	public Response deleteSystemUserPermissions(@PathParam("systemuser_id") Integer systemuser_id,
			@PathParam("related_permissions_id") Integer related_permissions_id) {
		return Response.ok(systemUserService.deleteSystemUserPermissions(systemuser_id, related_permissions_id)).build();
	}

	/**
	 * Create a new Permission entity
	 * 
	 * 
	 */

	@Path("/{systemuser_id}/permissions")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserPermissions(@PathParam("systemuser_id") Integer systemuser_id,
			Permission permission) {
		systemUserService.saveSystemUserPermissions(systemuser_id, permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}

	/**
	 * View an existing Worker entity
	 * 
	 */

	
	@GET
	@Path("/{systemuser_id}/worker/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUserWorker(@PathParam("systemuser_id") Integer systemuser_id,
			@PathParam("related_worker_id") Integer related_worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);
		return Response.ok(worker).build();
	}

	/**
	 * Select an existing SystemUser entity
	 * 
	 */

	@GET
	@Path("/{systemuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemUser(@PathParam("systemuser_id") Integer systemuser_id) {
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser_id)).build();
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemUser(SystemUser systemuser) {
	Integer i=	systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */

	@POST
	@Path("/newPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserPatient( SystemUser systemuser) {
		if(systemuser.getWorker()!=null){
			Worker w = systemuser.getWorker();
			if(w.getDoctor()!=null || w.getAdmin()!=null || w.getReceptionist()!=null){
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		SystemUser s = systemUserDAO.findSystemUserByPesel(systemuser.getPesel());
		if(s!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		Integer i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}
	
	@POST
	@Path("/newDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserDoctor( SystemUser systemuser) {
		if(systemuser.getWorker()!=null){
			Worker w = systemuser.getWorker();
			if(w.getPatient()!=null || w.getAdmin()!=null || w.getReceptionist()!=null){
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		SystemUser s = systemUserDAO.findSystemUserByPesel(systemuser.getPesel());
		if(s!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		Integer i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}
	
	@POST
	@Path("/newReceptionist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserReceptionist( SystemUser systemuser) {
		if(systemuser.getWorker()!=null){
			Worker w = systemuser.getWorker();
			if(w.getDoctor()!=null || w.getAdmin()!=null || w.getPatient()!=null){
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		SystemUser s = systemUserDAO.findSystemUserByPesel(systemuser.getPesel());
		if(s!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		Integer i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}
	
	@POST
	@Path("/newAdmin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserAdmin( SystemUser systemuser) {
		if(systemuser.getWorker()!=null){
			Worker w = systemuser.getWorker();
			if(w.getDoctor()!=null || w.getPatient()!=null || w.getReceptionist()!=null){
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		SystemUser s = systemUserDAO.findSystemUserByPesel(systemuser.getPesel());
		if(s!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Podany pesel/login istnieje");
			return Response.ok(map).build();
		}
		Integer i = systemUserService.saveSystemUser(systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(i)).build();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */


	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemuser_id}")
	@DELETE
	public void deleteSystemUser(@PathParam("systemuser_id") Integer systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id);
		systemUserService.deleteSystemUser(systemuser);
	}

	/**
	 * Get Worker entity by SystemUser
	 * 
	 */


	@GET
	@Path("/{systemuser_id}/worker")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSystemUserWorker(@PathParam("systemuser_id") Integer systemuser_id) {
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser_id).getWorker()).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemuser_id}/worker")
	@PUT
	public Response saveSystemUserWorker(@PathParam("systemuser_id") Integer systemuser_id,
			Worker worker) {
		systemUserService.saveSystemUserWorker(systemuser_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Show all SystemUser entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSystemUsers() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS, false).writeValueAsString(systemUserService.loadSystemUsers())).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemuser_id}/worker/{worker_id}")
	public Response deleteSystemUserWorker(@PathParam("systemuser_id") Integer systemuser_id,
			@PathParam("related_worker_id") Integer related_worker_id) {
		return Response.ok(systemUserService.deleteSystemUserWorker(systemuser_id, related_worker_id)).build();
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemuser_id}/permissions")
	@PUT
	public Response saveSystemUserPermissions(@PathParam("systemuser_id") Integer systemuser_id,
			Permission permissions) {
		systemUserService.saveSystemUserPermissions(systemuser_id, permissions);
		return Response.ok( permissionDAO.findPermissionByPrimaryKey(permissions.getId())).build();
	}

	/**
	 * Show all Permission entities by SystemUser
	 * 
	 */

	
	@GET
	@Path("/{systemuser_id}/permissions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSystemUserPermissions(@PathParam("systemuser_id") Integer systemuser_id) {
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser_id).getPermissions()).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */

	
	@Path("/{systemuser_id}/worker")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemUserWorker(@PathParam("systemuser_id") Integer systemuser_id,
			Worker worker) {
		systemUserService.saveSystemUserWorker(systemuser_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	
}
