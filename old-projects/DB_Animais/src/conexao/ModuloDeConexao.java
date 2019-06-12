/**  
* Módulo de conexão com: (bd_animais) - (tb_animais)
* tabelas: id - tipo - nome - raca - genero
**/
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Arix
 */
public class ModuloDeConexao {   
    //estabelece conexão com bd_animais
    public static Connection conector(){
        java.sql.Connection conexao=null;
        //caminho do driver de conexao na pasta 'Bibliotecas':
        String driver = "com.mysql.jdbc.Driver";
        //informações referentes ao bd_animais
        String url = "jdbc:mysql://localhost:3306/bd_animais";
        String user = "root";
        String passwd = "";
        
        //estabelece conexão com o bd_animais
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,passwd);
            return conexao;
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
