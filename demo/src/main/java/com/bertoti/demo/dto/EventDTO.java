package com.bertoti.demo.dto;

public record EventDTO(
     Integer id,
     String name,
     String description,
     String genero,
     String dateInicio,
     String dateFim,
     String promoters) {

     public EventDTO(EventDTO eventDTO, int id) {
           this(
                id,
                eventDTO.name(),
                eventDTO.description(),
                eventDTO.genero(),
                eventDTO.dateInicio(),
                eventDTO.dateFim(),
                eventDTO.promoters()
           );
     }
    
}
