package Threds;

public class CestaDeFrutas implements Runnable {

    @Override
    public void run() {
        //criação de lista de frutas
        String[] engredientes = {"Banana", "Mamao", "Maca", "Abacate"};
        
        System.out.println("Inicio do run()");
        //impressão da lista de frutas
        for (String fruta : engredientes){
            System.out.println(fruta);
            //parando por 3 segundos
            try {
                Thread.sleep(3*1000);
               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fim do run().");
    }

}
