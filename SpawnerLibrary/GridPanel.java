
package SpawnerLibrary;
import java.awt.Color;
import javax.swing.JPanel;

class GridPanel {
    private JPanel      _panel      = null;
    private boolean     _isDefault  = true;
    
    GridPanel(JPanel panel){
        _panel = panel;
    }
    
    // Change the state of the panel
    public void changeState(){
        // will be change in the future
        if(_isDefault){
            _panel.setBackground(Color.RED);
        }else{
            _panel.setBackground(Color.BLUE);
        }
        _isDefault = !_isDefault;
    }
    
}
