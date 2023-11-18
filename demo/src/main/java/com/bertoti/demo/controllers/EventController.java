package com.bertoti.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventRepository.getAllEvents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) {
        try{
            eventDTO = eventRepository.save(eventDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(eventDTO);

        } catch (IllegalArgumentException e) {
            // This is a client error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // This is a server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("generos")
    public ResponseEntity<?> getGenres(){
        ArrayList<generoDTO> genres = new ArrayList<generoDTO>();

        for (Categorias genero : Categorias.values()) {
            genres.add(new generoDTO(genero.name(), genero.name().toLowerCase()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(genres);
    }

    @GetMapping("promoters")
    public ResponseEntity<?> getPromoters(){
        //TODO: Implementar
        return null;
    }
}