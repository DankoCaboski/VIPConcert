package com.bertoti.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.enums.Categorias;
import com.bertoti.demo.repository.EventRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {

    private Integer id;
    private Integer imgId;
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

        genreValidation(eventDTO.genero());

        dateValidation(eventDTO);

        this.promoters = new ArrayList<User>();
    }

    public void genreValidation(String genreFromDTO) {
        Categorias genre = null;
        try {
            genre = Categorias.valueOf(genreFromDTO);
        } catch (Exception e) {
            log.info("Evento criado com categoria OUTROS");
            genre = Categorias.OUTROS;
        }
        this.genero = genre;
    }

    public void dateValidation (EventDTO eventDTO) {
        if(eventDTO.dateInicio() == "" || eventDTO.dateInicio() == null) {
            this.dateInicio = null;
            this.dateFim = null;
            return;
        }else {
            try{
                this.dateInicio = LocalDateTime.parse(eventDTO.dateInicio()).toLocalDate();
            }catch(Exception e) {
                log.info("Data de inicio inválida");
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        if (eventDTO.dateFim() == "" || eventDTO.dateFim() == null) {
            this.dateFim = null;
        }else{
            try{
                this.dateFim = LocalDateTime.parse(eventDTO.dateInicio()).toLocalDate();

            }catch(Exception e) {
                log.info("Data de fim inválida");
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    public String getDateInicioAsString() {
        if (this.dateInicio != null) {
            return this.dateInicio.toString();
        } else {
            return "";
            
        }
    }

    public String getDateFimAsString() {
        if (this.dateFim != null) {
            return this.dateFim.toString();
        } else {
            return "";
            
        }
    }

    public String getPromotersAsString() {
        String promotersList = "";
        if (promoters == null) {
            return promotersList;
        }
        for (User user : promoters) {
            promotersList.concat(",");
            promotersList.concat(user.getName());
        }
        return promotersList;
    }
}
