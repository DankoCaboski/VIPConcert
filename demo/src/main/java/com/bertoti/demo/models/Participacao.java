package com.bertoti.demo.models;

import com.bertoti.demo.dto.ParticipacaoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participacao {
    private Integer userId;
    private Integer eventId;

    public Participacao(ParticipacaoDTO participacaoDTO) {
        this.userId = participacaoDTO.userId();
    }
}
