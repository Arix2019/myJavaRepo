/*
* cliente TCP simples
 */
package com.arbproductions.apps;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            Socket cliente = new Socket("127.0.0.1", 12345);
            System.out.println("Conectado ao Servidor: ");
            Scanner ler = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while (ler.hasNextLine()) {
                saida.println(ler.nextLine());               
            }
            saida.close();
            ler.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println("NÃO FOI POSSIVEL SE CONECTAR AO SERVIDOR!" + e);
        }
    }

}
