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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({
		@NamedQuery(name = "findDoctorByPesel", query = "select doctor from DoctorView doctor where id = ?1"),
		@NamedQuery(name = "findDoctorViewById", query = "select doctor from DoctorView doctor where id = ?1") })
@Table(catalog = "eclinic", name = "Doctor_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "DoctorView")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class DoctorView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	String id;

	@Temporal(TemporalType.DATE)
	@Column(name = "register_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar registerDate;

	@Column(name = "is_active", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isActive;
	/**
	 */

	@Column(name = "email", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;

	@Column(name = "role", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String role;

	@Column(name = "name", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;

	@Column(name = "surname", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String surname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
