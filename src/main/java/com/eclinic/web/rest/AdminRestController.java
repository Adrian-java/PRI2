package com.eclinic.web.rest;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Admin;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Worker;
import com.eclinic.service.AdminService;

import java.util.List;

import javax.annotation.PostConstruct;
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
 * Spring Rest controller that handles CRUD requests for Admin entities
 * 
 */

//@Controller("AdminRestController")
@Component("AdminRestController")  
@Path("/Admin") //
public class AdminRestController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("wee-dao-context.xml"); //
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Admin entities
	 * 
	 */
	@Autowired
	private AdminService adminService;

	
	

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
		adminDAO =  (AdminDAO) context.getBean("AdminDAO");
		
	}
	/**
	 * Show all Admin entities
	 * 
	 */
	
	
	/*@RequestMapping(value = "/Admin", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> listAdmins() {
		return new java.util.ArrayList<Admin>(adminService.loadAdmins());}
		*/
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAdmins() {
		return  Response.ok(adminService.loadAdmins()).build();
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}/workers/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadAdminWorkers(@PathVariable Integer admin_id, @PathVariable Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return worker;
		
	}*/
	
	@GET
	@Path("/{admin_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAdminWorkers(@PathParam("admin_id") Integer admin_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(
				related_workers_id, -1, -1);

		return Response.ok(worker).build();
	}


	/**
	 * Select an existing Admin entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}", method = RequestMethod.GET)
	@ResponseBody
	public Admin loadAdmin(@PathVariable Integer admin_id) {
		return adminDAO.findAdminByPrimaryKey(admin_id);
		
	}*/
	
	@GET
	@Path("/{admin_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loadAdmin(@PathParam("admin_id") Integer admin_id) {
		adminDAO =  (AdminDAO) context.getBean("AdminDAO");
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin_id)).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}/workers", method = RequestMethod.POST)
	@ResponseBody
	public Worker newAdminWorkers(@PathVariable Integer admin_id, @RequestBody Worker worker) {
		adminService.saveAdminWorkers(admin_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}*/
	@Path("/{admin_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAdminWorkers(@PathParam("admin_id") Integer admin_id,
			 Worker worker) {
		adminService.saveAdminWorkers(admin_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin", method = RequestMethod.PUT)
	@ResponseBody
	public Admin saveAdmin(@RequestBody Admin admin) {
		adminService.saveAdmin(admin);
		return adminDAO.findAdminByPrimaryKey(admin.getId());
	}*/
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAdmin( Admin admin) {
		adminService.saveAdmin(admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}

	/**
	 * Create a new Admin entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin", method = RequestMethod.POST)
	@ResponseBody
	public Admin newAdmin(@RequestBody Admin admin) {
		adminService.saveAdmin(admin);
		return adminDAO.findAdminByPrimaryKey(admin.getId());
	}*/
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAdmin( Admin admin) {
		adminService.saveAdmin(admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}
	

	/**
	 * Save an existing Worker entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}/workers", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveAdminWorkers(@PathVariable Integer admin_id, @RequestBody Worker workers) {
		adminService.saveAdminWorkers(admin_id, workers);
		return workerDAO.findWorkerByPrimaryKey(workers.getId());
	}*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}/workers")
	@PUT
	public Response saveAdminWorkers(@PathParam("admin_id") Integer admin_id,
			 Worker workers) {
		adminService.saveAdminWorkers(admin_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAdmin(@PathVariable Integer admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id);
		adminService.deleteAdmin(admin);
	}*/
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}")
	@DELETE
	public void deleteAdmin(@PathParam("admin_id") Integer admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id);
		adminService.deleteAdmin(admin);
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	/*@RequestMapping(value = "/Admin/{admin_id}/workers/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAdminWorkers(@PathVariable Integer admin_id, @PathVariable Integer related_workers_id) {
		adminService.deleteAdminWorkers(admin_id, related_workers_id);
	}
	*/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}/workers/{worker_id}")
	public Response deleteAdminWorkers(@PathParam("admin_id") Integer admin_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(adminService.deleteAdminWorkers(admin_id, related_workers_id)).build();
	}


	/**
	 * Show all Worker entities by Admin
	 * 
	 */
	/*
	@RequestMapping(value = "/Admin/{admin_id}/workers", method = RequestMethod.GET)
	@ResponseBody
	public List<Worker> getAdminWorkers(@PathVariable Integer admin_id) {
		return new java.util.ArrayList<Worker>(adminDAO.findAdminByPrimaryKey(admin_id).getWorkers());
	}
	*/
	@GET
	@Path("/{admin_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdminWorkers(@PathParam("admin_id") Integer admin_id) {
		return Response.ok(adminDAO
				.findAdminByPrimaryKey(admin_id).getWorkers()).build();
	}

}
