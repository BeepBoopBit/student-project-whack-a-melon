
package SpawnerLibrary;

import java.util.ArrayList;
import javax.swing.JPanel;


// Handles all the Spawing Of Images
public class ImageSpawnerController {
    private static ImageSpawnerController _instance = null;
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
        _spawners.add(new ImageSpawner());
    }
    
    public void startAll(){
        for(int i = 0; i < _spawners.size(); ++i){
            _spawners.get(i).start();
        }
    }
}
