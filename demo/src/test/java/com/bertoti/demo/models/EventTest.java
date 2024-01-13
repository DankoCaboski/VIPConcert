package com.bertoti.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.bertoti.demo.enums.Categorias;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class EventTest {

    private ArrayList<Event> eventos = new ArrayList<Event>();
    private Random random = new Random();
    private int nEvents = random.nextInt(20);

    private void seedEventos(){

    
        for (int i = 0; i < nEvents; i++) {
            Event event = new Event();
            event.setId(i);
            event.setName("Evento " + i);
            Categorias[] categories = Categorias.values();
            event.setGenero(categories[random.nextInt(categories.length)]);
            if(i%2 == 0){
                event.setDateInicio(LocalDate.now());
                event.setDateFim(event.getDateInicio().plusDays(random.nextInt(10)));
            }
            event.setPromoters(null);
            eventos.add(event);
        }
    }

    void setUp() {
        seedEventos();
        assertEquals(eventos.size(), nEvents);
    }

    @Test
    void testDateValidation() {
        for (Event event : eventos) {
            if(event.getDateInicio() == null){
                assertEquals(event.getDateFim(), null);
            }
            else{
                assertNotEquals(null, event.getDateFim());
            }
        }
    }

    @Test
    void testGenreValidation() {
        for (Event event : eventos) {
            assertThat(event.getGenero(), isA(Categorias.class));
        }
    }

}