// PokemonButton.java
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

public class PokemonButton extends JButton {
    //private instance variables
    private Font pixelMplus;
    private PokemonSwitch load;
    
    // Sets the text "Pokemon" being shown on the bottom
    public void PokemonButtonSwitch(PokemonSwitch load){
        this.load=load;
        // Sets a custom font
        try{
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
		}
        this.setText("Pokemon");
        this.setFont(pixelMplus);

        ActionListener listener = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
            // Switches between showing which Pokemon's the user can switch to
            load.appear();
            }
        };
        this.addActionListener(listener);
    }

    // method that hides the pokemon available to the user
    public void gone(){
        load.gone2();
    }
}
