package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllVisits", query = "select myVisit from Visit myVisit"),
		@NamedQuery(name = "findVisitByDateOfVisit", query = "select myVisit from Visit myVisit where myVisit.dateOfVisit = ?1"),
		@NamedQuery(name = "findVisitByDateOfVisitAfter", query = "select myVisit from Visit myVisit where myVisit.dateOfVisit > ?1"),
		@NamedQuery(name = "findVisitByDateOfVisitBefore", query = "select myVisit from Visit myVisit where myVisit.dateOfVisit < ?1"),
		@NamedQuery(name = "findVisitById", query = "select myVisit from Visit myVisit where myVisit.id = ?1"),
		@NamedQuery(name = "findVisitByIsLeave", query = "select myVisit from Visit myVisit where myVisit.isLeave = ?1"),
		@NamedQuery(name = "findVisitByStatus", query = "select myVisit from Visit myVisit where myVisit.typeOfVisit.name = ?1"),
		@NamedQuery(name = "findVisitByPrimaryKey", query = "select myVisit from Visit myVisit where myVisit.id = ?1"),
		@NamedQuery(name = "findVisitByPesel", query = "select v from Visit v where v.patient in (select p from Patient p where  p in (select su.patient from SystemUser su where su.id =?1 ))))"),
		@NamedQuery(name = "findVisitByDateDoctor", query = "select v from Visit v where v.doctor = ?1)"),
		@NamedQuery(name = "findVisitByPatient", query = "select v from Visit v "),
		@NamedQuery(name = "findVisitBySpecial", query = "select myVisit from Visit myVisit where myVisit.special = ?1") })
@Table(catalog = "eclinic", name = "Visit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Visit")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	/**
	 */
//	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_visit", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date dateOfVisit;
	
//	@Temporal(TemporalType.TIME)
//	@Column(name = "time_of_visit", nullable = false)
//	@Basic(fetch = FetchType.EAGER)
//	@XmlElement
//	private
//	Date timeOfVisit;
	/**
	 */

	@Column(name = "description_of_visit", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String descriptionOfVisit;
	/**
	 */

	@Column(name = "is_leave", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isLeave;
	/**
	 */

	@Column(name = "special", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean special;

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "Id", nullable = true) })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_type_of_visit", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	TypeOfVisit typeOfVisit;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_receptionist", referencedColumnName = "Id", nullable = true) })
	@XmlTransient
	Receptionist receptionist;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_status_of_visit", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	StatusOfVisit statusOfVisit;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;

	@OneToMany(mappedBy = "visit", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	private
	java.util.Set<com.eclinic.domain.Documents> documents;
	
	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	/**
	 */
	public Date getDateOfVisit() {
		return this.dateOfVisit;
	}

	/**
	 */
	public void setDescriptionOfVisit(String descriptionOfVisit) {
		this.descriptionOfVisit = descriptionOfVisit;
	}

	/**
	 */
	public String getDescriptionOfVisit() {
		return this.descriptionOfVisit;
	}

	/**
	 */
	public void setIsLeave(Boolean isLeave) {
		this.isLeave = isLeave;
	}

	/**
	 */
	public Boolean getIsLeave() {
		return this.isLeave;
	}

	/**
	 */
	public void setSpecial(Boolean special) {
		this.special = special;
	}

	/**
	 */
	public Boolean getSpecial() {
		return this.special;
	}

	/**
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("patient")
	public Patient getPatient() {
		return patient;
	}

	/**
	 */
	public void setTypeOfVisit(TypeOfVisit typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("typeOfVisit")
	public TypeOfVisit getTypeOfVisit() {
		return typeOfVisit;
	}

	/**
	 */
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("receptionist")
	public Receptionist getReceptionist() {
		return receptionist;
	}

	/**
	 */
	public void setStatusOfVisit(StatusOfVisit statusOfVisit) {
		this.statusOfVisit = statusOfVisit;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("statusOfVisit")
	public StatusOfVisit getStatusOfVisit() {
		return statusOfVisit;
	}

	/**
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("doctor")
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 */
	public Visit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Visit that) {
		setId(that.getId());
		setDateOfVisit(that.getDateOfVisit());
		setDescriptionOfVisit(that.getDescriptionOfVisit());
		setIsLeave(that.getIsLeave());
		setSpecial(that.getSpecial());
		setPatient(that.getPatient());
		setTypeOfVisit(that.getTypeOfVisit());
		setReceptionist(that.getReceptionist());
		setStatusOfVisit(that.getStatusOfVisit());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("dateOfVisit=[").append(dateOfVisit).append("] ");
		buffer.append("descriptionOfVisit=[").append(descriptionOfVisit).append("] ");
		buffer.append("isLeave=[").append(isLeave).append("] ");
		buffer.append("special=[").append(special).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Visit))
			return false;
		Visit equalCheck = (Visit) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public java.util.Set<com.eclinic.domain.Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(java.util.Set<com.eclinic.domain.Documents> documents) {
		this.documents = documents;
	}

}
