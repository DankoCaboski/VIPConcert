package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bertoti.demo.models.Event;

@Repository
public class EventRepository {
        public static List<Event> eventos = new ArrayList<Event>();
}
