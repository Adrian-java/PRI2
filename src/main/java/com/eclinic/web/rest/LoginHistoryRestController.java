package com.eclinic.web.rest;

import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Worker;

import com.eclinic.service.LoginHistoryService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for LoginHistory entities
 * 
 */

@Controller("LoginHistoryRestController")
public class LoginHistoryRestController {

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryService loginHistoryService;

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

	/**
	 * Get Worker entity by LoginHistory
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}/worker", method = RequestMethod.GET)
	@ResponseBody
	public Worker getLoginHistoryWorker(@PathVariable Integer loginhistory_id) {
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id).getWorker();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}/worker", method = RequestMethod.PUT)
	@ResponseBody
	public Worker saveLoginHistoryWorker(@PathVariable Integer loginhistory_id, @RequestBody Worker worker) {
		loginHistoryService.saveLoginHistoryWorker(loginhistory_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Select an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}", method = RequestMethod.GET)
	@ResponseBody
	public LoginHistory loadLoginHistory(@PathVariable Integer loginhistory_id) {
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id);
	}

	/**
	 * Create a new LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory", method = RequestMethod.POST)
	@ResponseBody
	public LoginHistory newLoginHistory(@RequestBody LoginHistory loginhistory) {
		loginHistoryService.saveLoginHistory(loginhistory);
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId());
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}/worker/{worker_id}", method = RequestMethod.GET)
	@ResponseBody
	public Worker loadLoginHistoryWorker(@PathVariable Integer loginhistory_id, @PathVariable Integer related_worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);

		return worker;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}/worker", method = RequestMethod.POST)
	@ResponseBody
	public Worker newLoginHistoryWorker(@PathVariable Integer loginhistory_id, @RequestBody Worker worker) {
		loginHistoryService.saveLoginHistoryWorker(loginhistory_id, worker);
		return workerDAO.findWorkerByPrimaryKey(worker.getId());
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory", method = RequestMethod.PUT)
	@ResponseBody
	public LoginHistory saveLoginHistory(@RequestBody LoginHistory loginhistory) {
		loginHistoryService.saveLoginHistory(loginhistory);
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId());
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}/worker/{worker_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteLoginHistoryWorker(@PathVariable Integer loginhistory_id, @PathVariable Integer related_worker_id) {
		loginHistoryService.deleteLoginHistoryWorker(loginhistory_id, related_worker_id);
	}

	/**
	 * Show all LoginHistory entities
	 * 
	 */
	@RequestMapping(value = "/LoginHistory", method = RequestMethod.GET)
	@ResponseBody
	public List<LoginHistory> listLoginHistorys() {
		return new java.util.ArrayList<LoginHistory>(loginHistoryService.loadLoginHistorys());
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@RequestMapping(value = "/LoginHistory/{loginhistory_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteLoginHistory(@PathVariable Integer loginhistory_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id);
		loginHistoryService.deleteLoginHistory(loginhistory);
	}
}