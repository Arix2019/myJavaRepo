/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKTelaLogin;

import java.sql.*;
import conexao.ModuloDeConexao;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Arix
 */
public class frmOs extends javax.swing.JInternalFrame {

    Connection VarConexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //variaveis do jRadioButtom
    private String tipo;

    /**
     * Creates new form frmOs
     */
    public frmOs() {
        initComponents();
        VarConexao = ModuloDeConexao.conector();
    }

    private void pesquisarCliente() {
        String sql = "select id as Id, nome as Nome, telefone as Tel from tb_clientes where nome like ?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtCliPesquisa.getText() + "%");
            rs = pst.executeQuery();
            //importando dados para jTable
            tblCliente.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setarCampos() {
        int setar = tblCliente.getSelectedRow();
        txtIdCli.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
    }

    private void emitirOs() {
        String sql = "insert into tb_os(tipo,situacao,equipamento,defeito,servico,tecnico,valor,id_cliente) values(?,?,?,?,?,?,?,?)";
        try {
            pst = VarConexao.prepareCall(sql);
            pst.setString(1, tipo); //variavel corresponde ao jRadioButtom selecionado
            pst.setString(2, cmbSituacao.getSelectedItem().toString());
            pst.setString(3, txtOsEquip.getText());
            pst.setString(4, txtOsDefeito.getText());
            pst.setString(5, txtOsServico.getText());
            pst.setString(6, txtOsTec.getText());
            pst.setString(7, txtOsValor.getText());
            pst.setString(8, txtIdCli.getText());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "O.S emitida com Sucesso!");
                txtOsEquip.setText(null);
                txtOsDefeito.setText(null);
                txtOsServico.setText(null);
                txtOsTec.setText(null);
                txtOsValor.setText(null);
                txtIdCli.setText(null);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void pesquisarOsOptPane() {
        String numOs = JOptionPane.showInputDialog("Número da OS:");
        String sql = "select * from tb_os where os=" + numOs;
        try {
            pst = VarConexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNumeroOs.setText(rs.getString(1));
                txtData.setText(rs.getString(2));
                String rbtTipo = rs.getString(3);
                if (rbtTipo.equals("OS")) {
                    rbtOs.setSelected(true);
                    tipo = "OS";
                } else {
                    rbtOrca.setSelected(true);
                    tipo = "Orcamento";
                }
                cmbSituacao.setSelectedItem(rs.getString(4));
                txtOsEquip.setText(rs.getString(5));
                txtOsDefeito.setText(rs.getString(6));
                txtOsServico.setText(rs.getString(7));
                txtOsTec.setText(rs.getString(8));
                txtOsValor.setText(rs.getString(9));
                txtClienteId.setText(rs.getString(10));
            } else {
                JOptionPane.showMessageDialog(null, "Ordem de Serviço não encontrada!");
                txtOsEquip.setText(null);
                txtOsDefeito.setText(null);
                txtOsServico.setText(null);
                txtOsTec.setText(null);
                txtOsValor.setText(null);
                txtIdCli.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterarOs() {
        String sql = "update tb_os set tipo=?,situacao=?,equipamento=?,defeito=?,servico=?,tecnico=?,valor=? where os=?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cmbSituacao.getSelectedItem().toString());
            pst.setString(3, txtOsEquip.getText());
            pst.setString(4, txtOsServico.getText());
            pst.setString(5, txtOsDefeito.getText());
            pst.setString(6, txtOsTec.getText());
            pst.setString(7, txtOsValor.getText());
            pst.setString(8, txtNumeroOs.getText());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
                txtOsEquip.setText(null);
                txtOsDefeito.setText(null);
                txtOsServico.setText(null);
                txtOsTec.setText(null);
                txtOsValor.setText(null);
                txtIdCli.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar esta ação!\n Tente novamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void removerOs() {
        String sql = "delete from tb_os where os=?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtNumeroOs.getText());
            int rem = pst.executeUpdate();
            if (rem > 0) {
                JOptionPane.showMessageDialog(null, "OS foi removida com sucesso!");
                txtOsEquip.setText(null);
                txtOsDefeito.setText(null);
                txtOsServico.setText(null);
                txtOsTec.setText(null);
                txtOsValor.setText(null);
                txtIdCli.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel completar esta ação! \n Tente novamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void imprimirOs() {
        String reportPath = "C:\\Users\\Arix\\JaspersoftWorkspace\\MyReports\\os.jasper";
        int confirma = JOptionPane.showConfirmDialog(null, "Imprimir Ordem de "
                + "Serviço?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                HashMap filtroOs = new HashMap();
                filtroOs.put("numos", txtNumeroOs.getText());

                JasperPrint jPrint = JasperFillManager.fillReport(reportPath, filtroOs, VarConexao);

                JasperViewer.viewReport(jPrint, false);
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroOs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        rbtOrca = new javax.swing.JRadioButton();
        rbtOs = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        txtCliPesquisa = new javax.swing.JTextField();
        txtIdCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtOsEquip = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOsDefeito = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtOsServico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtOsTec = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtOsValor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ordem de Serviço");
        setPreferredSize(new java.awt.Dimension(640, 480));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nº OS");

        txtNumeroOs.setEditable(false);
        txtNumeroOs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNumeroOs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroOsKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Data:");

        txtData.setEditable(false);

        buttonGroup1.add(rbtOrca);
        rbtOrca.setText("Orçamento");
        rbtOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrcaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtOs);
        rbtOs.setText("Ordem de Serviço");
        rbtOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroOs, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtData))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtOs)
                    .addComponent(rbtOrca))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(rbtOrca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtOs)
                .addGap(14, 14, 14))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Situação:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Em Bancada", "Entrega Concluida", "Orçamento Aprovado", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Equipamento Pronto", "Equipamento Abandonado", "Retorno" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente:"));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "nome", "tel"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        txtCliPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisaKeyReleased(evt);
            }
        });

        txtIdCli.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCliPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Equipamento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Defeito:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tipo de Serviço:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Técnico:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Valor:");

        txtOsValor.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Id do Cliente:");

        txtClienteId.setEditable(false);
        txtClienteId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtClienteId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteIdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtOsEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOsServico, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOsValor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtOsDefeito, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(txtOsTec))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtOsEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtOsDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtOsServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtOsTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtOsValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/cadastrar2.png"))); // NOI18N
        btnInserir.setToolTipText("cadastrar um nova OS");
        btnInserir.setPreferredSize(new java.awt.Dimension(80, 80));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/lupa-ico.png"))); // NOI18N
        btnBuscar.setToolTipText("Persquisar Ordem de Serviço");
        btnBuscar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/atualizar2.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar Ordem de Serviço");
        btnAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(255, 51, 51));
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/excluir2.png"))); // NOI18N
        btnRemover.setToolTipText("Remover Ordem de Serviço");
        btnRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.setToolTipText("Imprimir Ordem de Serviço");
        btnImprimir.setPreferredSize(new java.awt.Dimension(80, 80));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisaKeyReleased
        // enquanto estiver digitando...
        pesquisarCliente();
    }//GEN-LAST:event_txtCliPesquisaKeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        // TODO add your handling code here:
        setarCampos();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void rbtOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrcaActionPerformed
        // se selecionado atribui um texto a variavel:
        tipo = "Orcamento";
    }//GEN-LAST:event_rbtOrcaActionPerformed

    private void rbtOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOsActionPerformed
        //  se selecionado atribui um texto a variavel:
        tipo = "OS";
    }//GEN-LAST:event_rbtOsActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // acontecerá quando o form for iniciado:
        rbtOrca.setSelected(true);
        tipo = "Orcamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        emitirOs();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtNumeroOsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroOsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroOsKeyReleased

    private void txtClienteIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteIdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteIdKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        pesquisarOsOptPane();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        alterarOs();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        int remover = JOptionPane.showConfirmDialog(null, "Deseja remover esta OS?", "Atenção!",
                JOptionPane.YES_NO_OPTION);
        if (remover == JOptionPane.YES_OPTION) {
            removerOs();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // imprime Ordem de Serviço:
        imprimirOs();
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnRemover;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtOrca;
    private javax.swing.JRadioButton rbtOs;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtCliPesquisa;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtNumeroOs;
    private javax.swing.JTextField txtOsDefeito;
    private javax.swing.JTextField txtOsEquip;
    private javax.swing.JTextField txtOsServico;
    private javax.swing.JTextField txtOsTec;
    private javax.swing.JTextField txtOsValor;
    // End of variables declaration//GEN-END:variables
}
