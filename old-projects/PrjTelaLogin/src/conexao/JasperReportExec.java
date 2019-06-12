package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportExec {
    private static final String url = "jdbc:mysql://localhost:3306/BD_Login";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pwd = "";
    
    public JasperReportExec(){
    }
    
    public void gerar(String layout, String numOs) throws JRException, ClassNotFoundException, SQLException{
        JasperDesign desenho = JRXmlLoader.load(layout);
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
        
        Class.forName(driver);
        Connection conexao = DriverManager.getConnection(url,user,pwd);
        Statement stm = conexao.createStatement();
        
        String query = "select OSER.os,data_os,situacao,equipamento,valor, CLI.nome,telefone from tb_os as OSER inner join tb_clientes as CLI on (CLI.id = OSER.id_cliente) where os=" + numOs;
        ResultSet rs = stm.executeQuery(query);
        JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
        
        Map parametros = new HashMap();
        parametros.put("Nota", new Double(10));
        JasperPrint jPrint = JasperFillManager.fillReport(relatorio, parametros,jrRs);
        
        JasperViewer jViewer = new JasperViewer(jPrint,false);
        jViewer.setTitle("Impressão de Ordem de Serviço - ARB AssisTec");
        jViewer.setVisible(true);        
        
    }
    
}
