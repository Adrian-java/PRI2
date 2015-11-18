package com.eclinic.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllClinics", query = "select myClinic from Clinic myClinic"),
		@NamedQuery(name = "findClinicById", query = "select myClinic from Clinic myClinic where myClinic.id = ?1"),
		@NamedQuery(name = "findClinicByName", query = "select myClinic from Clinic myClinic where myClinic.name = ?1"),
		@NamedQuery(name = "findClinicByNameContaining", query = "select myClinic from Clinic myClinic where myClinic.name like ?1"),
		@NamedQuery(name = "findClinicByPrimaryKey", query = "select myClinic from Clinic myClinic where myClinic.id = ?1") })
@Table(catalog = "eclinic", name = "Clinic")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Clinic")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
public class Clinic implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "name", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_address", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Address address;
	/**
	 */
	@OneToMany(mappedBy = "clinic", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Prescription> prescriptions;

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
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 */
	@JsonIgnore
	public Address getAddress() {
		return address;
	}

	/**
	 */
	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	/**
	 */
	@JsonIgnore
	public Set<Prescription> getPrescriptions() {
		if (prescriptions == null) {
			prescriptions = new java.util.LinkedHashSet<com.eclinic.domain.Prescription>();
		}
		return prescriptions;
	}

	/**
	 */
	public Clinic() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Clinic that) {
		setId(that.getId());
		setName(that.getName());
		setAddress(that.getAddress());
		setPrescriptions(new java.util.LinkedHashSet<com.eclinic.domain.Prescription>(that.getPrescriptions()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");

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
		if (!(obj instanceof Clinic))
			return false;
		Clinic equalCheck = (Clinic) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
