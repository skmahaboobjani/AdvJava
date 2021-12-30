import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailWithAttachments {

	public static void main(String[] args) throws AddressException {

		String host = "smtp.gmail.com";
		final String user = "221710307008@gitam.in";// change accordingly
		final String password = "Fassak@10";// change accordingly
		String to[] = { "saibadineedi@gmail.com"/* ,"221710307006@gitam.in","221710307049@gitam.in" */ };// change
																											// accordingly
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

		Address[] toArray = { new InternetAddress("saibadineedi@gmail.com")/*,
				new InternetAddress("221710307049@gitam.in"), new InternetAddress("221710307006@gitam.in") */};
		session.setDebug(true);
		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(user));

			message.addRecipients(Message.RecipientType.TO, toArray);

			message.setSubject("Chilaka Kottudu ");

			message.setText("This is simple program of sending email using JavaMail API");

			Multipart multipart = new MimeMultipart();

			MimeBodyPart attachmentPart = new MimeBodyPart();

			MimeBodyPart textPart = new MimeBodyPart();

			try {

				File f = new File("C:\\Users\\sai\\eclipse-workspace\\JavaMailApi\\src\\brahmi.jpg");

				attachmentPart.attachFile(f);
				textPart.setText("Brahmi");
				multipart.addBodyPart(textPart);
				multipart.addBodyPart(attachmentPart);

			} catch (IOException e) {

				e.printStackTrace();

			}

			message.setContent(multipart);

			message.setContent("<h2>HTML Image</h2>\r\n"
					+ "<img src=\"C:\\Users\\sai\\eclipse-workspace\\JavaMailApi\\src\\brahmi.jpg\" alt=\"Trulli\" width=\"500\" height=\"333\">",
					"text/html");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
