package com.bertoti.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bertoti.demo.DTOs.UserDTO;
import com.bertoti.demo.models.User;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    
    public User save(UserDTO userDTO) {
        User user = userDTO.toUser();
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

}
