/*
* conexão com banco de dados
 */
package Telas;

import java.sql.*;
import javax.swing.JOptionPane;
import Conexao.ModuloDeConexao;
import conexao.ModeloDeTabela;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Arix
 */
public class frmPrincipal extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conexao = null;
    String msgDef = "Ocorreu um erro! \n Se o problema persistir entre em contato com o"
            + " administrador do sistema. ";
    private ImageIcon iconeAnimal;

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        conexao = ModuloDeConexao.conector();
        //primeiroReg();
        bloquearBotoes();
        preencherTabela("select * from tb_animais order by id");
    }

    private void consultar() {
        ImageIcon icone;
        String sql = "select * from tb_animais where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            //campo 'txtId' responsável pela pesquisa
            pst.setString(1, txtId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                //pega os dados do campo correspondente na 'tb_animais'    
                txtTipo.setText(rs.getString(2));
                txtNome.setText(rs.getString(3));
                txtRaca.setText(rs.getString(4));
                cmbGenero.setSelectedItem(rs.getString(5));
                // insere a imagem do animal cadastrado:
                lblIcone.setIcon(new javax.swing.ImageIcon(rs.getString(6)));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não Cadastrado!");
                txtNome.setText(null);
                txtRaca.setText(null);
                txtTipo.setText(null);
                lblIcone.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arix\\Pictures\\vector\\imgbanco\\cat-icon.png"));
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, msgDef + e);
        }
    }

    private void inserir() {
        String sql = "insert into tb_animais(id,tipo,nome,raca,genero) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtId.getText());
            pst.setString(2, txtTipo.getText());
            pst.setString(3, txtNome.getText());
            pst.setString(4, txtRaca.getText());
            pst.setString(5, cmbGenero.getSelectedItem().toString());
            // insere os dados na tabela
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                limpar();
                preencherTabela("select * from tb_animais order by id");
                lblIcone.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arix\\Pictures\\vector\\imgbanco\\cat-icon.png"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgDef + e);
        }

    }

    private void atualizar() {
        String sql = "update tb_animais set tipo=?,nome=?,raca=?,genero=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtTipo.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtRaca.getText());
            pst.setString(4, cmbGenero.getSelectedItem().toString());
            pst.setString(5, txtId.getText());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
                preencherTabela("select * from tb_animais order by id");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgDef + e);
        }
    }

    private void deletar() {
        String sql = "delete from tb_animais where id=?";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover "
                + "este cadastro?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int removido = pst.executeUpdate();
                if (removido > 0) {
                    JOptionPane.showMessageDialog(null, "Cadastro removido com sucesso!");
                    preencherTabela("select * from tb_animais order by id");
                    limpar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, msgDef + e);
            }
        }

    }

    //método preencher tabela
    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "tipo", "nome", "raca", "genero"};

        try {
            pst = conexao.prepareStatement(SQL);
            rs = pst.executeQuery(SQL);
            rs.first();
            do {
                dados.add(new Object[]{rs.getInt("id"), rs.getString("tipo"), rs.getString("nome"),
                    rs.getString("raca"), rs.getString("genero")});
            } while (rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel preencher o ArrayList" + ex);
        }

        ModeloDeTabela modelo = new ModeloDeTabela(dados, colunas);
        jtTabela.setModel(modelo);
        jtTabela.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtTabela.getColumnModel().getColumn(0).setResizable(false);
        jtTabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtTabela.getColumnModel().getColumn(1).setResizable(false);
        jtTabela.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtTabela.getColumnModel().getColumn(2).setResizable(false);
        jtTabela.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtTabela.getColumnModel().getColumn(3).setResizable(false);
        jtTabela.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtTabela.getColumnModel().getColumn(4).setResizable(false);
        jtTabela.getTableHeader().setReorderingAllowed(false);
        jtTabela.setAutoResizeMode(jtTabela.AUTO_RESIZE_OFF);
        jtTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void primeiroReg() {
        try {
            String sql = "select * from tb_animais";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            rs.first();
            txtId.setText(String.valueOf(rs.getInt("id")));
            txtNome.setText(rs.getString("nome"));
            txtRaca.setText(rs.getString("raca"));
            txtTipo.setText(rs.getString("tipo"));
            cmbGenero.setSelectedItem(rs.getString("genero"));
            // insere a imagem do animal cadastrado:
            lblIcone.setIcon(new javax.swing.ImageIcon(rs.getString(6)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ultimoReg() {
        try {
            String sql = "select * from tb_animais";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            rs.last();
            txtId.setText(String.valueOf(rs.getInt("id")));
            txtNome.setText(rs.getString("nome"));
            txtRaca.setText(rs.getString("raca"));
            txtTipo.setText(rs.getString("tipo"));
            cmbGenero.setSelectedItem(rs.getString("genero"));
            // insere a imagem do animal cadastrado:
            lblIcone.setIcon(new javax.swing.ImageIcon(rs.getString(6)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void proximoReg() {
        try {
            rs.next();
            txtId.setText(String.valueOf(rs.getInt("id")));
            txtNome.setText(rs.getString("nome"));
            txtRaca.setText(rs.getString("raca"));
            txtTipo.setText(rs.getString("tipo"));
            cmbGenero.setSelectedItem(rs.getString("genero"));
            // insere a imagem do animal cadastrado:
            lblIcone.setIcon(new javax.swing.ImageIcon(rs.getString(6)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void anteriorReg() {
        try {
            rs.previous();
            txtId.setText(String.valueOf(rs.getInt("id")));
            txtNome.setText(rs.getString("nome"));
            txtRaca.setText(rs.getString("raca"));
            txtTipo.setText(rs.getString("tipo"));
            cmbGenero.setSelectedItem(rs.getString("genero"));
            // insere a imagem do animal cadastrado:
            lblIcone.setIcon(new javax.swing.ImageIcon(rs.getString(6)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void limpar() {
        txtId.setText(null);
        txtNome.setText(null);
        txtRaca.setText(null);
        txtTipo.setText(null);
        lblIcone.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arix\\Pictures\\vector\\imgbanco\\cat-icon.png"));
    }

    private void bloquearCampos() {
        txtId.setEnabled(false);
        txtNome.setEnabled(false);
        txtRaca.setEnabled(false);
        txtTipo.setEnabled(false);
        cmbGenero.setEnabled(false);
    }

    private void bloquearBotoes() {
        btnCadastro.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnAtualizar.setEnabled(false);
    }

    private void desbloquearBotoes() {
        btnCadastro.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnAtualizar.setEnabled(true);
    }

    private void desbloquearCampos() {
        txtId.setEnabled(true);
        txtNome.setEnabled(true);
        txtRaca.setEnabled(true);
        txtTipo.setEnabled(true);
        cmbGenero.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblIcone = new javax.swing.JLabel();
        btnConsulta = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jBarMenu = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuCadastro = new javax.swing.JMenuItem();
        jMenuConsultar = new javax.swing.JMenuItem();
        jMenuDeletar = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuOpcoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabela com os Animais");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(990, 542));
        setResizable(false);

        pnTabela.setBackground(new java.awt.Color(255, 255, 255));
        pnTabela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtTabela);

        javax.swing.GroupLayout pnTabelaLayout = new javax.swing.GroupLayout(pnTabela);
        pnTabela.setLayout(pnTabelaLayout);
        pnTabelaLayout.setHorizontalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTabelaLayout.setVerticalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Cad Animais");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Info:"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("ID:");

        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 51, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tipo:");

        txtTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Raça:");

        txtRaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Gênero:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Fêmea" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel8.setText("Entre com o código do animal pra consultar.");

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PctIcones/cat-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRaca)
                            .addComponent(cmbGenero, 0, 221, Short.MAX_VALUE))))
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIcone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );

        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Controle de Registros:"));

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PctIcones/first.png"))); // NOI18N
        btnPrimeiro.setToolTipText("Primeiro Registro");
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(89, 89));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PctIcones/last.png"))); // NOI18N
        btnUltimo.setToolTipText("ÚltimoRegistro");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PctIcones/next.png"))); // NOI18N
        btnProximo.setToolTipText("Próximo Registro");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PctIcones/prev.png"))); // NOI18N
        btnAnterior.setToolTipText("Registro Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Primeiro");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Último");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Voltar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Próximo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProximo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPrimeiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimo)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProximo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jMenu.setText("Menu");

        jMenuCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroActionPerformed(evt);
            }
        });
        jMenu.add(jMenuCadastro);

        jMenuConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuConsultar.setText("Consulta");
        jMenuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultarActionPerformed(evt);
            }
        });
        jMenu.add(jMenuConsultar);

        jMenuDeletar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuDeletar.setText("Remover");
        jMenuDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeletarActionPerformed(evt);
            }
        });
        jMenu.add(jMenuDeletar);

        jBarMenu.add(jMenu);

        jMenuSobre.setText("Sobre");
        jBarMenu.add(jMenuSobre);

        jMenuOpcoes.setText("Opções");
        jMenuOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcoesActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItem1);

        jBarMenu.add(jMenuOpcoes);

        setJMenuBar(jBarMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(892, 673));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        // metodo consultar
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo 'ID' para efetuar a pesquisa.");
        } else {
            consultar();
        }
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // limpa campos:
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // fecha o aplicativo
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // inserir registro:
        if (txtId.getText().isEmpty() || txtNome.getText().isEmpty() || txtRaca.getText().isEmpty()
                || txtTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.");
        } else {
            inserir();
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // metodo atualizar cadastro:
        if (txtId.getText().isEmpty() || txtNome.getText().isEmpty() || txtRaca.getText().isEmpty()
                || txtTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.");
        } else {
            atualizar();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // metodo para remover:
        if (txtId.getText().isEmpty() || txtNome.getText().isEmpty() || txtRaca.getText().isEmpty()
                || txtTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.");
        } else {
            deletar();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // exibe primeiro registro da tb_animais:
        primeiroReg();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // exibe último registro da tb_animais:
        ultimoReg();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // exibe o proximo registro da tb_animais:
        proximoReg();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        //exibe registro anterior da tb_animais:
        anteriorReg();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void jMenuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcoesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuOpcoesActionPerformed

    private void jMenuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroActionPerformed
        // TODO add your handling code here:
        desbloquearBotoes();
    }//GEN-LAST:event_jMenuCadastroActionPerformed

    private void jMenuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultarActionPerformed
        // TODO add your handling code here:
        desbloquearBotoes();
    }//GEN-LAST:event_jMenuConsultarActionPerformed

    private void jMenuDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeletarActionPerformed
        // TODO add your handling code here:
        desbloquearBotoes();
    }//GEN-LAST:event_jMenuDeletarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JMenuBar jBarMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuItem jMenuCadastro;
    private javax.swing.JMenuItem jMenuConsultar;
    private javax.swing.JMenuItem jMenuDeletar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuOpcoes;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
