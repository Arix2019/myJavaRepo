/*
preenchendo vetores com dados informados pelo teclado
*/
package vetor;
import java.util.Scanner;

public class Vetor02 {
    
    public static void main(String[] args){
    
        Scanner ler = new Scanner(System.in);
        int v[] = new int[4];
        int impar[] = new int[4];
        
        //preenchendo o vetor com dados pelo teclado:
        for (int x = 0; x < v.length; x++){
            System.out.print("Digite: ");
            int num = ler.nextInt();            
            if (num % 2 == 0){
                v[x] = num;
            } else{
                impar[x] = num;
            } 
        }
        
        //exibindo o conteudo armazenado no vetor (v):
        System.out.print("Exibindo números pares do vetor (v): ");
        for (int x: v) {
            System.out.print(x + " ");
        }
        
        System.out.println("");
        
        System.out.print("Exibindo números impares do vetor (impar): ");
        for (int x: impar) {
            System.out.print(x + " ");
        }

        System.out.println("");        

    }
    
}
