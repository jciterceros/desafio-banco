package com.jciterceros.desafio_banco.domain;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da conta corrente");
        super.imprimirExtrato();
    }
}
