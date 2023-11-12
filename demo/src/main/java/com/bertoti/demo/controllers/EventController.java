package com.bertoti.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.repository.EventRepository;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController{

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable String id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createEvent(EventDTO eventDTO) {
        return null;
    }
}