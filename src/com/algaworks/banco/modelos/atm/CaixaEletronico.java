package com.algaworks.banco.modelos.atm;

import com.algaworks.banco.modelos.Conta;
import com.algaworks.banco.modelos.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta) {
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento,Conta conta) {
        documento.quitarPagamento();

    }
}
