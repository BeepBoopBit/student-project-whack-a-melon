
package SpawnerLibrary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


public class ImageSpawner {
    private GridPanel _grid = null;
    private int _frequecyDelay = 0;
    private int _defaultDelay = 0;
    Timer _frequencyTimer = null;
    
    // Constructors
    public ImageSpawner(){
        // Randomize the delay of the timer [500, 1500)
        _frequecyDelay = (new Random()).nextInt(500,1500);
        _defaultDelay = _frequecyDelay;
    }
    
    // Relevant Methods
    
    // attach the grid panel to the class
    public void attachGridPanel(GridPanel myGrid){
        _grid = myGrid;
    }
    
    // Reset the delay to its default speed
    public void resetDelay(){
        _frequencyTimer.setDelay(_defaultDelay);
    }
    
    // stop _frequencyTimer
    public void stop(){
        _frequencyTimer.stop();
    }
    
    /// Reset of kill a WATERMELON
    public void resetState(){
        _grid.setDefault();
    }
    
    // Can change runtime
    
    // Delay the spawing of WATERMELONS
    public void delay(int delay){
        int myDelay = _frequencyTimer.getDelay() + delay;
        _frequencyTimer.setDelay(myDelay);
    }
    
    // Accelerate the spawing of WATERMELONS
    public void accelerate(int accelerate){
        int myAccelerate = _frequencyTimer.getDelay() - accelerate;
        _frequencyTimer.setDelay(myAccelerate);
    }
    
    // Should be call before calling start() method
    // can't change in runtime. Change using changeDelay() method
    public void setFrequencyDelay(int frequencyDelay){
        _frequecyDelay = frequencyDelay;
    }
    
    // Main
    public void start(){
        if(_frequencyTimer == null){
            // initialize the timer to call spawn() method when it is prompted
            _frequencyTimer = new Timer(_frequecyDelay, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    spawn();
                }
            });
        }
        
        // Start the timer
        _frequencyTimer.start();
    }
    public void kill(){
        _grid.setDefault();
    }
    // Spawing
    private void spawn(){
        _grid.changeState();
    }
    
}
