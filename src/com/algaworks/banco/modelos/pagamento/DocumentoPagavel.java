package com.algaworks.banco.modelos.pagamento;

//  Uma interface é apenas um contrato, não é instanciável.
public interface DocumentoPagavel {

//  Não tem implementação dos métodos, só está definido o que um DocumentoPagavel deve ter
    double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

}
