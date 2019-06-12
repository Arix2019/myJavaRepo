package Threds.ProgressBar01;

public class Pbar01 {
    
    public static void main(String[] args){
        ThreadBar progress01 = new ThreadBar();   
        ThreadBar02 progress02 = new ThreadBar02();
        //criando uma Thread
        Thread tBar01 = new Thread(progress01);
        Thread tBar02 = new Thread(progress02);

        //executando...
        tBar01.start();   
        //tBar02.start();
    }
}
