//package com.example.ECommerceApplication.controller;
//
//import com.example.ECommerceApplication.service.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private MailService mailService;
//
//    @GetMapping("/login-success")
//    public String handleLogin() {
//        // Get the currently authenticated user's details
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName(); // Typically the username or email
//
//        // Send email with the login time
//        LocalDateTime loginTime = LocalDateTime.now();
//        mailService.sendLoginEmail("user-email@example.com", username, loginTime);
//
//        return "Login successful! Email sent.";
//    }
//}
