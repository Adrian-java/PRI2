package com.eclinic.service;

import com.eclinic.dao.SevenDaysDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.SevenDays;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SevenDays entities
 * 
 */

@Service("SevenDaysService")
@Transactional
public class SevenDaysServiceImpl implements SevenDaysService {

	/**
	 * DAO injected by Spring that manages SevenDays entities
	 * 
	 */
	@Autowired
	private SevenDaysDAO sevenDaysDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Instantiates a new SevenDaysServiceImpl.
	 *
	 */
	public SevenDaysServiceImpl() {
	}

	/**
	 * Return a count of all SevenDays entity
	 * 
	 */
	@Transactional
	public Integer countSevenDayss() {
		return ((Long) sevenDaysDAO.createQuerySingleResult("select count(o) from SevenDays o").getSingleResult()).intValue();
	}

	/**
	 * Return all SevenDays entity
	 * 
	 */
	@Transactional
	public List<SevenDays> findAllSevenDayss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SevenDays>(sevenDaysDAO.findAllSevenDayss());
	}

	/**
	 * Delete an existing SevenDays entity
	 * 
	 */
	@Transactional
	public void deleteSevenDays(SevenDays sevendays) {
		sevenDaysDAO.remove(sevendays);
		sevenDaysDAO.flush();
	}

	/**
	 * Load an existing SevenDays entity
	 * 
	 */
	@Transactional
	public Set<SevenDays> loadSevenDayss() {
		return (Set<SevenDays>) sevenDaysDAO.findAllSevenDayss();
	}

	/**
	 */
	@Transactional
	public SevenDays findSevenDaysByPrimaryKey(Integer id) {
		return sevenDaysDAO.findSevenDaysById(id);
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public SevenDays saveSevenDaysVisitSchedulers(Integer id, VisitScheduler related_visitschedulers) {
		SevenDays sevendays = sevenDaysDAO.findSevenDaysByPrimaryKey(id, -1, -1);
		VisitScheduler existingvisitSchedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisitSchedulers != null) {
			existingvisitSchedulers.setId(related_visitschedulers.getId());
			existingvisitSchedulers.setNumberOfMonth(related_visitschedulers.getNumberOfMonth());
			existingvisitSchedulers.setDescription(related_visitschedulers.getDescription());
			existingvisitSchedulers.setTimeFrom(related_visitschedulers.getTimeFrom());
			existingvisitSchedulers.setTimeTo(related_visitschedulers.getTimeTo());
			existingvisitSchedulers.setDuration(related_visitschedulers.getDuration());
			related_visitschedulers = existingvisitSchedulers;
		} else {
			related_visitschedulers = visitSchedulerDAO.store(related_visitschedulers);
			visitSchedulerDAO.flush();
		}

		related_visitschedulers.setSevenDays(sevendays);
		sevendays.getVisitScheduler().add(related_visitschedulers);
		related_visitschedulers = visitSchedulerDAO.store(related_visitschedulers);
		visitSchedulerDAO.flush();

		sevendays = sevenDaysDAO.store(sevendays);
		sevenDaysDAO.flush();

		return sevendays;
	}

	/**
	 * Save an existing SevenDays entity
	 * 
	 */
	@Transactional
	public void saveSevenDays(SevenDays sevendays) {
		SevenDays existingSevenDays = sevenDaysDAO.findSevenDaysById(sevendays.getId());

		if (existingSevenDays != null) {
			if (existingSevenDays != sevendays) {
				existingSevenDays.setId(sevendays.getId());
				existingSevenDays.setMon(sevendays.getMon());
				existingSevenDays.setTue(sevendays.getTue());
				existingSevenDays.setWen(sevendays.getWen());
				existingSevenDays.setThu(sevendays.getThu());
				existingSevenDays.setFri(sevendays.getFri());
				existingSevenDays.setSat(sevendays.getSat());
				existingSevenDays.setSun(sevendays.getSun());
			}
			sevendays = sevenDaysDAO.store(existingSevenDays);
		} else {
			sevendays = sevenDaysDAO.store(sevendays);
		}
		sevenDaysDAO.flush();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public SevenDays deleteSevenDaysVisitSchedulers(Integer sevendays_id, Integer related_visitschedulers_id) {
		VisitScheduler related_visitschedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		SevenDays sevendays = sevenDaysDAO.findSevenDaysByPrimaryKey(sevendays_id, -1, -1);

		related_visitschedulers.setSevenDays(null);
		sevendays.getVisitScheduler().remove(related_visitschedulers);

		visitSchedulerDAO.remove(related_visitschedulers);
		visitSchedulerDAO.flush();

		return sevendays;
	}
}
