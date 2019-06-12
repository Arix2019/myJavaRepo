package listadecontatos;
import java.util.ArrayList;


public class ListaDeContatos {

    public static void main(String[] args) {
        
        ArrayList<Contato> contatos = new ArrayList();
        
        Contato contato01 = new Contato("Juju","juju@email.com","99558752");
        Contato contato02 = new Contato("Mel","memel@email.com","99558741");
        Contato contato03 = new Contato("Renatinha","rena@email.com","99874124");
        Contato contato04 = new Contato("Luluzinha","luluz@email.com","98874521");
        Contato contato05 = new Contato("Marcinha","marmar@email.com","98874125");
        

        contatos.add(contato01);
        contatos.add(contato02);
        contatos.add(contato03);
        contatos.add(contato04);
        contatos.add(contato05);
        

        for (Contato c : contatos){
            System.out.println(c);
        }        
        
    }
    
}
