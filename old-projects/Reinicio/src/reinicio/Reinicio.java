package reinicio;

import java.util.Scanner;

public class Reinicio {

    public static void main(String[] args) {
        System.out.print("Olá, qual seu nome? ");
        Scanner ler = new Scanner(System.in);
        String nome = ler.next();
        System.out.print("Seja bem vindo(a) " + nome + ", qual a sua idade? ");
        int idade = ler.nextInt();
        
        if (idade < 18){
            System.out.println("Prazer em te conhecer " + nome + ", você ainda "
                    + "não pode entrar na balada. :(");
        } else{
            System.out.println("Prazer em te conhecer " + nome + ", pode "
                    + "entrar na balada.");
        }
        
    }
    
}
