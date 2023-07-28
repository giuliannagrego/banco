package com.algaworks.banco.modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.HALF_EVEN;

/*  Classe ContaInvestimento herdada da Classe Conta:
    Usa-se o -> extends Conta
    Quando uma Classe é herdada, sempre que for instanciado algum objeto do tipo ContaInvestimento,
    esses objetos terão todas as propriedades e todos os comportamentos herdados dos objetos do tipo Conta.

    Pode-se dizer que:
    ContaInvestimento -é uma- subclasse de Conta, ou
    ContaInvestimento -é uma- especilização(um tipo específico, mais especializado) de Conta, ou
    ContaInvestimento -é uma- Conta
    -------Por outro lado, podemos dizer que-----------------------------------------------------------------
    A classe Conta é uma classe pai/mãe da classe ContaInvestimento, ou
    A classe Conta é uma superclasse, etc
*/
public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldo().compareTo(new BigDecimal("10000")) < 0) {
            sacar(new BigDecimal("30"));
        }
    }

    public void creditarRendimentos(BigDecimal percentualJuros) {
//        double valorRendimentos = getSaldo() * percentualJuros / 100;
        BigDecimal valorRendimentos = getSaldo().multiply(percentualJuros)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        depositar(valorRendimentos);
//      *RoundingMode.HALF_EVEN -> Padrão de arredondamento bancário*
    }
}
