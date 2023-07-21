package com.algaworks.banco.models;

import java.util.Objects;

public class Conta {

//      Atributos da conta (Propriedades)
//      Encapsulamento - modificador usado para definir o nivel acesso que se pode ter na variável, método, etc.
        private Pessoa titular;
        private int agencia;
        private int numero;
        private double saldo;

        public Conta(){
        }

        public Conta(Pessoa titular, int agencia, int numero){

                Objects.requireNonNull(titular);

                this.titular = titular;
                this.agencia = agencia;
                this.numero = numero;
        }

        public void depositar(double valor) {

                if (valor <= 0) {
                        throw new IllegalStateException("Valor deve ser maior que 0");
                }
                saldo = saldo + valor;
        }
        public void sacar(double valor) {

                if (valor <= 0) {
                        throw new IllegalStateException("Valor deve ser maior que 0");
                }

                if (saldo - valor < 0) {
                        throw new IllegalStateException("Saldo insuficiente");
                }

                saldo = saldo - valor;
        }

//      Sobrecarga de método
        void sacar(double valor, double taxaSaque) {
                sacar(valor + taxaSaque);
        }

//      Javabeans - Métodos Getters and Setters
        public Pessoa getTitular() {
                return titular;
        }

        public int getAgencia() {
                return agencia;
        }

        public void setAgencia(int agencia) {
                this.agencia = agencia;
        }

        public int getNumero() {
                return numero;
        }

        public double getSaldo() {
                return saldo;
        }
}
