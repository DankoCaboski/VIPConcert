package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void save(Map<String, Object> updates, int id) {
        User user = findById(id);
        if (user != null) {
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "name":
                        user.setName((String) value);
                        break;
                    case "email":
                        user.setEmail((String) value);
                        break;
                    case "cpf":
                        user.setCpf((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field: " + key);
                }
            }
            update(user);
        }
    }

    public boolean existByName(String username) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(username)) {
                return true;
                
            }
        }
        return false;
    }

    public User findByName(String username) {
        User foundUser = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(username)) {
                foundUser = user;
            }
        }
        return foundUser;
    }
}
