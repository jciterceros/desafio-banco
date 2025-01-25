package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;
import lombok.Data;

@Data
public class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = 1;
    private static Integer SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected Double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(Double valor) throws SaldoException {
        if (saldo < valor) {
            throw new SaldoException();
        }
        saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) throws SaldoException{
        if (saldo < valor) {
            throw new SaldoException();
        }
        saldo -= valor;
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da conta: ");
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Saldo: " + this.saldo);
    }
}
