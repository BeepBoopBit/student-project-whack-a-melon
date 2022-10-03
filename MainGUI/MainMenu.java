package MainGUI;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Button_Start = new javax.swing.JButton();
        Button_Scoreboard = new javax.swing.JButton();
        Button_Exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 162, 134));

        jLabel1.setBackground(new java.awt.Color(3, 162, 134));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_Title1.png"))); // NOI18N

        Button_Start.setBackground(new java.awt.Color(3, 162, 134));
        Button_Start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_StartButton2.png"))); // NOI18N
        Button_Start.setBorder(null);
        Button_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_StartActionPerformed(evt);
            }
        });

        Button_Scoreboard.setBackground(new java.awt.Color(3, 162, 134));
        Button_Scoreboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_ScoreboardButton1.png"))); // NOI18N
        Button_Scoreboard.setBorder(null);
        Button_Scoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ScoreboardActionPerformed(evt);
            }
        });

        Button_Exit.setBackground(new java.awt.Color(3, 162, 134));
        Button_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_ExitButton1.png"))); // NOI18N
        Button_Exit.setBorder(null);
        Button_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ExitActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(3, 162, 134));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG6.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(3, 162, 134));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG9.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(3, 162, 134));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG10.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CS128-8L PROJECT");

        jLabel5.setBackground(new java.awt.Color(3, 162, 134));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG7.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(3, 162, 134));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG8.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Scoreboard)
                            .addComponent(Button_Exit))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(Button_Start)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Start)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Button_Scoreboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_StartActionPerformed
        // Proceed to the difficulty window while also disposing the current window
        this.setVisible(false);
        DifficultyOption difficultyWindow = new DifficultyOption();
        difficultyWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_StartActionPerformed

    private void Button_ScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ScoreboardActionPerformed
        // Proceed to the leaderboard window while also disposing the current window
        this.setVisible(false);
        ScoreboardWindow leaderboard = new ScoreboardWindow();
        leaderboard.appear(false);
        this.dispose();
    }//GEN-LAST:event_Button_ScoreboardActionPerformed

    private void Button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExitActionPerformed
        // Proceed to exit and dispose of the current window
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Button_ExitActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Exit;
    private javax.swing.JButton Button_Scoreboard;
    private javax.swing.JButton Button_Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
