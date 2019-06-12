package TesteJasperReport;

import javax.swing.JOptionPane;

public class JasperReportEx {
    public static void main(String[] args){
        try {
            JasperReportTest gerarRel = new JasperReportTest();
            gerarRel.gerar("C:\\Users\\Arix\\JaspersoftWorkspace\\MyReports\\estadosBrasileiros.jrxml");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
}
