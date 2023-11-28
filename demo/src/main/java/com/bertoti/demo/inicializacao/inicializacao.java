package com.bertoti.demo.inicializacao;

import java.util.ArrayList;
import java.util.Random;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.enums.Categorias;
import com.bertoti.demo.repository.EventRepository;
import com.github.javafaker.Faker;

public class inicializacao {
    private static EventRepository eventRepository = new EventRepository();

    public static void seed(){

        Random random = new Random();
        Faker faker = new Faker();

        int randomNumber = random.nextInt(11) + 5; // Generates a random number between 5 and 15

        ArrayList<Categorias> genres = new ArrayList<Categorias>();

        for (Categorias genero : Categorias.values()) {
            genres.add(genero);
        }

        for (int i = 0; i < randomNumber; i++) {
            eventRepository.save(new EventDTO(null, null, faker.business().creditCardNumber(),
            faker.rickAndMorty().location(), genres.get(random.nextInt(genres.size())).toString(), null, null, null));
        }
        
    }
}
