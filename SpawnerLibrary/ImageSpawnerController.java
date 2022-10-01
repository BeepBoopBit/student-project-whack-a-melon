
package SpawnerLibrary;

import java.util.ArrayList;
import javax.swing.JPanel;


// Handles all the Spawing Of Images
public class ImageSpawnerController {
    private static ImageSpawnerController     _instance       = null;
    private ArrayList<GridPanel>    _panels         = new ArrayList<>();
    
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
        _panels.add(new GridPanel(newPanel));
    }
}
