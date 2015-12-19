package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@NamedQueries(value = { @NamedQuery(name = "findReceptionistViewById", query = "select r from ReceptionistView r where r.id = ?1") })
@Table(catalog = "eclinic", name = "Receptionist_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "ReceptionistView")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class ReceptionistView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	String id;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "register_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar registerDate;
	/**
	 */

	@Column(name = "email", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;


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

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

}
