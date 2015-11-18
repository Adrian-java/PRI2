package com.eclinic.service;

import com.eclinic.dao.DocumentsMappingDAO;
import com.eclinic.dao.ReferralDAO;

import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Referral;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Referral entities
 * 
 */

@Service("ReferralService")
@Transactional
public class ReferralServiceImpl implements ReferralService {

	/**
	 * DAO injected by Spring that manages DocumentsMapping entities
	 * 
	 */
	@Autowired
	private DocumentsMappingDAO documentsMappingDAO;

	/**
	 * DAO injected by Spring that manages Referral entities
	 * 
	 */
	@Autowired
	private ReferralDAO referralDAO;

	/**
	 * Instantiates a new ReferralServiceImpl.
	 *
	 */
	public ReferralServiceImpl() {
	}

	/**
	 * Save an existing Referral entity
	 * 
	 */
	@Transactional
	public void saveReferral(Referral referral) {
		Referral existingReferral = referralDAO.findReferralByPrimaryKey(referral.getId());

		if (existingReferral != null) {
			if (existingReferral != referral) {
				existingReferral.setId(referral.getId());
				existingReferral.setDestination(referral.getDestination());
				existingReferral.setRecognition(referral.getRecognition());
				existingReferral.setPurpose(referral.getPurpose());
			}
			referral = referralDAO.store(existingReferral);
		} else {
			referral = referralDAO.store(referral);
		}
		referralDAO.flush();
	}

	/**
	 */
	@Transactional
	public Referral findReferralByPrimaryKey(Integer id) {
		return referralDAO.findReferralByPrimaryKey(id);
	}

	/**
	 * Delete an existing Referral entity
	 * 
	 */
	@Transactional
	public void deleteReferral(Referral referral) {
		referralDAO.remove(referral);
		referralDAO.flush();
	}

	/**
	 * Load an existing Referral entity
	 * 
	 */
	@Transactional
	public Set<Referral> loadReferrals() {
		return referralDAO.findAllReferrals();
	}

	/**
	 * Return a count of all Referral entity
	 * 
	 */
	@Transactional
	public Integer countReferrals() {
		return ((Long) referralDAO.createQuerySingleResult("select count(o) from Referral o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Referral deleteReferralDocumentsMapping(Integer referral_id, Integer related_documentsmapping_id) {
		Referral referral = referralDAO.findReferralByPrimaryKey(referral_id, -1, -1);
		DocumentsMapping related_documentsmapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping_id, -1, -1);

		referral.setDocumentsMapping(null);
		referral = referralDAO.store(referral);
		referralDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		documentsMappingDAO.remove(related_documentsmapping);
		documentsMappingDAO.flush();

		return referral;
	}

	/**
	 * Return all Referral entity
	 * 
	 */
	@Transactional
	public List<Referral> findAllReferrals(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Referral>(referralDAO.findAllReferrals(startResult, maxRows));
	}

	/**
	 * Save an existing DocumentsMapping entity
	 * 
	 */
	@Transactional
	public Referral saveReferralDocumentsMapping(Integer id, DocumentsMapping related_documentsmapping) {
		Referral referral = referralDAO.findReferralByPrimaryKey(id, -1, -1);
		DocumentsMapping existingdocumentsMapping = documentsMappingDAO.findDocumentsMappingByPrimaryKey(related_documentsmapping.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdocumentsMapping != null) {
			existingdocumentsMapping.setId(related_documentsmapping.getId());
			related_documentsmapping = existingdocumentsMapping;
		} else {
			related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
			documentsMappingDAO.flush();
		}

		referral.setDocumentsMapping(related_documentsmapping);
		referral = referralDAO.store(referral);
		referralDAO.flush();

		related_documentsmapping = documentsMappingDAO.store(related_documentsmapping);
		documentsMappingDAO.flush();

		return referral;
	}
}
