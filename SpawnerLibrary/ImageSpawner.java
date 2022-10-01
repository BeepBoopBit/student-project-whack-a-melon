
package SpawnerLibrary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


public class ImageSpawner {
    private GridPanel _grid = null;
    private int _frequecyDelay = 500;
    Timer _frequencyTimer = null;
    
    // Constructors
    public ImageSpawner(){
        // Randomize the delay of the timer [500, 1500)
        _frequecyDelay = (new Random()).nextInt(500,1500);
    }
    
    // Relevant Methods
    public void attachGridPanel(GridPanel myGrid){
        _grid = myGrid;
    }
    
    // Can change runtime
    public void delay(int delay){
        int myDelay = _frequencyTimer.getDelay() + delay;
        _frequencyTimer.setDelay(myDelay);
    }
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
    
    // Spawing
    private void spawn(){
        _grid.changeState();
    }
    
}
