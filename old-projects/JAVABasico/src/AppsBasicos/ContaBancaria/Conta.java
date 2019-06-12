package AppsBasicos.ContaBancaria;

import java.util.Scanner;

public class Conta {

    //atributos da conta
    String Nome;
    int NumeroConta;
    double Saldo;
    double Limite;

    boolean Sacar(double Valor) {

        if (Valor > this.Limite) {
            System.out.println("Limite indisponivel.");
            System.out.println("Saldo atual: " + Saldo);
            return true;
        } else {
            Saldo = Saldo -= Valor;
            System.out.println("Saldo atual: " + Saldo);
            return false;
        }

    }

}
