package com.jciterceros.desafio_banco;

import com.jciterceros.desafio_banco.domain.Cliente;
import com.jciterceros.desafio_banco.domain.Conta;
import com.jciterceros.desafio_banco.domain.ContaCorrente;
import com.jciterceros.desafio_banco.domain.ContaPoupanca;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        System.out.println("\n********************* Dados iniciais das Contas *********************");
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();

        System.out.println("\n********************* Dados Tranferencia Conta Corrente para Poupanca *********************");
        try{
            contaCorrente.transferir(1050.0, contaPoupanca);
            contaCorrente.imprimirExtrato();
            contaPoupanca.imprimirExtrato();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n********************* Dados Tranferencia Conta Poupanca para Corrente *********************");
        try{
            contaPoupanca.transferir(50.0, contaCorrente);
            contaCorrente.imprimirExtrato();
            contaPoupanca.imprimirExtrato();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
