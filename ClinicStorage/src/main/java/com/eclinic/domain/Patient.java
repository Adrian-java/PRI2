package com.eclinic.domain;

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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPatients", query = "select myPatient from Patient myPatient"),
		@NamedQuery(name = "findPatientByConfirmed", query = "select myPatient from Patient myPatient where myPatient.confirmed = ?1"),
		@NamedQuery(name = "findPatientByDateOfBirth", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth = ?1"),
		@NamedQuery(name = "findPatientByDateOfBirthAfter", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth > ?1"),
		@NamedQuery(name = "findPatientByDateOfBirthBefore", query = "select myPatient from Patient myPatient where myPatient.dateOfBirth < ?1"),
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
@XmlType(namespace = "Web/com/eclinic/domain", name = "Patient")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "systemUser") })
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(generator = "foreign")
	String id;
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
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_address", referencedColumnName = "Id", nullable = false)})
	@XmlTransient
	Address address;
	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@XmlElement(name = "", namespace = "")
	SystemUser systemUser;
	/**
	 */
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits;
	/**
	 */
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> documentses;

	/**
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 */
	public String getId() {
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
//	@JsonIgnore
	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	/**
	 */
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	/**
	 */
	@JsonIgnore
	public SystemUser getSystemUser() {
		return systemUser;
	}

	/**
	 */
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	/**
	 */
	@JsonIgnore
	public Set<Visit> getVisits() {
		if (visits == null) {
			visits = new java.util.LinkedHashSet<com.eclinic.domain.Visit>();
		}
		return visits;
	}

	/**
	 */
	public void setDocumentses(Set<Documents> documentses) {
		this.documentses = documentses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Documents> getDocumentses() {
		if (documentses == null) {
			documentses = new java.util.LinkedHashSet<com.eclinic.domain.Documents>();
		}
		return documentses;
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
		setId(that.getId());
		setName(that.getName());
		setSurname(that.getSurname());
		setDateOfBirth(that.getDateOfBirth());
		setPhoneNr(that.getPhoneNr());
		setConfirmed(that.getConfirmed());
		setAddress(that.getAddress());
		setSystemUser(that.getSystemUser());
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(that.getVisits()));
		setDocumentses(new java.util.LinkedHashSet<com.eclinic.domain.Documents>(that.getDocumentses()));
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
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
