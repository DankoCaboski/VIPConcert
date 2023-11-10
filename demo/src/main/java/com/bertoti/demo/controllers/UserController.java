package com.bertoti.demo.controllers;

import com.bertoti.demo.teste;
import com.bertoti.demo.dto.UserDTO;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;
import com.bertoti.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    UserService userService = new UserService(userRepository);

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllUsers(@PathVariable String id ) {
        
        if(id.equals("all")){
            List<UserDTO> users = userService.getAllUsers();
            if (users.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(users);
            }
        }
        else{
            UserDTO userDTO = userService.getUserById(id);
            if (userDTO == null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(userDTO);
            }
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<User> getUserById(@PathVariable String id) {
    //     User user = userRepository.findById(Integer.parseInt(id));
    //     if (user != null) {
    //         return ResponseEntity.ok(user);
    //     } else {
    //         return ResponseEntity.noContent().build();
    //     }
    // }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            if (userRepository.existByCpf(userDTO.cpf())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            else{
                User newUser =  userRepository.save(userDTO);
                // teste.printUsers();
                return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
            }
        } catch (HttpMessageNotReadableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body format");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        User internalUser = userRepository.findById(id);
        if (internalUser != null) {
            try {
                internalUser.setName(userDTO.name());
                internalUser.setEmail(userDTO.email());
                internalUser.setCpf(userDTO.cpf());
                internalUser.setRole(userDTO.getRole());
                internalUser.setStatus(userDTO.getStatus());   
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while updating user");               }
            return ResponseEntity.ok(userRepository.save(internalUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        User userToDelete = userRepository.findById(id);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
