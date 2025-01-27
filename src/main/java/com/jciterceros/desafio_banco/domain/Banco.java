package com.jciterceros.desafio_banco.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Banco {
    private String nome;
    private List<Conta> contas;
}
