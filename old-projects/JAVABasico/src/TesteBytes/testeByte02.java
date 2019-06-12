package TesteBytes;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class testeByte02 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        //texto encapsulado utilizando Array de Strings:
        byte[] textoEnc = {83, 116, 114, 105, 110, 103, 32, 101, 109, 32, 66, 121, 116, 101, 115};
        //converte para String:
        String strDecript = new String(textoEnc, "UTF-8");
        //exibe:
        System.out.println("Texto Decriptado: " + strDecript);
    }
}
