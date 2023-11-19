package com.bertoti.demo.dto;

import com.bertoti.demo.models.Event;

public record EventDTO(
     Integer id,
     Integer imgId,
     String name,
     String description,
     String genero,
     String dateInicio,
     String dateFim,
     String promoters) {

     public EventDTO(EventDTO eventDTO, int id) {
           this(
                id,
                eventDTO.imgId(),
                eventDTO.name(),
                eventDTO.description(),
                eventDTO.genero(),
                eventDTO.dateInicio(),
                eventDTO.dateFim(),
                eventDTO.promoters()
           );
     }

     public EventDTO(Event event) {
           this(
                event.getId(),
                event.getImgId(),
                event.getName(),
                event.getDescription(),
                event.getGenero().name(),
                event.getDateInicio().toString(),
                event.getDateFim().toString(),
                event.getPromoters().toString()
           );
     }
    
}
