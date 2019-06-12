package lista02;
import java.util.Scanner;
import java.util.ArrayList;

public class Lista03 {
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        ArrayList lista01 = new ArrayList();
        ArrayList lista02 = new ArrayList();
        
        for (int i = 0; i <= 3; i++){
            System.out.print("Número: ");
            int num = ler.nextInt();
            if (num % 2 == 0){
                lista01.add(num);
            } else {
                lista02.add(num);
            }
        }
        
        System.out.println(lista01);
    
    }
    
}
