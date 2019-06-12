package Threds;

import java.util.concurrent.Executor;

public class ImprimirCestaFrutas {

    public static void main(String[] args) {
        //criação do objeto executavel
        CestaDeFrutas salada = new CestaDeFrutas();
        //criação da Thread
        Thread executar = new Thread(salada);
        //execuçã da Thread
        executar.start();
    }
}
