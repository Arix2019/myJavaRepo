/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeticoes;
import java.util.ArrayList;
/**
 *
 * @author Arix
 */
public class Repeticoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> numList = new ArrayList();
        
        System.out.println("Números pares de 0 a 10:");
        for(int x = 0; x <= 10; x++){
            if (x % 2 == 0){
                //adiciona números a lista
                numList.add(x);
            }     
        }
        //exibe lista com os números pares
        System.out.println(numList);
        System.out.println(numList.size());
        
        System.out.println("");
        System.out.println("percorrendo uma lista");
        int n = numList.size();
        for (int i = 0; i<n; i++ ){
            System.out.println(numList.get(i));
        }
    }
    
}
