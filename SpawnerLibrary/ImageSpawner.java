
package SpawnerLibrary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


public class ImageSpawner {
    private GridPanel _grid = null;
    private int _delay = 0;
    private int _frequecyDelay = 500;
    private int tempCounter = 0;
    Timer _frequencyTimer = null;
    
    // Constructors
    public ImageSpawner(){}
    
    // Relevant Methods
    public void attachGridPanel(GridPanel myGrid){
        _grid = myGrid;
    }
    
    // Can change runtime
    public void changeDelay(int delay){
        _delay = delay;
    }
    
    // Should be call before calling start() method
    // can't change in runtime. Change using changeDelay() method
    public void setFrequencyDelay(int frequencyDelay){
        _frequecyDelay = frequencyDelay;
    }
    
    // Main
    public void start(){
        if(_frequencyTimer == null){
            _frequencyTimer = new Timer(_frequecyDelay, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    scheduledSpawner();
                }
            });
        }
        _frequencyTimer.start();
    }
    
    // Spawing
    private void scheduledSpawner(){
        try {
            Thread.sleep(_delay);
            auxillarySpawner();
        } catch (InterruptedException ex) {
            Logger.getLogger(ImageSpawner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void auxillarySpawner(){
        System.out.println("Thread:" + Thread.currentThread().getId() + " -- Counter: " + tempCounter);
        tempCounter += 1;
    }
    
}
