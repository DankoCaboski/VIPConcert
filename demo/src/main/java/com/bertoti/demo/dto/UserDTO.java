package com.bertoti.demo.dto;

import com.bertoti.demo.enums.RolesEnum;
import com.bertoti.demo.enums.StatusEnum;
import com.bertoti.demo.models.User;

public record UserDTO(
    Integer id,
    String password,
    String email,
    String name, 
    String cpf,
    String role,
    String status
    ){

    public UserDTO(User user){
        this(user.getPid(), user.getPassword(), user.getEmail(), user.getName(), user.getCpf(), validateRole(user.getRole().name()), user.getStatus().name());
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
        try {
            StatusEnum.valueOf(status).name();
            return new User(id(), password(), email(), name(), cpf(), RolesEnum.valueOf(validateRole(role())), StatusEnum.valueOf(status()));
        } catch (Exception e) {
            return new User(id(), password(), email(), name(), cpf(), RolesEnum.valueOf(validateRole(role())), StatusEnum.ACTIVE);
        }
    }

    public StatusEnum getStatus() {
        return StatusEnum.valueOf(status);
    }
}
