package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.models.Event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EventRepository {
        public static ArrayList<Event> eventos = new ArrayList<Event>();

        public EventDTO save(EventDTO eventDTO) {
                try {
                        Event event = new Event(eventDTO);
                        eventos.add(event);
                        eventDTO = new EventDTO(eventDTO, event.getId());
                        return eventDTO;
                } catch (Exception e) {
                        throw e;
                }
        }

        public static int getNEvents() {
                return eventos.size();
        }

        public ArrayList<EventDTO> getAllEvents() {
                ArrayList<EventDTO> eventos = new ArrayList<EventDTO>();
                for (Event event : this.eventos) {
                        eventos.add(new EventDTO(event));
                }
                return eventos;
        }

        public boolean existById(Integer id) {
                return eventos.stream().anyMatch(evento -> evento.getId().equals(id));
            }

        public EventDTO getEventTitleById(String eventId) {
                Optional<Event> optionalEvent = eventos.stream()
                .filter(evento -> evento.getId().equals(Integer.parseInt(eventId)))
                .findFirst();
                if (optionalEvent.isPresent()) {
                return new EventDTO(optionalEvent.get());
                }else {
                return null;
                } 
        }
}
