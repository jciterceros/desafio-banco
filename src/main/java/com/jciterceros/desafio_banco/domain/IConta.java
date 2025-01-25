package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;

public interface IConta {
    void sacar(Double valor) throws SaldoException;

    void depositar(Double valor);

    void transferir(Double valor, IConta contaDestino);

    void imprimirExtrato();
}
