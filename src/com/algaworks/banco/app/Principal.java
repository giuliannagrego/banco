package com.algaworks.banco.app;

import com.algaworks.banco.models.Conta;
import com.algaworks.banco.models.Pessoa;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Fulano da Silva");
        titular1.setDocumento("53694831475");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Sicrana dos Santos");
        titular2.setDocumento("96453687523");

        Conta minhaConta = new Conta(titular1, 1234,1234);
//      minhaConta.titular = titular1;
//      minhaConta.agencia = 1234;
//      minhaConta.numero = 1234;
//      minhaConta.saldo = 0;

        Conta suaConta = new Conta(titular2,3542,8564253);
//      suaConta.setTitular(titular2);
//      suaConta.setAgencia(3542);
//      suaConta.setNumero(8564253);
//      suaConta.saldo = 0;

        minhaConta.depositar(15_000);
        suaConta.depositar(3_000);
        minhaConta.sacar(4_000);
        suaConta.sacar(7_000);
        suaConta.depositar(30_000);

//      minhaConta.saldo = minhaConta.saldo - 40_000;
//      Para que isso não aconteça, usamos o ENCAPSULAMENTO

//      minhaConta.sacar(1_000, 10);


        System.out.println("Títular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Títular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());

    }
}
