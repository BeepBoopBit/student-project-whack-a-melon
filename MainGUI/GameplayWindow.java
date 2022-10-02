package MainGUI;

import SpawnerLibrary.ImageSpawnerController;

public class GameplayWindow extends javax.swing.JFrame {

    ImageSpawnerController _spawner = ImageSpawnerController.getInstance();
    public GameplayWindow() {
        initComponents();
        setUpSpawner();
        _spawner.startAll();
    }
    
    private void setUpSpawner(){
        _spawner.addPanel(Grid_0);
        _spawner.addPanel(Grid_1);
        _spawner.addPanel(Grid_2);
        _spawner.addPanel(Grid_3);
        _spawner.addPanel(Grid_4);
        _spawner.addPanel(Grid_5);
        _spawner.addPanel(Grid_6);
        _spawner.addPanel(Grid_7);
        _spawner.addPanel(Grid_8);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Panel_TopLabels = new javax.swing.JPanel();
        Label_ScoreImage = new javax.swing.JLabel();
        Label_Score = new javax.swing.JLabel();
        Button_Back = new javax.swing.JButton();
        Grid_0 = new javax.swing.JPanel();
        Label_Melon0 = new javax.swing.JLabel();
        Grid_1 = new javax.swing.JPanel();
        Label_Melon1 = new javax.swing.JLabel();
        Grid_2 = new javax.swing.JPanel();
        Label_Melon2 = new javax.swing.JLabel();
        Grid_3 = new javax.swing.JPanel();
        Label_Melon3 = new javax.swing.JLabel();
        Grid_4 = new javax.swing.JPanel();
        Label_Melon4 = new javax.swing.JLabel();
        Grid_5 = new javax.swing.JPanel();
        Label_Melon5 = new javax.swing.JLabel();
        Grid_6 = new javax.swing.JPanel();
        Label_Melon6 = new javax.swing.JLabel();
        Grid_7 = new javax.swing.JPanel();
        Label_Melon7 = new javax.swing.JLabel();
        Grid_8 = new javax.swing.JPanel();
        Label_Melon8 = new javax.swing.JLabel();
        Panel_PowerUp = new javax.swing.JPanel();
        Button_Power1 = new javax.swing.JButton();
        Button_Power2 = new javax.swing.JButton();
        Button_Power3 = new javax.swing.JButton();
        Button_Power4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(3, 162, 134));

        Panel_TopLabels.setBackground(new java.awt.Color(3, 162, 134));

        Label_ScoreImage.setBackground(new java.awt.Color(3, 162, 134));
        Label_ScoreImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Score1.png"))); // NOI18N

        Label_Score.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Label_Score.setForeground(new java.awt.Color(255, 255, 255));
        Label_Score.setText("0");

        Button_Back.setBackground(new java.awt.Color(3, 162, 134));
        Button_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BackButton.png"))); // NOI18N
        Button_Back.setBorder(null);

        javax.swing.GroupLayout Panel_TopLabelsLayout = new javax.swing.GroupLayout(Panel_TopLabels);
        Panel_TopLabels.setLayout(Panel_TopLabelsLayout);
        Panel_TopLabelsLayout.setHorizontalGroup(
            Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TopLabelsLayout.createSequentialGroup()
                .addComponent(Label_ScoreImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Score)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Back)
                .addContainerGap())
        );
        Panel_TopLabelsLayout.setVerticalGroup(
            Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_TopLabelsLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Score)
                    .addComponent(Label_ScoreImage)
                    .addComponent(Button_Back))
                .addGap(17, 17, 17))
        );

        Grid_0.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_0Layout = new javax.swing.GroupLayout(Grid_0);
        Grid_0.setLayout(Grid_0Layout);
        Grid_0Layout.setHorizontalGroup(
            Grid_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon0, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_0Layout.setVerticalGroup(
            Grid_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_1.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_1Layout = new javax.swing.GroupLayout(Grid_1);
        Grid_1.setLayout(Grid_1Layout);
        Grid_1Layout.setHorizontalGroup(
            Grid_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_1Layout.setVerticalGroup(
            Grid_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_2.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_2Layout = new javax.swing.GroupLayout(Grid_2);
        Grid_2.setLayout(Grid_2Layout);
        Grid_2Layout.setHorizontalGroup(
            Grid_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_2Layout.setVerticalGroup(
            Grid_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_3.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_3Layout = new javax.swing.GroupLayout(Grid_3);
        Grid_3.setLayout(Grid_3Layout);
        Grid_3Layout.setHorizontalGroup(
            Grid_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_3Layout.setVerticalGroup(
            Grid_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_4.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_4Layout = new javax.swing.GroupLayout(Grid_4);
        Grid_4.setLayout(Grid_4Layout);
        Grid_4Layout.setHorizontalGroup(
            Grid_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon4, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_4Layout.setVerticalGroup(
            Grid_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_5.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_5Layout = new javax.swing.GroupLayout(Grid_5);
        Grid_5.setLayout(Grid_5Layout);
        Grid_5Layout.setHorizontalGroup(
            Grid_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon5, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_5Layout.setVerticalGroup(
            Grid_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_6.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_6Layout = new javax.swing.GroupLayout(Grid_6);
        Grid_6.setLayout(Grid_6Layout);
        Grid_6Layout.setHorizontalGroup(
            Grid_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon6, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_6Layout.setVerticalGroup(
            Grid_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_7.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_7Layout = new javax.swing.GroupLayout(Grid_7);
        Grid_7.setLayout(Grid_7Layout);
        Grid_7Layout.setHorizontalGroup(
            Grid_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon7, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_7Layout.setVerticalGroup(
            Grid_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Grid_8.setBackground(new java.awt.Color(3, 162, 134));

        Label_Melon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Hole.png"))); // NOI18N

        javax.swing.GroupLayout Grid_8Layout = new javax.swing.GroupLayout(Grid_8);
        Grid_8.setLayout(Grid_8Layout);
        Grid_8Layout.setHorizontalGroup(
            Grid_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon8, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        Grid_8Layout.setVerticalGroup(
            Grid_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Melon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_PowerUp.setBackground(new java.awt.Color(122, 133, 144));

        Button_Power1.setText("jButton1");

        Button_Power2.setText("jButton2");

        Button_Power3.setText("jButton3");

        Button_Power4.setText("jButton4");

        javax.swing.GroupLayout Panel_PowerUpLayout = new javax.swing.GroupLayout(Panel_PowerUp);
        Panel_PowerUp.setLayout(Panel_PowerUpLayout);
        Panel_PowerUpLayout.setHorizontalGroup(
            Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PowerUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_Power1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Power2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Power3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Power4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_PowerUpLayout.setVerticalGroup(
            Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PowerUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Power1)
                    .addComponent(Button_Power2)
                    .addComponent(Button_Power3)
                    .addComponent(Button_Power4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(Grid_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_PowerUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(Grid_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(Grid_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Grid_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_TopLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_TopLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grid_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grid_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grid_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grid_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(Panel_PowerUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GameplayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameplayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameplayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameplayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameplayWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Power1;
    private javax.swing.JButton Button_Power2;
    private javax.swing.JButton Button_Power3;
    private javax.swing.JButton Button_Power4;
    private javax.swing.JPanel Grid_0;
    private javax.swing.JPanel Grid_1;
    private javax.swing.JPanel Grid_2;
    private javax.swing.JPanel Grid_3;
    private javax.swing.JPanel Grid_4;
    private javax.swing.JPanel Grid_5;
    private javax.swing.JPanel Grid_6;
    private javax.swing.JPanel Grid_7;
    private javax.swing.JPanel Grid_8;
    private javax.swing.JLabel Label_Melon0;
    private javax.swing.JLabel Label_Melon1;
    private javax.swing.JLabel Label_Melon2;
    private javax.swing.JLabel Label_Melon3;
    private javax.swing.JLabel Label_Melon4;
    private javax.swing.JLabel Label_Melon5;
    private javax.swing.JLabel Label_Melon6;
    private javax.swing.JLabel Label_Melon7;
    private javax.swing.JLabel Label_Melon8;
    private javax.swing.JLabel Label_Score;
    private javax.swing.JLabel Label_ScoreImage;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Panel_PowerUp;
    private javax.swing.JPanel Panel_TopLabels;
    // End of variables declaration//GEN-END:variables
}
