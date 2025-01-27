package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContaServiceTest {

    @InjectMocks
    private ContaService contaService;

    @Mock
    private Conta contaOrigem;

    @Mock
    private Conta contaDestino;

    @BeforeEach
    public void setUp() {
        contaService = new ContaService();
    }

    @Test
    void testDepositar() {
        Double valor = 100.0;
        contaService.depositar(contaOrigem, valor);
        verify(contaOrigem, times(1)).depositar(valor);
    }

    @Test
    void testRealizarTransferenciaComSaldoSuficiente() throws SaldoException {
        Double valor = 50.0;
        doNothing().when(contaOrigem).transferir(valor, contaDestino);
        contaService.realizarTransferencia(contaOrigem, contaDestino, valor);
        verify(contaOrigem, times(1)).transferir(valor, contaDestino);
        verify(contaOrigem, times(1)).imprimirExtrato();
        verify(contaDestino, times(1)).imprimirExtrato();
    }

    @Test
    void testRealizarTransferenciaComSaldoInsuficiente() throws SaldoException {
        Double valor = 50.0;
        doThrow(new SaldoException()).when(contaOrigem).transferir(valor, contaDestino);
        assertThrows(SaldoException.class, () -> contaService.realizarTransferencia(contaOrigem, contaDestino, valor));
        verify(contaOrigem, times(1)).transferir(valor, contaDestino);
        verify(contaOrigem, never()).imprimirExtrato();
        verify(contaDestino, never()).imprimirExtrato();
    }

    @Test
    void testRealizarSaqueComSaldoSuficiente() throws SaldoException {
        Double valor = 50.0;
        doNothing().when(contaOrigem).sacar(valor);
        contaService.realizarSaque(contaOrigem, valor);
        verify(contaOrigem, times(1)).sacar(valor);
        verify(contaOrigem, times(1)).imprimirExtrato();
    }

    @Test
    void testRealizarSaqueComSaldoInsuficiente() throws SaldoException {
        Double valor = 50.0;
        doThrow(new SaldoException()).when(contaOrigem).sacar(valor);
        assertThrows(SaldoException.class, () -> contaService.realizarSaque(contaOrigem, valor));
        verify(contaOrigem, times(1)).sacar(valor);
        verify(contaOrigem, never()).imprimirExtrato();
    }
}
