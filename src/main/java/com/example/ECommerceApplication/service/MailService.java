//package com.example.ECommerceApplication.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendLoginEmail(String toEmail, String username, LocalDateTime loginTime) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject("Welcome to Our Application");
//        message.setText("Hello " + username + ",\n\n"
//                + "Welcome to our application! Your login time is: " + loginTime);
//
//        mailSender.send(message);
//    }
//}
//
