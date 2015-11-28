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
		@NamedQuery(name = "getAllPatients", query = "select patient from PatientView patient"),
		@NamedQuery(name = "getPatientByPesel", query = "select patient from PatientView patient where patient.id = ?1") })
@Table(catalog = "eclinic", name = "Patient_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Patient_View")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class PatientView {

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
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
	 * email
	 * 
	 */

	@Column(name = "email", length = 20, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String EMail;
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

	@Column(name = "city", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "country_code", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String countryCode;
	/**
	 */

	@Column(name = "province", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String province;
	/**
	 */

	@Column(name = "country", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String country;
	/**
	 */

	@Column(name = "country_code_city", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String countryCodeCity;
	/**
	 */

	@Column(name = "home_nr", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String homeNr;

	/**
	 */

	@Temporal(TemporalType.DATE)
	@Column(name = "register_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar registerDate;
	/**
	 */

	@Column(name = "is_active", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isActive;
	/**
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public Integer getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCodeCity() {
		return countryCodeCity;
	}

	public void setCountryCodeCity(String countryCodeCity) {
		this.countryCodeCity = countryCodeCity;
	}

	public String getHomeNr() {
		return homeNr;
	}

	public void setHomeNr(String homeNr) {
		this.homeNr = homeNr;
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

}
