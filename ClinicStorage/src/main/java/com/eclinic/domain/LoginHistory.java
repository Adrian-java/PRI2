package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllLoginHistorys", query = "select myLoginHistory from LoginHistory myLoginHistory"),
		@NamedQuery(name = "findLoginHistoryByDateLogin", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogin = ?1"),
		@NamedQuery(name = "findLoginHistoryByDateLoginAfter", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogin > ?1"),
		@NamedQuery(name = "findLoginHistoryByDateLoginBefore", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogin < ?1"),
		@NamedQuery(name = "findLoginHistoryByDateLogout", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogout = ?1"),
		@NamedQuery(name = "findLoginHistoryByDateLogoutAfter", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogout > ?1"),
		@NamedQuery(name = "findLoginHistoryByDateLogoutBefore", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.dateLogout < ?1"),
		@NamedQuery(name = "findLoginHistoryById", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.id = ?1"),
		@NamedQuery(name = "findLoginHistoryByPrimaryKey", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.id = ?1"),
		@NamedQuery(name = "findLoginHistoryBySessionNumber", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.sessionNumber = ?1"),
		@NamedQuery(name = "findLoginHistoryBySessionNumberContaining", query = "select myLoginHistory from LoginHistory myLoginHistory where myLoginHistory.sessionNumber like ?1") })
@Table(catalog = "eclinic", name = "Login_History")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "LoginHistory")
public class LoginHistory implements Serializable {
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
	@Temporal(TemporalType.DATE)
	@Column(name = "date_login", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateLogin;
	/**
	 */

	@Column(name = "session_number", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sessionNumber;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_logout", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateLogout;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_system_user", referencedColumnName = "Id") })
	@XmlTransient
	private
	SystemUser systemUser;


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
	public void setDateLogin(Calendar dateLogin) {
		this.dateLogin = dateLogin;
	}

	/**
	 */
	public Calendar getDateLogin() {
		return this.dateLogin;
	}

	/**
	 */
	public void setSessionNumber(String sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	/**
	 */
	public String getSessionNumber() {
		return this.sessionNumber;
	}

	/**
	 */
	public void setDateLogout(Calendar dateLogout) {
		this.dateLogout = dateLogout;
	}

	/**
	 */
	public Calendar getDateLogout() {
		return this.dateLogout;
	}


	/**
	 */
	public LoginHistory() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(LoginHistory that) {
		setId(that.getId());
		setDateLogin(that.getDateLogin());
		setSessionNumber(that.getSessionNumber());
		setDateLogout(that.getDateLogout());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("dateLogin=[").append(dateLogin).append("] ");
		buffer.append("sessionNumber=[").append(sessionNumber).append("] ");
		buffer.append("dateLogout=[").append(dateLogout).append("] ");

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
		if (!(obj instanceof LoginHistory))
			return false;
		LoginHistory equalCheck = (LoginHistory) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

}
