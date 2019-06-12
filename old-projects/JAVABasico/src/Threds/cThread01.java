package Threds;

public class cThread01 {
    public static void main(String[] args){
        classThread01 executa = new classThread01();
        Thread trd = new Thread(executa);
        trd.start();
    }
}
