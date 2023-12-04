package com.bertoti.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private int id;
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
        try {
            this.genero = Categorias.valueOf(eventDTO.genero());
        } catch (Exception e) {
            log.info("Evento criado com categoria outros");
            this.genero = Categorias.OUTROS;
        }
        try {
            // Exemplo de intrada de hora: 2021-10-10T10:10:10
            if(eventDTO.dateInicio() == "" || eventDTO.dateInicio() == null) {
                if (eventDTO.dateFim() == null) {
                    this.dateInicio = null;
                    this.dateFim = null;
                    }
            }else {
                LocalDateTime tempInicio = LocalDateTime.parse(eventDTO.dateInicio());
                this.dateInicio = LocalDate.of(tempInicio.getYear(), tempInicio.getMonthValue(), tempInicio.getDayOfMonth());
            }
            try {
                if (eventDTO.dateFim() == "" || eventDTO.dateFim() == null) {
                    this.dateFim = null;
                }else{
                    LocalDateTime tempFim = LocalDateTime.parse(eventDTO.dateInicio());
                    this.dateFim = LocalDate.of(tempFim.getYear(), tempFim.getMonthValue(), tempFim.getDayOfMonth());
                }
            } catch (Exception e) {
                log.info("Data de fim inválida");
                throw new IllegalArgumentException(e.getMessage());
            }
        } catch (Exception e) {
            log.info("Data de inicio inválida");
            throw new IllegalArgumentException(e.getMessage());
        }
        this.promoters = new ArrayList<User>();
    }

    public Integer getId() {
        return this.id;
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
