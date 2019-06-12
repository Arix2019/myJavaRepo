/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKTelaLogin;

import java.sql.*;
import conexao.ModuloDeConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//importa recursos da biblioteca 'rs2xml.jar'
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arix
 */
public class frmCliente extends javax.swing.JInternalFrame {

    Connection VarConexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form frmCliente
     */
    public frmCliente() {
        initComponents();
        btnNovoCad.setEnabled(false);
        btnCancelar.setEnabled(false);
        VarConexao = ModuloDeConexao.conector();
    }

    private void inserirCliente() {
        String sql = "insert into tb_clientes(nome,endereco,telefone,email) values(?,?,?,?)";
        btnCancelar.setEnabled(true);
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEnd.getText());
            pst.setString(3, txtTel.getText());
            pst.setString(4, txtEmail.getText());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
                txtNome.setText(null);
                txtEnd.setText(null);
                txtTel.setText(null);
                txtEmail.setText(null);
                btnCadastrar.setEnabled(false);
                btnNovoCad.setEnabled(true);
                btnCancelar.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    //filtro de pesquisa por nome:
    private void pesquisaCliente() {
        String sql = "select * from tb_clientes where nome like ?";
        try {
            pst = VarConexao.prepareStatement(sql);
            //passa o conteúdo da caixa de pesquisa (txtPesquisar) para '?':
            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();
            //iniciando a biblioteca 'rs2xml.jar' para preencher a jTable:
            jTableClientes.setModel(DbUtils.resultSetToTableModel(rs));
            jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(10);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // atualiza cadastro:
    private void atualizar() {
        String sql = "update tb_clientes set nome=?,endereco=?,telefone=?,email=? where id=?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEnd.getText());
            pst.setString(3, txtTel.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtIdCliente.getText());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                txtIdCliente.setText(null);
                txtNome.setText(null);
                txtEnd.setText(null);
                txtTel.setText(null);
                txtEmail.setText(null);
                btnCadastrar.setEnabled(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    //remove cadastro do cliente:
    private void remover() {
        String sql = "delete from tb_clientes where id=?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtIdCliente.getText());
            int rem = pst.executeUpdate();
            if (rem > 0) {
                JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
                txtIdCliente.setText(null);
                txtNome.setText(null);
                txtEnd.setText(null);
                txtTel.setText(null);
                txtEmail.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "ERRO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //seta o resultado da tabela com os campos:
    private void setarCampos() {
        int setar = jTableClientes.getSelectedRow();
        txtIdCliente.setText(jTableClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(jTableClientes.getModel().getValueAt(setar, 1).toString());
        txtEnd.setText(jTableClientes.getModel().getValueAt(setar, 2).toString());
        txtTel.setText(jTableClientes.getModel().getValueAt(setar, 3).toString());
        txtEmail.setText(jTableClientes.getModel().getValueAt(setar, 4).toString());
        btnNovoCad.setEnabled(true);
        btnCadastrar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtEnd = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnLimpaCampos = new javax.swing.JButton();
        btnNovoCad = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cliente");
        setPreferredSize(new java.awt.Dimension(640, 480));

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/lupa2.png"))); // NOI18N
        jLabel1.setToolTipText("Pesquisar Nome do Cliente");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "nome", "endereco", "telefone", "email"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("E-Mail:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/cadastrar2.png"))); // NOI18N
        btnCadastrar.setToolTipText("Inserir");
        btnCadastrar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/buscar2.png"))); // NOI18N
        btnAlterar.setToolTipText("Atualizar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(255, 102, 102));
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/excluir2.png"))); // NOI18N
        btnRemover.setToolTipText("Remover");
        btnRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("ID:");

        txtIdCliente.setEnabled(false);

        btnLimpaCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/limpar.png"))); // NOI18N
        btnLimpaCampos.setToolTipText("Limpar Campos");
        btnLimpaCampos.setPreferredSize(new java.awt.Dimension(80, 80));
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        btnNovoCad.setBackground(new java.awt.Color(102, 204, 255));
        btnNovoCad.setText("Novo Cad");
        btnNovoCad.setToolTipText("Habilita o um novo Cadastro.");
        btnNovoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCadActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar Cadastro");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnNovoCad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // método para cadastrar cliente:
        inserirCliente();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // enquanto estiver digitando executa o metodo:
        pesquisaCliente();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        setarCampos();
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // atualiza cadstro:
        atualizar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // remover cadastro do cliente:
        int decisao = JOptionPane.showConfirmDialog(null, "Deseja Remover o registro selecionado?",
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (decisao == JOptionPane.YES_OPTION) {
            remover();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed
        // limpa tds os campos:
        txtIdCliente.setText(null);
        txtNome.setText(null);
        txtEnd.setText(null);
        txtTel.setText(null);
        txtEmail.setText(null);
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtIdCliente.setText(null);
        txtNome.setText(null);
        txtEnd.setText(null);
        txtTel.setText(null);
        txtEmail.setText(null);
        btnNovoCad.setEnabled(true);
        btnCadastrar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCadActionPerformed
        // TODO add your handling code here:
        txtIdCliente.setText(null);
        txtNome.setText(null);
        txtEnd.setText(null);
        txtTel.setText(null);
        txtEmail.setText(null);
        btnNovoCad.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnNovoCadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnNovoCad;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
