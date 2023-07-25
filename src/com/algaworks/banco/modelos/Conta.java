package com.algaworks.banco.modelos;

import java.util.Objects;

/*      Uma classe ABSTRATA(abstract) é uma classe que não deve ser instânciada
        Ela é criada apenas para representar um conceito abstrato(genérico)

        Benefícios da classe abstrata:
        - Ajudam a trabalhar com o polimorfismo, deixando o código muito mais flexível, com baixo acoplamento
        - Permite decidir criar métodos abstratos, não limitando apenas à classe
*/
public abstract class Conta {

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

                if (getSaldoDisponivel() - valor < 0) {
                        throw new IllegalStateException("Saldo insuficiente");
                }

                saldo = saldo - valor;
        }
/*      Exemplo de método abstrato:
        As subclasses que herdam a superclasse, serão obrigadas a implementar esse método abstrato
        - O método abstrato não tem implementação, ao invés da abertura/fechamento de chaves, terá o ponto e vírgula -
*/
        public abstract void debitarTarifaMensal();

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

        public double getSaldoDisponivel() {
                return getSaldo();
        }
}
