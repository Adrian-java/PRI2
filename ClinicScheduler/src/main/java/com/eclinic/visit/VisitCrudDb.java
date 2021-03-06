package com.eclinic.visit;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.DocumentsDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SevenDaysDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.dao.view.DoctorViewDAO;
import com.eclinic.dao.view.PatientViewDAO;
import com.eclinic.dao.view.VisitSchedulerViewDAO;
import com.eclinic.dao.view.VisitViewDAO;
import com.eclinic.documents.util.DocumentsModel;
import com.eclinic.domain.Certificate;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Documents;
import com.eclinic.domain.DocumentsMapping;
import com.eclinic.domain.Prescription;
import com.eclinic.domain.Referral;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.view.VisitSchedulerView;
import com.eclinic.domain.view.VisitView;
import com.eclinic.model.VisitEdit;
import com.eclinic.model.VisitInfo;
import com.eclinic.visit.mapper.NewVisitMapper;
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
	private DoctorViewDAO doctorViewDao;
	@Autowired
	private PatientViewDAO patientViewDao;
	@Autowired
	private VisitSchedulerViewDAO visitSchedulerViewDao;
	@Autowired
	private DocumentsDAO documentsDao;

	public Set<VisitView> findVisitByDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return visitViewDao.findVisitByDateOfVisit(calendar);
	}

	public Set<VisitView> findVisitByDoctor(String doctorId, Date start,
			Date stop) {
		return visitViewDao.findVisitByDoctorAndDate(doctorId, start, stop, -1,
				-1);
	}

	public Set<VisitView> findPlaneVisitByPatient(String id) {
		return visitViewDao.findPlaneVisitByPatient(id);
	}

	public Set<VisitView> findDoneVisitByPatient(String id) {
		return visitViewDao.findDoneVisitByPatient(id);
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

	public Visit addVisit(NewVisitMapper newVisitMapper) {
		/*
		 * Visit visitById = visitDao.findVisitById(visitId); Patient patient =
		 * patientDao.findPatientById(patientId); visitById.setPatient(patient);
		 * visitById.setStatusOfVisit(statusOfVisitDao
		 * .findStatusOfVisitByType("niepotwierdzona").iterator().next()); Visit
		 * merge = visitDao.merge(visitById);
		 */

		Visit newVisit = new Visit();

		newVisit.setDateOfVisit(newVisitMapper.getDate());
		newVisit.setDescriptionOfVisit(newVisitMapper.getDescription());
		newVisit.setIsLeave(false);
		newVisit.setSpecial(false);
		newVisit.setPatient(patientDao.findPatientById(newVisitMapper
				.getPatientId()));
		newVisit.setTypeOfVisit(typeOfVisitDao
				.findTypeOfVisitByName(newVisitMapper.getTypeOfVisit())
				.iterator().next());
		newVisit.setReceptionist(receptionistDao
				.findReceptionistById(newVisitMapper.getIdReceptionist()));
		newVisit.setStatusOfVisit(statusOfVisitDao.findStatusOfVisitById(3));
		newVisit.setDoctor(doctorDao.findDoctorById(newVisitMapper
				.getIdDoctor()));

		Visit merge = visitDao.merge(newVisit);
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
		vs.setStartDate(vsm.getStartDate());
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
		if (specialization == null) {
			return null;
		}
		vs.setSpecialization(specialization);
		vs.setTimeFrom(vsm.getTimeFrom());
		vs.setTimeTo(vsm.getTimeTo());
		vs.setDuration(vsm.getDuration());
		vs.setVisitRepeat(vsm.getVisitRepeat());
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

	public VisitInfo findVisitById(Integer id) {
		VisitInfo v = new VisitInfo();
		v.setVisitView(visitViewDao.findVisitById(id));
		v.setDoctorView(doctorViewDao.findDoctorById(v.getVisitView()
				.getIdDoctor()));
		v.setPatientView(patientViewDao.findPatientById(v.getVisitView()
				.getIdPatient()));
//		v.setDocuments(createDocumentModel(documentsDao.findDocumentsByVisit(visitDao
//				.findVisitById(id))));
		return v;
	}
	
	

	private DocumentsModel createDocumentModel(Documents d) {
		Map<String, Object> map = new TreeMap<String, Object>();
		DocumentsModel dm = new DocumentsModel();
		dm.setDate(d.getDateOfDocuments().getTime());
		try {
			dm.setDescription(new String(d.getDescription(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		map.put("documents", dm);
//		Set<Referral> referral = new HashSet<Referral>();
//		Set<Prescription> prescription = new TreeSet<Prescription>();
//		Set<Certificate> certificate = new TreeSet<Certificate>();
//		Set<DocumentsMapping> documentsMappings = d.getDocumentsMappings();
//		for (DocumentsMapping dsm : documentsMappings) {
//			if (dsm.getReferral() != null) {
//				referral.add(dsm.getReferral());
//			}
//			if (dsm.getPrescription() != null) {
//				prescription.add(dsm.getPrescription());
//			}
//			if (dsm.getCertificate() != null) {
//				certificate.add(dsm.getCertificate());
//			}
//		}
//		if (referral.size() > 0)
//			map.put("referral", referral);
//		if (prescription.size() > 0)
//			map.put("referral", prescription);
//		if (certificate.size() > 0)
//			map.put("referral", certificate);
		return dm;
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

	public Set<VisitView> findVisitByDoctorAndSpecialization(String doctor,
			String specialization, Date startDate, Date endDate) {
		return visitViewDao.findVisitByDoctorSpecializationAndDate(doctor,
				specialization, startDate, endDate);
	}

	public Set<VisitView> findAllVisitByDate(Date start, Date stop) {
		return visitViewDao.findVisitByDate(start, stop);
	}

	public VisitView findVisitWithInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<VisitView> getAllVisitByPatient(String id) {
		return visitViewDao.findPlaneVisitByPatient(id);
	}

	public Visit editVisit(VisitEdit ve) {
		Visit v = visitDao.findVisitById(ve.getVisitId());
		v.setDescriptionOfVisit(ve.getDescription());
		Visit merge = visitDao.merge(v);
		visitDao.flush();
		return merge;
	}
}
