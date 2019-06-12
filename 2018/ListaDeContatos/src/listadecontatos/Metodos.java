package listadecontatos;
import java.util.ArrayList;

public class Metodos {
    
    ArrayList<Contato> contatos = new ArrayList();
    
    //metodo para cadastrar novos contatos:
    public void cadContatos(Contato contato){
       
        contatos.add(contato);
    }
    
    public String nomeDoContato(){
        return contatos.size() + " ";
    }
    
    
}
