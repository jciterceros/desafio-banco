package com.jciterceros.desafio_banco.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class Cliente {
    private String nome;

    public void setNome(String nome) {
        try {
            validarNome(nome);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
            System.exit(0);
        }
        this.nome = nome;
    }

    public void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
    }
}
