package Encapsulamento;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LerContaExterna {

    public LerContaExterna(String filePath) throws IOException {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

}
