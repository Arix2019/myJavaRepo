package conexao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arix
 */
public class ModeloDeTabela extends AbstractTableModel{
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public ModeloDeTabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    //metodo para setar e pegar os valores da tabela
    public ArrayList getLinhas(){
        return linhas;
    }
    
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    
    public String[] getColunas(){
        return colunas;
    }
    
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    
    //metodo retorna o numero de colunas
    public int getColumnCount(){
        return colunas.length;
    }
    
    //metodo conta o numero de linhas
    //conta qts elementos existem na ArrayList
    public int getRowCount(){
        return linhas.size();
    }
    
    //metodo pega o numero de colunas
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    //metodo para montar a tabela
    //objeto vai receber qtd de linhas que for passado como parametro
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
}
