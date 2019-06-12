package AppsBasicos;

import java.util.Scanner;

/**
 * Exemplo 1: Crie um aplicativo em Java que peça ao usuário para preencher uma 
 * matriz 3x3 com valores inteiros e depois exiba essa matriz.
 * Exemplo de array multidimensional:
 * @author Arix
 */
public class ArrayMult01 {
    public static void main(String[] args){
        int matriz[][] = new int[3][3]; //tres linhas para 3 colunas
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Informe os vaalors: ");
        for (int lin = 0 ; lin < 3; lin++){
            for (int col = 0 ; col < 3; col++){
                System.out.printf("Matrizes: " + "linha-> " + lin + " colunas-> " + col + ": ");
                matriz[lin][col] = ler.nextInt();
            }
        }
        //exibe a matriz com 3 linhas e 3 colunas:
        for (int lin = 0 ; lin < 3 ; lin++) {
            for (int col = 0 ; col < 3 ; col++){
                System.out.print("\t" + matriz[lin][col]);
            }
            System.out.println();
        }
    }
    
}
