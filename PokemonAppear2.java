// PokemonAppear2.java
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


public class PokemonAppear2 extends JPanel{
    //private instance variables
    private Player player;
    private int player2P;
    private int player1P;

    //p1p4 is short for pass 1 pokemon 4
    private JLabel p1p4 = new JLabel();
    //p1p4a is short for pass 1 pokemon 4 appearance (this shows the actual pokemon )
    private JLabel p1p4a = new JLabel();
    //p1p4a is short for pass 1 pokemon 4 appearance 2 (this shows pokemon status and type(type is shown later in the code))
    private JLabel p1p4a2 = new JLabel("Status: Alive");
    //p1p4i is short for pass 1 pokemon 4 image (this displays the pokemon image)
    private ImageIcon p1p4i = new ImageIcon("Pikachu.png");
    //p1p4t is short for pass 1 pokemon 4 text (shows the pokemon information)
    private PokemonText p1p4t = new PokemonText();
    // boolean once variable is used to make a specific code to run only once (sets the pokemon information on the very first turn)
    private boolean once4=true;

    //p1p5 is short for pass 1 pokemon 5
    private JLabel p1p5 = new JLabel();
    private JLabel p1p5a = new JLabel();
    private JLabel p1p5a2 = new JLabel("Status: Alive");
    private ImageIcon p1p5i = new ImageIcon("Bulbasaur.png");
    private PokemonText p1p5t = new PokemonText();
    private boolean once5=true;
    
    //p1p6 is short for pass 1 pokemon 6
    private JLabel p1p6 = new JLabel();
    private JLabel p1p6a = new JLabel();
    private JLabel p1p6a2 = new JLabel("Status: Alive");
    private ImageIcon p1p6i = new ImageIcon("Bidoof.png");
    private PokemonText p1p6t = new PokemonText();
    private boolean once6=true;
    private Font pixelMplus;

    // constructor to set this JPanel's background invisible
    public PokemonAppear2(){
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
    public PokemonAppear2(Player player, int player2P, int player1P){
        this.player=player;
        this.player2P=player2P;
        this.player1P=player1P;
        this.setOpaque(false);
        // Sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
    }

    // sets the position of all of Player 2's Pokemons, along with the Pokemon, only shows 1 Pokemon and their information at a time
    public void call(){
        this.setLayout(null);

        // Sets Player's 2 Pokemon 1 appearance/position and Pokemon 1 information appearance/position
        p1p4.setIcon(p1p4i);
        if(once4==true){
            p1p4t = new PokemonText(this.player.getPokemon1());
            once4=false;
        }
        p1p4.setBounds(520,100,280,220);
        p1p4t.setBounds(14,50,800,100);
        this.add(p1p4);
        this.add(p1p4t);
        if(this.player2P != 1){
            p1p4.setVisible(false);
            p1p4t.setVisible(false);
            p1p4a.setVisible(false);
            p1p4a2.setVisible(false);
        }
        else{
            p1p4.setVisible(true);
            p1p4t.setVisible(true);
            p1p4a.setVisible(true);
            p1p4a2.setVisible(true);
            
            p1p4a.setText("Type: " + player.getPokemon1().getType());
            p1p4a.setBounds(12, 75, 800, 100);
            p1p4a.setFont(pixelMplus);
            this.add(p1p4a);
            p1p4a2.setBounds(172, 75, 800, 100);
            p1p4a2.setFont(pixelMplus);
            this.add(p1p4a2);
        }
        this.setVisible(true);

        // Sets Player's 2 Pokemon 2 appearance/position and Pokemon 2 information appearance/position
        p1p5.setIcon(p1p5i);
        if(once5==true){
            p1p5t = new PokemonText(this.player.getPokemon2());
            once5=false;
        }
        p1p5.setBounds(520,100,280,220);
        p1p5t.setBounds(14,50,800,100);
        this.add(p1p5);
        this.add(p1p5t);
        if(this.player2P != 2){
            p1p5.setVisible(false);
            p1p5t.setVisible(false);
            p1p5a.setVisible(false);
            p1p5a2.setVisible(false);
        }
        else{
            p1p5.setVisible(true);
            p1p5t.setVisible(true);
            p1p5a.setVisible(true);
            p1p5a2.setVisible(true);
        
            p1p5a.setText("Type: " + player.getPokemon2().getType());
            p1p5a.setBounds(12, 75, 800, 100);
            p1p5a.setFont(pixelMplus);
            this.add(p1p5a);
            p1p5a2.setBounds(172, 75, 800, 100);
            p1p5a2.setFont(pixelMplus);
            this.add(p1p5a2);
        }
        this.setVisible(true);
        
        // Sets Player's 2 Pokemon 3 appearance/position and Pokemon 3 information appearance/position
        p1p6.setIcon(p1p6i);
        if(once6==true){
            p1p6t = new PokemonText(this.player.getPokemon3());
            once6=false;
        }
        p1p6.setBounds(520,100,280,220);
        p1p6t.setBounds(14,50,800,100);
        this.add(p1p6);
        this.add(p1p6t);
        
        if(player2P != 3){
            p1p6.setVisible(false);
            p1p6t.setVisible(false);
            p1p6a.setVisible(false);
            p1p6a2.setVisible(false);
        }
        else{
            p1p6.setVisible(true);
            p1p6t.setVisible(true);
            p1p6a.setVisible(true);
            p1p6a2.setVisible(true);
            
            p1p6a.setText("Type: " + player.getPokemon3().getType());
            p1p6a.setBounds(12, 75, 800, 100);
            p1p6a.setFont(pixelMplus);
            this.add(p1p6a);
            p1p6a2.setBounds(172, 75, 800, 100);
            p1p6a2.setFont(pixelMplus);
            this.add(p1p6a2);
        }
        this.setVisible(true);
        
    }
    
    // Sets the pokemon information being shown change to say the Pokemon has fainted
    public void setp1p4a2() {
        p1p4a2.setText("Status: Fainted");
    }
    public void setp1p5a2() {
        p1p5a2.setText("Status: Fainted");
    }
    public void setp1p6a2() {
        p1p6a2.setText("Status: Fainted");
    }

    // Mutators
    public void setPlayer(Player p1){
        player =p1;
    }
    public void setPlayer2P(int p1){
        player2P = p1;
    }
    public void setPlayer1P(int p1){
        player1P = p1;
    }
    
    // Accessors
    public Player getPlayer(){
        return player;
    }
    public int getPlayer2P(){
        return player2P;
    }
    public int getPlayer1P(){
        return player1P;
    }

    public PokemonText getPt4(){
        return p1p4t;
    }
    public PokemonText getPt5(){
        return p1p5t;
    }
    public PokemonText getPt6(){
        return p1p6t;
    }
}