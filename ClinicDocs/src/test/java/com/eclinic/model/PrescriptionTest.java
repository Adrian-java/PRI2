package com.eclinic.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

import com.eclinic.domain.Patient;

@ContextConfiguration(locations = {"classpath:/ClinicWeb/src/main/webapp/WEB-INF/classes/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PrescriptionTest {
	
	@Autowired
	private Patient patient;
	
	
	@Test
	public void patientTest() {
		Assert.assertEquals(patient.getName(), "agga");
	}
	

}
