//ArrayList multidimensional
package AppsBasicos;

import java.util.ArrayList;
import java.util.List;


public class TesteArray04 {

    public static void main(String[] args) {
        
        List<TesteArrayList04> infoUser = new ArrayList<>();
        
        
        TesteArrayList04 info01 = new TesteArrayList04("Patinha", 1);
        infoUser.add(info01);
        
        TesteArrayList04 info02 = new TesteArrayList04("Mel", 4);
        infoUser.add(info02);       
        
        
        for (TesteArrayList04 exibe : infoUser){
            System.out.println("Nome: " + exibe.getNome() + " | Idade: " 
                    + exibe.getIdade());
        }
                
        
    }

}
