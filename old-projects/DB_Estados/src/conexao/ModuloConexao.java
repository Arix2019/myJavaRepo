/*
 * modulo de  conexão com 'bd_estadoscapitais':
 * tabela: 'tb_estados_cidades'
 * campos: cod | cidades | estados
 */
package conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModuloConexao {
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bd_estadoscapitais";
        String user = "root";
        String pwd = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,pwd);
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
