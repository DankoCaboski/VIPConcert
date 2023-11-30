package com.bertoti.demo.controllers.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if (userRepository.existByName(data.username())) {return ResponseEntity.ok().build();} else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserDTO data) {
        try {
            if (userRepository.existByCpf(data.cpf())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            else{
                String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
                
                data = new UserDTO(data.id(), encryptedPassword, data.email(), data.name(), data.cpf(), data.role(), data.status());

                User newUser =  userRepository.save(data);
                return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
            }
        } catch (HttpMessageNotReadableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body format");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    
}
