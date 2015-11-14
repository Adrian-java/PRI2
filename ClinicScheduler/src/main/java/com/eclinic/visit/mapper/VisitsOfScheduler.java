package com.eclinic.visit.mapper;




import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import com.eclinic.domain.VisitScheduler;

public class VisitsOfScheduler {
	
	/*
	 * zwraca liczbę wizyt w konkretnym dniu tygodnia 
	 * dla konkretnej specjalizacji oraz konkretnego doktora
	 * na podstawie czasu trwania wizyty*
	 */
	
	public Integer countVisitPerDay (VisitScheduler visitScheduler){
		
		long to = visitScheduler.getTimeTo().getTime(); 
		long from = visitScheduler.getTimeFrom().getTime();
		long diff = to - from; //roznica w ms
		int diffMinutes = (int) (diff/60000); // roznica w min
		int count = diffMinutes/(visitScheduler.getDuration());
		return count;
	}
	
	
	
	/* zwraca wszystkie możliwe godziny wizyt
	 * w danym dniu tygodnia dla konkretnego lekarza 
	 * o konkretnej specjalizacji
	 */

	public Set<Time> startVisits (VisitScheduler visitScheduler){
		Set<Time> hours = new HashSet<Time>();
		
		long to = visitScheduler.getTimeTo().getTime(); 
		long from = visitScheduler.getTimeFrom().getTime();
		long duration = visitScheduler.getDuration() * 60000;
		long times = from;
		
		while (times < to){
			Time t = null;
			t.setTime(times);
			hours.add(t);
			times = times + duration;
		}
		
		return hours;
}
	
	/* tworzy nowe wizyty ze statusem wolna
	 * na określony czas od ostatniej zajętej wizyty
	 *
	 */
	
	public void createFreeVisits(){
		//TODO
	}
	 /*
	  * 
	  */
	
}