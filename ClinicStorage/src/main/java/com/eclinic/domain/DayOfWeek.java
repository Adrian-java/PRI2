package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

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
@NamedQueries({ @NamedQuery(name = "findDayOfWeekById", query = "select myD from DayOfWeek myD where myD.id = ?1") })
@Table(catalog = "eclinic", name = "Day_Of_Week")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Day_Of_Week")
public class DayOfWeek {

	
	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	private
	Integer id;
	/**
	 */

	@Column(name = "name")
	@XmlElement
	private
	String name;
	
	@OneToMany(mappedBy = "dayOfWeek", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Set<Graphic> graphic;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Graphic> getGraphics() {
		return graphic;
	}
	public void setGraphics(Set<Graphic> graphic) {
		this.graphic = graphic;
	}
}
