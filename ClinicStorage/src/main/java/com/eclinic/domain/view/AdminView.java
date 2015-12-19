package com.eclinic.domain.view;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries(value = { @NamedQuery(name = "findAllAdminsView", query = "select a from AdminView a") })
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
	String  id;
	/**
	 */


//	@Column(name = "description", columnDefinition = "BLOB")
//	@Basic(fetch = FetchType.EAGER)
//	@Lob
//	@XmlElement
//	String description;
	/**
	 */

	@Column(name = "is_super")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isSuper;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public Boolean getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}

}
