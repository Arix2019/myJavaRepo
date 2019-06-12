package EncriptadorAES;

import java.util.Scanner;

/**
 *
 * @author Arix
 */
public class EncriptaPrincipalAES {
    
    public static void main(String[] args){
        EncriptaAES cryptoAES = new EncriptaAES();
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o texto a ser Criptografado: ");
        String textoPuro = leitor.nextLine();
        
        cryptoAES.encriptadorAES(textoPuro);
    }
    
}
