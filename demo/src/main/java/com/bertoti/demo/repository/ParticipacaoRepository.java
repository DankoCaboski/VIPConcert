package com.bertoti.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bertoti.demo.dto.ParticipacaoDTO;
import com.bertoti.demo.models.Participacao;
import com.bertoti.demo.services.EventService;
import com.bertoti.demo.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ParticipacaoRepository {

    public static ArrayList<Participacao> participaceos = new ArrayList<Participacao>();

    public ArrayList<Participacao> getUserEvents(int id) {
        ArrayList<Participacao> UserParticipacaoes = new ArrayList<Participacao>();
        for (Participacao participacao : participaceos) {
            if(participacao.getUserId()==id){
                UserParticipacaoes.add(participacao);
                log.info("Participação cadastrada" + participacao.getUserId().toString());
            }
        }
        return UserParticipacaoes;
    }

    public Boolean save(ParticipacaoDTO participacaoDTO) {
        try {
            if(UserService.userExists(participacaoDTO.userId()) && EventService.eventExists(participacaoDTO.eventId())){
                return participaceos.add(new Participacao(participacaoDTO));
            }else{
                return false;
            }
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }
    }

}
