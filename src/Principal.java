public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.nome = "Fulano da Silva";
        titular1.documento = "53694831475";

        Pessoa titular2 = new Pessoa();
        titular2.nome = "Sicrana dos Santos";
        titular2.documento = "96453687523";

        Conta minhaConta = new Conta();
        minhaConta.titular = titular1;
        minhaConta.agencia = 1234;
        minhaConta.numero = 9878632;
        minhaConta.saldo = 0;

        Conta suaConta = new Conta();
        suaConta.titular = titular2;
        suaConta.agencia = 3542;
        suaConta.numero = 8564253;
        suaConta.saldo = 0;

        minhaConta.depositar(15_000);
        suaConta.depositar(3_000);

        minhaConta.sacar(4_000);
        suaConta.sacar(7_000);


        System.out.println("Títular: " + minhaConta.titular.nome);
        System.out.println("Saldo: " + minhaConta.saldo);

        System.out.println("Títular: " + suaConta.titular.nome);
        System.out.println("Saldo: " + suaConta.saldo);

    }
}
