package com.eclinic.visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.service.spi.Stoppable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SevenDaysDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.dao.view.VisitSchedulerViewDAO;
import com.eclinic.dao.view.VisitViewDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.view.VisitSchedulerView;
import com.eclinic.domain.view.VisitView;
import com.eclinic.visit.mapper.NewVisitSchedulerMapper;
import com.eclinic.visit.planner.VisitHelper;

@Component("VisitCrud")
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
	@Autowired
	private VisitViewDAO visitViewDao;
	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private VisitSchedulerViewDAO visitSchedulerViewDao;

	public Set<VisitView> findVisitByDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return visitViewDao.findVisitByDateOfVisit(calendar);
	}

	public Set<VisitView> findVisitByDoctor(String doctorId) {
		return visitViewDao.findVisitByDoctor(doctorId, -1, -1);
	}

	public Set<VisitView> findVisitByPatient(String id) {
		return visitViewDao.findVisitByPatient(id);
	}

	public Set<VisitView> findVisitBySpecialization(String specialization) {
		return visitViewDao.findVisitBySpecialization(specialization);
	}

	public Set<VisitView> findVisitByStatus(String status) {
		Set<VisitView> findVisitByStatus = visitViewDao
				.findVisitByStatus(status);
		return findVisitByStatus;
	}

	public VisitView findFirstFreeTermByDoctor(String id) {
		return findFreeTermsByDoctor(id, 1).iterator().next();
	}

	public VisitView findFirstFreeTermBySpecialization(String specialization) {
		return findFreeTermsBySpecialization(specialization, 1).iterator()
				.next();
	}

	public Set<VisitView> findFreeTermsByDoctor(String id, Integer numberOfVisit) {
		return visitViewDao.findFreeVisitByDoctor(id, numberOfVisit);
	}

	public Set<VisitView> findFreeTermsBySpecialization(String specialization,
			Integer resultCounterMonth) {
		return visitViewDao.findFreeVisitBySpecialization(specialization, 10);
	}

	public Visit addVisit(String patientId, Integer visitId) {
		Visit visitById = visitDao.findVisitById(visitId);
		Patient patient = patientDao.findPatientById(patientId);
		visitById.setPatient(patient);
		visitById.setStatusOfVisit(statusOfVisitDao
				.findStatusOfVisitByType("niepotwierdzona").iterator().next());
		Visit merge = visitDao.merge(visitById);
		// wysylka maila
		visitDao.flush();
		return merge;
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
			visitDao.flush();
		}
	}

	public void deleteVisit(Integer id) {
		changeStatusOfVisit(id, "wolna");
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
		// vs.setSevenDays(sevenDaysDao.merge(convertDaysToSevenDays));
		return visitSchedulerDao.merge(vs);
	}

	public void deleteVisitScheduler(VisitScheduler visitScheduler) {

	}

	public VisitScheduler addFreeVisit() {
		Set<VisitSchedulerView> allVisitSchedulerView = visitSchedulerViewDao
				.findAllVisitScheduler();
		try {
			setVisit(allVisitSchedulerView);
		} catch (ParseException e) {
		}
		return null;
	}

	public void setVisit(Set<VisitSchedulerView> allVisitSchedulerView)
			throws ParseException {
		int z = 0;
		for (VisitSchedulerView vsv : allVisitSchedulerView) {
			List<Boolean> days = visitHelper.addAllDays(vsv);
			System.out.println("Progress:" + (++z) + "/"
					+ allVisitSchedulerView.size());
			long minutes = visitHelper.getMinutes(vsv.getTimeFrom(),
					vsv.getTimeTo());
			int numberVisitInDay = (int) (minutes / vsv.getDuration());
			Calendar actualCalendar = vsv.getTimeFrom();
			int hour = actualCalendar.get(Calendar.HOUR_OF_DAY);
			int minute = actualCalendar.get(Calendar.MINUTE);

			Calendar calendar = Calendar.getInstance();
			int dayinMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int singleDayInMonth = 1; singleDayInMonth <= dayinMonth; singleDayInMonth++) {
				System.out.println("Day: " + singleDayInMonth + " for doctor: "
						+ vsv.getIdDoctor());
				String pattern = "dd/MM/yyyy HH:mm:ss";
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				String day = singleDayInMonth + "";
				Date date = format.parse(day + "/12/2015 " + hour + ":"
						+ minute + ":00");
				calendar.setTime(date);
				if (visitHelper.isDayVisit(
						calendar.get(Calendar.DAY_OF_WEEK) - 1, days)) {
					for (int i = 1; i <= numberVisitInDay; i++) {
						Calendar actD = visitHelper.computeStartTime(calendar,
								i - 1, vsv.getDuration());
						Calendar startDate = visitHelper.getStartDate(
								singleDayInMonth, actD, 0);
						Visit v = visitHelper.fillVisitData(vsv, startDate);
						visitDao.store(v);
						actualCalendar = actD;
					}
				}
			}
		}
	}

	public Set<VisitView> findAllVisit() {
		return visitViewDao.findAllVisit();
	}

	public VisitView findVisitById(Integer id) {
		return visitViewDao.findVisitById(id);
	}

	public VisitView findFirstFreeTermBySpecializationAndDoctor(
			String specialization, String doctor) {

		return findFreeTermBySpecializationAndDoctor(specialization, doctor)
				.iterator().next();
	}

	public Set<VisitView> findFreeTermBySpecializationAndDoctor(
			String specialization, String doctor) {
		Set<VisitView> visit = new LinkedHashSet<VisitView>();
		Set<VisitView> findFreeTermsByDoctor = findFreeTermsByDoctor(doctor, -1);
		for (VisitView vv : findFreeTermsByDoctor) {
			if (vv.getSpecialization().equals(specialization)) {
				visit.add(vv);
			}
		}
		return visit;
	}

	public Set<VisitView> findVisitBySpecializationAndDate(
			String specialization, Date startDate, Date endDate) {
		return visitViewDao.findVisitBySpecializationAndDate(specialization,
				startDate, endDate);
	}

	public Set<VisitScheduler> findVisitSchedulerBySpecialization(
			String specialization) {
		return visitSchedulerDao
				.findVisitSchedulerBySpecialization(specialization);
	}

	public Set<VisitScheduler> findVisitSchedulerByDoctor(String doctorId) {
		Doctor d = doctorDao.findDoctorById(doctorId);
		return visitSchedulerDao.findVisitSchedulerByDoctor(d);
	}
}
