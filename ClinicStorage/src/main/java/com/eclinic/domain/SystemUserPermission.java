package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(catalog = "eclinic", name = "System_User_Permission")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SystemUserPermission")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class SystemUserPermission {

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	private
	Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_permission", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	private
	Permission permission;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_system_user", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	private
	SystemUser systemUser;
	
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
}
