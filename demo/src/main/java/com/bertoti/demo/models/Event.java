package com.bertoti.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.enums.Categorias;
import com.bertoti.demo.repository.EventRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {

    private int id;
    private String name;
    private String description;
    private Categorias genero;
    private LocalDate dateInicio;
    private LocalDate dateFim;
    private ArrayList<User> promoters;

    public Event(EventDTO eventDTO) {
        this.id = EventRepository.getNEvents() + 1;
        this.name = eventDTO.name();
        this.description = eventDTO.description();
        try {
            this.genero = Categorias.valueOf(eventDTO.genero());
        } catch (Exception e) {
            this.genero = Categorias.OUTROS;
        }
        try {
            LocalDateTime tempInicio = LocalDateTime.parse(eventDTO.dateInicio());
            this.dateInicio = LocalDate.of(tempInicio.getYear(), tempInicio.getMonthValue(), tempInicio.getDayOfMonth());
            try {
            LocalDateTime tempFim = LocalDateTime.parse(eventDTO.dateInicio());
            this.dateFim = LocalDate.of(tempFim.getYear(), tempFim.getMonthValue(), tempFim.getDayOfMonth());
            } catch (Exception e) {
                throw new IllegalArgumentException("Data de fim inválida");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Data de inicio inválida");
        }
        this.promoters = new ArrayList<User>();
    }

    public int getId() {
        return this.id;
    }
}
