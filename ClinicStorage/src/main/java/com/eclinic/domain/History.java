package com.eclinic.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllHistorys", query = "select myHistory from History myHistory"),
		@NamedQuery(name = "findHistoryByDateFrom", query = "select myHistory from History myHistory where myHistory.dateFrom = ?1"),
		@NamedQuery(name = "findHistoryByDateFromAfter", query = "select myHistory from History myHistory where myHistory.dateFrom > ?1"),
		@NamedQuery(name = "findHistoryByDateFromBefore", query = "select myHistory from History myHistory where myHistory.dateFrom < ?1"),
		@NamedQuery(name = "findHistoryByDateTo", query = "select myHistory from History myHistory where myHistory.dateTo = ?1"),
		@NamedQuery(name = "findHistoryByDateToAfter", query = "select myHistory from History myHistory where myHistory.dateTo > ?1"),
		@NamedQuery(name = "findHistoryByDateToBefore", query = "select myHistory from History myHistory where myHistory.dateTo < ?1"),
		@NamedQuery(name = "findHistoryByFirstIllness", query = "select myHistory from History myHistory where myHistory.firstIllness = ?1"),
		@NamedQuery(name = "findHistoryById", query = "select myHistory from History myHistory where myHistory.id = ?1"),
		@NamedQuery(name = "findHistoryByPrimaryKey", query = "select myHistory from History myHistory where myHistory.id = ?1"),
		@NamedQuery(name = "findHistoryByStatisticNumber", query = "select myHistory from History myHistory where myHistory.statisticNumber = ?1"),
		@NamedQuery(name = "findHistoryByStatisticNumberContaining", query = "select myHistory from History myHistory where myHistory.statisticNumber like ?1") })
@Table(catalog = "eclinic", name = "History")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "History")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "recognition")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] recognition;
	/**
	 */

	@Column(name = "statistic_number", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String statisticNumber;
	/**
	 */

	@Column(name = "first_illness", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean firstIllness;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_from")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateFrom;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_to")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateTo;

	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	DocumentsMapping documentsMapping;

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
	public void setRecognition(byte[] recognition) {
		this.recognition = recognition;
	}

	/**
	 */
	public byte[] getRecognition() {
		return this.recognition;
	}

	/**
	 */
	public void setStatisticNumber(String statisticNumber) {
		this.statisticNumber = statisticNumber;
	}

	/**
	 */
	public String getStatisticNumber() {
		return this.statisticNumber;
	}

	/**
	 */
	public void setFirstIllness(Boolean firstIllness) {
		this.firstIllness = firstIllness;
	}

	/**
	 */
	public Boolean getFirstIllness() {
		return this.firstIllness;
	}

	/**
	 */
	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 */
	public Calendar getDateFrom() {
		return this.dateFrom;
	}

	/**
	 */
	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 */
	public Calendar getDateTo() {
		return this.dateTo;
	}

	/**
	 */
	public void setDocumentsMapping(DocumentsMapping documentsMapping) {
		this.documentsMapping = documentsMapping;
	}

	/**
	 */
	public DocumentsMapping getDocumentsMapping() {
		return documentsMapping;
	}

	/**
	 */
	public History() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(History that) {
		setId(that.getId());
		setRecognition(that.getRecognition());
		setStatisticNumber(that.getStatisticNumber());
		setFirstIllness(that.getFirstIllness());
		setDateFrom(that.getDateFrom());
		setDateTo(that.getDateTo());
		setDocumentsMapping(that.getDocumentsMapping());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("recognition=[").append(recognition).append("] ");
		buffer.append("statisticNumber=[").append(statisticNumber).append("] ");
		buffer.append("firstIllness=[").append(firstIllness).append("] ");
		buffer.append("dateFrom=[").append(dateFrom).append("] ");
		buffer.append("dateTo=[").append(dateTo).append("] ");

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
		if (!(obj instanceof History))
			return false;
		History equalCheck = (History) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
