/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Random;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class SendEmail {

    final String fromEmail = "";
    final String password = "";

    public static String getRandom() {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return String.format("%06d", number);
    }

    public String sendCode(String toEmail, String content) {
        String code = getRandom();
//        final String fromEmail = "phamduykhanhlc97@gmail.com";
//        final String password = "evskhzialprwptpg";
        try {

            // your host email smtp server details
            Properties pr = new Properties();

//            pr.put("mail.smtp.auth", "true");
//            pr.put("mail.smtp.starttls.enable", "true"); //TLS
//            pr.put("mail.smtp.host", "smtp.office365.com");
//            pr.put("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            mess.setSubject("User Email Verification");

            //set message text
            mess.setText(content + code);
            //send the message
            Transport.send(mess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
//    public static void main(String[] args) {
//        boolean test = false;
//        String toEmail = "hieuhn0301@gmail.com";
////        String fromEmail = "prj301_fuhoalac@outlook.com.vn";
////        String password = "Hieu@123";
//        String fromEmail = "hieuhnhe163048@fpt.edu.vn";
//        String password = "Hangochieu123";
////        final String fromEmail = "phamduykhanhlc97@gmail.com";
////        final String password = "evskhzialprwptpg";
//        try {
//
//            // your host email smtp server details
//            Properties pr = new Properties();
//
////            pr.put("mail.smtp.auth", "true");
////            pr.put("mail.smtp.starttls.enable", "true"); //TLS
////            pr.put("mail.smtp.host", "smtp.office365.com");
////            pr.put("mail.smtp.port", "587");
//            pr.setProperty("mail.smtp.auth", "true");
//            pr.setProperty("mail.smtp.starttls.enable", "true");
//            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
//            pr.setProperty("mail.smtp.port", "587");
//            //get session to authenticate the host email address and password
//            Session session = Session.getInstance(pr, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(fromEmail, password);
//                }
//            });
//
//            //set email message details
//            Message mess = new MimeMessage(session);
//
//            //set from email address
//            mess.setFrom(new InternetAddress(fromEmail));
//            //set to email address or destination email address
//            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//
//            //set email subject
//            mess.setSubject("User Email Verification");
//
//            //set message text
//            String code = getRandom();
//            mess.setText("Registered successfully.\n"
//                    + "Please verify your account using this code: " + code);
//            //send the message
//            Transport.send(mess);
//
//            test = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
