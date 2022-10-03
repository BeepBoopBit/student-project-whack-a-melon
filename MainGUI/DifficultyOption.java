package MainGUI;

import Scoreboard.ScoreController;

public class DifficultyOption extends javax.swing.JFrame {

    ScoreController _controller = ScoreController.getInstance();
    public DifficultyOption() {
        initComponents();
    }
    
    private void proceedToGameplay(int difficulty){
        // Proceed to the gameplay window
        GameplayWindow newWindow = new GameplayWindow(difficulty);
        newWindow.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Button_Easy = new javax.swing.JButton();
        Button_Medium = new javax.swing.JButton();
        Button_Hard = new javax.swing.JButton();
        Button_Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 162, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_Difficulty1.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(3, 162, 134));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG6.png"))); // NOI18N

        Button_Easy.setBackground(new java.awt.Color(3, 162, 134));
        Button_Easy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_Easy.png"))); // NOI18N
        Button_Easy.setBorder(null);
        Button_Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EasyActionPerformed(evt);
            }
        });

        Button_Medium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_Medium.png"))); // NOI18N
        Button_Medium.setBorder(null);
        Button_Medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_MediumActionPerformed(evt);
            }
        });

        Button_Hard.setBackground(new java.awt.Color(3, 162, 134));
        Button_Hard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_Hard.png"))); // NOI18N
        Button_Hard.setBorder(null);
        Button_Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_HardActionPerformed(evt);
            }
        });

        Button_Back.setBackground(new java.awt.Color(3, 162, 134));
        Button_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BackButton.png"))); // NOI18N
        Button_Back.setBorder(null);
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(3, 162, 134));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG9.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(3, 162, 134));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG10.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(3, 162, 134));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BG7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Easy)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button_Medium)
                                    .addComponent(Button_Hard, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(1, 1, 1)
                .addComponent(Button_Easy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Button_Medium)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Hard, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EasyActionPerformed
        _controller.setDifficulty("Easy");
        proceedToGameplay(0);
    }//GEN-LAST:event_Button_EasyActionPerformed

    private void Button_MediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MediumActionPerformed
        _controller.setDifficulty("Medium");
        proceedToGameplay(1);
    }//GEN-LAST:event_Button_MediumActionPerformed

    private void Button_HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_HardActionPerformed
        _controller.setDifficulty("Hard");
        proceedToGameplay(2);
    }//GEN-LAST:event_Button_HardActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        MainMenu newMenu = new MainMenu();
        newMenu.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

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
            java.util.logging.Logger.getLogger(DifficultyOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DifficultyOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DifficultyOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DifficultyOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DifficultyOption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Easy;
    private javax.swing.JButton Button_Hard;
    private javax.swing.JButton Button_Medium;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
