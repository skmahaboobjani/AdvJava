import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailBySite {
	public static void main(String[] args) throws AddressException {

		String host = "smtp.gmail.com";
		final String user = "221710307008@gitam.in";// change accordingly
		final String password = "Fassak@10";// change accordingly
		String to[] = {"saibadineedi@gmail.com","221710307006@gitam.in","221710307049@gitam.in"};// change accordingly
		Properties properies = new Properties();
		
		
		properies.put("mail.smtp.auth", "true");
		properies.put("mail.smtp.starttls.enable", "true");
		properies.put("mail.smtp.host", host);
		properies.put("mail.smtp.port", "587");
		
		
		Session session = Session.getDefaultInstance(properies, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		 Address[] toArray = {new InternetAddress("saibadineedi@gmail.com"),new InternetAddress("221710307049@gitam.in"),new InternetAddress("221710307006@gitam.in")};
		session.setDebug(true);
		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(user));
			
			message.addRecipients(Message.RecipientType.TO, toArray);
			
			message.setSubject("Chilaka Kottudu ");
			
			message.setText("This is simple program of sending email using JavaMail API");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}