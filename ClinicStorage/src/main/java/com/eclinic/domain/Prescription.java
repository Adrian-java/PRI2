package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
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
		@NamedQuery(name = "findAllPrescriptions", query = "select myPrescription from Prescription myPrescription"),
		@NamedQuery(name = "findPrescriptionByDepartment", query = "select myPrescription from Prescription myPrescription where myPrescription.department = ?1"),
		@NamedQuery(name = "findPrescriptionByDepartmentContaining", query = "select myPrescription from Prescription myPrescription where myPrescription.department like ?1"),
		@NamedQuery(name = "findPrescriptionByExecutionDate", query = "select myPrescription from Prescription myPrescription where myPrescription.executionDate = ?1"),
		@NamedQuery(name = "findPrescriptionByExecutionDateAfter", query = "select myPrescription from Prescription myPrescription where myPrescription.executionDate > ?1"),
		@NamedQuery(name = "findPrescriptionByExecutionDateBefore", query = "select myPrescription from Prescription myPrescription where myPrescription.executionDate < ?1"),
		@NamedQuery(name = "findPrescriptionById", query = "select myPrescription from Prescription myPrescription where myPrescription.id = ?1"),
		@NamedQuery(name = "findPrescriptionByIssuedDate", query = "select myPrescription from Prescription myPrescription where myPrescription.issuedDate = ?1"),
		@NamedQuery(name = "findPrescriptionByIssuedDateAfter", query = "select myPrescription from Prescription myPrescription where myPrescription.issuedDate > ?1"),
		@NamedQuery(name = "findPrescriptionByIssuedDateBefore", query = "select myPrescription from Prescription myPrescription where myPrescription.issuedDate < ?1"),
		@NamedQuery(name = "findPrescriptionByPrimaryKey", query = "select myPrescription from Prescription myPrescription where myPrescription.id = ?1") })
@Table(catalog = "eclinic", name = "Prescription")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Web/com/eclinic/domain", name = "Prescription")
public class Prescription implements Serializable {
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

	@Column(name = "department", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String department;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "issued_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar issuedDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "execution_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar executionDate;
	/**
	 */

	@Column(name = "remady")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] remady;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_clinic", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Clinic clinic;
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
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 */
	public String getDepartment() {
		return this.department;
	}

	/**
	 */
	public void setIssuedDate(Calendar issuedDate) {
		this.issuedDate = issuedDate;
	}

	/**
	 */
	public Calendar getIssuedDate() {
		return this.issuedDate;
	}

	/**
	 */
	public void setExecutionDate(Calendar executionDate) {
		this.executionDate = executionDate;
	}

	/**
	 */
	public Calendar getExecutionDate() {
		return this.executionDate;
	}

	/**
	 */
	public void setRemady(byte[] remady) {
		this.remady = remady;
	}

	/**
	 */
	public byte[] getRemady() {
		return this.remady;
	}

	/**
	 */
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	/**
	 */
	public Clinic getClinic() {
		return clinic;
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
	public Prescription() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Prescription that) {
		setId(that.getId());
		setDepartment(that.getDepartment());
		setIssuedDate(that.getIssuedDate());
		setExecutionDate(that.getExecutionDate());
		setRemady(that.getRemady());
		setClinic(that.getClinic());
		setDocumentsMapping(that.getDocumentsMapping());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("department=[").append(department).append("] ");
		buffer.append("issuedDate=[").append(issuedDate).append("] ");
		buffer.append("executionDate=[").append(executionDate).append("] ");
		buffer.append("remady=[").append(remady).append("] ");

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
		if (!(obj instanceof Prescription))
			return false;
		Prescription equalCheck = (Prescription) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
