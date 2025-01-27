package com.jciterceros.desafio_banco;

import com.jciterceros.desafio_banco.domain.Cliente;
import com.jciterceros.desafio_banco.domain.Conta;
import com.jciterceros.desafio_banco.domain.ContaCorrente;
import com.jciterceros.desafio_banco.domain.ContaPoupanca;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DesafioBancoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioBancoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("João");

        Conta contaCorrente = new ContaCorrente(cliente);
        contaCorrente.depositar(100.0);

        Conta contaPoupanca = new ContaPoupanca(cliente);
        contaPoupanca.depositar(1000.0);

        log.info("\n********************* Dados iniciais das Contas *********************");
        imprimirExtrato(contaCorrente);
        imprimirExtrato(contaPoupanca);

        log.info("\n********************* Dados Tranferencia Conta Corrente para Poupanca *********************");
        realizarTransferencia(contaCorrente, contaPoupanca, 1050.0);

        log.info("\n********************* Dados Tranferencia Conta Poupanca para Corrente *********************");
        realizarTransferencia(contaPoupanca, contaCorrente, 50.0);

        log.info("\n********************* Dados Sacar da Conta Poupanca *********************");
        realizarSaque(contaPoupanca, 100.0);

        log.info("\n********************* Dados Sacar da Conta Corrente *********************");
        realizarSaque(contaCorrente, 150.0);
    }

    private void imprimirExtrato(Conta conta) {
        conta.imprimirExtrato();
    }

    private void realizarTransferencia(Conta contaOrigem, Conta contaDestino, Double valor) {
        try {
            contaOrigem.transferir(valor, contaDestino);
            imprimirExtrato(contaOrigem);
            imprimirExtrato(contaDestino);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private void realizarSaque(Conta conta, Double valor) {
        try {
            conta.sacar(valor);
            imprimirExtrato(conta);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
