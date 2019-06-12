package Threds.ProgressBar01;

public class ThreadBar implements Runnable{
    
    public void run(){       
        for(int i=0; i<6;i++){
            System.out.printf("=");           
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nFim!");
    }
}
