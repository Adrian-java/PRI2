package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({ @NamedQuery(name = "findSevenDaysById", query = "select myS from SevenDays myS where myS.id = ?1") })
@Table(catalog = "eclinic", name = "Seven_Days")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SevenDays")
public class SevenDays {

	@Column(name = "Id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;

	@Column(name = "mon", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean mon;

	@Column(name = "tue", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean tue;

	@Column(name = "wen", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean wen;

	@Column(name = "thu", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean thu;

	@Column(name = "fri", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean fri;

	@Column(name = "sat", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean sat;

	@Column(name = "sun", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	Boolean sun;

	@OneToMany(mappedBy = "sevenDays", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.VisitScheduler> visitScheduler;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getMon() {
		return mon;
	}

	public void setMon(Boolean mon) {
		this.mon = mon;
	}

	public Boolean getTue() {
		return tue;
	}

	public void setTue(Boolean tue) {
		this.tue = tue;
	}

	public Boolean getWen() {
		return wen;
	}

	public void setWen(Boolean wen) {
		this.wen = wen;
	}

	public Boolean getThu() {
		return thu;
	}

	public void setThu(Boolean thu) {
		this.thu = thu;
	}

	public Boolean getFri() {
		return fri;
	}

	public void setFri(Boolean fri) {
		this.fri = fri;
	}

	public Boolean getSat() {
		return sat;
	}

	public void setSat(Boolean sat) {
		this.sat = sat;
	}

	public Boolean getSun() {
		return sun;
	}

	public void setSun(Boolean sun) {
		this.sun = sun;
	}

	public// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.VisitScheduler> getVisitScheduler() {
		return visitScheduler;
	}

	public void setVisitScheduler(// @XmlElement(name = "", namespace = "")
			java.util.Set<com.eclinic.domain.VisitScheduler> visitScheduler) {
		this.visitScheduler = visitScheduler;
	}

}
