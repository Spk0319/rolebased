package com.example.demo.controller;

import com.example.demo.model.ContactMessage;
import com.example.demo.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @Autowired
    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    public ContactMessage createContactMessage(@RequestBody ContactMessage contactMessage) {
        contactMessageService.saveMessage(contactMessage);
        return contactMessage;
    }

    @GetMapping
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageService.getAllMessages();
    }
}
