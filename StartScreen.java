// StartScreen.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

//imports
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JButton {
    //private instance variable
    private boolean clicked=false;
    public StartScreen(){
        //loads am image for the start up screen and sets the position of it
        ImageIcon homei = new ImageIcon("StartUp.jpeg");
        this.setIcon(homei);
        this.setLayout(null);
        this.setBounds(-10,0,800,800);
    }
    //checks if the screen has been clicked, and returns a boolean value
    public boolean checkClick(){
        ActionListener listener = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
               clicked=true;
            }
        };
        this.addActionListener(listener);
        return clicked;
    }
}
