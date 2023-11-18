package com.bertoti.demo.service;

import org.springframework.stereotype.Service;

import com.bertoti.demo.repository.EventRepository;

@Service
public class EventService {

    private static EventRepository eventRepository;

    public static boolean eventExists(Integer eventId) {
        return eventRepository.existById(eventId);
    }

}
