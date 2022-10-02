
package SpawnerLibrary;
import Scoreboard.ScoreController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GridPanel {
    private JPanel      _panel      = null;
    JLabel              _label      = null;
    private int         _gridState  = 0;
    String              _paths[]    = { "src/MainGUI/Gameplay_Hole.png",
                                        "src/MainGUI/Gameplay_Leaf.png",
                                        "src/MainGUI/Gameplay_Watermelon.png"
                                        };
    ScoreController     _score      = ScoreController.getInstance();
    GridPanel(JPanel panel){
        _panel = panel;
        _label = (JLabel) _panel.getComponent(0);
        _label.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e){
                        if(_label.getIcon().toString() == _paths[2]){
                            setDefault();
                            _score.addScore();
                        }
                    }
                }
        );
        
    }
    
    // Change the state of the panel
    public void changeState(){
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
    public void setDefault(){
        _label.setIcon(new ImageIcon(_paths[0]));
        _gridState = 1;
    }
    
}
