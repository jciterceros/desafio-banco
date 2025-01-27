package com.jciterceros.desafio_banco.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ContaPoupancaTest {

    private ContaPoupanca contaPoupanca;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João");
        contaPoupanca = new ContaPoupanca(cliente);
    }

    @Test
    void testImprimirExtrato() {
        contaPoupanca.depositar(100.0);
        contaPoupanca.imprimirExtrato();
        assertEquals(100.0, contaPoupanca.getSaldo());
    }
}
