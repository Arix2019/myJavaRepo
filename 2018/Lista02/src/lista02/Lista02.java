package lista02;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Lista02 {

    public static void main(String[] args) {
        // construtor ArrayList
        ArrayList lista02 = new ArrayList();
        
        System.out.println("Lista Vazia: " + lista02);
        
        lista02.add("Banana");
        lista02.add("Maça");
        lista02.add("Tomate");
        lista02.add("Mamão");
        lista02.add("Laranja");  
        lista02.add("Abacaxi");
        System.out.println("Lista atual: " + lista02);
        
        //percorrer a lista com o (iterator):
        //Construtor iterator
        Iterator i = lista02.iterator();
        
        System.out.println("Imprime todos os elementos da lista com (WHILE):");
        while(i.hasNext()){ //enquanto existir itens na lista...
            System.out.print(i.next() + " ");
        }
        System.out.println("\n-------------------------------------");
        
        //remover elemento atraves do seu indice
        System.out.println("Removido da lista: " + lista02.remove(lista02.size()-3));        
        System.out.println(lista02);
        
        //criar uma cópia da lista
        LinkedList copyList = new LinkedList(lista02);
        System.out.println("Faz Cópia da lista: " + copyList);
        
        //adicionando elemento a cópia da lista
        copyList.add("Raquel");
        copyList.add("Juliana");
        copyList.add("Luana");
        
        System.out.println("Conteúdo da nova lista: ");
        System.out.println("Conteúdo da primeira lista: " + lista02);
        System.out.println("Conteúdo da segunda lista: " + copyList);
    }
    
}
