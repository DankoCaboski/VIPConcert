package com.bertoti.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertoti.demo.dto.UserDTO;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(String id) {
        User userFromRepo = userRepository.findById(Integer.parseInt(id));
        if(userFromRepo == null){
            return null;
        }
        UserDTO userDTO = new UserDTO(userFromRepo);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> usersFromRepo = userRepository.findAll();
        List<UserDTO> userListDTO = new ArrayList<UserDTO>();
        for (User user : usersFromRepo) {
            userListDTO.add(new UserDTO(user));
        }
        return userListDTO;
    }
    
}
