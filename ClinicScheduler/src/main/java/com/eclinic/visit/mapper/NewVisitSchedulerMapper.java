package com.eclinic.visit.mapper;

import java.sql.Time;
import java.util.Set;

import com.eclinic.domain.DayOfWeek;

public class NewVisitSchedulerMapper {

    private Time timeFrom;
    
    private Time timeTo;
    
    private Integer idDoctor;
    
    private String specialization;
    
    private String description;

    private Set<String> daysOfWeek;

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getDaysOfWeek() {
	return daysOfWeek;
    }

    public void setDaysOfWeek(Set<String> daysOfWeek) {
	this.daysOfWeek = daysOfWeek;
    }

}