package com.bertoti.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.bertoti.demo.enums.Categorias;

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
    @Disabled
    void testGenreValidation() {

    }

    @Test
    @Disabled
    void testGetDateFim() {

    }

    @Test
    @Disabled
    void testGetDateFimAsString() {

    }

    @Test
    @Disabled
    void testGetDateInicio() {

    }

    @Test
    @Disabled
    void testGetDateInicioAsString() {

    }

    @Test
    @Disabled
    void testGetDescription() {

    }

    @Test
    @Disabled
    void testGetGenero() {

    }

    @Test
    @Disabled
    void testGetId() {

    }

    @Test
    @Disabled
    void testGetImgId() {

    }

    @Test
    @Disabled
    void testGetName() {

    }

    @Test
    @Disabled
    void testGetPromoters() {

    }

    @Test
    @Disabled
    void testGetPromotersAsString() {

    }

    @Test
    @Disabled
    void testSetDateFim() {

    }

    @Test
    @Disabled
    void testSetDateInicio() {

    }

    @Test
    @Disabled
    void testSetDescription() {

    }

    @Test
    @Disabled
    void testSetGenero() {

    }

    @Test
    @Disabled
    void testSetId() {

    }

    @Test
    @Disabled
    void testSetImgId() {

    }

    @Test
    @Disabled
    void testSetName() {

    }

    @Test
    @Disabled
    void testSetPromoters() {

    }

}