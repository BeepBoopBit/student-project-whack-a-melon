
package SpawnerLibrary;
import Scoreboard.ScoreController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GridPanel {
    private JPanel _panel = null;
    JLabel _label = null;
    private int _gridState = 0;
    String _paths[] = { "src/MainGUI/Gameplay_Hole.png",
        "src/MainGUI/Gameplay_Leaf.png",
        "src/MainGUI/Gameplay_Watermelon.png"
    };
    ScoreController _score = ScoreController.getInstance();
    
    // set variables and add a MouseListener to the label
    public GridPanel(JPanel panel){
        _panel = panel;
        _label = (JLabel) _panel.getComponent(0);
        _label.addMouseListener(
                new MouseAdapter(){
                    @Override
                    // When the label is pressed
                    public void mousePressed(MouseEvent e){
                        // if the icon is a WATERMELON
                        if(_label.getIcon().toString() == _paths[2]){
                            // Reset it to a HOLE
                            setDefault();
                            
                            // and add a score
                            _score.addScore();
                        }
                    }
                }
        );
        
    }
    
    // Change the state of the panel
    public void changeState(){
        // Change the icon in realtes to the current _gridState
        switch (_gridState) {
            case 0:
                _label.setIcon(new ImageIcon(_paths[0]));
                break;
            case 1:
                _label.setIcon(new ImageIcon(_paths[1]));
                break;
            case 2:
                _label.setIcon(new ImageIcon(_paths[2]));
                _gridState = -1;
                break;
            default:
                break;
        }
        _gridState += 1;
    }
    // Reset the Icon to a HOLE
    public void setDefault(){
        _label.setIcon(new ImageIcon(_paths[0]));
        _gridState = 1;
    }
}
