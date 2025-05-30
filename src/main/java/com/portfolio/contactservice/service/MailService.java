package com.portfolio.contactservice.service;

import com.portfolio.contactservice.model.EmailRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String toEmail;

    public void sendContactEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Portfolio Message from " + request.getName());
        message.setText("Name: " + request.getName() +
                "\nEmail: " + request.getEmail() +
                "\nMessage: " + request.getMessage());
        mailSender.send(message);
    }
}
