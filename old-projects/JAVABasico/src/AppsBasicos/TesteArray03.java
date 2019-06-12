/*
* Exemplo 2: Faça um aplicativo Java que peça o nome do aluno, receba duas notas e 
* depois retorne todas essas informações junto com a média dele.
 */
package AppsBasicos;

import java.util.Scanner;

public class TesteArray03 {

    public static void main(String[] args) {
             int cont;
        do {
            double nota[] = new double[4];
            double calc = 0;
            Scanner leitura = new Scanner(System.in);
            System.out.print("Nome: ");
            String nome = leitura.nextLine();
            for (int indice = 0; indice < 4; indice++) {
                System.out.print("Nota: " + indice + ": ");
                nota[indice] = leitura.nextDouble();
                calc = (nota[0] + nota[1] + nota[2] + nota[3]) / nota.length;
            }
            //exibe
            System.out.println("Nome do Aluno: " + nome + " - Media: " + calc);
            System.out.print("\nContinuar? 1-Sim / 0-Nao: ");
            cont = leitura.nextInt();
        } while (cont != 0);
    }
}
