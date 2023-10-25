package com.bertoti.demo.dto;

import com.bertoti.demo.enums.RolesEnum;
import com.bertoti.demo.models.User;

public record UserDTO(Integer id, String email, String name, String cpf, String role){
    public UserDTO(User user){
        this(user.getId(), user.getEmail(), user.getName(), user.getCpf(), validateRole(user.getRole().name()));
    }

    public RolesEnum getRole(){
        try {
            return RolesEnum.valueOf(role());
        } catch (Exception e) {
            return RolesEnum.UNDEFINED;
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
        return new User(id(), email(), name(), cpf(), RolesEnum.valueOf(validateRole(role())));
    }
}
