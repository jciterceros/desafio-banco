package com.jciterceros.desafio_banco.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        log.info("Imprimindo extrato da conta corrente");
        System.out.println("Extrato da conta corrente");
        super.imprimirExtrato();
    }
}
