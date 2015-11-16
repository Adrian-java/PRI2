package com.eclinic.service;

import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Referral;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Referral entities
 * 
 */
public interface ReferralService {

	/**
	 * Save an existing Referral entity
	 * 
	 */
	public void saveReferral(Referral referral);

	/**
	 */
	public Referral findReferralByPrimaryKey(Integer id);

	/**
	 * Delete an existing Referral entity
	 * 
	 */
	public void deleteReferral(Referral referral_1);

	/**
	 * Load an existing Referral entity
	 * 
	 */
	public Set<Referral> loadReferrals();

	/**
	 * Return a count of all Referral entity
	 * 
	 */
	public Integer countReferrals();

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	public Referral deleteReferralDocumentsMapping(Integer referral_id, Integer related_documentsmapping_id);

	/**
	 * Return all Referral entity
	 * 
	 */
	public List<Referral> findAllReferrals(Integer startResult, Integer maxRows);

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	public Referral saveReferralDocumentsMapping(Integer id_1, DocumentsMapping related_documentsmapping);
}