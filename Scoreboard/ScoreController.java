package Scoreboard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ScoreController {
    //variables
    private int _score = 0;
    int _scoreMax[] = {9,89,898,8997};
    int _currentMaxIndex = 0;
    String preScoreText[] = {"000","00","0"};
    JTable _scoreTable = null;
    String _difficulty = "MEDIUM";
    
    
    void attachTable(JTable table){
        _scoreTable = table;
    }
        
    
    void addScore(javax.swing.JLabel label) {
        // set the text to null
        String scoreText = null;
        
        // Add Score
        _score++;
        
        // check if the current score is < the current max
        if(_scoreMax[_currentMaxIndex] != 0){
            // if it is, then decrement the max
            _scoreMax[_currentMaxIndex] -= 1;
        }else{
            // else, go to the next max
            _currentMaxIndex += 1;
        }
        
        // set the score
        scoreText = preScoreText[_currentMaxIndex] + Integer.toString(_score);
        
        // set the text of the labe in relates to the score
        label.setText(scoreText);
    }
    
    
    void scoreboardReset(javax.swing.JLabel label) {
        // Reset the Label
        label.setText("0000");
        
        // Reset the Score
        _score=0;
    }
    
    void exitGame(javax.swing.JFrame frame) {
        
        // Save the information to the leaderboard
        saveToLeaderboard();
        
        // Reset the score
        _score=0;
        
        //does not stop the program!!!
        frame.setVisible(false); 
    }
    
    
    private void saveToLeaderboard(){
        // store the data inside of the file
        ArrayList<String[]> fileData = getDataFromFile();
        
        // Ask for name Input
        String playerName = askNameInput();
        
        // summarize the data for the player
        String saveData[] = {playerName, _difficulty, java.time.LocalDate.now().toString(), Integer.toString(_score)};
        
        // Store the data
        storeNewData(saveData);
        
        // Sort the data
        sorter(fileData);
        
        // Get the model of the attached table
        DefaultTableModel myModel = (DefaultTableModel) _scoreTable.getModel();
        
        // Remove all data
        myModel.setRowCount(0);
        
        // Add all data to the model
        for(int i = 0; i < fileData.size(); ++i){
            myModel.addRow(fileData.get(i));
        }
    }
    
    private ArrayList<String[]> getDataFromFile(){
        ArrayList<String[]> fileData = new ArrayList<>();
        try {
            // create a file object pointing to the scoreboard file
            File myObj = new File("src/Scoreboard/localLeaderboard.txt");
            
            // read the file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // get the data of the line
                String data = myReader.nextLine();
                
                // split it by " "
                String arrData[] = data.split(" ");
                
                // get the score
                fileData.add(arrData);
            }
            // Close the reader to save the changes (if there is)
            myReader.close();
        } catch (FileNotFoundException e) {
            // catch if the file is nout found
            System.out.println("File not Found");
        }
        return fileData;
    }
    
    private void storeNewData(String[] playerData){
        // Get the path
        File path = new File("src/Scoreboard/localLeaderboard.txt");
        
        // Declare the writer object
        FileWriter wr = null;
        try {
            // try to create a FileWriter with the specified path
            wr = new FileWriter(path,true);
            
            // Write all the player data to the file
            for(int i = 0; i < 4; ++i){
                try {
                    wr.append(playerData[i] + " ");
                } catch (IOException ex) {
                    Logger.getLogger(ScoreController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Make sure there is space at the end
            wr.append("\n");
            
            // Save and close the file
            wr.flush();
            wr.close();
        } catch (IOException ex) {
            // Catch if there is a problem writing in file
            Logger.getLogger(ScoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String askNameInput(){
        String userInput = "";
        int userInputLimit = 10;
        Boolean isAlphanumerical = Boolean.FALSE;
        while (!isAlphanumerical) {
                try {
                    userInput = JOptionPane.showInputDialog("Enter your name: ");
                    //check if userInput is longer than the limit
                    if(userInput.length()>userInputLimit) {throw new ArrayIndexOutOfBoundsException(); }
                    //check if userInput is empty
                    if(userInput.equals("")) {userInput = "Anonymous";}
                    int counter = 0;
                    //loop through the entire thing to find if there's a non-digit or letter inside the string
                    for (char c:userInput.toCharArray()) {
                        if (!Character.isLetterOrDigit(c)) {
                            throw new ArithmeticException();
                        }
                    }
                    //break out of the while loop
                    if (counter==0) {isAlphanumerical = Boolean.TRUE; }
                }
                catch (ArithmeticException e) {//irrelevant exception handler name, used as a placeholder to not trigger nullpointerexception when the player cancels
                    JOptionPane.showMessageDialog(null, "Contains symbols and spaces! Limited to only digits and letters.");
                }
                catch (ArrayIndexOutOfBoundsException e2) {//irrelevant exception handler name, used as a placeholder to not trigger nullpointerexception when the player cancels
                    JOptionPane.showMessageDialog(null, "Must be " + userInputLimit +"characters or less!");
                }
            }
        return userInput;
    }
    
    private void sorter(ArrayList<String[]> arrData) {
        // assume that all values are of the same size
        int arrDataBack = arrData.get(0).length-1;
        
        // Bubble sort implementation
        for(int i = 0; i < arrData.size(); ++i){
            for(int j = 0; j < arrData.size()-i-1; ++j){
                int l = Integer.parseInt(arrData.get(j)[arrDataBack]);
                int r = Integer.parseInt(arrData.get(j+1)[arrDataBack]);
                if(l < r){
                    // swap the values
                    String tempData[] = arrData.get(j);
                    arrData.set(j, arrData.get(j+1));
                    arrData.set(j+1,tempData);
                }
            }
        }
    }
}
