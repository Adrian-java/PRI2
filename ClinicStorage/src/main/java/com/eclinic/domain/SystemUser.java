package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.hibernate.annotations.Parameter;


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
		@NamedQuery(name = "findSystemUserByPassword", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.password = ?1"),
		@NamedQuery(name = "findSystemUserByPasswordContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.password like ?1"),
		@NamedQuery(name = "findSystemUserByPesel", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.id = ?1"),
		@NamedQuery(name = "findSystemUserByPeselContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.id like ?1"),
		@NamedQuery(name = "findSystemUserByPrimaryKey", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.id = ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDate", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate = ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDateAfter", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate > ?1"),
		@NamedQuery(name = "findSystemUserByRegisterDateBefore", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.registerDate < ?1"),
		@NamedQuery(name = "findSystemUserByRole", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.role = ?1"),
		@NamedQuery(name = "findSystemUserByRoleContaining", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.role like ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDate", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate = ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDateAfter", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate > ?1"),
		@NamedQuery(name = "findSystemUserByUnregisterDateBefore", query = "select mySystemUser from SystemUser mySystemUser where mySystemUser.unregisterDate < ?1") })
@Table(catalog = "eclinic", name = "System_User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "SystemUser")
public class SystemUser implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	String id;
	/**
	 */

	@Column(name = "password", length = 20000, nullable = false)
	@Basic(fetch = FetchType.LAZY)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "description")
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

	@Column(name = "role", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String role;
	/**
	 */


	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_system_user_permission", referencedColumnName = "Id") })
	@XmlTransient
	SystemUserPermission systemUserPermission;
	/**
	 */
	@OneToOne(mappedBy = "systemUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@XmlElement(name = "", namespace = "")
	Patient patient;
	/**
	 */
	@OneToOne(mappedBy = "systemUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@XmlElement(name = "", namespace = "")
	Doctor doctor;
	/**
	 */
	@OneToOne(mappedBy = "systemUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@XmlElement(name = "", namespace = "")
	Receptionist receptionist;
	/**
	 */
	@OneToOne(mappedBy = "systemUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@XmlElement(name = "", namespace = "")
	Admin admin;

	@OneToMany(mappedBy = "systemUser", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	private
	java.util.Set<com.eclinic.domain.LoginHistory> loginHistory;
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
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 */
//	public void setPesel(String pesel) {
//		this.pesel = pesel;
//	}
//
//	/**
//	 */
//	public String getPesel() {
//		return this.pesel;
//	}

	/**
	 */
	public void setSystemUserPermission(SystemUserPermission systemUserPermission) {
		this.systemUserPermission = systemUserPermission;
	}

	/**
	 */
	@JsonIgnore
	public SystemUserPermission getSystemUserPermission() {
		return systemUserPermission;
	}

	/**
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
	@JsonIgnore
	public Patient getPatient() {
		return patient;
	}

	/**
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 */
	@JsonIgnore
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 */
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	/**
	 */
	@JsonIgnore
	public Receptionist getReceptionist() {
		return receptionist;
	}

	/**
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 */
	@JsonIgnore
	public Admin getAdmin() {
		return admin;
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
		setPassword(that.getPassword());
		setDescription(that.getDescription());
		setRegisterDate(that.getRegisterDate());
		setIsActive(that.getIsActive());
		setChangedPassword(that.getChangedPassword());
		setEmail(that.getEmail());
		setUnregisterDate(that.getUnregisterDate());
		setRole(that.getRole());
//		setPesel(that.getsPesel());
		setSystemUserPermission(that.getSystemUserPermission());
		setPatient(that.getPatient());
		setDoctor(that.getDoctor());
		setReceptionist(that.getReceptionist());
		setAdmin(that.getAdmin());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("registerDate=[").append(registerDate).append("] ");
		buffer.append("isActive=[").append(isActive).append("] ");
		buffer.append("changedPassword=[").append(changedPassword).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("unregisterDate=[").append(unregisterDate).append("] ");
		buffer.append("role=[").append(role).append("] ");

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
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public java.util.Set<com.eclinic.domain.LoginHistory> getLoginHistory() {
		return loginHistory;
	}

	public void setLoginHistory(java.util.Set<com.eclinic.domain.LoginHistory> loginHistory) {
		this.loginHistory = loginHistory;
	}
	
	@JsonIgnore
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(role));

		return authorities;
	}

	@JsonIgnore
	@Transient
	public String getUsername() {
		return id;
	}

	@JsonIgnore
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Transient
	public boolean isEnabled() {
		return isActive;
//		return true;
	}

	
}
