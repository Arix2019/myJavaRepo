package TesteBytes;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class testeByte {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String texto = "String em Bytes";
        byte[] auxilio;
        
        System.out.println("Texto puro: " + texto);
        auxilio = texto.getBytes(); //converte para Bytes
        String var = new String(auxilio,"UTF-8"); //converte para String

        System.out.println("Bytes com Array de String(Encriptado): " + Arrays.toString(auxilio));
        System.out.println("Bytes sem Array de String(Encriptado): " + auxilio);
        System.out.println("Texto Decriptado: " + var);
    }
}
