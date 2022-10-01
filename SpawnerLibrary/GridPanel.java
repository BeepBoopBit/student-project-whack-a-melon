
package SpawnerLibrary;
import java.awt.Color;
import javax.swing.JPanel;

class GridPanel {
    private JPanel      _panel      = null;
    private boolean     _isDefault  = true;
    
    GridPanel(JPanel panel){
        _panel = panel;
    }
    
    public void changeState(){
        if(_isDefault){
            _panel.setBackground(Color.RED);
        }else{
            _panel.setBackground(Color.BLUE);
        }
        _isDefault = !_isDefault;
    }
    
}
