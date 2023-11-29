package com.bertoti.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertoti.demo.dto.UserDTO;
import com.bertoti.demo.models.Event;
import com.bertoti.demo.models.Participacao;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.ParticipacaoRepository;
import com.bertoti.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;
    @Autowired
    private static ParticipacaoRepository participacoesRepository;

    public UserService(UserRepository userRepository, ParticipacaoRepository participacoesRepository) {
        this.userRepository = userRepository;
        this.participacoesRepository = participacoesRepository;
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
    public static boolean userExists(Integer userId) {
        return userRepository.existByCpf(Integer.toString(userId));
    }
    
}
