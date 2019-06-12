package StaticTable;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Arix
 */
public class ListarContatos extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
       
    Object [][] dados = {
        {"Patinha","Macho","Siâmes"},
        {"Barto","Macho","Vira-Latas"},
        {"Mel","Fêmea","Siâmes"},
        {"Branquinho","Macho","Siâmes"},
        {"Grandinho","Macho","Siâmes"}
    };
    
    String [] colunas = {"Nome","Sexo","Raça"};
    
    
    public ListarContatos() {
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);        
        getContentPane().add(painelFundo); 
        
    }
    
    public void criaJanela(){
       
        setTitle("Lista dos Gatos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
