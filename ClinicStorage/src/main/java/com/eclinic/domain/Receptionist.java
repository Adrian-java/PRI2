package com.eclinic.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllReceptionists", query = "select myReceptionist from Receptionist myReceptionist"),
		@NamedQuery(name = "findReceptionistById", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.id = ?1"),
		@NamedQuery(name = "findReceptionistByName", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.name = ?1"),
		@NamedQuery(name = "findReceptionistByNameContaining", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.name like ?1"),
		@NamedQuery(name = "findReceptionistByPhoneNr", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.phoneNr = ?1"),
		@NamedQuery(name = "findReceptionistByPhoneNrContaining", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.phoneNr like ?1"),
		@NamedQuery(name = "findReceptionistByPrimaryKey", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.id = ?1"),
		@NamedQuery(name = "findReceptionistBySurname", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.surname = ?1"),
		@NamedQuery(name = "findReceptionistBySurnameContaining", query = "select myReceptionist from Receptionist myReceptionist where myReceptionist.surname like ?1") })
@Table(catalog = "eclinic", name = "Receptionist")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Receptionist")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "systemUser") })
public class Receptionist implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(generator = "foreign")
	Integer id;
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

	@Column(name = "phone_nr", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phoneNr;
	/**
	 */

	@Column(name = "access", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] access;

	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@XmlElement(name = "", namespace = "")
	SystemUser systemUser;
	/**
	 */
	@OneToMany(mappedBy = "receptionist", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
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
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	/**
	 */
	public String getPhoneNr() {
		return this.phoneNr;
	}

	/**
	 */
	public void setAccess(byte[] access) {
		this.access = access;
	}

	/**
	 */
	public byte[] getAccess() {
		return this.access;
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
	public Receptionist() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Receptionist that) {
		setId(that.getId());
		setName(that.getName());
		setSurname(that.getSurname());
		setPhoneNr(that.getPhoneNr());
		setAccess(that.getAccess());
		setSystemUser(that.getSystemUser());
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(that.getVisits()));
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
		buffer.append("phoneNr=[").append(phoneNr).append("] ");
		buffer.append("access=[").append(access).append("] ");

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
		if (!(obj instanceof Receptionist))
			return false;
		Receptionist equalCheck = (Receptionist) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
