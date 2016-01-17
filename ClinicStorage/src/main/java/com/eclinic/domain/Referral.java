package com.eclinic.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllReferrals", query = "select myReferral from Referral myReferral"),
		@NamedQuery(name = "findReferralById", query = "select myReferral from Referral myReferral where myReferral.id = ?1"),
		@NamedQuery(name = "findReferralByPrimaryKey", query = "select myReferral from Referral myReferral where myReferral.id = ?1") })
@Table(catalog = "eclinic", name = "Referral")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Referral")
@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "documentsMapping") })
public class Referral implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
//	@GeneratedValue(generator = "foreign")
	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "destination")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String destination;
	/**
	 */

	@Column(name = "recognition")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String recognition;
	/**
	 */

	@Column(name = "purpose")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String purpose;

	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.EAGER)
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
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 */
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	/**
	 */
	public String getRecognition() {
		return this.recognition;
	}

	/**
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 */
	public String getPurpose() {
		return this.purpose;
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
	public Referral() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Referral that) {
		setId(that.getId());
		setDestination(that.getDestination());
		setRecognition(that.getRecognition());
		setPurpose(that.getPurpose());
		setDocumentsMapping(that.getDocumentsMapping());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("destination=[").append(destination).append("] ");
		buffer.append("recognition=[").append(recognition).append("] ");
		buffer.append("purpose=[").append(purpose).append("] ");

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
		if (!(obj instanceof Referral))
			return false;
		Referral equalCheck = (Referral) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
