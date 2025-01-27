package com.jciterceros.desafio_banco.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ContaCorrenteTest {

    private ContaCorrente contaCorrente;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João");
        contaCorrente = new ContaCorrente(cliente);
    }

    @Test
    void testImprimirExtrato() {
        contaCorrente.depositar(100.0);
        contaCorrente.imprimirExtrato();
        assertEquals(100.0, contaCorrente.getSaldo());
    }
}
