package com.jciterceros.desafio_banco;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesafioBancoIntegrationTests {

//    @Autowired
//    private ContaService contaService;
//
//    @Test
//    void testDepositar() {
//        Cliente cliente = new Cliente();
//        cliente.setNome("João");
//
//        ContaCorrente contaCorrente = new ContaCorrente(cliente);
//        contaService.depositar(contaCorrente, 200.0);
//
//        assertEquals(200.0, contaCorrente.getSaldo());
//    }
//
//    @Test
//    void testTransferencia() throws SaldoException {
//        Cliente cliente = new Cliente();
//        cliente.setNome("João");
//
//        ContaCorrente contaCorrente = new ContaCorrente(cliente);
//        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
//
//        contaService.depositar(contaCorrente, 500.0);
//        contaService.depositar(contaPoupanca, 1000.0);
//
//        contaService.realizarTransferencia(contaCorrente, contaPoupanca, 300.0);
//
//        assertEquals(200.0, contaCorrente.getSaldo());
//        assertEquals(1300.0, contaPoupanca.getSaldo());
//    }
//
//    @Test
//    void testSaque() throws SaldoException {
//        Cliente cliente = new Cliente();
//        cliente.setNome("João");
//
//        ContaCorrente contaCorrente = new ContaCorrente(cliente);
//        contaService.depositar(contaCorrente, 300.0);
//
//        contaService.realizarSaque(contaCorrente, 100.0);
//
//        assertEquals(200.0, contaCorrente.getSaldo());
//    }
//
//    @Test
//    void testTransferenciaSaldoInsuficiente() {
//        Cliente cliente = new Cliente();
//        cliente.setNome("João");
//
//        ContaCorrente contaCorrente = new ContaCorrente(cliente);
//        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
//
//        contaService.depositar(contaCorrente, 100.0);
//
//        assertThrows(SaldoException.class, () -> contaService.realizarTransferencia(contaCorrente, contaPoupanca, 150.0));
//    }
}