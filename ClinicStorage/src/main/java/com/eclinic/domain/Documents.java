package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({
		@NamedQuery(name = "findDocumentsById", query = "select myDocuments from Documents myDocuments where myDocuments.id = ?1"),
		@NamedQuery(name = "findDocumentsByType", query = "select myDocuments from Documents myDocuments where myDocuments.typeOfDocuments = ?1"),
		@NamedQuery(name = "findDocumentsByDate", query = "select myDocuments from Documents myDocuments where myDocuments.dateOfDocuments = ?1"),
		@NamedQuery(name = "findDocumentsByPatient", query = "select myDocuments from Documents myDocuments where myDocuments.patient = ?1"),
		@NamedQuery(name = "findDocumentsByDoctor", query = "select myDocuments from Documents myDocuments where myDocuments.doctor = ?1") })
@Table(catalog = "eclinic", name = "Documents")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Documents")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Documents {


	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Patient patient;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_documents", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateOfDocuments;
	
	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String description;
	
	@Column(name = "type_of_documents")
	@XmlElement
	String typeOfDocuments;
	
	@Column(name = "data_of_documents")
	@XmlElement
	String dataOfDocuments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Calendar getDateOfDocuments() {
		return dateOfDocuments;
	}

	public void setDateOfDocuments(Calendar dateOfDocuments) {
		this.dateOfDocuments = dateOfDocuments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeOfDocuments() {
		return typeOfDocuments;
	}

	public void setTypeOfDocuments(String typeOfDocuments) {
		this.typeOfDocuments = typeOfDocuments;
	}

	public String getDataOfDocuments() {
		return dataOfDocuments;
	}

	public void setDataOfDocuments(String dataOfDocuments) {
		this.dataOfDocuments = dataOfDocuments;
	}
	
	
}
