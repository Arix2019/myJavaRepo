package conexao;

import java.sql.*;

/**
 * alt + shift + f (identa o codigo)
 * @author Arix
 * inserir usuario em uma tabela:
 * insert into tbusuario(id,usuario,fone,login,senha)
 * values('',nome,'fone','login','senha');
 */
public class ModuloDeConexao {
    //metodo resposavel por estabelecer a conexao
    // com o Banco de Dados

    public static Connection conector() {
        java.sql.Connection VarConexao = null;
        //abaixo "chama" o drive mysql
        String driver = "com.mysql.jdbc.Driver";
        // Armazenando informacoes referente ao Banco
        String url = "jdbc:mysql://localhost:3306/BD_Login";
        String user = "root";
        String passwd = "";
        //Estabelecendo a conexao com o Banco
        try {
            Class.forName(driver);
            VarConexao = DriverManager.getConnection(url, user, passwd);
            return VarConexao;
            
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
    }
}
