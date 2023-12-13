/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
/**
 *
 * @author zakir
 */
public class WelcomeMail {
    private String to;
    private String from;
    
    private String host = "smtp.gmail.com";
    private String textBody;
    private String password;
    private String subject;
    
    public WelcomeMail(String to, String message, String sub) {
        this.to = to;
        this.from = "davepopel123@gmail.com";
        this.textBody = message;
        this.password = "rouo apge bcgl wpfq";
        this.subject = sub;
    }
    public void sendEmail(){
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from,password);
        }
                });   
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
              message.setContent(textBody, "text/html");
              Transport.send(message);
              System.out.println("Email Sent Successfully....");
        }catch (MessagingException mex){
            mex.printStackTrace();
          
        }
                }
}

