//implementação de Runnable que pode ser executada por Thread
package Threds;

public class GeradorRelatorio implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 11; i++){
            System.out.println("Linha " + i);
        }
        //System.out.println("Fim da Aplicação!");        
    }
    
}
