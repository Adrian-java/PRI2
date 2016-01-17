//package com.eclinic.helper;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.eclinic.converter.DocumentConverter;
//import com.eclinic.domain.Patient;
//import com.eclinic.model.Certificate;
//import com.eclinic.model.Prescription;
//import com.eclinic.model.PrescriptionData;
//import com.eclinic.model.Referral;
//import com.eclinic.model.VisitInfo;
//import com.eclinic.visit.VisitCrudDb;
//import com.sun.xml.messaging.saaj.util.ByteOutputStream;
//
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
//
//public class DocumentGenerator {
//	
//	@Autowired
//	private VisitCrudDb visitCrudDb;
//
//	@Autowired
//	private DocumentBuilder builder;
//	
//	private DocumentConverter converter;
//	
//	private ByteOutputStream byteStream;
//	
//	private EntityConverter entityConverter;
//	
//	public DocumentGenerator() {
//		setupEnvironment();
//	}
//
//	public void generatePrescription(Integer visitId) {
//		
//		Patient patient = getPatientByVisitId(visitId);
//		
//		String prescriptionPath = findReportPath("prescription.jasper");
//		Prescription prescription = builder.createPrescription(patient);
//
//		JasperReport report = createReport(prescriptionPath);
//
//		JRBeanCollectionDataSource dataSource = getPrescriptionData(prescription);
//		Map<String, Object> parameters = converter.convertToPrescription(prescription);
//
//		JasperPrint printObject = createPrintObject(report, dataSource, parameters);
//		exportToStream(printObject, byteStream);
//	}
//	
//	public void generateCertificate(Integer visitId) {
//
//		Patient patient = getPatientByVisitId(visitId);
//		String certificatePath = findReportPath("certificate.jasper");
//		Certificate certificate = builder.createCertificate(patient);
//
//		JasperReport report = createReport(certificatePath);
//
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
//				initializeEmptyDataSource());
//		Map<String, Object> parameters = converter.convertToCertificate(certificate);
//
//		JasperPrint printObject = createPrintObject(report, dataSource, parameters);
//		exportToStream(printObject, byteStream);
//	}
//
//	public void generateReferral(Integer visitId) {
//
//		Patient patient = getPatientByVisitId(visitId);
//		String referralPath = findReportPath("referral.jasper");
//		Referral referral = builder.createReferaral(patient);
//
//		JasperReport report = createReport(referralPath);
//
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
//				initializeEmptyDataSource());
//		Map<String, Object> parameters = converter.convertToReferral(referral);
//
//		JasperPrint printObject = createPrintObject(report, dataSource, parameters);
//		exportToStream(printObject, byteStream);
//	}
//	
//	
//	public ByteOutputStream getGeneratedDocument() {
//		return this.byteStream;
//	}
//	
//	private Patient getPatientByVisitId(Integer visitId) {
//		VisitInfo visit = visitCrudDb.findVisitById(visitId);
//		Patient patient = entityConverter.convertToPatient(visit.getPatientView());
//		return patient;
//	}
//
//	private void exportToStream(JasperPrint print, ByteOutputStream byteStream) {
//		try {
//			JasperExportManager.exportReportToPdfStream(print, byteStream);
//		} catch (JRException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	private JasperPrint createPrintObject(JasperReport report,
//			JRBeanCollectionDataSource dataSource,
//			Map<String, Object> parameters) {
//		JasperPrint print = null;
//		try {
//			print = JasperFillManager
//					.fillReport(report, parameters, dataSource);
//		} catch (JRException e) {
//			throw new RuntimeException(e);
//		}
//		return print;
//	}
//
//	private JasperReport createReport(String fileName) {
//		JasperReport report = null;
//		try {
//			report = (JasperReport) JRLoader.loadObjectFromFile(fileName);
//		} catch (JRException e) {
//			throw new RuntimeException(e);
//		}
//		return report;
//	}
//
//	private JRBeanCollectionDataSource getPrescriptionData(
//			Prescription prescription) {
//		PrescriptionData data = converter.getDataFrom(prescription);
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
//				data.getRemedy());
//		return dataSource;
//	}
//	
//	private String findReportPath(String fileName) {
//		ClassLoader loader = this.getClass().getClassLoader();
//		String file = "reports/" + fileName;
//		return loader.getResource(file).getPath();
//	}
//
//	private List<Object> initializeEmptyDataSource() {
//		List<Object> list = new ArrayList<Object>();
//		list.add("list");
//		return list;
//	}
//	
//	private void setupEnvironment() {
//		this.converter = new DocumentConverter();
//		this.entityConverter = new EntityConverter();
//		this.byteStream = new ByteOutputStream();
//	}
//	
//}
