package Encapsulamento;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<>();

        System.out.println("Informações sobre o Cliente: ");

        // info conta(cliente) 01        
        Conta c01 = new Conta("Patinha The Cat", 12000.50, 6000.00);
        System.out.println("Nome: " + c01.getCliente());
        System.out.println("Saldo Atual: [R$ " + c01.getSaldo() + "]");
        System.out.println("Seu Limite atual de saque: [R$ " + c01.getLimite() + "]");

        //valor do saque:
        double saqueC01 = 1250.50;
        //valor do depósito:
        double depC01 = 1000.00;
        //seta o valor do saque
        c01.saca(saqueC01);
        
        System.out.println("Saque efetuado no valor: [R$ " + saqueC01 + "]");
        //seta o valor do depósito:
        c01.depoisita(depC01);
        System.out.println("Depósito no valor de [R$ " + depC01 + "]" );
        System.out.println("Saldo Atual: [R$ " + c01.getSaldo() + "]");
        // fim info conta(cliente) 01

    }

}
