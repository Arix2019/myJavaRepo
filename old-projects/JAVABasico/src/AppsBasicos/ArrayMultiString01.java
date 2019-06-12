/*
*   array multidimensional de String
*/
package AppsBasicos;
import java.util.Scanner;
public class ArrayMultiString01 {

    public static void main(String[] args) {
        double matriz[][] = new double[3][5]; //linha -> coluna
        Scanner ler = new Scanner(System.in);

        System.out.println("Matriz[3][5]: ");
        for (int lin = 0; lin < 3; lin++) {
            for (int col = 0; col < 5; col++) {
                System.out.printf("Matrizes-> Linha["+lin+"]" + " Coluna["+col+"] : ");
                matriz[lin][col] = ler.nextDouble(); 
            }
        }
        //exibe a matriz:
        for (int lin = 0; lin < 3; lin++) {
            for (int col = 0; col < 5; col++) {
                System.out.print("\t" + matriz[lin][col]);
            }
            System.out.println();
        }
            

    }

}

/* ex: array multidimensional:
    Nome	nt1	nt2	nt3
    Arix	4,5	9,9	8,0
    Pata	6,6	6,8	8,6
*/