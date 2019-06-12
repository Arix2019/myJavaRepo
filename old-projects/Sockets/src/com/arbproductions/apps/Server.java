/*
* servidor TCP simples
 */
package com.arbproductions.apps;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Arix
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Conexão Aberta: ");
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com: " + cliente.getInetAddress().getHostAddress());
            Scanner ler = new Scanner(cliente.getInputStream());
            while (ler.hasNextLine()) {
                System.out.println(ler.nextLine());
                
                if (ler.nextLine().equals("exit")){
                    System.out.println("Servidor Desligado.");
                    System.exit(0);
                }
                
            }
            ler.close();
            servidor.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
