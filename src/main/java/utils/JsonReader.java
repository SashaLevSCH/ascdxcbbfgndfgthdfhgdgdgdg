package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class JsonReader {
	public JsonReader(String scenarioName, String testDataFileName) {
	}

    public JsonReader() {

    }

    public static JSONObject readTestData(String strScenarioName, String testDataFileName) throws Exception {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(testDataFileName);
		
		System.out.println("Scenario Data for - "+ strScenarioName);
		
		Object obj = jsonParser.parse(reader);
		
		JSONObject dataObject = (JSONObject) obj;
		
		JSONObject jsonChild = (JSONObject) dataObject.get(strScenarioName);
		
		return jsonChild;
	}

	public static String readTxt(int line) throws IOException {
		String lines = Files.readAllLines(Paths.get("testsWebUI.txt")).get(line);
		return lines;
	}

	public static void SendMailSSLWithAttachment() {
		// Create object of Property file
		Properties props = new Properties();
		String email = ".....@gmail.com";
		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");
		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");
		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
		// set the port of SMTP server
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(email, ".....");
					}

				});
		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			// Set the from address
			message.setFrom(new InternetAddress(email));
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			// Add the subject link
			message.setSubject("Testing Subject");
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			// Set the body of email
			messageBodyPart1.setText("This is message body");
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			// Mention the file which you want to send
			File xx = new File(System.getProperty("user.dir"), "Reports");
			String filename = ".html";
			// Create data source and pass the filename
			DataSource source = new FileDataSource(xx + "/" + filename);
			// set the handler
			if (((FileDataSource) source).getFile().exists()) {
				messageBodyPart2.setDataHandler(new DataHandler(source));
				// set the file
				messageBodyPart2.setFileName(filename);
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
				// add body part 1
				multipart.addBodyPart(messageBodyPart2);
				// add body part 2
				multipart.addBodyPart(messageBodyPart1);
				// set the content
				message.setContent(multipart);
				// finally send the email
				Transport.send(message);
//                System.out.println("\n" + ANSI_CYAN + "===Email Sent===" + ANSI_PURPLE + "===To: " + ANSI_PURPLE + email + " ===!" + ANSI_BLUE + "===With File: " + filename + ANSI_RESET + "\n");
			} else {
//                System.out.println("\n" + ANSI_CYAN + "File doesn't exists " + ANSI_RESET + "\n");
			}
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
