package com.eclinic.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.converter.DocumentConverter;
import com.eclinic.documents.util.CertificateModel;
import com.eclinic.documents.util.DocumentsCrud;
import com.eclinic.documents.util.DocumentsModel;
import com.eclinic.documents.util.PrescriptionModel;
import com.eclinic.documents.util.ReferralModel;
import com.eclinic.domain.Patient;
import com.eclinic.domain.view.PatientView;
import com.eclinic.helper.DocumentBuilder;
import com.eclinic.helper.EntityConverter;
import com.eclinic.model.Certificate;
import com.eclinic.model.Prescription;
import com.eclinic.model.PrescriptionData;
import com.eclinic.model.Referral;
import com.eclinic.model.VisitInfo;
import com.eclinic.user.mangament.patient.PatientCrudDB;
import com.eclinic.visit.VisitCrudDb;
import com.sun.xml.messaging.saaj.util.ByteOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Component("DocumentController")
@javax.ws.rs.Path("/documents")
public class DocumentController {

	@Autowired
	private PatientCrudDB patientCrudDB;

	private DocumentConverter converter;

	@Autowired
	private DocumentBuilder builder;
	
	@Autowired
	private VisitCrudDb visitCrudDb;

	@Autowired
	private DocumentsCrud documentsCrud;

	private EntityConverter entityConverter;

	private ByteOutputStream byteStream;

	public DocumentController() {
		setupEnvironment();
		compileReports();
	}

	@POST
	@Path("/new/prescription")
	@Consumes("application/json")
	public Response addPrescription(PrescriptionModel model) {
		try {
			documentsCrud.addPrescription(model);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@POST
	@Path("/new/certificate")
	@Consumes("application/json")
	public Response addCertificate(CertificateModel model) {
		try {
			documentsCrud.addCertificate(model);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@POST
	@Path("/new/referral")
	@Consumes("application/json")
	public Response addReferral(ReferralModel model) {
		try {
			documentsCrud.addReferral(model);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@POST
	@Path("/new/document")
	@Consumes("application/json")
	public Response addDocument(DocumentsModel model) {
		try {
			documentsCrud.addDocument(model);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/prescription/{visitId}")
	@Produces("application/pdf")
	public Response findPrescription(@PathParam("visitId") Integer visitId) {
		createPrescription(visitId);
		return createResponse(byteStream);
	}

	@GET
	@Path("/certificate/{visitId}")
	@Produces("application/pdf")
	public Response findCertificate(@PathParam("visitId") Integer visitId) {
		createCertificate(visitId);
		return createResponse(byteStream);
	}

	@GET
	@Path("/referral/{visitId}")
	@Produces("application/pdf")
	public Response findReferral(@PathParam("visitId") Integer visitId) {
		createReferral(visitId);
		return createResponse(byteStream);
	}

	// ///////////
	@GET
	@Path("/prescription/data/{visitId}")
	@Produces("application/json")
	public Response findPrescriptionData(@PathParam("visitId") Integer id) {
		try {
			return Response.ok(documentsCrud.getPrescriptionByVisit(id)).build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/certificate/data/{visitId}")
	@Produces("application/json")
	public Response findCertificateData(@PathParam("visitId") Integer id) {
		try {
			return Response.ok(documentsCrud.getCertificateByVisit(id)).build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/referral/data/{visitId}")
	@Produces("application/json")
	public Response findReferralData(@PathParam("visitId") Integer id) {
		try {
			return Response.ok(documentsCrud.getReferralByVisit(id)).build();
		} catch (Exception e) {
			return Response.noContent().build();
		}
	}

	@SuppressWarnings("deprecation")
	private Response createResponse(ByteOutputStream byteStream) {
		return Response.status(200).entity(byteStream.toByteArray()).build();
	}

	private Patient getPatientById(String patientId) {
		PatientView view = patientCrudDB.getPatientById(patientId);
		return entityConverter.convertToPatient(view);
	}

	private void compileReport(String fileName) {
		String filePath = findReportPath(fileName);
		try {
			JasperCompileManager.compileReportToFile(filePath);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

	private String findReportPath(String fileName) {
		ClassLoader loader = this.getClass().getClassLoader();
		String file = "reports/" + fileName;
		return loader.getResource(file).getPath();
	}

	private void createPrescription(Integer visitId) {
		
		Patient patient = getPatientByVisitId(visitId);
		
		String prescriptionPath = findReportPath("prescription.jasper");
		Prescription prescription = builder.createPrescription(patient);

		JasperReport report = createReport(prescriptionPath);

		JRBeanCollectionDataSource dataSource = getPrescriptionData(prescription);
		Map<String, Object> parameters = converter
				.convertToPrescription(prescription);

		JasperPrint printObject = createPrintObject(report, dataSource,
				parameters);
		exportToStream(printObject, byteStream);
	}

	private Patient getPatientByVisitId(Integer visitId) {
		VisitInfo visit = visitCrudDb.findVisitById(visitId);
		Patient patient = entityConverter.convertToPatient(visit.getPatientView());
		return patient;
	}

	private void createCertificate(Integer visitId) {

		Patient patient = getPatientByVisitId(visitId);
		String certificatePath = findReportPath("certificate.jasper");
		Certificate certificate = builder.createCertificate(patient);

		JasperReport report = createReport(certificatePath);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
				initializeDataSource());
		Map<String, Object> parameters = converter
				.convertToCertificate(certificate);

		JasperPrint printObject = createPrintObject(report, dataSource,
				parameters);
		exportToStream(printObject, byteStream);
	}

	private void createReferral(Integer visitId) {

		Patient patient = getPatientByVisitId(visitId);
		String referralPath = findReportPath("referral.jasper");
		Referral referral = builder.createReferaral(patient);

		JasperReport report = createReport(referralPath);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
				initializeDataSource());
		Map<String, Object> parameters = converter.convertToReferral(referral);

		JasperPrint printObject = createPrintObject(report, dataSource,
				parameters);
		exportToStream(printObject, byteStream);
	}

	private void exportToStream(JasperPrint print, ByteOutputStream byteStream) {
		try {
			JasperExportManager.exportReportToPdfStream(print, byteStream);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

	private JasperPrint createPrintObject(JasperReport report,
			JRBeanCollectionDataSource dataSource,
			Map<String, Object> parameters) {
		JasperPrint print = null;
		try {
			print = JasperFillManager
					.fillReport(report, parameters, dataSource);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		return print;
	}

	private JasperReport createReport(String fileName) {
		JasperReport report = null;
		try {
			report = (JasperReport) JRLoader.loadObjectFromFile(fileName);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		return report;
	}

	private JRBeanCollectionDataSource getPrescriptionData(
			Prescription prescription) {
		PrescriptionData data = converter.getDataFrom(prescription);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
				data.getRemedy());
		return dataSource;
	}

	private List<Object> initializeDataSource() {
		List<Object> list = new ArrayList<Object>();
		list.add("list");
		return list;
	}

	private void compileReports() {
		compileReport("prescription.jrxml");
		compileReport("certificate.jrxml");
		compileReport("referral.jrxml");
	}

	private void setupEnvironment() {
		this.converter = new DocumentConverter();
		// this.builder = new DocumentBuilder();
		this.entityConverter = new EntityConverter();
		this.byteStream = new ByteOutputStream();
	}

}
