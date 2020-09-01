package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailSenderUtil {
	
	private MailSender mailSender;

	@Autowired
	public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	public void send(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	

}
