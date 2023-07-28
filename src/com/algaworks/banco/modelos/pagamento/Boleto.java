package com.algaworks.banco.modelos.pagamento;

import com.algaworks.banco.modelos.Pessoa;

import java.math.BigDecimal;

/*  Foi criada uma classe -concreta- que implementa uma interface

    - Quando uma classe implementa uma interface, que possui métodos abstratos,
    obrigatóriamente a classe precisa implementar esses métodos.

            *Caso contrário a classe não compila*
*/
public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Pessoa beneficiario;
    private BigDecimal valor;
    private boolean pago;

    public Boleto(Pessoa beneficiario, BigDecimal valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void estornarPagamento() {
        pago = false;
    }
    @Override
    public void quitarPagamento() {
        pago = true;
    }

}
