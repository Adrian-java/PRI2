package com.eclinic.service;

import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.HistoryDAO;

import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.History;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for History entities
 * 
 */

@Service("HistoryService")
@Transactional
public class HistoryServiceImpl implements HistoryService {

	/**
	 * DAO injected by Spring that manages DocumentsMapping entities
	 * 
	 */
	@Autowired
	private DocumentsMappingDAO documentsMappingDAO;

	/**
	 * DAO injected by Spring that manages History entities
	 * 
	 */
	@Autowired
	private HistoryDAO historyDAO;

	/**
	 * Instantiates a new HistoryServiceImpl.
	 *
	 */
	public HistoryServiceImpl() {
	}

	/**
	 * Return all History entity
	 * 
	 */
	@Transactional
	public List<History> findAllHistorys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<History>(historyDAO.findAllHistorys(startResult, maxRows));
	}

	/**
	 * Return a count of all History entity
	 * 
	 */
	@Transactional
	public Integer countHistorys() {
		return ((Long) historyDAO.createQuerySingleResult("select count(o) from History o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing History entity
	 * 
	 */
	@Transactional
	public void deleteHistory(History history) {
		historyDAO.remove(history);
		historyDAO.flush();
	}

	/**
	 * Load an existing History entity
	 * 
	 */
	@Transactional
	public Set<History> loadHistorys() {
		return historyDAO.findAllHistorys();
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public History deleteHistoryDocumentsMapping(Integer history_id, Integer related_documentsmapping_id) {
		History history = historyDAO.findHistoryByPrimaryKey(history_id, -1, -1);
		DocumentsMapping related_documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping_id, -1, -1);

		history.setDocumentsMapping(null);
		history = historyDAO.store(history);
		historyDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		documentsMappingDAO.remove(related_documentsmapping);
		documentsMappingDAO.flush();

		return history;
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public History saveHistoryDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping) {
		History history = historyDAO.findHistoryByPrimaryKey(id, -1, -1);
		DocumentsMapping existingdocumentsMapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentsMapping != null) {
			existingdocumentsMapping.setId(related_documentsmapping.getId());
			related_documentsmapping = existingdocumentsMapping;
		} else {
			related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
			documentsMappingDAO.flush();
		}

		history.setDocumentsMapping(related_documentsmapping);
		history = historyDAO.store(history);
		historyDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		return history;
	}

	/**
	 * Save an existing History entity
	 * 
	 */
	@Transactional
	public void saveHistory(History history) {
		History existingHistory = historyDAO.findHistoryByPrimaryKey(history.getId());

		if (existingHistory != null) {
			if (existingHistory != history) {
				existingHistory.setId(history.getId());
				existingHistory.setRecognition(history.getRecognition());
				existingHistory.setStatisticNumber(history.getStatisticNumber());
				existingHistory.setFirstIllness(history.getFirstIllness());
				existingHistory.setDateFrom(history.getDateFrom());
				existingHistory.setDateTo(history.getDateTo());
			}
			history = historyDAO.store(existingHistory);
		} else {
			history = historyDAO.store(history);
		}
		historyDAO.flush();
	}

	/**
	 */
	@Transactional
	public History findHistoryByPrimaryKey(Integer id) {
		return historyDAO.findHistoryByPrimaryKey(id);
	}
}
