// CheckWin.java
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

public class CheckWin extends JPanel{

    //private instance variables
    private Player p1;
    private Player p2;
    
    private Font pixelMplus;
    private JLabel winner;

    private FightButton button1;
    private PokemonButton button2;
    private RunButton button3;

    // empty constructor
    public CheckWin() {
    }
    //mutator that initializes the buttons
    public void setButtons(FightButton button1, PokemonButton button2, RunButton button3){
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
    }
    
    //sets the position of the end screen that displays the winner
    public void checkUpdate(){
        winner = new JLabel();
        winner.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0,635,800,200);
        winner.setVisible(false);
    }
    
    //checks to see if either side has 3 pokemons fainted, will load a different end screen/image depending on who the winner is
    public void check(){
        //sets a custom font
        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
        }
        winner.setFont(pixelMplus);
        
        //checks if all of Player 1's Pokemons if they fainted or not, displays Player 2 winning
        if(p1.getPokemon1().getHealthLeft()<1 && p1.getPokemon2().getHealthLeft()<1 && p1.getPokemon3().getHealthLeft()<1){
            //hides all buttons because the image will load on top of this
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            ImageIcon player1win = new ImageIcon("Player2Win.png");
            winner.setIcon(player1win);
            winner.setVisible(true);
            winner.setBounds(100,100,100,100);
            
        }
        //checks if all of Player 2's Pokemons if they fainted or not, displays Player 1 winning
        if(p2.getPokemon1().getHealthLeft()<1 && p2.getPokemon2().getHealthLeft()<1 && p2.getPokemon3().getHealthLeft()<1){
            //hides all buttons because the image will load on top of this
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            ImageIcon player1win = new ImageIcon("Player1Win.png");
            winner.setIcon(player1win);
            winner.setVisible(true);
        }
        this.add(winner);
    }
    // initializes the players
    public void setCheckWin(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }
}
