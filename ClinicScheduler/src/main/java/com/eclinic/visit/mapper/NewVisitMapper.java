package com.eclinic.visit.mapper;

import java.util.Date;

public class NewVisitMapper {

    private String patientId;
    
    private Date date;
    
    private String description;
    
    private String idReceptionist;
    
    private String idDoctor;
    
    private String typeOfVisit;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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

    public String getIdReceptionist() {
        return idReceptionist;
    }

    public void setIdReceptionist(String idReceptionist) {
        this.idReceptionist = idReceptionist;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getTypeOfVisit() {
	return typeOfVisit;
    }

    public void setTypeOfVisit(String typeOfVisit) {
	this.typeOfVisit = typeOfVisit;
    }
    
    
}
