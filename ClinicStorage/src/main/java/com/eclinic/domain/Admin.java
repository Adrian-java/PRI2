package com.eclinic.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAdminById", query = "select myAdmin from Admin myAdmin where myAdmin.id = ?1"),
		@NamedQuery(name = "findAdminByIsSuper", query = "select myAdmin from Admin myAdmin where myAdmin.isSuper = ?1"),
		@NamedQuery(name = "findAdminByPrimaryKey", query = "select myAdmin from Admin myAdmin where myAdmin.id = ?1"),
		@NamedQuery(name = "findAllAdmins", query = "select myAdmin from Admin myAdmin") })
@Table(catalog = "eclinic", name = "Admin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Admin")
@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "systemUser") })
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(generator = "foreign")
	String id;
	/**
	 */

	@Column(name = "is_super", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isSuper;

	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@XmlElement(name = "", namespace = "")
	SystemUser systemUser;

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
	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}

	/**
	 */
	public Boolean getIsSuper() {
		return this.isSuper;
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
	public Admin() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Admin that) {
		setId(that.getId());
		setIsSuper(that.getIsSuper());
		setSystemUser(that.getSystemUser());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("isSuper=[").append(isSuper).append("] ");

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
		if (!(obj instanceof Admin))
			return false;
		Admin equalCheck = (Admin) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
