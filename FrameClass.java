// FrameClass.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

//imports
import java.awt.*;
import javax.swing.*;

public class FrameClass extends JFrame {

    // constructor
    public FrameClass() {
        // changes window icon
        ImageIcon image = new ImageIcon("ball.png");
        this.setIconImage(image.getImage());
        // Closes on the X button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // cant resize window
        this.setResizable(false);
        // window dimensions
        this.setSize(800, 800);
        // makes frame visible
        this.setVisible(true);
        // sets window title
        this.setTitle("Jeel's Pokemon Game");
        // changes background color
        this.getContentPane().setBackground(Color.cyan);
    }
}
