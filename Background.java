// Background.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

//imports
import javax.swing.*;

public class Background extends JPanel {
    //responsible for the background of the game, which is the battlefield, also a constructor
    public Background(){
        JLabel label = new JLabel();

        ImageIcon image = new ImageIcon("Background.png");
        label.setIcon(image);
        //sets background to be centered on the screen
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        this.add(label);
    }

}