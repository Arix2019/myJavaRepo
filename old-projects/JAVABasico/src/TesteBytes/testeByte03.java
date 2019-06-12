package TesteBytes;

import java.util.Arrays;

public class testeByte03 {

    public static void main(String[] args) {
        //String abc = "abcdefghijklmnopqrstuvwxyz";
        String[] abc = {"a","b"};
        
        String num = "0123456789";

        
        byte[] byteABC;
        byte[] byteNUM;

        //conversao de String para bytes
        //byteABC = abc.getBytes();
        byteNUM = num.getBytes();

        
        //System.out.println("Abcdario: " + Arrays.toString(byteABC));
        //System.out.println("Numeros 0a9: " + Arrays.toString(byteNUM));
    }
}
