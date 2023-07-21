public class Conta {

//      Atributos da conta (Propriedades)

        Pessoa titular;
        int agencia;
        int numero;
        double saldo;

        void depositar(double valor) {

                if (valor <= 0) {
                        throw new IllegalStateException("Valor deve ser maior que 0");
                }
                saldo = saldo + valor;
        }
        void sacar(double valor) {

                if (valor <= 0) {
                        throw new IllegalStateException("Valor deve ser maior que 0");
                }

                if (saldo - valor < 0) {
                        throw new IllegalStateException("Saldo insuficiente");
                }

                saldo = saldo - valor;
        }
}
