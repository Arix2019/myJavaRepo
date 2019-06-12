package listas;
import java.util.ArrayList;
/**
 *
 * @author Arix
 */
public class Listas {

    public static void main(String[] args) {
        //exemplo de lista
       
        ArrayList lista = new ArrayList();
        
        lista.add("Banana");
        lista.add("Maça");
        lista.add("Tomate");
        lista.add("Mamão");
        lista.add("Laranja");

        //lista
        System.out.println("lista atual: " + lista);
        
        //exibe o indice da lista
        System.out.println("Indice dois da lista: "+lista.get(2));
        
        //tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size());
        
        //adicionar outro elemento a lista
        lista.add(0, "Tangerina");
        
        System.out.println("lista atual: " + lista + "\n" + lista.get(0) + " foi"
                + " adicionado a lista na posição: " + lista.indexOf("Tangerina"));
        
        //verifica se existe na lista
        System.out.println("Existe Laranja na lista?");
        if (lista.contains("Laranja") == true) {
            System.out.println("Sim.");
        } else {
            System.out.println("Não.");
        }
        
        
        
        
    }
    
}
