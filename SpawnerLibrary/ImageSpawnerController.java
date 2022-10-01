
package SpawnerLibrary;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


// Handles all the Spawing Of Images
public class ImageSpawnerController {
    // Singleton variable
    private static ImageSpawnerController _instance = null;
    
    // Stores all the ImageSpawners
    private ArrayList<ImageSpawner> _spawners = new ArrayList<>();
    
    // Constructors
    private ImageSpawnerController(){}
    public static ImageSpawnerController getInstance(){
        if(_instance == null){
            _instance = new ImageSpawnerController();
        }
        return _instance;
    }
    
    // Relevant Functions
    public void addPanel(JPanel newPanel){
        // Create the new GridPanel using the newPanel
        GridPanel newGridPanel = new GridPanel(newPanel);
        
        // Create the Image Spawner
        ImageSpawner newSpawner = new ImageSpawner();
        
        // Attach the new spawner to the GridPanel
        newSpawner.attachGridPanel(newGridPanel);
        
        // Add it to the array
        _spawners.add(newSpawner);
    }
    
    public void startAll(){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).start();
        }
    }
    
    // delay by the default 100
    public void delayAll(){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).delay(100);
        }
    }
    // delay by the value specified by the user
    public void delayAll(int milliseconds){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).delay(milliseconds);
        }
    }
    // random delay by the default [100, 501)
    public void randomDelayAll(){
        Random rand = new Random();
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).delay(rand.nextInt(100,501));
        }
    }
    // random delay from value in range of [l, r)
    public void randomDelayAll(int l, int r){
        Random rand = new Random();
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).delay(rand.nextInt(l,r));
        }
    }
    
    // delay by the default 100
    public void delayAt(int index){
        _spawners.get(index).delay(100);
    }
    // delay by the value specified by the user
    public void delayAt(int index, int milliseconds){
        _spawners.get(index).delay(milliseconds);
    }
    // random delay by the default [100, 501)
    public void randomDelayAt(int index){
        Random rand = new Random();
        _spawners.get(index).delay(rand.nextInt(100,501));
    }
    // random delay from value in range of [l, r)
    public void randomDelayAt(int index, int l, int r){
        Random rand = new Random();
        _spawners.get(index).delay(rand.nextInt(l,r));
    }

    
    // accelerate by the default 100
    public void accelerateAll(){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).accelerate(100);
        }
    }
    // accelerate by the value specified by the user
    public void accelerateAll(int milliseconds){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).accelerate(milliseconds);
        }
    }
    // random accelerate by the default [100, 501)
    public void randomAccelerateAll(){
        Random rand = new Random();
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).accelerate(rand.nextInt(100,501));
        }
    }
    // random accelerate from value in range of [l, r)
    public void randomAccelerateAll(int l, int r){
        Random rand = new Random();
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).accelerate(rand.nextInt(l,r));
        }
    }

    // delay by the default 100
    public void accelerateAt(int index){
        _spawners.get(index).accelerate(100);
    }
    // delay by the value specified by the user
    public void accelerateAt(int index, int milliseconds){
        _spawners.get(index).accelerate(milliseconds);
    }
    // random delay by the default [100, 501)
    public void randomAccelerateAt(int index){
        Random rand = new Random();
        _spawners.get(index).accelerate(rand.nextInt(100,501));
    }
    // random delay from value in range of [l, r)
    public void randomAccelerateAt(int index, int l, int r){
        Random rand = new Random();
        _spawners.get(index).accelerate(rand.nextInt(l,r));
    }

    

}
