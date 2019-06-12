package Threds;

public class classThread01 implements Runnable{
    private int i;
    
    @Override
    public void run() {
        while(i < 11){
            System.out.print(i++);
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
  
        }
    }
    
}
