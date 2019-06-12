package AppsBasicos;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pessoas {

    public static void main(String[] args) throws InterruptedException {

        try {
            List<classPessoas> regPessoas = new ArrayList<>();
            Scanner leitor = new Scanner(System.in);
            //classPessoas p01 = new classPessoas("Patinha", 1, "São Paulo");
            //regPessoas.add(p01);

            //classPessoas p02 = new classPessoas("Mel", 5, "São Paulo");
            //regPessoas.add(p02);
           for (int i = 0; i < 2; i++) {
                System.out.printf("Nome: ");
                String nome = leitor.next();
                
                System.out.printf("Idade: ");
                int idade = leitor.nextInt();
                
                System.out.printf("Cidade: ");
                String cidade = leitor.next();
                
                System.out.println("");
                
                classPessoas exibePessoas = new classPessoas(nome, idade, cidade);
                regPessoas.add(exibePessoas);
            }
            System.out.println("\n\tRegistros: ");
            for (classPessoas exibePessoas : regPessoas) {
                System.out.println("Nome: " + exibePessoas.getNome() + "\nIdade: "
                        + exibePessoas.getIdade() + "\nCidade: "
                        + exibePessoas.getCidade() + "\n");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        
        
    }

}
