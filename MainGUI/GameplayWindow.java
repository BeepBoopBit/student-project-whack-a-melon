package MainGUI;

import Scoreboard.ScoreController;
import SpawnerLibrary.ImageSpawnerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;

public class GameplayWindow extends javax.swing.JFrame {

    //v-JPopupMenu
    //setup the popup menu, adding menuItems
    JPopupMenu popup;
    JMenuItem returnToMenuItem;
    JMenuItem aboutMenuItem;
    JMenuItem helpMenuItem;
    private void initializePopupMenu() {
        popup = new JPopupMenu();
        helpMenuItem = new JMenuItem("Help");
        aboutMenuItem = new JMenuItem("About");
        returnToMenuItem = new JMenuItem("Home");
        
        popup.add(returnToMenuItem);
        popup.add(helpMenuItem);
        popup.add(aboutMenuItem);
        this.add(popup);
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
                    showPopupMenu(e);
            }
        });
        
        returnToMenuItem.addActionListener(e -> popupActionPerformed(e));
        helpMenuItem.addActionListener(e -> popupActionPerformed(e));
        aboutMenuItem.addActionListener(e -> popupActionPerformed(e));
    }
    
    private void showPopupMenu(MouseEvent e) {
        popup.show(e.getComponent(), e.getX(), e.getY());
        
    }
    
    private void popupActionPerformed(ActionEvent e) {
        if (e.getSource()==returnToMenuItem) {
            MainMenu home = new MainMenu();
            this.setVisible(false);
            this.dispose();
            home.setVisible(true);
        }
        if (e.getSource()==helpMenuItem) {
            //display instructions
            JOptionPane.showMessageDialog(this, "Welcome to Whack-a-Melon!\nGain as much points as you can before the timer runs out by reacting on growing watermelons on time!\n\nPowerups:\nIncrease time for -10 score\n2x Multiplier for -15 score","Instructions",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource()==aboutMenuItem) {
            //
            JOptionPane.showMessageDialog(this, "CS128-L BM1\nVersion 1.0 \n Renz Angel Aguirre (Leader) \nEvanescence Naad \n Paul Miguel Reonal \nClyde Kenneth Calub \nVon Derwin Caibigan","About",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //
    ImageSpawnerController _spawner = ImageSpawnerController.getInstance();
    ScoreController _controller = ScoreController.getInstance();
    int _currentBlockIndex = 0;
    
    // take note that the delay of each spawn is randomize by this range
    // so Change the range to balance out the spawing of the watermelons
    int _easy[] = {2000,3500};
    int _medium[] = {1000,2500};
    int _hard[] = {500,1500};
    
    // NOTE: Every Timer Variable has the same explanation as _powerUpTimer[0]
    // Change the _elapseTime if you want to change how long the cooldown is:
    // [0] -> Freeze Timer
    // [1] -> Fire Timer
    // [2] -> Block Timer
    // [3] -> Add Life Timer
    Timer _powerUpTimer[] ={
        new Timer(1000,new ActionListener(){
            // 1000 -> a second
            int _elapseTime = 1000*10;
            @Override
            public void actionPerformed(ActionEvent e){
                // since the timer is repetedly called every 1000ms
                // decrement the _elapseTime by 1000 until a specified
                // amount, shall achieve the desired goal
                _elapseTime -= 1000;
                
                // Convert the _elaseTime to minutes and seconds
                String minutes = Integer.toString((_elapseTime/60000) % 60);
                String seconds = Integer.toString((_elapseTime/1000) % 60);
                
                // set the corresponding power_button
                Button_X2.setText(minutes + ':' + seconds);
                
                // If the duration is done, stop the timer
                if(_elapseTime == 0){
                    stopTimer(0);
                    resetMultiplier();
                    Button_X2.setEnabled(true);
                    Button_X2.setText("x2");
                }
            }
        }),
        new Timer(1000,new ActionListener(){
            // 1000 -> a second
            int _elapseTime = 1000*10;
            @Override
            public void actionPerformed(ActionEvent e){
                // since the timer is repetedly called every 1000ms
                // decrement the _elapseTime by 1000 until a specified
                // amount, shall achieve the desired goal
                _elapseTime -= 1000;
                
                // Convert the _elaseTime to minutes and seconds
                String minutes = Integer.toString((_elapseTime/60000) % 60);
                String seconds = Integer.toString((_elapseTime/1000) % 60);
                
                // set the corresponding power_button
                Button_AddTime.setText(minutes + ':' + seconds);
                
                // If the duration is done, stop the timer
                if(_elapseTime == 0){
                    stopTimer(1);
                    Button_AddTime.setEnabled(true);
                    Button_AddTime.setText("Add Time");
                }
            }
        })
    };
    
    
    int _gameTimerTime = 1000*45;
    Timer _gameTimer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                // since the timer is repetedly called every 1000ms
                // decrement the _elapseTime by 1000 until a specified
                // amount, shall achieve the desired goal
                _gameTimerTime -= 1000;
                
                // Convert the _elaseTime to minutes and seconds
                String minutes = Integer.toString((_gameTimerTime/60000) % 60);
                String seconds = Integer.toString((_gameTimerTime/1000) % 60);
                
                // set the corresponding power_button
                Label_Timer.setText(minutes + ':' + seconds);
                
                // If the duration is done, stop the timer
                if(_gameTimerTime == 0){
                    exit();
                }
            }
    });
    
    private void resetMultiplier(){
        _controller.resetMultiplier();
    }
    private void addTime(){
        _gameTimerTime += 1000*30;
    }
    
    public GameplayWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        // add all the grids (panels) to the _spawner
        setUpSpawner();
        
        // Attach Components to the controller
        setUpController();

        // Start spawing all the images
        _spawner.startAll();
        
        // Change the range to balance the spawning
        _spawner.randomDelayAll(_medium[0],_medium[1]);
        setUpTimer(1000*30);
    }

    public GameplayWindow(int difficulty) {
        initComponents();
        
        // add all the grids (panels) to the _spawner
        setUpSpawner();
        
        // Attach Components to the controller
        setUpController();

        // Start spawing all the images
        _spawner.startAll();
        
        // Change the range to balance the spawning
        switch (difficulty) {
            case 0:
                _spawner.randomDelayAll(_easy[0],_easy[1]);
                setUpTimer(1000*45);
                break;
            case 1:
                _spawner.randomDelayAll(_medium[0],_medium[1]);
                setUpTimer(1000*30);
                break;
            case 2:
                _spawner.randomDelayAll(_hard[0],_hard[1]);
                setUpTimer(1000*25);
                break;
            default:
                break;
        }
    }
    private void setUpSpawner(){
        //
        initializePopupMenu();
        //
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
    
    private void setUpController(){
        _controller.attachScoreLabel(Label_Score);
    }
    
    public void setUpTimer(int time){
        _gameTimerTime = time;
        _gameTimer.start();
    }
    
    // Use by classes that doesn't have access to Scoreboard window
    // and creating one might not be optimal
    public void exit(){
        Button_BackMousePressed(null);
    }
    
    
    // Auxillary Function for Power-ups
    public void stopTimer(int index){
        _powerUpTimer[index].stop();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Panel_TopLabels = new javax.swing.JPanel();
        Label_Timer = new javax.swing.JLabel();
        Label_Score = new javax.swing.JLabel();
        Label_ScoreImage1 = new javax.swing.JLabel();
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
        Button_X2 = new javax.swing.JButton();
        Button_AddTime = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(3, 162, 134));

        Panel_TopLabels.setBackground(new java.awt.Color(3, 162, 134));

        Label_Timer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Label_Timer.setForeground(new java.awt.Color(255, 255, 255));
        Label_Timer.setText("00:00");

        Label_Score.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Label_Score.setForeground(new java.awt.Color(255, 255, 255));
        Label_Score.setText("0");

        Label_ScoreImage1.setBackground(new java.awt.Color(3, 162, 134));
        Label_ScoreImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/Gameplay_Score1.png"))); // NOI18N

        Button_Back.setBackground(new java.awt.Color(3, 162, 134));
        Button_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainGUI/MainMenu_BackButton.png"))); // NOI18N
        Button_Back.setBorder(null);
        Button_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Button_BackMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Panel_TopLabelsLayout = new javax.swing.GroupLayout(Panel_TopLabels);
        Panel_TopLabels.setLayout(Panel_TopLabelsLayout);
        Panel_TopLabelsLayout.setHorizontalGroup(
            Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TopLabelsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Label_ScoreImage1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_Score)
                .addGap(61, 61, 61)
                .addComponent(Label_Timer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(Button_Back)
                .addContainerGap())
        );
        Panel_TopLabelsLayout.setVerticalGroup(
            Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TopLabelsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_ScoreImage1)
                    .addGroup(Panel_TopLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Label_Score)
                        .addComponent(Label_Timer))
                    .addComponent(Button_Back))
                .addContainerGap(103, Short.MAX_VALUE))
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

        Button_X2.setText("X2");
        Button_X2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_X2ActionPerformed(evt);
            }
        });

        Button_AddTime.setText("Add Time");
        Button_AddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PowerUpLayout = new javax.swing.GroupLayout(Panel_PowerUp);
        Panel_PowerUp.setLayout(Panel_PowerUpLayout);
        Panel_PowerUpLayout.setHorizontalGroup(
            Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PowerUpLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Button_X2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_AddTime, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        Panel_PowerUpLayout.setVerticalGroup(
            Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PowerUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PowerUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_X2)
                    .addComponent(Button_AddTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Panel_TopLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(Grid_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Grid_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Grid_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(Grid_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_PowerUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
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
                .addGap(18, 18, 18)
                .addComponent(Panel_PowerUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void Button_BackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_BackMousePressed
        // Create a new Scoreboard Window and dispose of the current window
        ScoreboardWindow _newWindow = new ScoreboardWindow();
        this.setVisible(false);
        this.dispose();
        _newWindow.appear(true);
    }//GEN-LAST:event_Button_BackMousePressed

    private void Button_AddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddTimeActionPerformed
        // Change the RIGHT value if you want to change how much should
        // the player cost per each use of ADD LIFE power-up
        if(Integer.parseInt(Label_Score.getText()) >= 10){
            Button_AddTime.setEnabled(false);
            _powerUpTimer[1].start();
            _controller.decreaseScore(10);
            addTime();
        }
    }//GEN-LAST:event_Button_AddTimeActionPerformed

    private void Button_X2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_X2ActionPerformed
        // Change the RIGHT value if you want to change how much should
        // the player cost per each use of BLOCK power-up
        if(Integer.parseInt(Label_Score.getText()) >= 15){
            Button_X2.setEnabled(false);
            _powerUpTimer[0].start();
            _controller.decreaseScore(15);
            _controller.setMultiplier(2);
        }
    }//GEN-LAST:event_Button_X2ActionPerformed

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
    private javax.swing.JButton Button_AddTime;
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_X2;
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
    private javax.swing.JLabel Label_ScoreImage1;
    private javax.swing.JLabel Label_Timer;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Panel_PowerUp;
    private javax.swing.JPanel Panel_TopLabels;
    // End of variables declaration//GEN-END:variables
}
