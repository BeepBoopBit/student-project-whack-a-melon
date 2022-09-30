/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author V
 */
public class scoreFunctionality {
    //variables
    private String scoreReset = "0000";
    private int score = 0;
    private String scoreText = null;
    //during gameplay
    
    void scoreboardWhilePlaying(javax.swing.JLabel label) {
        //working
        score++;
        if (score<10) {
            //9...1
            scoreText = "000" + Integer.toString(score);
        }
        else if (score<100) {
            //99...10
            scoreText = "00" + Integer.toString(score);
        }
        else if (score<1000) {
            scoreText = "0" + Integer.toString(score);
        }
        else if (score<10000) {
            scoreText = Integer.toString(score);
        }
        else {
            scoreText = "9999";
            //limit
        }
        label.setText(scoreText);
    }
    
    void scoreboardReset(javax.swing.JLabel label) {
        //working
        label.setText(scoreReset);
        resetScore();
    }
    
    void resetScore() {
        score=0;
    }
    void exitGame(javax.swing.JFrame frame) {
        resetScore();
        saveToLeaderboard();
        frame.setVisible(false);
    }
    
    void saveToLeaderboard() {
        //working
        try (BufferedWriter encoder = new BufferedWriter(new FileWriter("src/GUI/localLeaderboard.txt",true))) {
            String playerName = JOptionPane.showInputDialog("Enter your name.");
            //could add little complexity to limit the name into the first four/five;
            //get difficulty and time
            String difficulty = "Hard";//ph
            encoder.write(playerName+" "+difficulty+" "+java.time.LocalDateTime.now() +" "+score+"\n");
            encoder.close();
        }
        catch (Exception e) {
            System.out.println("An error occurred: "+e);
        }
    }
    
    //viewing scoreboard (new panel)?
    //remaining task (own  automated score sorter)
    javax.swing.JTable writeLocalFile() {
        //wip
        javax.swing.JTable table = new javax.swing.JTable();
        try (BufferedReader localFile = new BufferedReader(new FileReader("src/GUI/localLeaderboard.txt"))){
            //table model 
            table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                //this is the data
            },
            new String [] {
                "Name", "Difficulty", "Date & Time", "Score"
            }) 
            {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
            //
            
        }
        catch (Exception e) {
            
        }
        return table;
    }
    
}
