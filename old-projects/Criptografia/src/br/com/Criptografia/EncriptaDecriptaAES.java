package br.com.Criptografia;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

/**
 * Criptografia (AES)
 *
 * @author Arix
 */
public class EncriptaDecriptaAES {

    static String IV = "AAAAAAAAAAAAAAAA";
    static String textoPuro = "teste texto 12345678\\0\\0\\0";
    static String chaveEncriptacao = "0123456789abcdef";

    public static void main(String[] args) {

        try {
            System.out.println("Texto Puro: " + textoPuro);
            byte[] textoEncriptado = encrypt(textoPuro, chaveEncriptacao);

            System.out.println("Texto Encriptado: ");
            for (int i = 0; i < textoEncriptado.length; i++) {
                System.out.print(new Integer(textoEncriptado[i]) + " ");
            }

            System.out.println(" ");

            String textoDecriptado = decrypt(textoEncriptado, chaveEncriptacao);
            System.out.println("Texto Decriptado: " + textoDecriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] encrypt(String textoPuro, String chaveEncriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveEncriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textoPuro.getBytes("UTF-8"));
    }

    public static String decrypt(byte[] textoEncriptado, String chaveEncriptacao) throws Exception {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveEncriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoEncriptado), "UTF-8");
    }

}
