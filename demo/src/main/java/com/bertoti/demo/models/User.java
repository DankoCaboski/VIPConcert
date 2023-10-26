package com.bertoti.demo.models;

import com.bertoti.demo.enums.RolesEnum;
import com.bertoti.demo.enums.StatusEnum;

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
    private RolesEnum role;
    private StatusEnum status;

    public RolesEnum getRole() {
        return role;
    }

}
