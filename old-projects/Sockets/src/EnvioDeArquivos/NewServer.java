/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioDeArquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NewServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5678);
            Socket clSocket = server.accept();
            InputStream in = clSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);
            String fName = reader.readLine();
            System.out.println(fName);
            File f1 = new File("C:\\Users\\Arix\\Desktop\\novo" + fName);
            FileOutputStream out = new FileOutputStream(f1);
            int tamanho = 4096; // buffer de 4KB  
            byte[] buffer = new byte[tamanho];
            int lidos = -1;
            while ((lidos = in.read(buffer, 0, tamanho)) != -1) {
                System.out.println(lidos);
                out.write(buffer, 0, lidos);
            }
            out.flush();
        } catch (IOException e) {
        }
    }
}
