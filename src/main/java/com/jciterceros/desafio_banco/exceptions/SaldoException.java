package com.jciterceros.desafio_banco.exceptions;

public class SaldoException extends Exception {
    public SaldoException() {
        super("Saldo insuficiente");
    }

    public SaldoException(String message) {
        super(message);
    }
}
