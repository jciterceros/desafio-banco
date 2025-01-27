package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = 1;
    private static Integer sequencia = 1;

    private Integer agencia;
    private Integer numero;
    private Double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencia++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(Double valor) throws SaldoException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }

        if (saldo < valor) {
            throw new SaldoException();
        }
        saldo -= valor;
        log.info("Saque realizado: " + valor);
    }

    @Override
    public void depositar(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        saldo += valor;
        log.info("Depósito realizado: " + valor);
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) throws SaldoException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de transferência deve ser positivo");
        }
        if (saldo < valor) {
            throw new SaldoException();
        }
        saldo -= valor;
        contaDestino.depositar(valor);
        log.info("Transferência realizada: " + valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Saldo: " + this.saldo);
    }
}
