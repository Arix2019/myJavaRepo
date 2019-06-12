package TesteJasperReport;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportTest {
    private static final String url = "jdbc:mysql://localhost:3306/bd_estadoscapitais";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String login = "root";
    private static final String pwd = "";
    
    public JasperReportTest(){       
    }
    
    public void gerar(String layout) throws JRException,SQLException,ClassNotFoundException{
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(layout);
        
        //compila o resultado
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
        
        //estabelece conexão
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,login,pwd);
        Statement stm = con.createStatement();
        String query = "select * from tb_estados_cidades where estados='SP'";
        ResultSet rs = stm.executeQuery(query);
        
        //implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
        
        //executa o relatorio
        Map parametros = new HashMap();
        parametros.put("nota", new Double(10));
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRs);
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao,true);
        viewer.setTitle("Teste JasperReport");
        viewer.setVisible(true);
        
    } 
}
