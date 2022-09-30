package MyLibrary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import MyGUI.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JLabel;

public class ImagePopper {
    
    // Make use of singletone since we only want the ImagePopper to have one instance
    Random myRandom = new Random();
    private ImagePopper(){}
    private static ImagePopper _myInstance = null;
    public static ImagePopper get_instance(){
        if(_myInstance == null){
            _myInstance = new ImagePopper();
        }
        return _myInstance;
    }
    
    public void setGUI(GUI myGUI){
        _myGUI = myGUI;
    }
    
    public void startPopping(){
        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.red);
        newPanel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    _myGUI.addScore();
                    newPanel.setVisible(false);
                    startPopping();
                }
        });
        newPanel.setPreferredSize(new Dimension(50,50));
        newPanel.setBounds(myRandom.nextInt(100), myRandom.nextInt(100), 50, 50);
        _myGUI.addPanel(newPanel);
    }
    
    // Variables
    private GUI _myGUI = null;
}
