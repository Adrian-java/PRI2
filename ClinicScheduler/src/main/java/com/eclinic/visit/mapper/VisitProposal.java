package com.eclinic.visit.mapper;

import java.util.Date;

public class VisitProposal {

    private String doctorName;
    
    private String doctorVorname;
    
    private Date date;
    
    private String specialization;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorVorname() {
        return doctorVorname;
    }

    public void setDoctorVorname(String doctorVorname) {
        this.doctorVorname = doctorVorname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    
}
