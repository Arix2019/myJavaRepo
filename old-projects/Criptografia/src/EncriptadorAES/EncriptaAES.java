package EncriptadorAES;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encriptador (AES)
 * @author Arix
 */
public class EncriptaAES {
    
    static String IV = "AAAAAAAAAAAAAAAA";
    static String chaveEncriptacao = "0123456789abcdef";    
    
    public void encriptadorAES(String textoPuro){
        Scanner leitor = new Scanner(System.in); 
        
        try {
            //System.out.println("Informe o texto a ser Criptografado: ");
            //textoPuro = leitor.nextLine();
            byte[] textoEncriptado = encrypt(textoPuro,chaveEncriptacao);
            
            System.out.println("Texto Criptografado: ");
            for (int i=0;i<textoEncriptado.length;i++){
                System.out.print(textoEncriptado[i]);
            }        
            System.out.println(" ");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static byte[] encrypt(String textoPuro, String chaveEncriptacao) throws Exception{
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveEncriptacao.getBytes("UTF-8"),"AES");
        encripta.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textoPuro.getBytes("UTF-8"));
    }
    
}
