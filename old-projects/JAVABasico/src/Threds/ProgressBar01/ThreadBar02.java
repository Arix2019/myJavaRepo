package Threds.ProgressBar01;

public class ThreadBar02 implements Runnable{

    @Override
    public void run() {
        for (int x=0;x<6;x++){
            System.out.printf("#");
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
