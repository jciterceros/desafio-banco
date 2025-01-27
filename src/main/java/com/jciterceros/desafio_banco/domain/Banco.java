package com.jciterceros.desafio_banco.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta não pode ser nula");
        }
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta não pode ser nula");
        }
        contas.remove(conta);
    }
}
