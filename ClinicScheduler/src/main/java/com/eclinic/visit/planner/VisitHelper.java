package com.eclinic.visit.planner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.eclinic.domain.DayOfWeek;
import com.eclinic.domain.SevenDays;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.visit.mapper.NewVisitMapper;
import com.eclinic.visit.mapper.VisitProposal;

@Component("VisitHelper")
public class VisitHelper {

    public Set<VisitProposal> getFreeVisitBySpecialization(
	    Set<VisitScheduler> findVisitSchedulerBySpecialization,
	    Set<Visit> findVisitByDateOfVisitAfter) {
	VisitProposal v = new VisitProposal();
	if (findVisitByDateOfVisitAfter.isEmpty()) {
	    VisitScheduler next = findVisitSchedulerBySpecialization.iterator().next();
	    Date day = new Date();
	    SevenDays sevenDays = next.getSevenDays();
	    Calendar c = Calendar.getInstance();
	    c.set(day.getYear(), day.getMonth(), day.getDay());
	    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	    List<Integer> numberOfDay = VisitHelper.getNumberOfDay(sevenDays);
	    for (Integer i : numberOfDay) {
		if (dayOfWeek == i) {
		    dayOfWeek = i;
		    break;
		}
		++dayOfWeek;
	    }
	    c.set(day.getYear(), day.getMonth(), dayOfWeek);
	    v.setDate(c.getTime());
	    v.setDoctorName(next.getDoctor().getName());
	    v.setDoctorVorname(next.getDoctor().getSurname());
	    v.setSpecialization(next.getSpecialization().getName());
	}
	Set<VisitProposal> visitProposal = new HashSet<VisitProposal>();
	visitProposal.add(v);
	// TODO: implementacja wolnych wizyt na podstawie visitschedulera oraz
	// visit oraz dodanie wynikow do Set<VisitProposal>
	return visitProposal;
    }

    public Set<VisitProposal> getFreeVisitByDoctor(Set<VisitScheduler> findVisitSchedulerByDoctor,
	    Set<Visit> findVisitByDateOfVisitAfter) {
	Set<VisitProposal> visitProposal = new HashSet<VisitProposal>();

	return visitProposal;
    }

    private static List<Integer> getNumberOfDay(SevenDays s) {
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

}
