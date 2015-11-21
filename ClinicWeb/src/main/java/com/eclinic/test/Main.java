package com.eclinic.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.view.VisitSchedulerViewDAO;
import com.eclinic.dao.view.VisitViewDAO;
import com.eclinic.domain.Visit;
import com.eclinic.domain.view.VisitSchedulerView;
import com.eclinic.domain.view.VisitView;

public class Main {

	private static Main m;

	private static DoctorDAO doctorDao;

	private static TypeOfVisitDAO typeOfVisitDao;

	private static StatusOfVisitDAO statusOfVisitDao;

	private static VisitDAO visitDao;

	private static VisitViewDAO visitViewDao;

	public static void main(String... args) throws ParseException {

		System.out.println();
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		m = new Main();

		VisitSchedulerViewDAO visitSchedulerViewDao = (VisitSchedulerViewDAO) ctx
				.getBean("VisitSchedulerViewDAO");
		doctorDao = (DoctorDAO) ctx.getBean("DoctorDAO");
		typeOfVisitDao = (TypeOfVisitDAO) ctx.getBean("TypeOfVisitDAO");
		statusOfVisitDao = (StatusOfVisitDAO) ctx.getBean("StatusOfVisitDAO");
		visitDao = (VisitDAO) ctx.getBean("VisitDAO");
		visitViewDao = (VisitViewDAO) ctx.getBean("VisitViewDAO");
		
		Set<VisitView> freeBySp = visitViewDao.findFreeVisitBySpecialization("Psycholog", 10);
		System.out.println();
//		Set<VisitSchedulerView> allVisitSchedulerView = visitSchedulerViewDao
//				.findAllVisitScheduler();
//		m.setVisit(allVisitSchedulerView);

	}

	private Calendar getStartDate(int day, Calendar d, int st)
			throws ParseException {
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();

		c.set(2015, 12, day, d.get(Calendar.HOUR_OF_DAY),
				d.get(Calendar.MINUTE), 0);
		return c;

	}

	public void setVisit(Set<VisitSchedulerView> allVisitSchedulerView)
			throws ParseException {
		int z = 0;
		for (VisitSchedulerView vsv : allVisitSchedulerView) {
			List<Boolean> days = addAllDays(vsv);
			System.out.println("Progress:" + (++z) + "/"
					+ allVisitSchedulerView.size());
			long minutes = m.getMinutes(vsv.getTimeFrom(), vsv.getTimeTo());
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
				if (isDayVisit(calendar.get(Calendar.DAY_OF_WEEK) - 1, days)) {
					for (int i = 1; i <= numberVisitInDay; i++) {
						Calendar actD = computeStartTime(calendar, i - 1,
								vsv.getDuration());
						Calendar startDate = m.getStartDate(singleDayInMonth,
								actD, 0);
						Visit v = fillVisitData(vsv, startDate);
						visitDao.store(v);
						actualCalendar = actD;
					}
				}
			}
		}
	}

	private boolean isDayVisit(int dayOfWeekinMonth, List<Boolean> days) {

		for (int i = 1; i < days.size(); i++)
			if (days.get(i) != null && days.get(i) && i == dayOfWeekinMonth)
				return true;
		return false;
	}

	private Visit fillVisitData(VisitSchedulerView vsv, Calendar startDate) {
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

	private Calendar computeStartTime(Calendar timeFrom, int i, Integer duration) {
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

}
