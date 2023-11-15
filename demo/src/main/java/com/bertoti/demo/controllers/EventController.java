package com.bertoti.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.dto.generoDTO;
import com.bertoti.demo.enums.Categorias;
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

    @GetMapping("generos")
    public ResponseEntity<?> getGenres(){
        ArrayList<generoDTO> genres = new ArrayList<generoDTO>();

        for (Categorias categoria : Categorias.values()) {
            genres.add(new generoDTO(categoria.name(), categoria.name().toLowerCase()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(genres);
    }

    @GetMapping("promoters")
    public ResponseEntity<?> getPromoters(){
        return null;
    }
}