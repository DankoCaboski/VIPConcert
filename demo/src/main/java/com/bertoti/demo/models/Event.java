package com.bertoti.demo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.bertoti.demo.enums.Categorias;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String name;
    private String description;
    private Categorias categoria;
    private LocalDateTime dateInicio;
    private LocalDateTime dateFim;
    private ArrayList<User> promoters;
}
