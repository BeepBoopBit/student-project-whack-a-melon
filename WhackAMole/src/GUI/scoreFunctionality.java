/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        if (score==0) {
            label.setFont(new Font("Unispace", label.getFont().getStyle(), 18));
        }
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
                    if(playerName.equals("")) {playerName = "Anonymous";}
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
//            System.out.println(playerName);
            //get difficulty and time
            //ph
            encoder.write(playerName+regex+difficulty[1]+regex+java.time.LocalDateTime.now()+regex+score+"\n");
            encoder.flush();
            encoder.close();
        }
        catch (Exception e) {
            System.out.println("An error occurred: "+e);
        }
        //sorter
        /*
        ArrayList = entire string
        2D array:
            [0] = position in writing
            [1] = index in arrayList
            [2] = score
        */
        sorter();
    }
    
    void sorter() {
        try (BufferedReader file = new BufferedReader(new FileReader("src/GUI/localLeaderboard.txt"))) {
            //initialization and declaration
            String data = null;
            int arrayListIndex = 0;
            ArrayList<String> line = new ArrayList<>(); //storing entire line
            int[][] array;
//          HashMap<Integer, Integer> dict = new HashMap<>(); //storing [index, score]
            while ((data=file.readLine())!=null) {
//               dict.put(arrayListIndex, Integer.parseInt(data.substring(42, data.length())));
                line.add(data);
            }
            arrayListIndex = line.size();
            System.out.println("Array length " + arrayListIndex);
            array = new int[3][arrayListIndex];
            for (int i = 0;i<2;i++) {
                for (int k = 0; k<arrayListIndex;k++) {
                    array[i][k] = k;
                }
            }
            for (int k=0; k<arrayListIndex;k++) {
                array[2][k] = Integer.parseInt((line.get(k)).substring(42, line.get(k).length())); //aggregatiion of getting e.g the score of 30 or 1000
            }
            System.out.println("Before");
            for (int i = 0;i<3;i+=2) {
                for (int k = 0; k<arrayListIndex;k++) {
                    System.out.println("i: "+i+" k: "+k+" "+array[i][k]);
                }
            }
            //sort
            try {
                for (int i = 0 ;i< arrayListIndex-1; i++){
                    int min = i;
                    for (int j = i+1; j< arrayListIndex; j++){
                        if (array[2][j] > array[2][min]){
                            min = j;
                        }
                    }
                    int temp = array[2][min];
                    array[2][min] = array[2][i];
                    array[2][i] = temp;
                    temp = array[1][min];
                    array[1][min] = array[1][i];
                    array[1][i] = temp;
                }
            }
            catch (Exception e) {System.out.println("Error "+e);}

            System.out.println("After");
            //testing
            try {
//              dict.forEach((key,value) -> System.out.println("[Key]:"+key+"[Value]:"+value));
                for (int i = 0;i<3;i+=2) {
                    for (int k = 0; k<arrayListIndex;k++) {
                        System.out.println("i: "+i+" k: "+k+" "+array[i][k]);
                    }
                }
            }
            catch (Exception e) {System.out.println(e);}
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/GUI/placeholder.txt",true))) {
                //i = position, k = index in list
                
                for (int i=0;i<arrayListIndex;i++) {
                    for (int k=0;k<arrayListIndex;k++) {
                        if (array[0][k]==i) {
                            int index = array[1][k];
                            writer.write(line.get(index)+"\n");
                        }
                    }
                }
                writer.flush();
                writer.close();
            }
            catch (Exception e) {System.out.println("writing file error: "+e);}
            file.close();
            File oldFile = new File("src/GUI/localLeaderboard.txt");
            if (oldFile.delete()) {
                System.out.println("Deleted file");
            }
            else {
                System.out.println("Can't delete");
            }
            File newFile = new File("src/GUI/placeholder.txt");
            newFile.renameTo(oldFile);
        }
        catch (Exception e) {System.out.println(e);}
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
                    dataRow.substring(0, 9),dataRow.substring(11, 17),dataRow.substring(18, 40),dataRow.substring(42, dataRow.length())//these values are the format of the .txt
                });
            }
        }
        catch (Exception e) {
            
        }
        return table;
    }
    
}
