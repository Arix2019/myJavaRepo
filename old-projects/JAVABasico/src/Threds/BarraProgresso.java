package Threds;

//Runnable para barra de progresso:
public class BarraProgresso implements Runnable{

    @Override
    public void run() {
        for (int bar = 0; bar < 11; bar++){
            System.out.println("== Barra: " + bar);
        }
    }
    
}
