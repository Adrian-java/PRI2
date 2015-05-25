package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSystemUsers", query = "select mySystemUser from SystemUser mySystemUser"),
		@NamedQuery(name = "findSystemUserByChangedPassword", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.changedPassword = ?1"),
		@NamedQuery(name = "findSystemUserByEmail", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.email = ?1"),
		@NamedQuery(name = "findSystemUserByEmailContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.email like ?1"),
		@NamedQuery(name = "findSystemUserById", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.id = ?1"),
		@NamedQuery(name = "findSystemUserByIsActive", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.isActive = ?1"),
		@NamedQuery(name = "findSystemUserByLogin", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.login = ?1"),
		@NamedQuery(name = "findSystemUserByLoginContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.login like ?1"),
		@NamedQuery(name = "findSystemUserByPassword", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.password = ?1"),
		@NamedQuery(name = "findSystemUserByPasswordContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.password like ?1"),
		@NamedQuery(name = "findSystemUserByPrimaryKey", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.id = ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDate", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate = ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDateAfter", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate > ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDateBefore", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate < ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDate", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate = ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDateAfter", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate > ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDateBefore", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate < ?1") })
@Table(catalog = "eclinic", name = "System_User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SystemUser")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class SystemUser implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "login", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String login;
	/**
	 */

	@Column(name = "password", length = 20000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;
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

	@Column(name = "changedPassword", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean changedPassword;
	/**
	 */

	@Column(name = "email", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "unregister_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar unregisterDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_worker", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Worker worker;
	/**
	 */
	@OneToMany(mappedBy = "systemUser", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Permission> permissions;

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
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setDescription(byte[] description) {
		this.description = description;
	}

	/**
	 */
	public byte[] getDescription() {
		return this.description;
	}

	/**
	 */
	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 */
	public Calendar getRegisterDate() {
		return this.registerDate;
	}

	/**
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 */
	public Boolean getIsActive() {
		return this.isActive;
	}

	/**
	 */
	public void setChangedPassword(Boolean changedPassword) {
		this.changedPassword = changedPassword;
	}

	/**
	 */
	public Boolean getChangedPassword() {
		return this.changedPassword;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setUnregisterDate(Calendar unregisterDate) {
		this.unregisterDate = unregisterDate;
	}

	/**
	 */
	public Calendar getUnregisterDate() {
		return this.unregisterDate;
	}

	/**
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/**
	 */
	//@JsonIgnore
	@JsonProperty("worker")
	public Worker getWorker() {
		return worker;
	}

	/**
	 */
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	/**
	 */
	@JsonIgnore
	public Set<Permission> getPermissions() {
		if (permissions == null) {
			permissions = new java.util.LinkedHashSet<com.eclinic.domain.Permission>();
		}
		return permissions;
	}

	/**
	 */
	public SystemUser() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(SystemUser that) {
		setId(that.getId());
		setLogin(that.getLogin());
		setPassword(that.getPassword());
		setDescription(that.getDescription());
		setRegisterDate(that.getRegisterDate());
		setIsActive(that.getIsActive());
		setChangedPassword(that.getChangedPassword());
		setEmail(that.getEmail());
		setUnregisterDate(that.getUnregisterDate());
		setWorker(that.getWorker());
		setPermissions(new java.util.LinkedHashSet<com.eclinic.domain.Permission>(
				that.getPermissions()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("login=[").append(login).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("registerDate=[").append(registerDate).append("] ");
		buffer.append("isActive=[").append(isActive).append("] ");
		buffer.append("changedPassword=[").append(changedPassword).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("unregisterDate=[").append(unregisterDate).append("] ");

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
		if (!(obj instanceof SystemUser))
			return false;
		SystemUser equalCheck = (SystemUser) obj;
		if ((id == null && equalCheck.id != null)
				|| (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Transient
	public String getUsername() {
		return login;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return true;
	}

}
