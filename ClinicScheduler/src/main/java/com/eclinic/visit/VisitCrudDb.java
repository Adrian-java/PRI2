package com.eclinic.visit;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SevenDaysDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;
import com.eclinic.visit.mapper.VisitProposal;
import com.eclinic.visit.mapper.VisitsOfScheduler;
import com.eclinic.visit.planner.VisitHelper;

@Component("VisitCrudDb")
public class VisitCrudDb implements VisitCrud {

	@Autowired
	private VisitDAO visitDao;
	@Autowired
	private SpecializationDAO specializationDao;
	@Autowired
	private VisitSchedulerDAO visitSchedulerDao;
	@Autowired
	private VisitHelper visitHelper;
	@Autowired
	private DoctorDAO doctorDao;
	@Autowired
	private ReceptionistDAO receptionistDao;
	@Autowired
	private StatusOfVisitDAO statusOfVisitDao;
	@Autowired
	private TypeOfVisitDAO typeOfVisitDao;
	@Autowired
	private SevenDaysDAO sevenDaysDao;

	public Set<Visit> findVisitByDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return visitDao.findVisitByDateOfVisit(calendar);
	}

	public Set<Visit> findVisitByDoctor(Doctor doctor) {
		return visitDao.findVisitByDoctor(doctor, -1, -1);
	}

	public Set<Visit> findVisitByPatient(String id) {
		return visitDao.findVisitByPatient(id);
	}

	public Set<Visit> findVisitBySpecialization(String specialization) {

		return null;
	}

	public Set<Visit> findVisitByStatus(String status) {
		Set<Visit> findVisitByStatus = visitDao.findVisitByStatus(status);
		return findVisitByStatus;
	}

	public VisitProposal findFirstFreeTermByDoctor(String id) {
		Set<VisitProposal> findFreeTermsByDoctor = findFreeTermsByDoctor(id,
				null);
		return (findFreeTermsByDoctor.isEmpty() ? null : findFreeTermsByDoctor
				.iterator().next());
	}

	public VisitProposal findFirstFreeTermBySpecialization(String specialization) {
		Set<VisitProposal> findFreeTermsBySpecialization = findFreeTermsBySpecialization(
				specialization, null);
		return (findFreeTermsBySpecialization.isEmpty() ? null
				: findFreeTermsBySpecialization.iterator().next());
	}

	public Set<VisitProposal> findFreeTermsByDoctor(String id,
			Integer resultCounterMonth) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		Set<Visit> findVisitByDateOfVisitAfter = visitDao
				.findVisitByDateOfVisitAfter(calendar);

		Doctor findDoctorById = doctorDao.findDoctorById(id);

		Set<VisitScheduler> findVisitSchedulerByDoctor = visitSchedulerDao
				.findVisitSchedulerByDoctor(findDoctorById);

		Set<VisitProposal> visitByDoctor = visitHelper.getFreeVisitByDoctor(
				findVisitSchedulerByDoctor, findVisitByDateOfVisitAfter);
		return (visitByDoctor.isEmpty() ? null : visitByDoctor);
	}

	public Set<VisitProposal> findFreeTermsBySpecialization(
			String specialization, Integer resultCounterMonth) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		Set<Visit> findVisitByDateOfVisitAfter = visitDao
				.findVisitByDateOfVisitAfter(calendar);

		Set<VisitScheduler> findVisitSchedulerBySpecialization = visitSchedulerDao
				.findVisitSchedulerBySpecialization(specialization);

		Set<VisitProposal> visitBySpecialization = visitHelper
				.getFreeVisitBySpecialization(
						findVisitSchedulerBySpecialization,
						findVisitByDateOfVisitAfter);
		return (visitBySpecialization.isEmpty() ? null : visitBySpecialization);
	}

	public Visit addVisit(NewVisitMapper newVisit) {
		doctorDao.findDoctorById(newVisit.getIdDoctor());
		Calendar c = new GregorianCalendar();
		c.setTime(newVisit.getDate());
		Visit v = new Visit();
		v.setDateOfVisit(c.getTime());
		v.setDescriptionOfVisit(newVisit.getDescription());
		v.setDoctor(doctorDao.findDoctorById(newVisit.getIdDoctor()));
		v.setIsLeave(false);
		// v.setPatientCard(patientCard);
		v.setReceptionist(receptionistDao.findReceptionistById(newVisit
				.getIdReceptionist()));
		v.setSpecial(visitHelper.isSpecialVisit(newVisit));
		Set<StatusOfVisit> findStatusOfVisitByType = statusOfVisitDao
				.findStatusOfVisitByType("Zarejestrowany");
		v.setStatusOfVisit((findStatusOfVisitByType == null ? null
				: findStatusOfVisitByType.iterator().next()));
		Set<TypeOfVisit> findTypeOfVisitByName = typeOfVisitDao
				.findTypeOfVisitByName(newVisit.getTypeOfVisit());
		v.setTypeOfVisit((findTypeOfVisitByName == null ? null
				: findTypeOfVisitByName.iterator().next()));
		return visitDao.merge(v);
	}

	public void changeStatusOfVisit(Integer id, String status) {
		Visit findVisitById = visitDao.findVisitById(id);
		if (findVisitById != null) {
			Set<StatusOfVisit> findStatusOfVisitByType = statusOfVisitDao
					.findStatusOfVisitByType(status);
			findVisitById
					.setStatusOfVisit((findStatusOfVisitByType != null ? findStatusOfVisitByType
							.iterator().next() : null));
			visitDao.merge(findVisitById);
		}
	}

	public void deleteVisit(Integer id) {
		Visit findVisitById = visitDao.findVisitById(id);
		Set<StatusOfVisit> findStatusOfVisitByType = statusOfVisitDao
				.findStatusOfVisitByType("Deleted");
		findVisitById.setStatusOfVisit((findStatusOfVisitByType == null ? null
				: findStatusOfVisitByType.iterator().next()));
	}

	public VisitScheduler addVisitScheduler(NewVisitSchedulerMapper vsm) {
		VisitScheduler vs = new VisitScheduler();
		vs.setDoctor(doctorDao.findDoctorById(vsm.getIdDoctor()));
		vs.setDescription((vsm.getDescription() != null ? vsm.getDescription()
				.getBytes() : null));
		Set<Specialization> findSpecializationByName = specializationDao
				.findSpecializationByName(vsm.getSpecialization());
		Specialization specialization = null;
		for (Specialization s : findSpecializationByName) {
			if (s.getDoctor().getId().equals(vsm.getIdDoctor())) {
				specialization = s;
				break;
			}
		}
		vs.setSpecialization(specialization);
		vs.setTimeFrom(vsm.getTimeFrom());
		vs.setTimeTo(vsm.getTimeTo());
		SevenDays convertDaysToSevenDays = visitHelper
				.convertDaysToSevenDays(vsm.getDaysOfWeek());
		vs.setSevenDays(sevenDaysDao.merge(convertDaysToSevenDays));
		return visitSchedulerDao.merge(vs);
	}

	public void deleteVisitScheduler(VisitScheduler visitScheduler) {
		// TODO Auto-generated method stub

	}

	public VisitScheduler addVFreeVisit() {
		VisitsOfScheduler visitsOfScheduler = new VisitsOfScheduler();
		Set<VisitScheduler> visitSchedulers = visitSchedulerDao.findAllVisitSchedulers();
		Set<Visit> visits = visitDao.findAllVisits();
		visitsOfScheduler.createFreeVisits(visitSchedulers, visits);
		return null;
	}



}
