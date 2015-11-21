package com.eclinic.visit.mapper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.visit.planner.CustomComparators;

@Component("VisitsOfScheduler")
public class VisitsOfScheduler {

	
	@Autowired 
	private VisitDAO visitDao;
	
	/*
	 * zwraca liczbę wizyt w konkretnym dniu tygodnia dla konkretnej
	 * specjalizacji oraz konkretnego doktora na podstawie czasu trwania wizyty*
	 */

	private Integer countVisitPerDay(VisitScheduler visitScheduler) {

		long to = visitScheduler.getTimeTo().getTime();
		long from = visitScheduler.getTimeFrom().getTime();
		long diff = to - from; // roznica w ms
		int diffMinutes = (int) (diff / 60000); // roznica w min
		int count = diffMinutes / (visitScheduler.getDuration());
		return count;
	}

	/*
	 * zwraca wszystkie możliwe godziny wizyt w danym dniu tygodnia dla
	 * konkretnego lekarza o konkretnej specjalizacji
	 */

	public Set<Time> startVisits(VisitScheduler visitScheduler) {
		Set<Time> hours = new HashSet<Time>();

		long to = visitScheduler.getTimeTo().getTime();
		long from = visitScheduler.getTimeFrom().getTime();
		long duration = visitScheduler.getDuration() * 60000;
		long times = from;

		while (times < to) {
			Time t = null;
			t.setTime(times);
			hours.add(t);
			times = times + duration;
		}

		return hours;
	}

	/*
	 * tworzy nowe wizyty ze statusem wolna na określony czas od ostatniej
	 * zajętej wizyty
	 */

	public void createFreeVisits(Set <VisitScheduler> visitSchedulers, Set <Visit> visits){
	
		Visit last = findLastVisit(visits);
		Calendar cal;
		Calendar calendar = Calendar.getInstance();
		Date takenDate;
		StatusOfVisit statusOfVisit = new StatusOfVisit();
		statusOfVisit.setId(0);
		statusOfVisit.setType("wolna");
		
		TypeOfVisit typeOfVisit = new TypeOfVisit();
		
		
		if(last != null){
			
			cal = Calendar.getInstance();
			cal.setTime(last.getDateOfVisit());
			cal.set( Calendar.HOUR_OF_DAY, 0 );
	        cal.set( Calendar.MINUTE, 0 );
	        cal.set(Calendar.SECOND, 0 );
	        cal.set( Calendar.MILLISECOND, 0 );
			
		}
		else
		{
			cal = Calendar.getInstance();
			cal.set( Calendar.HOUR_OF_DAY, 0 );
	        cal.set( Calendar.MINUTE, 0 );
	        cal.set(Calendar.SECOND, 0 );
	        cal.set( Calendar.MILLISECOND, 0 );

		}
		
		Calendar forTwoMonths = cal;
		int firstDayWeek = cal.getFirstDayOfWeek();
		cal.set(Calendar.DAY_OF_MONTH, firstDayWeek);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		forTwoMonths.add(Calendar.MONTH, 2);
		
		Set<Date> mon = new HashSet<Date>();
		Set<Date> tue = new HashSet<Date>();
		Set<Date> wed = new HashSet<Date>();
		Set<Date> thr = new HashSet<Date>();
		Set<Date> fri = new HashSet<Date>();
		Set<Date> sat = new HashSet<Date>();
		Set<Date> sun = new HashSet<Date>();
		
		int days = 7;
		
		while(cal.before(forTwoMonths)){
			if(cal.get(Calendar.DAY_OF_WEEK) == 1)
				mon.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 2)
				tue.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 3)
				wed.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 4)
				thr.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 5)
				fri.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 6)
				sat.add(cal.getTime());
			if(cal.get(Calendar.DAY_OF_WEEK) == 7)
				sun.add(cal.getTime());
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
			
			
		}
			for(VisitScheduler v:visitSchedulers){
				Set<Time> hours = startVisits(v);
				SevenDays dayOfWeek = v.getSevenDays();
				typeOfVisit.setDuration(v.getDuration());
				
				if(dayOfWeek.getMon()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date m:mon){	
						m.setHours(takenDate.getHours());
						m.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(m); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
				}
				if(dayOfWeek.getTue()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date t:tue){	
						t.setHours(takenDate.getHours());
						t.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(t); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
				}
					
				}
				if(dayOfWeek.getWen()){
					
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date w:wed){	
						w.setHours(takenDate.getHours());
						w.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(w); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
					
				}
				if(dayOfWeek.getThu()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date t:thr){	
						t.setHours(takenDate.getHours());
						t.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(t); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
					
				}
				if(dayOfWeek.getFri()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date f:fri){	
						f.setHours(takenDate.getHours());
						f.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(f); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
					
				}
				if(dayOfWeek.getSat()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date s:sat){	
						s.setHours(takenDate.getHours());
						s.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(s); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
					
				}
				if(dayOfWeek.getSun()){
					for(Time h:hours){
						takenDate = new Date (h.getTime());
						for(Date s:sun){	
						s.setHours(takenDate.getHours());
						s.setMinutes(takenDate.getMinutes());
						
						calendar.setTime(s); 
					
						Visit visit = new Visit();
						visit.setDoctor(v.getDoctor());
						visit.setDateOfVisit(calendar.getTime());
						visit.setIsLeave(false);
						visit.setSpecial(false);
						visit.setStatusOfVisit(statusOfVisit);
						visit.setTypeOfVisit(typeOfVisit);
						visitDao.store(visit);

						}
					}
					
				}
			}
			
		}

	/*
	 * szukanie ostatniej zajętej wizyty
	 */

	public Visit findLastVisit(Set<Visit> visits) {
		List<Visit> listOfVisit = new ArrayList<Visit>();
		for (Visit visit : visits) {
			if (!visit.getStatusOfVisit().equals(0)) {
				listOfVisit.add(visit);
			}
		}

		if (listOfVisit.size() > 0) {
			Collections.sort(listOfVisit, new CustomComparators());
			return listOfVisit.get(listOfVisit.size() - 1);
		}

		return null;

	}

	/*
	  * 
	  */


}