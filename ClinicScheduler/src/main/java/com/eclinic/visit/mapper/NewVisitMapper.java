package com.eclinic.visit.mapper;

import java.util.Date;

public class NewVisitMapper {

    private Integer patientId;
    
    private Date date;
    
    private String description;
    
    private Integer idReceptionist;
    
    private Integer idDoctor;
    
    private String typeOfVisit;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdReceptionist() {
        return idReceptionist;
    }

    public void setIdReceptionist(Integer idReceptionist) {
        this.idReceptionist = idReceptionist;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getTypeOfVisit() {
	return typeOfVisit;
    }

    public void setTypeOfVisit(String typeOfVisit) {
	this.typeOfVisit = typeOfVisit;
    }
    
    
}
