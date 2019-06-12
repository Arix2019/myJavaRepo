// ler e escrever em um arquivo externo
package Encapsulamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PrincipalExterna {

    private Path filePath = Paths.get("C:\\TestArquivo\\conta01.txt");
    private Charset utf8 = StandardCharsets.UTF_8;

    public void armazenarContas(ArrayList<Conta> contas) throws IOException {

        try (BufferedWriter wr = Files.newBufferedWriter(filePath, utf8)) {
            for (Conta exibeConta : contas) {
                wr.write(exibeConta.getCliente() + ";" + exibeConta.getSaldo() + ";"
                        + exibeConta.getLimite());
                wr.newLine();
            }
        }
    }

    public ArrayList<Conta> recuperarContas() throws IOException {
        ArrayList<Conta> contas = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath,utf8)) {
            System.out.println("----CONTAS:----");
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] split = line.split(";");
                //System.out.println(split[0]+split[1]+split[2]);
                Conta conta = new Conta(split[0],Double.parseDouble(split[1]),Double.parseDouble(split[2]));
                contas.add(conta);
            }
        }

        return contas;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Conta> contas = new ArrayList<>();
        Conta conta01 = new Conta("Mel Lisboa", 50000.00, 15000.00);
        Conta conta02 = new Conta("Jennifer Lopez", 25500.00, 10000.00);
        Conta conta03 = new Conta("Ella Pidjavisk", 5000.00, 1200.00);
        Conta conta04 = new Conta("Kira Hoffester", 82150.00, 35000.00);
        contas.add(conta01);
        contas.add(conta02);
        contas.add(conta03);
        contas.add(conta04);
        //--------------------------------------------------------------

        PrincipalExterna arquivo = new PrincipalExterna(); 
        arquivo.armazenarContas(contas);        
        ArrayList<Conta> recuperaContas = arquivo.recuperarContas();
        for (Conta conta : recuperaContas) {
            conta.exibeSaldo();
        }

        //lê o arquivo criado:
        //LerContaExterna lerConta = new LerContaExterna("C:\\TestArquivo\\conta01.txt");
    }

}
