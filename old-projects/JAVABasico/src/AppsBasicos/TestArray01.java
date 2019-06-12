package AppsBasicos;

import java.util.ArrayList;

/**
 *
 * @author Arix
 */
public class TestArray01 {

    private static boolean Object;
    
    public static void main(String[] args){
        ArrayList <String> nomes = new ArrayList <String> ();
        //String result;
        nomes.add("Patinha");
        nomes.add("Bartô");
        nomes.add("Mel");
        nomes.add("Grande");
        nomes.add("Branco");
        
        for (String result:nomes) {
            System.out.println(result);
        }
        
    }
    
}
