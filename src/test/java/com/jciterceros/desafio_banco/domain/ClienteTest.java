package com.jciterceros.desafio_banco.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
    }

    @Test
    void testSetNomeValido() {
        String nomeValido = "João";
        cliente.setNome(nomeValido);
        assertEquals(nomeValido, cliente.getNome());
    }

    @Test
    void testSetNomeInvalido() {
        String nomeInvalido = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setNome(nomeInvalido);
        });
        assertEquals("Nome não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void testValidarNomeValido() {
        String nomeValido = "Maria";
        assertDoesNotThrow(() -> cliente.validarNome(nomeValido));
    }

    @Test
    void testValidarNomeInvalido() {
        String nomeInvalido = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.validarNome(nomeInvalido);
        });
        assertEquals("Nome não pode ser nulo ou vazio", exception.getMessage());
    }
}
