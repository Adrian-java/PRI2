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
		@NamedQuery(name = "findAllVisitSchedulers", query = "select myVisitScheduler from VisitScheduler myVisitScheduler"),
		@NamedQuery(name = "findVisitSchedulerById", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.id = ?1"),
		@NamedQuery(name = "findVisitSchedulerByNumberOfDay", query = "select myVisitScheduler from VisitScheduler myVisitScheduler"),
		@NamedQuery(name = "findVisitSchedulerBySpecializationName", query="select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.specialization.name = ?1"),
		@NamedQuery(name = "findVisitSchedulerByNumberOfMonth", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.numberOfMonth = ?1"),
		@NamedQuery(name = "findVisitSchedulerByPrimaryKey", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.id = ?1"),
		@NamedQuery(name = "findVisitSchedulerByDoctor", query="select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.doctor = ?1"),
		@NamedQuery(name = "findVisitSchedulerByTimeOfVisit", query = "select myVisitScheduler from VisitScheduler myVisitScheduler") })
@Table(catalog = "eclinic", name = "Visit_Scheduler")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "VisitScheduler")
public class VisitScheduler implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
//	/**
//	 */
//
//	@Column(name = "number_of_day", nullable = false)
//	@Basic(fetch = FetchType.EAGER)
//	@XmlElement
//	Integer numberOfDay;
	/**
	 */

	@Column(name = "number_of_month")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numberOfMonth;
	/**
	 */

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;
	/**
	 */
	@Column(name = "time_from")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private
	Time timeFrom;
	
	@Column(name = "time_to")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private
	Time timeTo;
	
	@Column(name = "duration")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	private
	Integer duration;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_specialization", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Specialization specialization;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_seven_days", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	SevenDays sevenDays;

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

//	/**
//	 */
//	public void setNumberOfDay(Integer numberOfDay) {
//		this.numberOfDay = numberOfDay;
//	}
//
//	/**
//	 */
//	public Integer getNumberOfDay() {
//		return this.numberOfDay;
//	}

	/**
	 */
	public void setNumberOfMonth(Integer numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	/**
	 */
	public Integer getNumberOfMonth() {
		return this.numberOfMonth;
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
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	/**
	 */
	@JsonIgnore
	public Specialization getSpecialization() {
		return specialization;
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
	public VisitScheduler() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VisitScheduler that) {
		setId(that.getId());
		setNumberOfMonth(that.getNumberOfMonth());
		setDescription(that.getDescription());
		setSpecialization(that.getSpecialization());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("numberOfMonth=[").append(numberOfMonth).append("] ");
		buffer.append("description=[").append(description).append("] ");

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
		if (!(obj instanceof VisitScheduler))
			return false;
		VisitScheduler equalCheck = (VisitScheduler) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	public SevenDays getSevenDays() {
		return sevenDays;
	}

	public void setSevenDays(SevenDays sevenDays) {
		this.sevenDays = sevenDays;
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

	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
