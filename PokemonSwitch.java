// PokemonSwitch.java
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
import java.awt.*;
import java.util.*;

public class PokemonSwitch extends JPanel{
    //private instance variables
    private Font pixelMplus;
    private boolean appear=true;
    private boolean appear2=true;

    private Player player1;
    private Player player2;
    private PokemonAppear pkmAppear;
    private PokemonAppear2 pkmAppear2;
    private FightButton button1;

    private AttackInfo attackInfo;

    private JButton charmander;
    private JButton squirtle;
    private JButton butterfree;
    private JButton pikachu;
    private JButton bulbasaur;
    private JButton bidoof;
    private boolean once=false;
    

    // Empty constructor
    public PokemonSwitch(){
        // Sets a custom font
        this.setLayout(null);
        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(22f);	
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
        }
        catch(IOException | FontFormatException e){
        }
    }
    // semi-constructor (also to keep tester file organized)
    public void setPokemonSwitch(Player player1, Player player2,PokemonAppear pkmAppear, PokemonAppear2 pkmAppear2, FightButton button1){
        this.player1=player1;
        this.player2=player2;
        this.pkmAppear=pkmAppear;
        this.pkmAppear2=pkmAppear2;
        this.button1=button1;
        this.setLayout(null);
        // Sets a custom font
        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(22f);	
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
        }
        catch(IOException | FontFormatException e){
        }
        // calls in the other method in this class
        this.call();
    }

    // Sets the entire appearance of the Pokemon's the user can switch to, an image for each of them, and the text above it says which Pokemons are Player 1's and Player 2's.
    public void call(){
        Random rand = new Random();
        int player1Pokemon = rand.nextInt(3)+1;
        // player1Pokemon =1;
        if(!once){
            pkmAppear.setPlayer1P(player1Pokemon);
            pkmAppear.call();
            button1.setPlayer1(player1);
            button1.setPkmChosen1(player1Pokemon);
            if(player1Pokemon==1){
                button1.setPt1(pkmAppear.getPt1());
            }
            if(player1Pokemon==2){
                button1.setPt1(pkmAppear.getPt2());
            }
            if(player1Pokemon==3){
                button1.setPt1(pkmAppear.getPt3());
            }
            once=true;
        }
        // Sets the text says which Pokemons are Player 1's
        JLabel p1p = new JLabel();
        p1p.setText("Player 1's Pokemons");
        p1p.setFont(pixelMplus);
        p1p.setForeground(new Color(10,10,250));
        p1p.setBounds(10,-30,250,100);
        this.add(p1p);

        // Sets the text says which Pokemons are Player 2's
        JLabel p2p = new JLabel();
        p2p.setText("Player 2's Pokemons");
        p2p.setFont(pixelMplus);
        p2p.setForeground(new Color(250,10,10));
        p2p.setBounds(260,-30,250,100);
        this.add(p2p);
        
        
        // Sets the button with an image of this pokemon, and sets their position
        charmander = new JButton();
        ImageIcon imgcharmander = new ImageIcon("MiniCharmander.png");
        charmander.setIcon(imgcharmander);
        charmander.setBounds(0,40,83,83);
        this.add(charmander);
        ActionListener listener = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
                // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
                if(player1.getPokemon1().getHealthLeft()>=1){
                    pkmAppear.setPlayer1P(1);
                    pkmAppear.call();

                    button1.setPlayer1(player1);
                    button1.setPkmChosen1(1);
                    button1.setPt1(pkmAppear.getPt1());
                }
                // Button disables if the user tries to click it if the if statement above fails
                else{
                    charmander.setEnabled(false);
                }
            }
        };
        charmander.addActionListener(listener);


        // Sets the button with an image of this pokemon, and sets their position
        squirtle = new JButton();
        ImageIcon imgSquirtle = new ImageIcon("MiniSquirtle.png");
        squirtle.setIcon(imgSquirtle);
        squirtle.setBounds(83,40,83,83);
        this.add(squirtle);
        ActionListener listener2 = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
                // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
                if(player1.getPokemon2().getHealthLeft()>1){
                    pkmAppear.setPlayer1P(2);
                    pkmAppear.call();
                    button1.setPlayer1(player1);
                    button1.setPkmChosen1(2);
                    button1.setPt1(pkmAppear.getPt2());
                }
                // Button disables if the user tries to click it if the if statement above fails
                else{
                    squirtle.setEnabled(false);
                }
            }
        };
        squirtle.addActionListener(listener2);

        // Sets the button with an image of this pokemon, and sets their position
        butterfree = new JButton();
        ImageIcon imgbutterfree = new ImageIcon("MiniButterfree.png");
        butterfree.setIcon(imgbutterfree);
        butterfree.setBounds(166,40,83,83);
        this.add(butterfree);
        ActionListener listener3 = new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent ae){
                // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
                if(player1.getPokemon3().getHealthLeft()>1){
                   pkmAppear.setPlayer1P(3);
                   pkmAppear.call();
                   button1.setPlayer1(player1);
                   button1.setPkmChosen1(3);
                   button1.setPt1(pkmAppear.getPt3());
                }
                // Button disables if the user tries to click it if the if statement above fails
                else{
                    butterfree.setEnabled(false);
                }
            }

        };
        butterfree.addActionListener(listener3);

        // Sets the button with an image of this pokemon, and sets their position
        pikachu = new JButton();
        ImageIcon imgpikachu = new ImageIcon("MiniPikachu.png");
        pikachu.setIcon(imgpikachu);
        pikachu.setBounds(252,40,83,83);
        this.add(pikachu);
        ActionListener listener4 = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae){
            // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
            if(player2.getPokemon1().getHealthLeft()>=1){
                pkmAppear2.setPlayer2P(1);
                pkmAppear2.call();
                button1.setPlayer(player2);
                button1.setPkmChosen(1);
                button1.setPt(pkmAppear2.getPt4());
            }
            // Button disables if the user tries to click it if the if statement above fails
            else{
                pikachu.setEnabled(false);
            }
        }
    };
    pikachu.addActionListener(listener4);

    // Sets the button with an image of this pokemon, and sets their position
    bulbasaur = new JButton();
    ImageIcon imgbulbasaur = new ImageIcon("MiniBulbasaur.png");
    bulbasaur.setIcon(imgbulbasaur);
    bulbasaur.setBounds(335,40,83,83);
    this.add(bulbasaur);
    ActionListener listener5 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
            if(player2.getPokemon2().getHealthLeft()>=1){
                pkmAppear2.setPlayer2P(2);
                pkmAppear2.call();
                button1.setPlayer(player2);
                button1.setPkmChosen(2);
                button1.setPt(pkmAppear2.getPt5());
            }
            // Button disables if the user tries to click it if the if statement above fails
            else{
            bulbasaur.setEnabled(false);
            }
        }
    };
    bulbasaur.addActionListener(listener5);

    // Sets the button with an image of this pokemon, and sets their position
    bidoof = new JButton();
    ImageIcon imgBidoof = new ImageIcon("MiniBidoof.png");
    bidoof.setIcon(imgBidoof);
    bidoof.setBounds(418,40,83,83);
    this.add(bidoof);
    ActionListener listener6 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
                // Changes to this pokemon when this button has been clicked if they user's pokemon isn't fainted
                if(player2.getPokemon3().getHealthLeft()>=1){
                    pkmAppear2.setPlayer2P(3);
                    pkmAppear2.call();
                    button1.setPlayer(player2);
                    button1.setPkmChosen(3);
                    button1.setPt(pkmAppear2.getPt6());
                }
                // Button disables if the user tries to click it if the if statement above fails
                else{
                    bidoof.setEnabled(false);
                }
            }
        };
        bidoof.addActionListener(listener6);

        // Hides the JPanel at the start
        this.setVisible(false);
    }   

    // Switches between showing or hiding this panel
    public void appear() {
        if(appear2==false){
            this.setVisible(true);
            // Hides the attack message
            attackInfo.show(false);
            appear=true;
        }
        else if(appear==true){
            this.setVisible(true);
            // Hides the attack message
            attackInfo.show(false);
        }
        else{
            this.setVisible(false);
            // Shows the attack message
            attackInfo.show(true);
        }
        appear2=true;
        appear = !appear;
    }

    // Hides this panel
    public void gone2() {
        this.setVisible(false);

        
        appear2=false;
        // Shows the attack message
        attackInfo.show(true);
    }
    //mutator
    public void setAttackInfo(AttackInfo attackInfo){
        this.attackInfo=attackInfo;
    }
    //disables the pokemon switch button for pokemons that have fainted
    public void pkmgone(int num){
        if(num==11){
            charmander.setEnabled(false);
        }
        if(num==12){
            squirtle.setEnabled(false);
        }
        if(num==13){
            butterfree.setEnabled(false);
        }
        if(num==21){
            pikachu.setEnabled(false);
        }
        if(num==22){
            bulbasaur.setEnabled(false);
        }
        if(num==23){
            bidoof.setEnabled(false);
        }
    }
}
