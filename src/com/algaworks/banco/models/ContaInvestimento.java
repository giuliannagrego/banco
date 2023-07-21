package com.algaworks.banco.models;

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

    public void creditarRendimentos(double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }


}
