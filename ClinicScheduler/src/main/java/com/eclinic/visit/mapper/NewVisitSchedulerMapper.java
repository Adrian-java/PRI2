package com.eclinic.visit.mapper;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class NewVisitSchedulerMapper {

    private Time timeFrom;
    
    private Time timeTo;
    
    private String idDoctor;
    
    private String specialization;
    
    private String description;

    private Date startDate;
    
    private Integer duration;
    
    private Integer visitRepeat;
    

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

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getVisitRepeat() {
		return visitRepeat;
	}

	public void setVisitRepeat(Integer visitRepeat) {
		this.visitRepeat = visitRepeat;
	}

}
