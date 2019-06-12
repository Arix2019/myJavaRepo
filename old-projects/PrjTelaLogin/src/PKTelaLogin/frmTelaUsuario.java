package PKTelaLogin;

import javax.swing.JOptionPane;
import java.sql.*;
import conexao.ModuloDeConexao;

/**
 *
 * @author Arix
 */
public class frmTelaUsuario extends javax.swing.JInternalFrame {

    //frameworks que estao dentro do pacote (java.sql)
    Connection VarConexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form frmTelaUsuario
     */
    public frmTelaUsuario() {
        initComponents();
        // cmbPerfilUser.setSelectedItem(null);
        VarConexao = ModuloDeConexao.conector();
    }

    private void consultar() {
        String sql = "select * from TB_Login where id=?";

        try {
            pst = VarConexao.prepareStatement(sql);
            // o numero (1) corresponde a posição do (user) na tabela
            pst.setString(1, txtIdUser.getText());
            // responsável pela consulta
            rs = pst.executeQuery();
            // testa se existe a pesquisa          
            
            if (rs.next()) {
                txtUsuarioUser.setText(rs.getString(2)); // 'pega' o conteudo do campo (2) da tabela
                txtTelefoneUser.setText(rs.getString(3));
                cmbPerfilUser.setSelectedItem(rs.getString(4));
                txtEmailUser.setText(rs.getString(5));
                txtSenhaUser.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não Cadastrado!");
                LimparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void cadastrar() {
        String sql = "insert into TB_Login(id,usuario,telefone,perfil,email,senha) values(?,?,?,?,?,?)";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtIdUser.getText());
            pst.setString(2, txtUsuarioUser.getText());
            pst.setString(3, txtTelefoneUser.getText());
            pst.setString(4, cmbPerfilUser.getSelectedItem().toString());
            pst.setString(5, txtEmailUser.getText());
            pst.setString(6, txtSenhaUser.getText());
            // A linha abaixo insere na tabela os novos dados inseridos:           
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                LimparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar o Cadastro!");
        }
    }

    //Metodo para alterar os dados do usuario:
    private void alterar() {
        String sql = "update TB_Login set usuario=?,telefone=?,perfil=?,email=?,senha=? where id=?";
        try {
            pst = VarConexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioUser.getText());
            pst.setString(2, txtTelefoneUser.getText());
            pst.setString(3, cmbPerfilUser.getSelectedItem().toString());
            pst.setString(4, txtEmailUser.getText());
            pst.setString(5, txtSenhaUser.getText());
            pst.setString(6, txtIdUser.getText());

            if ((txtIdUser.getText().isEmpty()) || (txtUsuarioUser.getText().isEmpty())
                    || (txtSenhaUser.getText().isEmpty()) || (txtTelefoneUser.getText().isEmpty())
                    || (txtEmailUser.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por Favor, Preencha todos os campos antes de Continuar.");
            } else {
                //atualiza a (TB_Login):
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
                    LimparCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar o Cadastro!");
        }
    }
    
    //metodo para deletar registro
    private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este Usuário?","Atenção",JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from TB_Login where id=?";
            try {
                pst = VarConexao.prepareStatement(sql);
                pst.setString(1, txtIdUser.getText());
                int removido = pst.executeUpdate();
                if (removido > 0) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");                
                }    
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possivel remover o Usuário!");
            }
        }
    }

    private void LimparCampos() {
        txtIdUser.setText(null);
        txtSenhaUser.setText(null);
        txtTelefoneUser.setText(null);
        txtUsuarioUser.setText(null);
        txtEmailUser.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        txtUsuarioUser = new javax.swing.JTextField();
        txtTelefoneUser = new javax.swing.JTextField();
        txtEmailUser = new javax.swing.JTextField();
        txtSenhaUser = new javax.swing.JTextField();
        cmbPerfilUser = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnLimparCampos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ARB Productions (Tela Usuário)");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Usuários:"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Id:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Usuário:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("E-Mail:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Senha:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Perfil:");

        cmbPerfilUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Adm" }));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/icone-cadastro.png"))); // NOI18N

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/limpar.png"))); // NOI18N
        btnLimparCampos.setToolTipText("Limpar Campos");
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.setPreferredSize(new java.awt.Dimension(80, 80));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair sem Cadastrar");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/atualizar2.png"))); // NOI18N
        btnAtualizar.setToolTipText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/buscar2.png"))); // NOI18N
        btnConsultar.setToolTipText("Consultar");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PKTelaLogin/imagem/cadastrar2.png"))); // NOI18N
        btnCadastrar.setToolTipText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arix\\Desktop\\icones\\excluir2.png")); // NOI18N
        btnExcluir.setToolTipText("Apagar");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setPreferredSize(new java.awt.Dimension(80, 80));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("*Todos os campos devem ser Preenchidos.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailUser)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPerfilUser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtUsuarioUser, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefoneUser, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuarioUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefoneUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbPerfilUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // Limpa os campos da sessão cadastro de usuário
        LimparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        //  confirma a saida
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // testa se os campos foram preenchidos:
        if ((txtIdUser.getText().isEmpty()) || (txtUsuarioUser.getText().isEmpty())
                || (txtSenhaUser.getText().isEmpty()) || (txtTelefoneUser.getText().isEmpty())
                || (txtEmailUser.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Por Favor, Preencha todos os campos antes de Continuar.");
        } else {
            cadastrar();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // metodo consultar:
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        //metodo alterar:
        alterar();

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // remove usuário:
        remover();
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbPerfilUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmailUser;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtSenhaUser;
    private javax.swing.JTextField txtTelefoneUser;
    private javax.swing.JTextField txtUsuarioUser;
    // End of variables declaration//GEN-END:variables
}
