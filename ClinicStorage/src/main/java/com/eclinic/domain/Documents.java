package com.eclinic.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllDocumentss", query = "select myDocuments from Documents myDocuments"),
		@NamedQuery(name = "findDocumentsByDateOfDocuments", query = "select myDocuments from Documents myDocuments where myDocuments.dateOfDocuments = ?1"),
		@NamedQuery(name = "findDocumentsByDateOfDocumentsAfter", query = "select myDocuments from Documents myDocuments where myDocuments.dateOfDocuments > ?1"),
		@NamedQuery(name = "findDocumentsByDateOfDocumentsBefore", query = "select myDocuments from Documents myDocuments where myDocuments.dateOfDocuments < ?1"),
		@NamedQuery(name = "findDocumentsByPatient", query = "select myDocuments from Documents myDocuments where myDocuments.patient =  ?1"),
		@NamedQuery(name = "findDocumentsById", query = "select myDocuments from Documents myDocuments where myDocuments.id = ?1"),
		@NamedQuery(name = "findDocumentsByPrimaryKey", query = "select myDocuments from Documents myDocuments where myDocuments.id = ?1"),
		@NamedQuery(name = "findDocumentsByTypeOfDocuments", query = "select myDocuments from Documents myDocuments where myDocuments.typeOfDocuments = ?1"),
		@NamedQuery(name = "findDocumentsByTypeOfDocumentsContaining", query = "select myDocuments from Documents myDocuments where myDocuments.typeOfDocuments like ?1") })
@Table(catalog = "eclinic", name = "Documents")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Documents")
@XmlRootElement(namespace = "Web/com/eclinic/domain")
public class Documents implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_documents")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateOfDocuments;
	/**
	 */

	@Column(name = "description")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;
	/**
	 */

	@Column(name = "type_of_documents", length = 200)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String typeOfDocuments;
	/**
	 */

	@Column(name = "data_of_documents")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] dataOfDocuments;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	/**
	 */
	@OneToMany(mappedBy = "documents", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.DocumentsMapping> documentsMappings;

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
	public void setDateOfDocuments(Calendar dateOfDocuments) {
		this.dateOfDocuments = dateOfDocuments;
	}

	/**
	 */
	public Calendar getDateOfDocuments() {
		return this.dateOfDocuments;
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
	public void setTypeOfDocuments(String typeOfDocuments) {
		this.typeOfDocuments = typeOfDocuments;
	}

	/**
	 */
	public String getTypeOfDocuments() {
		return this.typeOfDocuments;
	}

	/**
	 */
	public void setDataOfDocuments(byte[] dataOfDocuments) {
		this.dataOfDocuments = dataOfDocuments;
	}

	/**
	 */
	public byte[] getDataOfDocuments() {
		return this.dataOfDocuments;
	}

	/**
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
	@JsonIgnore
	public Patient getPatient() {
		return patient;
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
	public void setDocumentsMappings(Set<DocumentsMapping> documentsMappings) {
		this.documentsMappings = documentsMappings;
	}

	/**
	 */
	@JsonIgnore
	public Set<DocumentsMapping> getDocumentsMappings() {
		if (documentsMappings == null) {
			documentsMappings = new java.util.LinkedHashSet<com.eclinic.domain.DocumentsMapping>();
		}
		return documentsMappings;
	}

	/**
	 */
	public Documents() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Documents that) {
		setId(that.getId());
		setDateOfDocuments(that.getDateOfDocuments());
		setDescription(that.getDescription());
		setTypeOfDocuments(that.getTypeOfDocuments());
		setDataOfDocuments(that.getDataOfDocuments());
		setPatient(that.getPatient());
		setDoctor(that.getDoctor());
		setDocumentsMappings(new java.util.LinkedHashSet<com.eclinic.domain.DocumentsMapping>(that.getDocumentsMappings()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("dateOfDocuments=[").append(dateOfDocuments).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("typeOfDocuments=[").append(typeOfDocuments).append("] ");
		buffer.append("dataOfDocuments=[").append(dataOfDocuments).append("] ");

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
		if (!(obj instanceof Documents))
			return false;
		Documents equalCheck = (Documents) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
