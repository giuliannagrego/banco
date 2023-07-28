package com.algaworks.banco.modelos.exceptions;

//  Para "OBRIGAR" quem chama o método a tratar a exceção, basta que a classe herde Exception
//  Para "NÃO OBRIGAR" quem chama o método a tratar a exceção, basta que a classe herde RuntimeException
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String message) {
        super(message);
    }

}
