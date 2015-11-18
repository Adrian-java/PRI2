package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllGraphics", query = "select myGraphic from Graphic myGraphic"),
		@NamedQuery(name = "findGraphicByDay", query = "select myGraphic from Graphic myGraphic"),
		@NamedQuery(name = "findGraphicByDayAfter", query = "select myGraphic from Graphic myGraphic "),
		@NamedQuery(name = "findGraphicByDayBefore", query = "select myGraphic from Graphic myGraphic"),
		@NamedQuery(name = "findGraphicById", query = "select myGraphic from Graphic myGraphic where myGraphic.id = ?1"),
		@NamedQuery(name = "findGraphicByPrimaryKey", query = "select myGraphic from Graphic myGraphic where myGraphic.id = ?1") })
@Table(catalog = "eclinic", name = "Graphic")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Graphic")
public class Graphic implements Serializable {
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

	@Column(name = "absence", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] absence;
	
	@Column(name = "time_from", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private
	Time timeFrom;
	
	@Column(name = "time_to", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private
	Time timeTo;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_day_of_week", referencedColumnName = "Id", nullable = false) })
	private
//	@XmlTransient
	DayOfWeek dayOfWeek;

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
	public void setAbsence(byte[] absence) {
		this.absence = absence;
	}

	/**
	 */
	public byte[] getAbsence() {
		return this.absence;
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
	public Graphic() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Graphic that) {
		setId(that.getId());
		setAbsence(that.getAbsence());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("absence=[").append(absence).append("] ");

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
		if (!(obj instanceof Graphic))
			return false;
		Graphic equalCheck = (Graphic) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Time getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}

	public //	@XmlTransient
	DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(//	@XmlTransient
	DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}
