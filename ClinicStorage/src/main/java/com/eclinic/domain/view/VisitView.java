package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

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
@NamedQueries({
		@NamedQuery(name = "findAllVisitView", query = "select vs from VisitView vs"),
		@NamedQuery(name = "findAllVisitViewById", query = "select vs from VisitView vs where vs.id = ?1"),
		@NamedQuery(name = "findVisitViewByStatus", query = "select vs from VisitView vs where vs.status = ?1"),
		@NamedQuery(name = "findVisitViewByPatient", query = "select vs from VisitView vs where vs.idPatient = ?1"),
		@NamedQuery(name = "findDoneVisitViewByPatient", query = "select vs from VisitView vs where vs.idPatient = ?1 and dateOfVisit <= ?2"),
		@NamedQuery(name = "findPlaneVisitViewByPatient", query = "select vs from VisitView vs where vs.idPatient = ?1 and vs.dateOfVisit > ?2 and vs.status != 'wolna' "),
		@NamedQuery(name = "findVisitViewByDoctorAndDate", query = "select vs from VisitView vs where vs.idDoctor = ?1 and vs.dateOfVisit between ?2 and ?3 and vs.status != 'wolna'"),
		@NamedQuery(name = "findVisitViewByDateOfVisit", query = "select vs from VisitView vs where vs.dateOfVisit >= ?1"),
		@NamedQuery(name = "findVisitViewBySpecialization", query = "select vs from VisitView vs where vs.specialization =  ?1"),
		@NamedQuery(name = "findVisitViewBySpecializationAndDate", query = "select vs from VisitView vs where vs.specialization =  ?1 and vs.dateOfVisit between ?2 and ?3"),
		@NamedQuery(name = "findVisitViewByDoctorAndSpecializationAndDate", query = "select vs from VisitView vs where vs.idDoctor = ?1 and vs.specialization =  ?2 and vs.dateOfVisit between ?3 and ?4 and vs.status !='wolna'"),
		@NamedQuery(name = "findVisitViewByDate", query = "select vs from VisitView vs where vs.dateOfVisit between ?1 and ?2"),
		@NamedQuery(name = "findFreeVisitViewByDoctor", query = "select vs from VisitView vs where vs.status = 'wolna' and vs.idDoctor = ?1"),
		@NamedQuery(name = "findFreeVisitViewBySpecialization", query = "select vs from VisitView vs where vs.status = 'wolna' and vs.specialization = ?1") })
@Table(catalog = "eclinic", name = "Visit_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "VisitScheduler")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class VisitView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	private Integer id;
	@Column(name = "id_patient")
	private String idPatient;
	@Column(name = "date_of_visit")
	private Date dateOfVisit;
	@Column(name = "description_of_visit")
	private String descriptionOfVisit;
	@Column(name = "is_leave")
	private Boolean leave;
	@Column(name = "id_receptionist")
	private String idReceptionist;
	@Column(name = "special")
	private Boolean special;
	@Column(name = "status")
	private String status;
	@Column(name = "specialization")
	private String specialization;
	@Column(name = "description")
	private String description;
	@Column(name = "id_doctor")
	private String idDoctor;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDescriptionOfVisit() {
		return descriptionOfVisit;
	}

	public void setDescriptionOfVisit(String descriptionOfVisit) {
		this.descriptionOfVisit = descriptionOfVisit;
	}

	public Boolean getLeave() {
		return leave;
	}

	public void setLeave(Boolean leave) {
		this.leave = leave;
	}

	public String getIdReceptionist() {
		return idReceptionist;
	}

	public void setIdReceptionist(String idReceptionist) {
		this.idReceptionist = idReceptionist;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
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
}
