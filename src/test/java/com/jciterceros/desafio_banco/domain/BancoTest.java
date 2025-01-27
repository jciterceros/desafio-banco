package com.jciterceros.desafio_banco.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BancoTest {

    private Banco banco;
    private Conta conta;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        conta = new Conta();
    }

    @Test
    void testAdicionarContaValida() {
        banco.adicionarConta(conta);
        assertTrue(banco.getContas().contains(conta));
    }

    @Test
    void testAdicionarContaNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            banco.adicionarConta(null);
        });
        assertEquals("Conta não pode ser nula", exception.getMessage());
    }

    @Test
    void testRemoverContaValida() {
        banco.adicionarConta(conta);
        banco.removerConta(conta);
        assertFalse(banco.getContas().contains(conta));
    }

    @Test
    void testRemoverContaNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            banco.removerConta(null);
        });
        assertEquals("Conta não pode ser nula", exception.getMessage());
    }
}
