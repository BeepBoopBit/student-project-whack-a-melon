package MyLibrary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import MyGUI.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class ImagePopper {
    
    // Make use of singletone since we only want the ImagePopper to have one instance
    Random myRandom = new Random();
    private ImagePopper(){
        setUpPanels();
    }
    private ImagePopper(ArrayList<JPanel> myList){
        _panels = myList;
        setUpPanels();
    }
    private static ImagePopper _myInstance = null;
    public static ImagePopper get_instance(){
        if(_myInstance == null){
            _myInstance = new ImagePopper();
        }
        return _myInstance;
    }
    public static ImagePopper get_instance(ArrayList<JPanel> myList){
        if(_myInstance == null){
            _myInstance = new ImagePopper(myList);
        }
        return _myInstance;
    }
    
    public void setLabel(JLabel myLabel){
        _scoreLabel = myLabel;
    }
    
    public void setGUI(GUI myGUI){
        _myGUI = myGUI;
    }
    
    public void setUpPanels(){
        for(int i = 0; i < _panels.size(); ++i){
            _panels.get(i).setBackground(_defaultColor);
            _panels.get(i).addMouseListener(
                    new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            JPanel tempPanel = (JPanel)(e.getSource());
                            if(tempPanel.getBackground() != _defaultColor){
                                _myGUI.addScore();
                                tempPanel.setBackground(_defaultColor);
                                _scoreLabel.setText(Integer.toString(Integer.parseInt(_scoreLabel.getText()) + 1));
                                startPopping();
                            }
                        }
                    }
            );
        }
    }
    
    public void startPopping(){
        Random rand = new Random();
        _panels.get(rand.nextInt(_panels.size())).setBackground(Color.BLACK);
    }
    // Variables
    private GUI _myGUI = null;
    private ArrayList<JPanel> _panels;
    private Color _defaultColor = Color.RED;
    private JLabel _scoreLabel = null;
}
