package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(catalog = "eclinic", name = "Admin_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "AdminView")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class AdminView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "pesel", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private String pesel;
	/**
	 */

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;
	/**
	 */

	@Column(name = "is_super")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	Boolean isSuper;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public byte[] getDescription() {
		return description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}

	public Boolean getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}

}
