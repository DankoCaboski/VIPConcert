package com.bertoti.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertoti.demo.dto.ParticipacaoDTO;
import com.bertoti.demo.models.Participacao;
import com.bertoti.demo.repository.ParticipacaoRepository;
import com.bertoti.demo.repository.UserRepository;
import com.bertoti.demo.service.UserService;

@RestController
@RequestMapping("/participacao")
@CrossOrigin(origins = "*")
public class ParticipacaoController {

    @Autowired
    private static UserRepository userRepository;
    @Autowired
    private static ParticipacaoRepository participacoesRepository;

    UserService userService = new UserService(userRepository, participacoesRepository);

    @GetMapping("/{id}/events")
    public ResponseEntity<?> getUserEvents(@PathVariable int id) {
        //TODO: implementar
        //TODO: revisar return
        ArrayList<Participacao> eventos = userService.getUserEvents(id);
        if(eventos != null){
            if (eventos.size() > 0) {
                return ResponseEntity.ok(eventos);
            }else{
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @PostMapping
    public ResponseEntity<?> registerParticipation(@RequestBody ParticipacaoDTO participacaoDTO) {
        Boolean saved = participacoesRepository.save(participacaoDTO);
        if(saved == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }else{
            if(saved){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Usuário ou evento não existem");
            }
        }
    }
}
