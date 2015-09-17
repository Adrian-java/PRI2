package com.eclinic.email.sender;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailReminder {

	private List<String> emails;
	
	@Autowired
	private VisitWriter writer;
	
	@Autowired
	private EmailSender sender;

	public void getEmails() {
		try {
			emails = writer.getEmails();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
//	@Scheduled(cron = "0 0 0 * * *")  <- today at midnight
	@Scheduled(fixedDelay = 10000)
	public void remind() {
		getEmails();
		for(String email : emails) {
			System.out.println("Wysyłam zawiadomienie do: " + email);
			sender.setSubject("Reminder");
			sender.setContent("Przypominamy o jutrzejszej wizycie");
			sender.send(email);
		}
	}
}
