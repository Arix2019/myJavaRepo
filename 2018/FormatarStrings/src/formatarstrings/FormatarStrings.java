
package formatarstrings;


public class FormatarStrings {

    public static void main(String[] args) {
        
        String str = "Minha string de teste.";
        
        System.out.println(String.format("|%020d|", 93)); 
        
        //saida hexadecimal
        System.out.println(String.format("%x", 100));
                
    }
    
}
