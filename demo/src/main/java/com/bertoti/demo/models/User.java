package com.bertoti.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String name;
    private String cpf;
    private String role;

    public User fixRole() {
        try {
            this.role = RolesEnum.valueOf(role).name();
            return this;
        } catch (IllegalArgumentException e) {
            this.role = RolesEnum.UNDEFINED.name();
            return this;
        }
    }

    public String getRole() {
        return role;
    }
}
