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
                        log.info("Event created: " + eventDTO.id());
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

        public EventDTO getEventById(String eventId) {
                try {
                        for (Event event : eventos) {
                            if (event.getId().equals(Integer.parseInt(eventId))) {
                                    return new EventDTO(event);
                                
                            }    
                        }
                        return null;
                } catch (Exception e) {
                        throw e;
                }
        }

        public static EventDTO getEventByIdStatic(String eventId) {
                try {
                        for (Event event : eventos) {
                            if (event.getId().equals(Integer.parseInt(eventId))) {
                                return new EventDTO(event);
                            }    
                        }
                        return null;
                } catch (Exception e) {
                        throw e;
                }
        }
}
