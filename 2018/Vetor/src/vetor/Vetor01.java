/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetor;

/**
 *
 * @author Arix
 */
public class Vetor01 {
    
    public static void main(String[] argd){
        
        String mes[] = {"Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago",
                        "Set","Out","Nov","Dez"};
        int totDias[] = {31,28,31,30,31,30,31,30,31,30,31,30};
        
        //System.out.println("O mês de " + mes[0] + " tem " + totDias[0] + " dias.");
        //for each
        for (int c = 0; c < mes.length; c++){
            System.out.println("O mês de "+ mes[c] + " possui " + totDias[c] + " dias.");
        }
        
        
    }
    
}
