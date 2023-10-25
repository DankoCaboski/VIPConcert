package com.bertoti.demo.DTOs;

import com.bertoti.demo.models.RolesEnum;
import com.bertoti.demo.models.User;

public record UserDTO(Integer id, String email, String name, String cpf, String role){
    public UserDTO(User user){
        this(user.getId(), user.getEmail(), user.getName(), user.getCpf(), validateRole(user.getRole()));
        if(role() == RolesEnum.UNDEFINED.name()){
            throw new IllegalArgumentException("User created as UNDEFINED\n Invalid role: " + user.getRole());
        }
    }

    private static String validateRole(String role) {
        try {
            return RolesEnum.valueOf(role).name();
        } catch (IllegalArgumentException e) {
            return RolesEnum.UNDEFINED.name();
        }
    }

    public User toUser(){
        return new User(id(), email(), name(), cpf(), role());
    }
}
