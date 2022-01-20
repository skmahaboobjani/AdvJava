import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
 
import javax.mail.Authenticator;
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

import sun.misc.IOUtils;
 
/**
 * This utility class provides a functionality to send an HTML e-mail message
 * with embedded images.
 * @author www.codejava.net
 *
 */
 class EmbeddedImageEmailUtil {
 
    /**
     * Sends an HTML e-mail with inline images.
     * @param host SMTP host
     * @param port SMTP port
     * @param userName e-mail address of the sender's account
     * @param password password of the sender's account
     * @param toAddress e-mail address of the recipient
     * @param subject e-mail subject
     * @param htmlBody e-mail content with HTML tags
     * @param mapInlineImages
     *          key: Content-ID
     *          value: path of the image file
     * @throws AddressException
     * @throws MessagingException
     */
    public static void send(String host, String port,
            final String userName, final String password, String[] toAddress,
            String subject, String htmlBody,
            Map<String, String> mapInlineImages)
                throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
       
        InternetAddress[] toAddresses =  getToAddresses(toAddress);//{ new InternetAddress(toAddress[0]) };
        
        
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlBody, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds inline image attachments
        if (mapInlineImages != null && mapInlineImages.size() > 0) {
            Set<String> setImageID = mapInlineImages.keySet();
             
            for (String contentId : setImageID) {
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.setHeader("Content-ID", "<" + contentId + ">");
                imagePart.setDisposition(MimeBodyPart.INLINE);
                 
                String imageFilePath = mapInlineImages.get(contentId);
                try {
                    imagePart.attachFile(imageFilePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(imagePart);
            }
        }
 
        msg.setContent(multipart);
       /* StringWriter writer = new StringWriter();
        IOUtils.copy(new FileInputStream(new File("home.html")), writer);

        message.setContent(writer.toString(), "text/html");
 */
      //  C:\Users\sai\eclipse-workspace\JavaMailApi\src\NewFile.html
        Transport.send(msg);
    }

	private static InternetAddress[] getToAddresses(String[] toAddresses) throws AddressException {
		InternetAddress[] adresses=new InternetAddress[toAddresses.length];
		for(int i=0;i<toAddresses.length;i++)
		{
			adresses[i]=new InternetAddress(toAddresses[i]);
		}
		return adresses;
	}
}



public class InlineImageEmailTester {
 
    /**
     * main entry of the program
     */
    public static void main(String[] args) {
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "221710307008@gitam.in";
        String password = "Fassak@10";
 
        // message info
        String mailTo[] = {"saibadineedi@gmail.com"/*,"himavarshith716@gmail.com","patlollaharishkumar066@gmail.com","chsureshreddy321@gmail.com"*/};
        String subject = " Sent mail Using Java,Test e-mail with inline images";
        StringBuffer body
            = new StringBuffer("<html>This message contains two inline images.<br>");
        body.append("The first image is a chart:<br>");
        body.append("<img src=\"cid:image1\" width=\"40%\" height=\"40%\" /><br>");
        body.append("The second one is a cube:<br>");
        body.append("<img src=\"cid:image2\" width=\"30%\" height=\"30%\" /><br><br>");
      //  body.append("<button type=\"submit\" formaction=\"https://www.youtube.com/watch?v=MkaUB7iQaQ8\">Click Me!</button><br>");
        
        body.append("https://www.youtube.com/watch?v=MkaUB7iQaQ8\\<br>");
        
        body.append("<button type=\"submit\" style=\"background-color: #4CAF50;\r\n" + 
        		"  border: none;\r\n" + 
        		"  color: white;\r\n" + 
        		"  padding: 15px 32px;\r\n" + 
        		"  text-align: center;\r\n" + 
        		"  text-decoration: none;\r\n" + 
        		"  display: inline-block;\r\n" + 
        		"  font-size: 16px;\r\n" + 
        		"  margin: 4px 2px;\r\n" + 
        		"  cursor: pointer;\"><a href=\"https://www.w3schools.com/\"> Visit </a></button>");
        body.append("End of message.");
       
        body.append("</html>");
                           
        // inline images
        Map<String, String> inlineImages = new HashMap<String, String>();
        inlineImages.put("image1", "C:/Users/sai/eclipse-workspace/JavaMailApi/src/brahmi.jpg");
        inlineImages.put("image2", "C:/Users/sai/eclipse-workspace/JavaMailApi/src/getup_srinu.jpg");
 
        try {
            EmbeddedImageEmailUtil.send(host, port, mailFrom, password, mailTo,
                subject, body.toString(), inlineImages);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
}