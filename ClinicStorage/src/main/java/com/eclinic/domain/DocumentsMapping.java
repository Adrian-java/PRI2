package com.eclinic.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllDocumentsMappings", query = "select myDocumentsMapping from DocumentsMapping myDocumentsMapping"),
		@NamedQuery(name = "findDocumentsMappingById", query = "select myDocumentsMapping from DocumentsMapping myDocumentsMapping where myDocumentsMapping.id = ?1"),
		@NamedQuery(name = "findDocumentsMappingByPrimaryKey", query = "select myDocumentsMapping from DocumentsMapping myDocumentsMapping where myDocumentsMapping.id = ?1") })
@Table(catalog = "eclinic", name = "Documents_Mapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "DocumentsMapping")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
public class DocumentsMapping implements Serializable {
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
	@OneToOne(mappedBy = "documentsMapping", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	History history;
	/**
	 */
	@OneToOne(mappedBy = "documentsMapping", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	Certificate certificate;
	/**
	 */
	@OneToMany(mappedBy = "documentsMapping", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Documents> documentses;
	/**
	 */
	@OneToOne(mappedBy = "documentsMapping", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	Prescription prescription;
	/**
	 */
	@OneToOne(mappedBy = "documentsMapping", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	Referral referral;

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
	public void setHistory(History history) {
		this.history = history;
	}

	/**
	 */
	public History getHistory() {
		return history;
	}

	/**
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	/**
	 */
	public Certificate getCertificate() {
		return certificate;
	}

	/**
	 */
	public void setDocumentses(Set<Documents> documentses) {
		this.documentses = documentses;
	}

	/**
	 */
	public Set<Documents> getDocumentses() {
		if (documentses == null) {
			documentses = new java.util.LinkedHashSet<com.eclinic.domain.Documents>();
		}
		return documentses;
	}

	/**
	 */
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	/**
	 */
	public Prescription getPrescription() {
		return prescription;
	}

	/**
	 */
	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	/**
	 */
	public Referral getReferral() {
		return referral;
	}

	/**
	 */
	public DocumentsMapping() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(DocumentsMapping that) {
		setId(that.getId());
		setHistory(that.getHistory());
		setCertificate(that.getCertificate());
		setDocumentses(new java.util.LinkedHashSet<com.eclinic.domain.Documents>(that.getDocumentses()));
		setPrescription(that.getPrescription());
		setReferral(that.getReferral());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");

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
		if (!(obj instanceof DocumentsMapping))
			return false;
		DocumentsMapping equalCheck = (DocumentsMapping) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
