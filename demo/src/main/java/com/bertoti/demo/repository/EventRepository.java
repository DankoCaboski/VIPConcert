package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;

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

        public List<Event> getAllEvents() {
                for (Event event : eventos) {
                        log.info(event.getName());
                }
                return eventos;
        }

        public boolean existById(Integer id) {
                return eventos.stream().anyMatch(evento -> evento.getId().equals(id));
            }

        public EventDTO getEventTitleById(String eventId) {
                try {
                        EventDTO eventDTO = new EventDTO(eventos.stream().filter(evento -> evento.getId().equals(Integer.parseInt(eventId))).findFirst().get());
                        return eventDTO;
                } catch (Exception e) {
                        throw e;
                }
        }
}
