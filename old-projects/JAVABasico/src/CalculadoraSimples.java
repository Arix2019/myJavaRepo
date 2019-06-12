
import javax.swing.JOptionPane;

/**
 *
 * @author Arix
 */
public class CalculadoraSimples extends javax.swing.JFrame {
    /**
     * Creates new form CalculadoraSimples
     */
    public CalculadoraSimples() {
        initComponents();
    }
    Double num1,num2,calc;
    String operador,temp;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtExibe = new javax.swing.JTextField();
        btnSoma = new javax.swing.JButton();
        btnMultiplicacao = new javax.swing.JButton();
        btnDivisao = new javax.swing.JButton();
        btnSubtracao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnSete = new javax.swing.JButton();
        btnOito = new javax.swing.JButton();
        btnUm = new javax.swing.JButton();
        btnDois = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnQuatro = new javax.swing.JButton();
        btnNove = new javax.swing.JButton();
        btnZero = new javax.swing.JButton();
        btnCalculo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnPonto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Calculator - by @rix");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(380, 395));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtExibe.setEditable(false);
        txtExibe.setBackground(new java.awt.Color(204, 204, 204));
        txtExibe.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnSoma.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSoma.setText("+");
        btnSoma.setPreferredSize(new java.awt.Dimension(75, 40));
        btnSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSomaActionPerformed(evt);
            }
        });

        btnMultiplicacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMultiplicacao.setText("x");
        btnMultiplicacao.setPreferredSize(new java.awt.Dimension(75, 40));
        btnMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicacaoActionPerformed(evt);
            }
        });

        btnDivisao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDivisao.setText("/");
        btnDivisao.setPreferredSize(new java.awt.Dimension(75, 40));
        btnDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivisaoActionPerformed(evt);
            }
        });

        btnSubtracao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSubtracao.setText("-");
        btnSubtracao.setPreferredSize(new java.awt.Dimension(75, 40));
        btnSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubtracaoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCinco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCinco.setForeground(new java.awt.Color(0, 102, 255));
        btnCinco.setText("5");
        btnCinco.setPreferredSize(new java.awt.Dimension(70, 50));
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });

        btnSeis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeis.setForeground(new java.awt.Color(0, 102, 255));
        btnSeis.setText("6");
        btnSeis.setPreferredSize(new java.awt.Dimension(70, 50));
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });

        btnSete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSete.setForeground(new java.awt.Color(0, 102, 255));
        btnSete.setText("7");
        btnSete.setPreferredSize(new java.awt.Dimension(70, 50));
        btnSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeteActionPerformed(evt);
            }
        });

        btnOito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOito.setForeground(new java.awt.Color(0, 102, 255));
        btnOito.setText("8");
        btnOito.setPreferredSize(new java.awt.Dimension(70, 50));
        btnOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOitoActionPerformed(evt);
            }
        });

        btnUm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUm.setForeground(new java.awt.Color(0, 102, 255));
        btnUm.setText("1");
        btnUm.setPreferredSize(new java.awt.Dimension(70, 50));
        btnUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUmActionPerformed(evt);
            }
        });

        btnDois.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDois.setForeground(new java.awt.Color(0, 102, 255));
        btnDois.setText("2");
        btnDois.setPreferredSize(new java.awt.Dimension(70, 50));
        btnDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoisActionPerformed(evt);
            }
        });

        btnTres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTres.setForeground(new java.awt.Color(0, 102, 255));
        btnTres.setText("3");
        btnTres.setPreferredSize(new java.awt.Dimension(70, 50));
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });

        btnQuatro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuatro.setForeground(new java.awt.Color(0, 102, 255));
        btnQuatro.setText("4");
        btnQuatro.setPreferredSize(new java.awt.Dimension(70, 50));
        btnQuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuatroActionPerformed(evt);
            }
        });

        btnNove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNove.setForeground(new java.awt.Color(0, 102, 255));
        btnNove.setText("9");
        btnNove.setPreferredSize(new java.awt.Dimension(70, 50));
        btnNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoveActionPerformed(evt);
            }
        });

        btnZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnZero.setForeground(new java.awt.Color(0, 102, 255));
        btnZero.setText("0");
        btnZero.setPreferredSize(new java.awt.Dimension(70, 50));
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnCalculo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCalculo.setText("=");
        btnCalculo.setPreferredSize(new java.awt.Dimension(70, 70));
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("CC");
        jButton2.setPreferredSize(new java.awt.Dimension(75, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnZero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPonto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPonto.setText(".");
        btnPonto.setPreferredSize(new java.awt.Dimension(75, 40));
        btnPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPontoActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMultiplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDivisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSoma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExibe)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExibe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMultiplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDivisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDivisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisaoActionPerformed
        operador = "/";
        num1 = Double.parseDouble(txtExibe.getText());
        txtExibe.setText("");   
    }//GEN-LAST:event_btnDivisaoActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        txtExibe.setText(txtExibe.getText()+"5");
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        txtExibe.setText(txtExibe.getText()+"6");

    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeteActionPerformed
        txtExibe.setText(txtExibe.getText()+"7");
    }//GEN-LAST:event_btnSeteActionPerformed

    private void btnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOitoActionPerformed
        txtExibe.setText(txtExibe.getText()+"8");
    }//GEN-LAST:event_btnOitoActionPerformed

    private void btnSubtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtracaoActionPerformed
        operador = "-";
        num1 = Double.parseDouble(txtExibe.getText());
        txtExibe.setText("");    
    }//GEN-LAST:event_btnSubtracaoActionPerformed

    private void btnSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSomaActionPerformed
        operador = "+";
        num1 = Double.parseDouble(txtExibe.getText());
        txtExibe.setText("");
    }//GEN-LAST:event_btnSomaActionPerformed

    private void btnMultiplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicacaoActionPerformed
        operador = "*";
        num1 = Double.parseDouble(txtExibe.getText());
        txtExibe.setText("");    
    }//GEN-LAST:event_btnMultiplicacaoActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        
        switch(operador){
            case "+":
                num2 = Double.parseDouble(txtExibe.getText());
                calc = num1 + num2;
                txtExibe.setText(String.valueOf(calc));
                break;

            case "-":
                num2 = Double.parseDouble(txtExibe.getText());
                calc = num1 - num2;
                txtExibe.setText(String.valueOf(calc));     
                break;

            case "*":
                num2 = Double.parseDouble(txtExibe.getText());
                calc = num1 * num2;
                txtExibe.setText(String.valueOf(calc));
                break;

            case "/":
                num2 = Double.parseDouble(txtExibe.getText());
                calc = num1 / num2;
                txtExibe.setText(String.valueOf(calc));
                break;

            default:
                JOptionPane.showMessageDialog(null, "ERRO!");
        }
    }//GEN-LAST:event_btnCalculoActionPerformed

    private void btnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUmActionPerformed
        txtExibe.setText(txtExibe.getText()+"1");
    }//GEN-LAST:event_btnUmActionPerformed

    private void btnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoisActionPerformed
        txtExibe.setText(txtExibe.getText()+"2");
    }//GEN-LAST:event_btnDoisActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        txtExibe.setText(txtExibe.getText()+"3");
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuatroActionPerformed
        txtExibe.setText(txtExibe.getText()+"4");
    }//GEN-LAST:event_btnQuatroActionPerformed

    private void btnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoveActionPerformed
        txtExibe.setText(txtExibe.getText()+"9");
    }//GEN-LAST:event_btnNoveActionPerformed

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        txtExibe.setText(txtExibe.getText()+"0");
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPontoActionPerformed
        txtExibe.setText(txtExibe.getText()+".");
    }//GEN-LAST:event_btnPontoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtExibe.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CalculadoraSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraSimples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraSimples().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculo;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnDivisao;
    private javax.swing.JButton btnDois;
    private javax.swing.JButton btnMultiplicacao;
    private javax.swing.JButton btnNove;
    private javax.swing.JButton btnOito;
    private javax.swing.JButton btnPonto;
    private javax.swing.JButton btnQuatro;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSete;
    private javax.swing.JButton btnSoma;
    private javax.swing.JButton btnSubtracao;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUm;
    private javax.swing.JButton btnZero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtExibe;
    // End of variables declaration//GEN-END:variables
}
