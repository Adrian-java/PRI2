package com.eclinic.graphic;

import java.util.Date;

import com.eclinic.domain.Graphic;

public class NewGraphicMapper {
	
	private Integer idDoctor;
	private boolean absence;
	private Date from;
	private Date to;
	

	public Integer getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}
	public boolean isAbsence() {
		return absence;
	}
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}

}
