package com.eclinic.web.rest;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.ApplicationParameterDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.ApplicationParameter;
import com.eclinic.service.ApplicationParameterService;

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
 * Spring Rest controller that handles CRUD requests for ApplicationParameter entities
 * 
 */

//@Controller("ApplicationParameterRestController")
@Component
@Path("/ApplicationParameter")
public class ApplicationParameterRestController {

	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("wee-dao-context.xml");
	/**
	 * DAO injected by Spring that manages ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterDAO applicationParameterDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterService applicationParameterService;

	
	
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
		applicationParameterDAO =  (ApplicationParameterDAO) context.getBean("ApplicationParameterDAO");
		
	}
	/**
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	/*@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.PUT)
	@ResponseBody
	public ApplicationParameter saveApplicationParameter(@RequestBody ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId());
	}*/
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveApplicationParameter( ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId())).build();
	}

	/**
	 * Create a new ApplicationParameter entity
	 * 
	 */
	/*@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.POST)
	@ResponseBody
	public ApplicationParameter newApplicationParameter(@RequestBody ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId());
	}
	*/
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newApplicationParameter( ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId())).build();
	}

	/**
	 * Show all ApplicationParameter entities
	 * 
	 */
	/*@RequestMapping(value = "/ApplicationParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<ApplicationParameter> listApplicationParameters() {
		return new java.util.ArrayList<ApplicationParameter>(applicationParameterService.loadApplicationParameters());
	}*/
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listApplicationParameters() {
		return  Response.ok(applicationParameterService.loadApplicationParameters()).build();
	}

	

	/**
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	/*@RequestMapping(value = "/ApplicationParameter/{applicationparameter_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteApplicationParameter(@PathVariable Integer applicationparameter_id) {
		ApplicationParameter applicationparameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
		applicationParameterService.deleteApplicationParameter(applicationparameter);
	}*/
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{applicationparameter_id}")
	@DELETE
	public void deleteApplicationParameter(@PathParam("applicationparameter_id") Integer applicationparameter_id) {
		ApplicationParameter applicationparameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
		applicationParameterService.deleteApplicationParameter(applicationparameter);
	}

	/**
	 * Select an existing ApplicationParameter entity
	 * 
	 */
	/*@RequestMapping(value = "/ApplicationParameter/{applicationparameter_id}", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationParameter loadApplicationParameter(@PathVariable Integer applicationparameter_id) {
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
	}*/
	@GET
	@Path("/{applicationparameter_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadApplicationParameter(@PathParam("applicationparameter_id") Integer applicationparameter_id) {
		applicationParameterDAO =  (ApplicationParameterDAO) context.getBean("ApplicationParameterDAO");
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id)).build();// addressDAO.findAddressByPrimaryKey(address_id);
	}
}