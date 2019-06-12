package Strings;

import java.util.Scanner;

public class PrincipalTestArray {
    public static void main(String[] args){
        TestArrayStrings valida = new TestArrayStrings();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("--Validador de CPF - (Informe apenas números) ou Tecle (s) para sair: --");
        System.out.print("Informe o CPF: ");
        String VarCpf = ler.next();
        
        //classe TestArrayStrings
        valida.ValidadorCpf(VarCpf);
    
    }
    
}
