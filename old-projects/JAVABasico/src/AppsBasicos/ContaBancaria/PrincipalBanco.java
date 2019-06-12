package AppsBasicos.ContaBancaria;

import java.util.Scanner;

public class PrincipalBanco {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        double vs;

        // atributos conta do cliente001
        Conta Cliente001 = new Conta();
        Cliente001.Nome = "Patinha da Silva";
        Cliente001.NumeroConta = 001;
        Cliente001.Saldo = 12000;
        Cliente001.Limite = 6000;

        // atributos conta do cliente002
        Conta Cliente002 = new Conta();
        Cliente002.Nome = "Bartolomeu de Almeida";
        Cliente002.NumeroConta = 002;
        Cliente002.Saldo = 16200;
        Cliente002.Limite = 6500;

        //informações sobre o saque do cliente
        System.out.println(Cliente001.Nome + " - Saldo atual: " + Cliente001.Saldo);
        System.out.printf("Informe o valor do saque: ");
        vs = leitura.nextDouble();
        
        Cliente001.Sacar(vs);

    }
}
