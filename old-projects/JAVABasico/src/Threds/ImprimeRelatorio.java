package Threds;

public class ImprimeRelatorio {
    public static void main(String[] args){
        System.out.println("Inicio da Aplicação:");
        
        //criação dos objetos executavel
        GeradorRelatorio relatorio = new GeradorRelatorio();       
        BarraProgresso barra = new BarraProgresso();
        
        //criação da Thread
        Thread executor = new Thread(relatorio);       
        Thread pBar = new Thread(barra);
       
        //inicio das execução das Threads
        executor.start();       
        //processo de exibição da barra de progresso:
        pBar.start();
                
    }
            
}
