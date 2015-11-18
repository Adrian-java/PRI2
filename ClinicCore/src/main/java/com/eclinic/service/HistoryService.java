package com.eclinic.service;

import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.History;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for History entities
 * 
 */
public interface HistoryService {

	/**
	 * Return all History entity
	 * 
	 */
	public List<History> findAllHistorys(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all History entity
	 * 
	 */
	public Integer countHistorys();

	/**
	 * Delete an existing History entity
	 * 
	 */
	public void deleteHistory(History history);

	/**
	 * Load an existing History entity
	 * 
	 */
	public Set<History> loadHistorys();

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public History deleteHistoryDocumentsMapping(Integer history_id, Integer related_documentsmapping_id);

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public History saveHistoryDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping);

	/**
	 * Save an existing History entity
	 * 
	 */
	public void saveHistory(History history_1);

	/**
	 */
	public History findHistoryByPrimaryKey(Integer id_1);
}