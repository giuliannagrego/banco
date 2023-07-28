package com.algaworks.banco.modelos.pagamento;

import java.math.BigDecimal;

//  Uma interface é apenas um contrato, não é instanciável.
public interface DocumentoPagavel {

//  Não tem implementação dos métodos, só está definido o que um DocumentoPagavel deve ter
    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();


//    Evitar o uso do default (pode ser considerado uma má prática)
    default void imprimirRecibo() {
        System.out.println("RECIBO:");
        System.out.println("Valor total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
