package TesteClasses;

import java.util.Scanner;

/**
 *
 * @author Arix
 */
public class ClasseArrayPrincipal {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        
        ClasseArray cliente0001 = new ClasseArray();
        cliente0001.nomeCli = "TESTE";
        cliente0001.numeroConta = 44545;
        cliente0001.limiteCli = 1500;
        cliente0001.saldoCli = 5000;

        System.out.println("Nome: " + cliente0001.nomeCli);
        System.out.println("Saldo: " + cliente0001.saldoCli);        
        System.out.println("Numero da Conta: "+cliente0001.numeroConta);
        System.out.println("Limite de Saque: " + cliente0001.limiteCli);
        
        System.out.print("Valor do Saque: ");
        double saque = ler.nextDouble();
        cliente0001.saldo(saque);
    }
    
}
