package com.algaworks.banco.app;

import com.algaworks.banco.TipoPessoa;
import com.algaworks.banco.modelos.ContaEspecial;
import com.algaworks.banco.modelos.ContaInvestimento;
import com.algaworks.banco.modelos.Pessoa;
import com.algaworks.banco.modelos.atm.CaixaEletronico;
import com.algaworks.banco.modelos.exceptions.SaldoInsuficienteException;
import com.algaworks.banco.modelos.pagamento.Boleto;
import com.algaworks.banco.modelos.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Fulano da Silva");
        titular1.setDocumento("53694831475");
//      titular1.setRendimentoAnual(Double.valueOf(15_000d));
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        System.out.println(LocalDateTime.now());
        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-07-26T17:00:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        System.out.println(titular1.getTipo());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Sicrana dos Santos");
        titular2.setDocumento("96453687523");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 1234,1234);
//      minhaConta.titular = titular1;
//      minhaConta.agencia = 1234;
//      minhaConta.numero = 1234;
//      minhaConta.saldo = 0;

        ContaEspecial suaConta = new ContaEspecial(titular2,3542,8564253, new BigDecimal("10000"));
//      suaConta.setTitular(titular2);
//      suaConta.setAgencia(3542);
//      suaConta.setNumero(8564253);
//      suaConta.saldo = 0;

        try {
            minhaConta.depositar(new BigDecimal("150000"));
            minhaConta.sacar(new BigDecimal("4000"));

            suaConta.depositar(new BigDecimal("30000"));
            suaConta.sacar(new BigDecimal("7000"));
            suaConta.depositar(new BigDecimal("30000"));

//          minhaConta.saldo = minhaConta.saldo - 40_000;
//          Para que isso não aconteça, usamos o ENCAPSULAMENTO

//          minhaConta.sacar(1_000, 10);

            minhaConta.creditarRendimentos(new BigDecimal(0.8));
            minhaConta.debitarTarifaMensal();

            suaConta.sacar(new BigDecimal("60000"));
            suaConta.debitarTarifaMensal();

//          System.out.println("Títular: " + minhaConta.getTitular().getNome());
//          System.out.println("Saldo: " + minhaConta.getSaldo());

//          System.out.println("Títular: " + suaConta.getTitular().getNome());
//          ASystem.out.println("Saldo: " + suaConta.getSaldo());

/*          Usando o princípio do polimorfismo, o Boleto -É UM- DocumentoPagavel.
            Possibilitando o vínculo entre ambos.
*/

//          DocumentoPagavel boletoEscola = new Boleto(titular2, 2_000); OU
            Boleto boletoEscola = new Boleto(titular2,new BigDecimal(2_000));
            Holerite salarioFuncionario = new Holerite(titular1,new BigDecimal("100"),220);

            caixaEletronico.pagar(boletoEscola,suaConta);
            caixaEletronico.estornarPagamento(boletoEscola,suaConta);

            caixaEletronico.pagar(salarioFuncionario,minhaConta);

            suaConta.sacar(new BigDecimal("3000"));
            System.out.println("Boleto pago: " + boletoEscola.estaPago()); // false
            boletoEscola.imprimirRecibo();
            System.out.println();
            System.out.println("Salário pago: " + salarioFuncionario.estaPago()); // true
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
