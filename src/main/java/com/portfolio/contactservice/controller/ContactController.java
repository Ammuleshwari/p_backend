package com.portfolio.contactservice.controller;

import com.portfolio.contactservice.model.EmailRequest;
import com.portfolio.contactservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://ammuleshwariparne.vercel.app")  // allow your React frontend
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final MailService mailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        mailService.sendContactEmail(request);
        return ResponseEntity.ok("Message sent successfully!");
    }
}
