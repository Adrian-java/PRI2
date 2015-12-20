package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllCertificates", query = "select myCertificate from Certificate myCertificate"),
		@NamedQuery(name = "findCertificateById", query = "select myCertificate from Certificate myCertificate where myCertificate.id = ?1"),
		@NamedQuery(name = "findCertificateByIdNumber", query = "select myCertificate from Certificate myCertificate where myCertificate.idNumber = ?1"),
		@NamedQuery(name = "findCertificateByIdNumberContaining", query = "select myCertificate from Certificate myCertificate where myCertificate.idNumber like ?1"),
		@NamedQuery(name = "findCertificateByPrimaryKey", query = "select myCertificate from Certificate myCertificate where myCertificate.id = ?1") })
@Table(catalog = "eclinic", name = "Certificate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Certificate")
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
//	@GeneratedValue(strategy = IDENTITY)
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

	@Column(name = "id_number", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String idNumber;
	/**
	 */

	@Column(name = "purpose")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] purpose;

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
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 */
	public String getIdNumber() {
		return this.idNumber;
	}

	/**
	 */
	public void setPurpose(byte[] purpose) {
		this.purpose = purpose;
	}

	/**
	 */
	public byte[] getPurpose() {
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
	public Certificate() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Certificate that) {
		setId(that.getId());
		setRecognition(that.getRecognition());
		setIdNumber(that.getIdNumber());
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
		buffer.append("recognition=[").append(recognition).append("] ");
		buffer.append("idNumber=[").append(idNumber).append("] ");
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
		if (!(obj instanceof Certificate))
			return false;
		Certificate equalCheck = (Certificate) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
