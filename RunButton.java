// RunButton.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

//imports
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class RunButton extends JButton {
    //private instance variables
    private Font pixelMplus;

    // empty constructor
    public RunButton(){
        try{
            // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
		}
        this.setText("Run"); // sets the button to say "Run" on it
        this.setFont(pixelMplus);

        ActionListener listener = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
                // Closes the game if clicked 
                System.exit(0);
           }
        };
        this.addActionListener(listener);
    }
}
