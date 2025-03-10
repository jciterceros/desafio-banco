package com.jciterceros.desafio_banco.domain;

import com.jciterceros.desafio_banco.exceptions.SaldoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContaService {
    public void depositar(Conta conta, Double valor) {
        conta.depositar(valor);
    }

    public void realizarTransferencia(Conta contaOrigem, Conta contaDestino, Double valor) throws SaldoException {
        try {
            contaOrigem.transferir(valor, contaDestino);
            imprimirExtrato(contaOrigem);
            imprimirExtrato(contaDestino);
        } catch (SaldoException e) {
            log.info(e.getMessage());
        }
//        contaOrigem.transferir(valor, contaDestino);
//        imprimirExtrato(contaOrigem);
//        imprimirExtrato(contaDestino);
    }

    public void realizarSaque(Conta conta, Double valor) throws SaldoException{
        try {
            conta.sacar(valor);
            imprimirExtrato(conta);
        } catch (SaldoException e) {
            log.info(e.getMessage());
        }
//        conta.sacar(valor);
//        imprimirExtrato(conta);
    }

    public void imprimirExtrato(Conta conta) {
        conta.imprimirExtrato();
    }
}
