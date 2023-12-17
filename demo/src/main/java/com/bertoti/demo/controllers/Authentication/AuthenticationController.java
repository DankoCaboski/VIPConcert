package com.bertoti.demo.controllers.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertoti.demo.dto.UserDTO;
import com.bertoti.demo.dto.Authentication.AuthenticationDTO;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) {
        log.info("Login attempt with username: {}", data.username());
        if (userRepository.existByName(data.username())) {
            if(userRepository.findByName(data.username()).getPassword().equals(data.password())){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } 
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User user = null;
            user = userRepository.save(new User(null, userDTO.password(), userDTO.email(), userDTO.name(), userDTO.cpf(), userDTO.getRole(), userDTO.getStatus()));
            log.info("Creating user with name: {}", user.getName());
            if(user != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(null);
            }
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            log.error("Error while creating user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }
}
