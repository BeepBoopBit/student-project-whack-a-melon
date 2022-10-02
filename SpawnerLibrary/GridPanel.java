
package SpawnerLibrary;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GridPanel {
    private JPanel      _panel      = null;
    private int     _gridState      = 0;
    
    GridPanel(JPanel panel){
        _panel = panel;
    }
    
    // Change the state of the panel
    public void changeState(){
        JLabel panelComponent = (JLabel) _panel.getComponent(0);
        switch (_gridState) {
            case 0:
                panelComponent.setIcon(new ImageIcon("src/MainGUI/Gameplay_Hole.png"));
                break;
            case 1:
                panelComponent.setIcon(new ImageIcon("src/MainGUI/Gameplay_Leaf.png"));
                break;
            case 2:
                panelComponent.setIcon(new ImageIcon("src/MainGUI/Gameplay_Watermelon.png"));
                _gridState = -1;
                break;
            default:
                break;
        }
        _gridState += 1;
    }
    
}
