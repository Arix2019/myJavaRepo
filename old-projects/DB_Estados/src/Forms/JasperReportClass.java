package Forms;

import java.sql.*;
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

public class JasperReportClass {
    private static final String url = "jdbc:mysql://localhost:3306/bd_estadoscapitais";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pwd = "";
    
    public JasperReportClass(){
    }
    
    public void gerar(String layout) throws JRException, ClassNotFoundException, SQLException{
        JasperDesign desenho = JRXmlLoader.load(layout);
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
        
        Class.forName(driver);
        Connection conexao = DriverManager.getConnection(url,user,pwd);
        Statement stm = conexao.createStatement();
        String query = "select * from tb_estados_cidades where estados='SP'";
        ResultSet rs = stm.executeQuery(query);
        JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
        
        Map parametros = new HashMap();
        parametros.put("Nota", new Double(10));
        JasperPrint jPrint = JasperFillManager.fillReport(relatorio, parametros, jrRs);
        
        JasperViewer jViewer = new JasperViewer(jPrint,true);
        jViewer.setTitle("Relatório de Estados - by: Arix");
        jViewer.setVisible(true);
    }
    
}
