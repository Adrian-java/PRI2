package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllVisitScheduler", query = "select vsv from VisitSchedulerView vsv") })
@Table(catalog = "eclinic", name = "Visit_Scheduler_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "VisitSchedulerView")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class VisitSchedulerView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	private Integer id;
	@Column(name = "number_of_month")
	private Integer numberOfMonth;
	@Column(name = "description")
	private String description;
	@Column(name = "time_from")
	private Calendar timeFrom;
	@Column(name = "time_to")
	private Calendar timeTo;
	@Column(name = "duration")
	private Integer duration;
	@Column(name = "id_doctor")
	private String idDoctor;
	@Column(name = "register_date")
	private Calendar registerDate;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "Mon")
	private Boolean Mon;
	@Column(name = "Tue")
	private Boolean Tue;
	@Column(name = "Wen")
	private Boolean Wen;
	@Column(name = "Thu")
	private Boolean Thu;
	@Column(name = "Fri")
	private Boolean Fri;
	@Column(name = "Sat")
	private Boolean Sat;
	@Column(name = "Sun")
	private Boolean Sun;
	@Column(name = "specialization")
	private String specialization;
	@Column(name = "specialization_description")
	private String specializationDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfMonth() {
		return numberOfMonth;
	}

	public void setNumberOfMonth(Integer numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Calendar timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Calendar getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Calendar timeTo) {
		this.timeTo = timeTo;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Calendar getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Boolean getMon() {
		return Mon;
	}

	public void setMon(Boolean mon) {
		Mon = mon;
	}

	public Boolean getTue() {
		return Tue;
	}

	public void setTue(Boolean tue) {
		Tue = tue;
	}

	public Boolean getWen() {
		return Wen;
	}

	public void setWen(Boolean wen) {
		Wen = wen;
	}

	public Boolean getThu() {
		return Thu;
	}

	public void setThu(Boolean thu) {
		Thu = thu;
	}

	public Boolean getFri() {
		return Fri;
	}

	public void setFri(Boolean fri) {
		Fri = fri;
	}

	public Boolean getSat() {
		return Sat;
	}

	public void setSat(Boolean sat) {
		Sat = sat;
	}

	public Boolean getSun() {
		return Sun;
	}

	public void setSun(Boolean sun) {
		Sun = sun;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSpecializationDescription() {
		return specializationDescription;
	}

	public void setSpecializationDescription(String specializationDescription) {
		this.specializationDescription = specializationDescription;
	}

}
