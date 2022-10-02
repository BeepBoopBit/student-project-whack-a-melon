package Scoreboard;
import MainGUI.GameplayWindow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ScoreController {
    //variables
    private int _score = 0;
    private int _life = 10;
    private JTable _scoreTable = null;
    private String _difficulty = "MEDIUM";
    private JLabel _scoreLabel = null;
    private JLabel _lifeLabel = null;
    private static ScoreController _instance = null;
    private GameplayWindow _window = null;
    
    private ScoreController() {}
    public static ScoreController getInstance(){
        if(_instance == null){
            _instance = new ScoreController();
        }
        return _instance;
    }
    
    // Should be called once before saving to the leaderboard
    public void attachTable(JTable table){
        _scoreTable = table;
    }
    
    // Should be called once before adding a score
    public void attachScoreLabel(JLabel newLabel){
        _scoreLabel = newLabel;
    }
    public void attachLifeLabel(JLabel newLabel){
        _lifeLabel = newLabel;
        _lifeLabel.setText(Integer.toString(_life));
    }
    public void attachMainWindow(GameplayWindow newWindow){
        _window = newWindow;
    }
    
    public void addScore() {
        // Add Score
        _score++;
        
        // set the text of the label in relates to the current score
        _scoreLabel.setText(Integer.toString(_score));
    }
    
    public void decreaseLife(){
        // decrement the life
        _life--;
        
        if(_life == 0){
            _window.exit();
        }
        
        // set the text of the label in relates to the current life
        _lifeLabel.setText(Integer.toString(_life));
    }
    
    public void scoreboardReset(javax.swing.JLabel label) {
        // Reset the Label
        label.setText("0000");
        
        // Reset the Score
        _score=0;
    }
    
    public void saveToLeaderboard(){
        // store the data inside of the file
        ArrayList<String[]> fileData = getDataFromFile();
        
        // Ask for name Input
        String playerName = askNameInput();
        
        // summarize the data for the player
        String saveData[] = {playerName, _difficulty, java.time.LocalDate.now().toString(), Integer.toString(_score)};
        fileData.add(saveData);
        
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

        // Reset the score
        _score=0;
    }
    
    public void populateTable(){
        // Get the data
        ArrayList<String[]> fileData = getDataFromFile();
        
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
                    if(userInput.length()>userInputLimit) {
                        throw new ArrayIndexOutOfBoundsException(); 
                    }
                    
                    //check if userInput is empty
                    if(userInput.equals("")) {
                        userInput = "Anonymous";
                    }
                    
                    //loop through the entire thing to find if there's a non-digit or letter inside the string
                    for (char c:userInput.toCharArray()) {
                        if (!Character.isLetterOrDigit(c)) {
                            throw new ArithmeticException();
                        }
                    }
                    //break out of the while loop
                    isAlphanumerical = Boolean.TRUE; 
                }
                catch (ArithmeticException e) {
                    //irrelevant exception handler name, used as a placeholder to not trigger nullpointerexception when the player cancels
                    JOptionPane.showMessageDialog(null, "Contains symbols and spaces! Limited to only digits and letters.");
                }
                catch (ArrayIndexOutOfBoundsException e2) {
                    //irrelevant exception handler name, used as a placeholder to not trigger nullpointerexception when the player cancels
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
