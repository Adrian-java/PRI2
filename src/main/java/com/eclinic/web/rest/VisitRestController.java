package com.eclinic.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.email.sender.EmailSender;
import com.eclinic.email.sender.VisitWriter;
import com.eclinic.model.VisitModel;
import com.eclinic.model.VisitUser;
import com.eclinic.service.PatientCardService;
import com.eclinic.service.VisitService;

@Path("/Visit")
@Component("VisitRestController")
public class VisitRestController {

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private PatientCardDAO patientCardDAO;

	@Autowired
	private ReceptionistDAO receptionistDAO;

	@Autowired
	private PatientCardService patientCardService;
	
	
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	@Autowired
	private VisitDAO visitDAO;

	@Autowired
	private VisitService visitService;
	
	@Autowired 
	private SystemUserDAO systemUserDao;
	
	@Autowired
	private VisitWriter writer;

	
	public VisitRestController(){}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/typeOfVisit/{typeofvisit_id}")
	public Response deleteVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_typeofvisit_id") Integer related_typeofvisit_id) {
		return Response.ok(visitService.deleteVisitTypeOfVisit(visit_id, related_typeofvisit_id)).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/sickLeaves/{sickleave_id}")
	public Response deleteVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		return Response.ok(visitService.deleteVisitSickLeaves(visit_id, related_sickleaves_id)).build();
	}
	
	@GET
	@Path("/{visit_id}/typeOfVisit/{typeofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_typeofvisit_id") Integer related_typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit_id, -1, -1);

		return Response.ok(typeofvisit).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/doctor/{doctor_id}")
	public Response deleteVisitDoctor(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(visitService.deleteVisitDoctor(visit_id, related_doctor_id)).build();
	}
	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisit( VisitModel visitmodel) {
		try{
			Integer id = createNewVisit(visitmodel);
		return Response.ok(visitDAO.findVisitByPrimaryKey(id)).build();
		}catch(Exception e){
			throw new RuntimeException(e);
//			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}

	private Integer createNewVisit(VisitModel visitmodel) {
		Doctor doctor = createDoctor();
		Patient patient = createPatient(visitmodel);
		PatientCard patientCard = validatePatientCard(doctor, patient);
		Receptionist receptionist = createReceptionist();
		StatusOfVisit visitStatus = createVisitStatus();
		TypeOfVisit visitType = createVisitType();
		
		Visit visit = new Visit(doctor, receptionist, patientCard);
		setVisitParameters(visitmodel, visitStatus, visitType, visit);
		Integer  id = visitService.saveVisit(visit);

		sendVisitConfirmation(patient);
		savePatientEmailOnReminderList(patient.getEMail(), visitmodel.getDateOfVisit());
		return id;
	}

	private PatientCard validatePatientCard(Doctor doctor, Patient patient) {
		PatientCard patientCard = patientCardDAO.findPatientCardByPatientId(patient);
		if(patientCard==null)
			patientCard = createPatientCard(doctor, patient);
		return patientCard;
	}

	private void sendVisitConfirmation(Patient patient) {
		EmailSender sender = new EmailSender();
		sender.send(patient.getEMail());
	}
	
	private void savePatientEmailOnReminderList(String email, Calendar visitDate) {
//		VisitWriter writer = new VisitWriter();
		try {
			writer.saveVisit(visitDate, email);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void setVisitParameters(VisitModel visitmodel, StatusOfVisit visitStatus, TypeOfVisit visitType,
			Visit visit) {
		visit.setDateOfVisit(visitmodel.getDateOfVisit());
		visit.setDescriptionOfVisit(visitmodel.getDescriptionOfVisit());
		visit.setIsLeave(visitmodel.getIsLeave());
		visit.setSpecial(visitmodel.getSpecial());
		visit.setStatusOfVisit(visitStatus);
		visit.setTypeOfVisit(visitType);
	}

	private TypeOfVisit createVisitType() {
		//		TypeOfVisit visitType = typeOfVisitDAO.findTypeOfVisitByName(visitmodel.getTypeOfVisit()).iterator().next();
				TypeOfVisit visitType = new TypeOfVisit();
				visitType.setId(1);
		return visitType;
	}

	private StatusOfVisit createVisitStatus() {
		StatusOfVisit visitStatus = new StatusOfVisit();
		visitStatus.setId(1);
//		StatusOfVisit visitStatus = statusOfVisitDAO.findStatusOfVisitByType(visitmodel.getStatusOfVisit())
//				.iterator()
//				.next();
		return visitStatus;
	}

	private Receptionist createReceptionist() {
//		Receptionist receptionist = systemUserDao.findSystemUserByPesel(visitmodel.getRecepcionistLogin()).getWorker().getReceptionist();
		Receptionist receptionist = new Receptionist();
		receptionist.setId(1);
		return receptionist;
	}

	private PatientCard createPatientCard(Doctor doctor, Patient patient) {
		PatientCard patientcCard = new PatientCard();
		patientcCard.setDoctor(doctor);
		patientcCard.setPatient(patient);
//			pc.setRegisterDate(systemUserDao.findSystemUserByPesel(visitmodel.getDoctorLogin()).getRegisterDate());
		Calendar cal = Calendar.getInstance();
		patientcCard.setRegisterDate(cal);
		Integer id = patientCardService.savePatientCard(patientcCard);
		return patientcCard;
	}

	private Patient createPatient(VisitModel visitmodel) {
//		Patient patient  = systemUserDao.findSystemUserByPesel(visitmodel.getPatientPesel())
//				.getWorker()
//				.getPatient();
		Patient patient = new Patient();
		patient.setName("Pacjent");
		patient.setId(23);
		patient.setEMail(visitmodel.getPatientEmail());
		return patient;
	}

	private Doctor createDoctor() {
//		Doctor doctor = systemUserDao.findSystemUserByPesel(visitmodel.getDoctorLogin())
//				.getWorker()
//				.getDoctor();
		Doctor doctor = new Doctor();
		doctor.setId(1);
		return doctor;
	}

	@GET
	@Path("/{visit_id}/typeOfVisit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getTypeOfVisit()).build();
	}
	
	@GET
	@Path("/{visit_id}/sickLeaves/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return Response.ok(sickleave).build();
	}

	@GET
	@Path("/{visit_id}/statusOfVisit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getStatusOfVisit()).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/receptionist/{receptionist_id}")
	public Response deleteTypeOfUserPermission(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		return Response.ok(visitService.deleteVisitReceptionist(visit_id, related_receptionist_id)).build();
	}

	@GET
	@Path("/{visit_id}/sickLeaves")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitSickLeaves(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getSickLeaves()).build();
	}

	@Path("/{visit_id}/statusOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/patientCard/{patientcard_id}")
	public Response deleteVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_patientcard_id") Integer related_patientcard_id) {
		return Response.ok(visitService.deleteVisitPatientCard(visit_id, related_patientcard_id)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/sickLeaves")
	@PUT
	public Response saveVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			SickLeave sickleaves) {
		visitService.saveVisitSickLeaves(visit_id, sickleaves);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId())).build();
	}

	@GET
	@Path("/{visit_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitDoctor(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor= doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);
		return Response.ok(doctor).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/receptionist")
	@PUT
	public Response saveVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/statusOfVisit/{statusofvisit_id}")
	public Response deleteVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_statusofvisit_id") Integer related_statusofvisit_id) {
		return Response.ok(visitService.deleteVisitStatusOfVisit(visit_id, related_statusofvisit_id)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}")
	@DELETE
	public void deleteVisit(@PathParam("visit_id") Integer visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id);
		visitService.deleteVisit(visit);
	}

	@Path("/{visit_id}/patientCard")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/doctor")
	@PUT
	public Response saveVisitDoctor(@PathParam("visit_id") Integer visit_id,
			Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	@GET
	@Path("/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id)).build();
	}
	
	@GET
	@Path("/get/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitByPesel(@PathParam("pesel") String pesel) throws JsonGenerationException, JsonMappingException, DataAccessException, IOException {
		return Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
				false).writeValueAsString(visitDAO.findVisitByPesel(pesel))).build();
	}

	@Path("/{visit_id}/typeOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listVisits() throws JsonGenerationException, JsonMappingException, IOException {
		
		List<VisitUser> set = new ArrayList<VisitUser>();
		Set<Visit> visit = visitService.loadVisits();
		Set<SystemUser> sys = systemUserDao.findAllSystemUsers();
		for(Visit v : visit){
			for(SystemUser su : sys){
				if(su.getWorker().getPatient()!=null && v.getPatientCard().getPatient().getId().equals(su.getWorker().getPatient().getId())){
					VisitUser vu = new VisitUser();
					vu.setSystemUser(su);
					vu.setVisit(v);
					set.add(vu);
				}
			}
		}
		
		return  Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
				false).writeValueAsString(set)).build();
	}
	
	@Path("/{visit_id}/typeOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}

	@GET
	@Path("/{visit_id}/patientCard/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_patientcard_id") Integer related_patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcard_id, -1, -1);
		return Response.ok(patientcard).build();
	}

	@GET
	@Path("/{visit_id}/receptionist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitReceptionist(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getReceptionist()).build();
	}

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVisit(Visit visit) {
		visitService.saveVisit(visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	@Path("/{visit_id}/sickLeaves")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			SickLeave sickleave) {
		visitService.saveVisitSickLeaves(visit_id, sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/statusOfVisit")
	@PUT
	public Response saveVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}

	@GET
	@Path("/{visit_id}/statusOfVisit/{statusofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_statusofvisit_id") Integer related_statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit_id, -1, -1);
		return Response.ok(statusofvisit).build();
	}

	@GET
	@Path("/{visit_id}/receptionist/{receptionist_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);
		return Response.ok(receptionist).build();
	}

	@Path("/{visit_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitDoctor(@PathParam("visit_id") Integer visit_id,
			Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	@GET
	@Path("/{visit_id}/patientCard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitPatientCard(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getPatientCard()).build();
	}

	@GET
	@Path("/{visit_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitDoctor(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getDoctor()).build();
	}

	@Path("/{visit_id}/receptionist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/patientCard")
	@PUT
	public Response saveVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}
}
