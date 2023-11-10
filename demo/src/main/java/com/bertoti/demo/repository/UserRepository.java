package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bertoti.demo.dto.UserDTO;
import com.bertoti.demo.models.User;

import lombok.Getter;

@Getter

@Repository
public class UserRepository {
    public static List<User> users = new ArrayList<>();
    
    public User save(UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setId(users.size()+1);
        users.add(user);
        return user;
    }
    
    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    public void update(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, user);
        }
    }

    public User delete(User user) {
        users.remove(user);
        return user;
    }

    public boolean existById(Integer id) {
        return users.stream().anyMatch(user -> user.getId() == id);
    }

    public boolean existByCpf(String cpf) {

        return users.stream().anyMatch(user -> user.getCpf().equalsIgnoreCase(cpf));
    }

}
