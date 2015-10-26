package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({ @NamedQuery(name = "findSystemUserPermissionByPesel", query = "select sup from SystemUserPermissionView sup where sup.pesel = ?1") })
@Table(catalog = "eclinic", name = "System_User_Permission_View")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SystemUserPermissionView")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class SystemUserPermissionView {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	private Integer id;

	@Column(name = "pesel", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String pesel;

	@Column(name = "name", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;

	@Column(name = "display")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean display;
	/**
	 */

	@Column(name = "edit")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean edit;
	/**
	 */

	@Column(name = "execute")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean execute;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Boolean getEdit() {
		return edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	public Boolean getExecute() {
		return execute;
	}

	public void setExecute(Boolean execute) {
		this.execute = execute;
	}

}
