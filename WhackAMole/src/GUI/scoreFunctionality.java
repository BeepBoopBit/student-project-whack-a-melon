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
import javax.swing.table.DefaultTableModel;
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
        frame.setVisible(false);//does not stop the program!!!
    }
    
    void saveToLeaderboard() {
        //working
        String regex = " ";
        String[] difficulty = {"Hard  ","Medium","Easy  "};
        int nameLimit = 10;
        //encoder
        try (BufferedWriter encoder = new BufferedWriter(new FileWriter("src/GUI/localLeaderboard.txt",true))) {
            Boolean isAlphanumerical = Boolean.FALSE;
            String playerName = "";
            while (!isAlphanumerical) {
                try {
                    playerName = JOptionPane.showInputDialog("Enter your name(max of 5 chars):");
                    if(playerName.length()>nameLimit) {throw new ArrayIndexOutOfBoundsException(); }
                    if(playerName == "") {playerName = "Anonymous";}
                    int counter = 0;
                    for (char c:playerName.toCharArray()) {
                        if (!Character.isLetterOrDigit(c)) {
                            counter++;
                        }
                    }
                    if (counter==0) {isAlphanumerical = Boolean.TRUE; }
                    else {throw new ArithmeticException();}//ignore the fact its arithmeticexeption (just want to ignore nullpointerexception when the player cancels)
                }
                catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, "Not a digit nor lettter!");
                }
                catch (ArrayIndexOutOfBoundsException e2) {
                    JOptionPane.showMessageDialog(null, "Must be " + nameLimit +"characters or less!");
                }
            }
            //limit name to five
//            if (playerName.length()>5) {playerName = playerName.substring(0, 5);}
            if (playerName.length()<nameLimit) { 
                for (int i = playerName.length();i<nameLimit;i++){
                    playerName = playerName + " ";
                }
            }
            System.out.println(playerName);
            //get difficulty and time
            //ph
            encoder.write(playerName+regex+difficulty[2]+regex+java.time.LocalDateTime.now()+regex+score+"\n");
            encoder.close();
            
        }
        catch (Exception e) {
            System.out.println("An error occurred: "+e);
        }
        //sorter
        try (BufferedReader localFile = new BufferedReader(new FileReader("src/GUI/localLeaderboard.txt"))) {
            String data = null;
            while ((data=localFile.readLine())!=null) {
                
            }
        }
        catch (Exception e) {}
    }
    
    //viewing scoreboard (new panel)?
    //remaining task (own  automated score sorter)
    javax.swing.JTable updateTable() {
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
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            String dataRow = null;
            while ((dataRow = localFile.readLine())!= null) {
                model.addRow(new Object[] {
                    dataRow.substring(0, 9),dataRow.substring(11, 16),dataRow.substring(18, 40),dataRow.substring(41, dataRow.length())//these values are the format of the .txt
                });
            }
        }
        catch (Exception e) {
            
        }
        return table;
    }
    
}
