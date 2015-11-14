package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPatients", query = "select myPatient from Patient myPatient"),
		@NamedQuery(name = "findPatientByConfirmed", query = "select myPatient from Patient myPatient where myPatient.confirmed = ?1"),
		@NamedQuery(name = "findPatientByDateOfBirth", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth = ?1"),
		@NamedQuery(name = "findPatientByDateOfBirthAfter", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth > ?1"),
		@NamedQuery(name = "findPatientByDateOfBirthBefore", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth < ?1"),
		@NamedQuery(name = "findPatientByEMail", query = "select myPatient from Patient myPatient"),
		@NamedQuery(name = "findPatientByEMailContaining", query = "select myPatient from Patient myPatient"),
		@NamedQuery(name = "findPatientById", query = "select myPatient from Patient myPatient where myPatient.id = ?1"),
		@NamedQuery(name = "findPatientByName", query = "select myPatient from Patient myPatient where myPatient.name = ?1"),
		@NamedQuery(name = "findPatientByNameContaining", query = "select myPatient from Patient myPatient where myPatient.name like ?1"),
		@NamedQuery(name = "findPatientByPhoneNr", query = "select myPatient from Patient myPatient where myPatient.phoneNr = ?1"),
		@NamedQuery(name = "findPatientByPhoneNrContaining", query = "select myPatient from Patient myPatient where myPatient.phoneNr like ?1"),
		@NamedQuery(name = "findPatientByPrimaryKey", query = "select myPatient from Patient myPatient where myPatient.id = ?1"),
		@NamedQuery(name = "findPatientBySurname", query = "select myPatient from Patient myPatient where myPatient.surname = ?1"),
		@NamedQuery(name = "findPatientBySurnameContaining", query = "select myPatient from Patient myPatient where myPatient.surname like ?1") })
@Table(catalog = "eclinic", name = "Patient")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Patient")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "name", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 * nazwisko
	 * 
	 */

	@Column(name = "surname", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String surname;

	/**
	 * data urodzenia
	 * 
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateOfBirth;
	/**
	 * email
	 * 
	 */

//	@Column(name = "e_mail", length = 20, nullable = true)
//	@Basic(fetch = FetchType.EAGER)
//	@XmlElement
//	String EMail;
	/**
	 * telefon
	 * 
	 */

	@Column(name = "phone_nr", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phoneNr;
	/**
	 */

	@Column(name = "confirmed", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer confirmed;

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_address", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Address address;
	/**
	 */
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Worker> workers;
	
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> documents;

	/**
	 */
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits;
	
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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nazwisko
	 * 
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * nazwisko
	 * 
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * data urodzenia
	 * 
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * data urodzenia
	 * 
	 */
	public Calendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * email
	 * 
	 */
//	public void setEMail(String EMail) {
//		this.EMail = EMail;
//	}
//
//	/**
//	 * email
//	 * 
//	 */
//	public String getEMail() {
//		return this.EMail;
//	}

	/**
	 * telefon
	 * 
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	/**
	 * telefon
	 * 
	 */
	public String getPhoneNr() {
		return this.phoneNr;
	}

	/**
	 */
	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 */
	public Integer getConfirmed() {
		return this.confirmed;
	}

	/**
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 */
	// @JsonIgnore
	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}



	/**
	 */
	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}

	/**
	 */
	@JsonIgnore
	public Set<Worker> getWorkers() {
		if (workers == null) {
			workers = new java.util.LinkedHashSet<com.eclinic.domain.Worker>();
		}
		return workers;
	}


	/**
	 */
	public Patient() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Patient that) {
		if (that.getId() != null)
			setId(that.getId());
		if (that.getName() != null)
			setName(that.getName());
		if (that.getSurname() != null)
			setSurname(that.getSurname());
		if (that.getDateOfBirth() != null)
			setDateOfBirth(that.getDateOfBirth());
//		if (that.getEMail() != null)
//			setEMail(that.getEMail());
		if (that.getPhoneNr() != null)
			setPhoneNr(that.getPhoneNr());
		if (that.getConfirmed() != null)
			setConfirmed(that.getConfirmed());
		if (that.getAddress() != null)
			setAddress(that.getAddress());
		setWorkers(new java.util.LinkedHashSet<com.eclinic.domain.Worker>(
				that.getWorkers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("surname=[").append(surname).append("] ");
		buffer.append("dateOfBirth=[").append(dateOfBirth).append("] ");
//		buffer.append("EMail=[").append(EMail).append("] ");
		buffer.append("phoneNr=[").append(phoneNr).append("] ");
		buffer.append("confirmed=[").append(confirmed).append("] ");

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
		if (!(obj instanceof Patient))
			return false;
		Patient equalCheck = (Patient) obj;
		if ((id == null && equalCheck.id != null)
				|| (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public // @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> documents) {
		this.documents = documents;
	}

	public //@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> getVisits() {
		return visits;
	}

	public void setVisits(//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits) {
		this.visits = visits;
	}
}
