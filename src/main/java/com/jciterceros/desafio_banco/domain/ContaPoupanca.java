package com.jciterceros.desafio_banco.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        log.info("Imprimindo extrato da conta poupança");
        log.info("Extrato da conta poupança");
        super.imprimirExtrato();
    }
}
