package AppsBasicos;

import java.util.Scanner;

/**
 *
 * @author Arix
 */
public class TesteArray02 {
    public static void main(String[] args){
        int nota[] = new int[3];
        Scanner entrada = new Scanner(System.in);
        
        //recebendo os numeros
        for (int indice = 0; indice < 3; indice++){
            System.out.print("Informe a Nota: " + indice + ": ");
            nota[indice] = entrada.nextInt();
        }
        
        //exibindo os numeros
        for (int indice = 0; indice < 3; indice++ ){
            System.out.println("Valor armazenado: " + nota[indice]);
        }

    }
    
}
