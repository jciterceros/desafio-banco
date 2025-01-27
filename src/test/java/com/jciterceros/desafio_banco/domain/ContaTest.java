package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContaTest {

    private Conta conta;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("João");
        conta = new Conta(cliente);
    }

    @Test
    void testSacarValorPositivo() throws SaldoException {
        conta.depositar(100.0);
        conta.sacar(50.0);
        assertEquals(50.0, conta.getSaldo());
    }

    @Test
    void testSacarValorNegativo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(-10.0);
        });
        assertEquals("Valor de saque deve ser positivo", exception.getMessage());
    }

    @Test
    void testSacarSaldoInsuficiente() {
        SaldoException exception = assertThrows(SaldoException.class, () -> {
            conta.sacar(50.0);
        });
        assertNotNull(exception);
    }

    @Test
    void testDepositarValorPositivo() {
        conta.depositar(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    void testDepositarValorNegativo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(-10.0);
        });
        assertEquals("Valor de depósito deve ser positivo", exception.getMessage());
    }

    @Test
    void testTransferirValorPositivo() throws SaldoException {
        Conta contaDestino = new Conta(new Cliente("Maria"));
        conta.depositar(100.0);
        conta.transferir(50.0, contaDestino);
        assertEquals(50.0, conta.getSaldo());
        assertEquals(50.0, contaDestino.getSaldo());
    }

    @Test
    void testTransferirValorNegativo() {
        Conta contaDestino = new Conta(new Cliente("Maria"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.transferir(-10.0, contaDestino);
        });
        assertEquals("Valor de transferência deve ser positivo", exception.getMessage());
    }

    @Test
    void testTransferirSaldoInsuficiente() {
        Conta contaDestino = new Conta(new Cliente("Maria"));
        SaldoException exception = assertThrows(SaldoException.class, () -> {
            conta.transferir(50.0, contaDestino);
        });
        assertNotNull(exception);
    }
}
