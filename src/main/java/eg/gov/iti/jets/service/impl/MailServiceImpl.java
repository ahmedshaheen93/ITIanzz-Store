package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.MailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class MailServiceImpl implements MailService {
    private static MailServiceImpl instance;

    protected MailServiceImpl() {
    }

    // response card number
    @Override
    public boolean sendScratchCardMail(UserDto user, ScratchCard scratchCard) {

        // Recipient's email ID needs to be mentioned.
        String to = user.getEmail();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("welcome our Dear " + user.getFirstName() + " " + user.getLastName() + "\n");
        stringBuilder.append("you have requested amount of money to be add to your balance \n");
        stringBuilder.append("as you send us a money using Bee service \n");
        stringBuilder.append("this link is valid for one time and will add amount of " + scratchCard.getCardAmount() + "$" + " \n");
        stringBuilder.append("to your account \n");
        String messageBody = "http://localhost:8088/iti-store/scratchCard?number=" + scratchCard.getCardNumber();
        stringBuilder.append(messageBody);
        String subject = "you have a new scratchCard";
        try {
            return yahooSend(to, subject, stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean sendForgetPasswordMail(UserDto user, String randomPassword) {
        String to = user.getEmail();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("welcome our Dear " + user.getFirstName() + " " + user.getLastName() + "\n");
        stringBuilder.append("you have requested a new password \n");
        stringBuilder.append("as you send your email \n");
        stringBuilder.append("this is your new password \n" + randomPassword + " \n");
        String subject = "Reset Password";
        try {
            return yahooSend(to, subject, stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static MailServiceImpl getInstance() {
        return instance = Objects.requireNonNullElseGet(instance, MailServiceImpl::new);
    }

    private boolean yahooSend(String mail, String subject, String msg) throws IOException {

        // Sender's email ID needs to be mentioned
        String from = "ahmedshaheen93@yahoo.com";
        String credential = System.getProperty("user.home") + "/iti-store/credential";
        String pass = new String(Files.readAllBytes(Paths.get(credential)));
        // Recipient's email ID needs to be mentioned.
        String to = mail;
        String host = "smtp.mail.yahoo.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");


        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(msg);
            System.out.print("Sending msg " + msg);
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, 587, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            System.out.print(mex);
            mex.printStackTrace();
        }
        return false;
    }
}
