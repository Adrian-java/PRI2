package com.eclinic.visit.planner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.view.VisitViewDAO;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.view.VisitSchedulerView;
import com.eclinic.domain.view.VisitView;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.visit.mapper.VisitProposal;

@Component("VisitHelper")
public class VisitHelper {

	@Autowired
	public DoctorDAO doctorDao;
	@Autowired
	public TypeOfVisitDAO typeOfVisitDao;
	@Autowired
	public StatusOfVisitDAO statusOfVisitDao;
	@Autowired
	public VisitDAO visitDao;
	@Autowired
	public VisitViewDAO visitViewDao;

	public Set<VisitView> getFreeVisitBySpecialization(String specialization) {
		VisitView v = new VisitView();
		// if (findVisitByDateOfVisitAfter.isEmpty()) {
		// VisitScheduler next =
		// findVisitSchedulerBySpecialization.iterator().next();
		// Date day = new Date();
		// SevenDays sevenDays = next.getSevenDays();
		// Calendar c = Calendar.getInstance();
		// c.set(day.getYear(), day.getMonth(), day.getDay());
		// int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		// List<Integer> numberOfDay = VisitHelper.getNumberOfDay(sevenDays);
		// for (Integer i : numberOfDay) {
		// if (dayOfWeek == i) {
		// dayOfWeek = i;
		// break;
		// }
		// ++dayOfWeek;
		// }
		// c.set(day.getYear(), day.getMonth(), dayOfWeek);
		// v.setDate(c.getTime());
		// v.setDoctorName(next.getDoctor().getName());
		// v.setDoctorVorname(next.getDoctor().getSurname());
		// v.setSpecialization(next.getSpecialization().getName());
		// }
		Set<VisitView> visitProposal = new HashSet<VisitView>();
		visitProposal.add(v);
		// TODO: implementacja wolnych wizyt na podstawie visitschedulera oraz
		// visit oraz dodanie wynikow do Set<VisitProposal>
		return visitProposal;
	}

	public Set<VisitProposal> getFreeVisitByDoctor(
			Set<VisitScheduler> findVisitSchedulerByDoctor,
			Set<Visit> findVisitByDateOfVisitAfter) {

		for (VisitScheduler v : findVisitSchedulerByDoctor) {

		}
		Set<VisitProposal> visitProposal = new HashSet<VisitProposal>();
		return visitProposal;
	}

	public static List<Integer> getNumberOfDay(SevenDays s) {
		List<Integer> list = new ArrayList<Integer>();
		if (s.getMon() != null)
			list.add(1);
		if (s.getTue() != null)
			list.add(2);
		if (s.getWen() != null)
			list.add(3);
		if (s.getThu() != null)
			list.add(4);
		if (s.getFri() != null)
			list.add(5);
		if (s.getSat() != null)
			list.add(6);
		if (s.getSun() != null)
			list.add(7);
		return list;
	}

	public Boolean isSpecialVisit(NewVisitMapper newVisit) {
		// TODO Auto-generated method stub
		return null;
	}

	public SevenDays convertDaysToSevenDays(Set<String> set) {
		SevenDays sd = new SevenDays();

		sd.setMon(false);
		sd.setTue(false);
		sd.setWen(false);
		sd.setThu(false);
		sd.setFri(false);
		sd.setSat(false);
		sd.setSun(false);
		for (String d : set) {
			sd.setMon(d.equalsIgnoreCase("monday") ? true : sd.getMon());
			sd.setTue(d.equalsIgnoreCase("tuesday") ? true : sd.getTue());
			sd.setWen(d.equalsIgnoreCase("wednesday") ? true : sd.getWen());
			sd.setThu(d.equalsIgnoreCase("thuesday") ? true : sd.getThu());
			sd.setFri(d.equalsIgnoreCase("friday") ? true : sd.getFri());
			sd.setSat(d.equalsIgnoreCase("saturday") ? true : sd.getSat());
			sd.setSun(d.equalsIgnoreCase("sunday") ? true : sd.getSun());
		}
		return sd;
	}

	//////////////////
	
	
	public Visit fillVisitData(VisitSchedulerView vsv, Calendar startDate) {
		Visit v = new Visit();
		v.setDoctor(doctorDao.findDoctorById(vsv.getIdDoctor()));
		v.setIsLeave(false);
		v.setStatusOfVisit(statusOfVisitDao.findStatusOfVisitByType("wolna")
				.iterator().next());
		v.setTypeOfVisit(typeOfVisitDao
				.findTypeOfVisitByName(vsv.getSpecialization()).iterator()
				.next());
		v.setSpecial(false);
		v.setDateOfVisit(startDate.getTime());
		return v;
	}

	public Calendar computeStartTime(Calendar timeFrom, int i, Integer duration) {
		long milis = duration * 60000 * i;
		long addedmili = timeFrom.getTimeInMillis() + milis;
		Date d = new Date(addedmili);
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal;
	}
	
	public List<Boolean> addAllDays(VisitSchedulerView vsv) {
		List<Boolean> days = new ArrayList<Boolean>();
		days.add(vsv.getMon());
		days.add(vsv.getTue());
		days.add(vsv.getWen());
		days.add(vsv.getThu());
		days.add(vsv.getFri());
		days.add(vsv.getSat());
		days.add(vsv.getSun());
		return days;
	}

	public long getMinutes(Calendar from, Calendar to) {

		long diff = to.getTimeInMillis() - from.getTimeInMillis();
		return (diff / 60000);
	}
	
	public boolean isDayVisit(int dayOfWeekinMonth, List<Boolean> days) {

		for (int i = 1; i < days.size(); i++)
			if (days.get(i) != null && days.get(i) && i == dayOfWeekinMonth)
				return true;
		return false;
	}
	
	public Calendar getStartDate(int day, Calendar d, int st)
			throws ParseException {
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();

		c.set(2015, 12, day, d.get(Calendar.HOUR_OF_DAY),
				d.get(Calendar.MINUTE), 0);
		return c;

	}
}
