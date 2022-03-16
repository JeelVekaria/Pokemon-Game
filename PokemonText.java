// PokemonText.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

//imports
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class PokemonText extends JLabel {
    // private instance variables
    private Font pixelMplus;
    private Pokemon pkm;
    private String name;
    private int hpl;
    private int hpt;

    // Empty constructor
    public PokemonText() {
        // sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
        this.setFont(pixelMplus);
        this.setOpaque(false);
    }

    // constructor 
    public PokemonText(Pokemon pkm) {
        // sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
        this.setOpaque(false);
        HPLost(pkm);
        this.setFont(pixelMplus);
    }

    // updates the Pokemon's information with the proper health and names
    public void HPLost(Pokemon pkma) {
        pkm = pkma;
        name = pkm.getName();
        hpl = pkm.getHealthLeft();
        hpt = pkm.getHealthTotal();
        if (pkm.getName().equals("Charmander") || pkm.getName().equals("Squirtle")
                || pkm.getName().equals("Butterfree")) {
            this.setText("Player 1's " + name + " " + hpl + "/" + hpt + " HP");
        } else {
            this.setText("Player 2's " + name + " " + hpl + "/" + hpt + " HP");
        }
    }

    // accessor
    public String getName() {
        return pkm.getName();
    }

}
