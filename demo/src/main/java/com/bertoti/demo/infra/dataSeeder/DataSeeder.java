package com.bertoti.demo.infra.dataSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.bertoti.demo.dto.EventDTO;
import com.bertoti.demo.enums.Categorias;
import com.bertoti.demo.models.Event;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.EventRepository;
import com.bertoti.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSeeder {
    
    private static EventRepository eventRepository = new EventRepository();

    public static void seedAll() {
        seedUsers();
        seedEvents();
    }
    
    private static void seedUsers() {

        Collection<User> users = new ArrayList<>();
		User user = new User();
		user.setName("teste");
		user.setPassword("teste");
		users.add(user);

		User userAdm = new User();
		userAdm.setName("admin");
		userAdm.setPassword("admin");
		users.add(userAdm);

		UserRepository.users.addAll(users);
    }


    private static void seedEvents() {
        Random random = new Random();
        int nEvents = random.nextInt(10);
        for (int i = 0; i < nEvents; i++) {

            Event event = new Event();
            event.setId(i);
            event.setName("Evento " + i);
            Categorias[] categories = Categorias.values();
            event.setGenero(categories[random.nextInt(categories.length)]);
            event.setDateInicio(null);
            event.setDateFim(null);

            event.setPromoters(null);
            EventDTO eventDTO = new EventDTO(event);
            eventRepository.save(eventDTO);
        }
    }
}
