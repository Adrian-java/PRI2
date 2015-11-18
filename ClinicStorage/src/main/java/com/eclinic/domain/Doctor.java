package com.eclinic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllDoctors", query = "select myDoctor from Doctor myDoctor"),
		@NamedQuery(name = "findDoctorById", query = "select myDoctor from Doctor myDoctor where myDoctor.id = ?1"),
		@NamedQuery(name = "findDoctorByName", query = "select myDoctor from Doctor myDoctor where myDoctor.name = ?1"),
		@NamedQuery(name = "findDoctorByNameContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.name like ?1"),
		@NamedQuery(name = "findDoctorByPrimaryKey", query = "select myDoctor from Doctor myDoctor where myDoctor.id = ?1"),
		@NamedQuery(name = "findDoctorBySurname", query = "select myDoctor from Doctor myDoctor where myDoctor.surname = ?1"),
		@NamedQuery(name = "findDoctorBySurnameContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.surname like ?1") })
@Table(catalog = "eclinic", name = "Doctor")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Doctor")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "systemUser") })
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	// @Column(name = "Id", nullable = false)
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
	 */

	@Column(name = "surname", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String surname;

	/**
	 */
	// @Id
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@XmlElement(name = "", namespace = "")
	SystemUser systemUser;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Specialization> specializations;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> documentses;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Graphic> graphics;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.VisitScheduler> visitSchedulers;

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
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 */
	public String getSurname() {
		return this.surname;
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
	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}

	/**
	 */
	@JsonIgnore
	public Set<Specialization> getSpecializations() {
		if (specializations == null) {
			specializations = new java.util.LinkedHashSet<com.eclinic.domain.Specialization>();
		}
		return specializations;
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
	public void setGraphics(Set<Graphic> graphics) {
		this.graphics = graphics;
	}

	/**
	 */
	@JsonIgnore
	public Set<Graphic> getGraphics() {
		if (graphics == null) {
			graphics = new java.util.LinkedHashSet<com.eclinic.domain.Graphic>();
		}
		return graphics;
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
	public void setVisitSchedulers(Set<VisitScheduler> visitSchedulers) {
		this.visitSchedulers = visitSchedulers;
	}

	/**
	 */
	@JsonIgnore
	public Set<VisitScheduler> getVisitSchedulers() {
		if (visitSchedulers == null) {
			visitSchedulers = new java.util.LinkedHashSet<com.eclinic.domain.VisitScheduler>();
		}
		return visitSchedulers;
	}

	/**
	 */
	public Doctor() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Doctor that) {
		setId(that.getId());
		setName(that.getName());
		setSurname(that.getSurname());
		setSystemUser(that.getSystemUser());
		setSpecializations(new java.util.LinkedHashSet<com.eclinic.domain.Specialization>(
				that.getSpecializations()));
		setDocumentses(new java.util.LinkedHashSet<com.eclinic.domain.Documents>(
				that.getDocumentses()));
		setGraphics(new java.util.LinkedHashSet<com.eclinic.domain.Graphic>(
				that.getGraphics()));
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(
				that.getVisits()));
		setVisitSchedulers(new java.util.LinkedHashSet<com.eclinic.domain.VisitScheduler>(
				that.getVisitSchedulers()));
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
		if (!(obj instanceof Doctor))
			return false;
		Doctor equalCheck = (Doctor) obj;
		if ((id == null && equalCheck.id != null)
				|| (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
