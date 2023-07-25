package com.algaworks.banco.modelos.pagamento;

//  O DocumentoEstornável É UM DocumentoPagavel, tornando desnecessária a repetição das variáveis
//  -> Então... Também existe herança em Interface!
public interface DocumentoEstornavel extends DocumentoPagavel {

//    double getValorTotal();
//    boolean estaPago();
    void estornarPagamento();
}
