package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Visit entities
 * 
 */
public interface VisitService {

	public Set<Visit> loadVisits();

	public Visit deleteVisitTypeOfVisit(Integer visit_id, Integer related_typeofvisit_id);

	public void deleteVisit(Visit visit);

	public Visit deleteVisitPatientCard(Integer visit_id_1, Integer related_patientcard_id);

	public List<Visit> findAllVisits(Integer startResult, Integer maxRows);

	public Visit saveVisitTypeOfVisit(Integer id, TypeOfVisit related_typeofvisit);

	public Integer saveVisit(Visit visit_1);

	public Integer countVisits();

	public Visit deleteVisitReceptionist(Integer visit_id_2, Integer related_receptionist_id);

	public Visit saveVisitDoctor(Integer id_1, Doctor related_doctor);

	public Visit saveVisitStatusOfVisit(Integer id_2, StatusOfVisit related_statusofvisit);

	public Visit findVisitByPrimaryKey(Integer id_3);

	public Visit deleteVisitSickLeaves(Integer visit_id_3, Integer related_sickleaves_id);

	public Visit deleteVisitStatusOfVisit(Integer visit_id_4, Integer related_statusofvisit_id);

	public Visit saveVisitSickLeaves(Integer id_4, SickLeave related_sickleaves);

	public Visit deleteVisitDoctor(Integer visit_id_5, Integer related_doctor_id);

	public Visit saveVisitPatientCard(Integer id_5, PatientCard related_patientcard);

	public Visit saveVisitReceptionist(Integer id_6, Receptionist related_receptionist);
}