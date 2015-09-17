package com.eclinic.email.sender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class VisitWriter {
	
	private File file = new File("visits.txt");
	
	public void saveVisit(Calendar date, String email) throws IOException {
		checkIfFileExists();
		
		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()); 
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String visit = String.valueOf(date.getTimeInMillis()) + ',' + email + System.lineSeparator();
		bufferedWriter.write(visit);
		bufferedWriter.close();
	}
	
	public List<String> getEmails() throws IOException {
		checkIfFileExists();
		
		FileReader fileReader = new FileReader(file.getAbsoluteFile());
		BufferedReader reader = new BufferedReader(fileReader);
		
		List<String> visits = new ArrayList<>();
		
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {
			Calendar cal = new GregorianCalendar();
			String[] line = currentLine.split(",");			
			String date = line[0];
			String email = line[1];

			setVisitDate(cal, date);
			Date visitDate = cal.getTime();
			Date tomorrow = getTomorrowDate();
			
			if (visitDate.before(tomorrow)) {
				visits.add(email);
			}
		}
		reader.close();
		return visits;
	}
	
	private void checkIfFileExists() throws IOException {
		if (!file.exists())
			file.createNewFile();
	}

	private void setVisitDate(Calendar cal, String date) {
		long miliseconds = (long) Long.parseLong(date);
		cal.setTimeInMillis(miliseconds);
	}
	
	private Date getTomorrowDate() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(c.getTime());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.add(Calendar.DAY_OF_YEAR, 1);

		return c.getTime();
		
	}

}
