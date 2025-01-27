package com.jciterceros.desafio_banco;

import com.jciterceros.desafio_banco.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DesafioBancoApplication implements CommandLineRunner {

    private final ContaService contaService;

    public DesafioBancoApplication(ContaService contaService) {
        this.contaService = contaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioBancoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("João");

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        contaService.depositar(contaCorrente, 100.0);
        contaService.depositar(contaPoupanca, 1000.0);

        log.info("\n********************* Dados iniciais das Contas *********************");
        contaService.imprimirExtrato(contaCorrente);
        contaService.imprimirExtrato(contaPoupanca);

        log.info("\n********************* Dados Tranferencia Conta Corrente para Poupanca *********************");
        contaService.realizarTransferencia(contaCorrente, contaPoupanca, 1050.0);

        log.info("\n********************* Dados Tranferencia Conta Poupanca para Corrente *********************");
        contaService.realizarTransferencia(contaPoupanca, contaCorrente, 50.0);

        log.info("\n********************* Dados Sacar da Conta Poupanca *********************");
        contaService.realizarSaque(contaPoupanca, 100.0);

        log.info("\n********************* Dados Sacar da Conta Corrente *********************");
        contaService.realizarSaque(contaCorrente, 150.0);
    }
}