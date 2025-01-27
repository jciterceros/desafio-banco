package com.jciterceros.desafio_banco.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaldoExceptionTest {

    @Test
    void testSaldoExceptionDefaultMessage() {
        SaldoException exception = new SaldoException();
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    void testSaldoExceptionCustomMessage() {
        String customMessage = "Saldo abaixo do mínimo permitido";
        SaldoException exception = new SaldoException(customMessage);
        assertEquals(customMessage, exception.getMessage());
    }
}
