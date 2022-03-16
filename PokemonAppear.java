// PokemonAppear.java
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

public class PokemonAppear extends JPanel {
    // private instance variables
    private Player player;
    private int player1P;
    private int player2P;

    //p1p1 is short for pass 1 pokemon 1
    private JLabel p1p1 = new JLabel();
    //p1p1a is short for pass 1 pokemon 1 appearance (this shows the actual pokemon )
    private JLabel p1p1a = new JLabel();
    //p1p1a is short for pass 1 pokemon 1 appearance 2 (this shows pokemon status and type(type is shown later in the code))
    private JLabel p1p1a2 = new JLabel("Status: Alive");
    // p1p1i is short for pass 1 pokemon 1 image (this displays the pokemon image)
    private ImageIcon p1p1i = new ImageIcon("Charmander.png");
    // p1p1t is short for pass 1 pokemon 1 text (shows the pokemon information)
    private PokemonText p1p1t = new PokemonText();
    // boolean once variable is used to make a specific code to run only once (sets the pokemon information on the very first turn)
    private boolean once = true;
    
    //p1p2 is short for pass 1 pokemon 2
    private JLabel p1p2 = new JLabel();
    private JLabel p1p2a = new JLabel();
    private JLabel p1p2a2 = new JLabel("Status: Alive");
    private ImageIcon p1p2i = new ImageIcon("Squirtle.png");
    private PokemonText p1p2t = new PokemonText();
    private boolean once2 = true;

    //p1p3 is short for pass 1 pokemon 3
    private JLabel p1p3 = new JLabel();
    private JLabel p1p3a = new JLabel();
    private JLabel p1p3a2 = new JLabel("Status: Alive");
    private ImageIcon p1p3i = new ImageIcon("Butterfree.png");
    private PokemonText p1p3t = new PokemonText();
    private boolean once3 = true;
    private Font pixelMplus;

    // constructor to set this JPanel's background invisible
    public PokemonAppear() {
        this.setOpaque(false);
        // Sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
    }

    // constructor to initialize the instance variables
    public PokemonAppear(Player player, int player1P, int player2P) {
        this.player = player;
        this.player1P = player1P;
        this.player2P = player2P;
        this.setOpaque(false);
        // Sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
    }

    // sets the position of all of Player 1's Pokemons, along with the Pokemon, only shows 1 Pokemon and their information at a time
    public void call() {
        this.setLayout(null);

        // Sets Player's 1 Pokemon 1 appearance/position and Pokemon 1 information appearance/position
        p1p1.setIcon(p1p1i);
        if (once == true) {
            p1p1t = new PokemonText(this.player.getPokemon1());
            once = false;
        }
        p1p1.setBounds(0, 0, 800, 220);
        p1p1t.setBounds(270, 165, 800, 100);
        this.add(p1p1);
        this.add(p1p1t);
        this.setVisible(true);
        if (this.player1P != 1) {
            p1p1.setVisible(false);
            p1p1t.setVisible(false);
            p1p1a.setVisible(false);
            p1p1a2.setVisible(false);
        } 
        else {
            p1p1.setVisible(true);
            p1p1t.setVisible(true);
            p1p1a.setVisible(true);
            p1p1a2.setVisible(true);

            p1p1a.setText("Type: " + player.getPokemon1().getType());
            p1p1a.setBounds(270, 190, 800, 100);
            p1p1a.setFont(pixelMplus);
            this.add(p1p1a);
            p1p1a2.setBounds(430, 190, 800, 100);
            p1p1a2.setFont(pixelMplus);
            this.add(p1p1a2);
        }

        // Sets Player's 1 Pokemon 2 appearance/position and Pokemon 2 information appearance/position
        p1p2.setIcon(p1p2i);
        if (once2 == true) {
            p1p2t = new PokemonText(this.player.getPokemon2());
            once2 = false;
        }
        p1p2.setBounds(0, 0, 800, 220);
        p1p2t.setBounds(270, 165, 800, 100);
        this.add(p1p2);
        this.add(p1p2t);
        this.setVisible(true);
        if (this.player1P != 2) {
            p1p2.setVisible(false);
            p1p2t.setVisible(false);
            p1p2a.setVisible(false);
            p1p2a2.setVisible(false);
        } 
        else {
            p1p2.setVisible(true);
            p1p2t.setVisible(true);
            p1p2a.setVisible(true);
            p1p2a2.setVisible(true);

            p1p2a.setText("Type: " + player.getPokemon2().getType());
            p1p2a.setBounds(270, 190, 800, 100);
            p1p2a.setFont(pixelMplus);
            this.add(p1p2a);
            p1p2a2.setBounds(430, 190, 800, 100);
            p1p2a2.setFont(pixelMplus);
            this.add(p1p2a2);
        }

        // Sets Player's 1 Pokemon 3 appearance/position and Pokemon 3 information appearance/position
        p1p3.setIcon(p1p3i);
        if (once3 == true) {
            p1p3t = new PokemonText(this.player.getPokemon3());
            once3 = false;
        }
        p1p3.setBounds(0, 0, 800, 220);
        p1p3t.setBounds(270, 165, 800, 100);
        this.add(p1p3);
        this.add(p1p3t);
        this.setVisible(true);
        if (this.player1P != 3) {
            p1p3.setVisible(false);
            p1p3t.setVisible(false);
            p1p3a.setVisible(false);
            p1p3a2.setVisible(false);

        } 
        else {
            p1p3.setVisible(true);
            p1p3t.setVisible(true);
            p1p3a.setVisible(true);
            p1p3a2.setVisible(true);

            p1p3a.setText("Type: " + player.getPokemon3().getType());
            p1p3a.setBounds(270, 190, 800, 100);
            p1p3a.setFont(pixelMplus);
            this.add(p1p3a);
            p1p3a2.setBounds(430, 190, 800, 100);
            p1p3a2.setFont(pixelMplus);
            this.add(p1p3a2);
        }
    }

    // Sets the pokemon information being shown change to say the Pokemon has fainted
    public void setp1p1a2() {
        p1p1a2.setText("Status: Fainted");
    }
    public void setp1p2a2() {
        p1p2a2.setText("Status: Fainted");
    }
    public void setp1p3a2() {
        p1p3a2.setText("Status: Fainted");
    }

    // Mutators
    public void setPlayer(Player p1) {
        player = p1;
    }

    public void setPlayer1P(int p1) {
        player1P = p1;
    }

    public void setPlayer2P(int p1) {
        player2P = p1;
    }

    // Accessors
    public Player getPlayer() {
        return player;
    }

    public int getPlayer1P() {
        return player1P;
    }

    public int getPlayer2P() {
        return player2P;
    }

    public PokemonText getPt1() {
        return p1p1t;
    }

    public PokemonText getPt2() {
        return p1p2t;
    }

    public PokemonText getPt3() {
        return p1p3t;
    }
}
