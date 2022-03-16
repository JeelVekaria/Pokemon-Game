// FightButton.java
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
import java.util.Random;

public class FightButton extends JButton {
    // private instance variables
    private Font pixelMplus;
    private CheckWin win;

    private PokemonAppear2 pkmAppear2;
    private Player player;
    private int pkmChosen;
    private PokemonText pt;

    private PokemonAppear pkmAppear;
    private Player player1;
    private int pkmChosen1;
    private PokemonText pt1;

    private boolean switchAttack = true;
    private AttackInfo attackInfo;

    private PokemonButton pb;
    private PokemonSwitch pkmswitch;

    // empty constructor
    public FightButton() {
        // sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
        this.setText("Fight"); // sets the text Fight over the button shown on the bottom right side of the
                               // screen
        this.setFont(pixelMplus);
    }

    // semi-constructor, a mutator to modify all the instances at once
    public void setFightButton(PokemonAppear2 pkmAppear2a, CheckWin win, PokemonAppear pkmAppeara) {
        this.win = win;
        this.pkmAppear = pkmAppeara;
        this.pkmAppear2 = pkmAppear2a;

        // initalizes instance variables that will refrence to Player 2
        if (pkmAppear2.getPlayer2P() == 1) {
            this.pt1 = pkmAppear.getPt1();
        }
        if (pkmAppear2.getPlayer2P() == 2) {
            this.pt1 = pkmAppear.getPt2();
        }
        if (pkmAppear2.getPlayer2P() == 3) {
            this.pt1 = pkmAppear.getPt3();
        }
        this.player = pkmAppear2.getPlayer();
        this.pkmChosen = pkmAppear2.getPlayer2P();

        // initalizes instance variables that will refrence to Player 1
        if (pkmAppear.getPlayer1P() == 1) {
            this.pt = pkmAppear2.getPt4();
        }
        if (pkmAppear.getPlayer1P() == 2) {
            this.pt = pkmAppear2.getPt5();
        }
        if (pkmAppear.getPlayer1P() == 3) {
            this.pt = pkmAppear2.getPt6();
        }
        this.player1 = pkmAppear.getPlayer();
        this.pkmChosen1 = pkmAppear.getPlayer1P();

        // sets a custom font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
        }
        this.setText("Fight"); // sets the text Fight over the button shown on the bottom right side of the
                               // screen
        this.setFont(pixelMplus);

    }

    // method that is responsible for the opponent pokemon losing health and
    // alternating attacks
    public void call() {
        // checks if the button has been clicked
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Random rand = new Random();
                int amount = 0; // is responsible for the random attack damage done to Player 2's Pokemon
                int amount1 = 0; // is responsible for the random attack damage done to Player 1's Pokemon
                pb.gone(); // hides the pokemons that the user can switch with
                amount = rand.nextInt(50) + 1;
                amount1 = rand.nextInt(50) + 1;

                // sets the opponent pokemon in the attackInfo object to display which pokemon
                // is being attacked
                if (switchAttack == false) { // runs when it's Player 2's turn to attack
                    if (pkmChosen == 1) {
                        attackInfo.setPkm2(player.getPokemon1());
                    } else if (pkmChosen == 2) {
                        attackInfo.setPkm2(player.getPokemon2());
                    } else if (pkmChosen == 3) {
                        attackInfo.setPkm2(player.getPokemon3());
                    }
                }
                // runs when its Player 1's turn to attack
                else {
                    // sets the opponent pokemon in the attackInfo object to display which pokemon
                    // is being attacked
                    if (pkmChosen1 == 1) {
                        attackInfo.setPkm1(player1.getPokemon1());
                    } else if (pkmChosen1 == 2) {
                        attackInfo.setPkm1(player1.getPokemon2());
                    } else if (pkmChosen1 == 3) {
                        attackInfo.setPkm1(player1.getPokemon3());
                    }
                }

                // switchAttack just alternates between Player 1 and Player 2 attacking
                if (switchAttack == true && check2()) {
                    // hides the text above the Pokemon says who's turn it is
                    attackInfo.call(switchAttack);

                    // checks is Player 2's Pokemon 1 is being attacked
                    if (pkmChosen == 1 && player.getPokemon1().getHealthLeft() > 0) {
                        if (player.getPokemon1().getHealthLeft() - amount < 1) {
                            pkmAppear2.setp1p4a2();
                            pkmswitch.pkmgone(21);

                        }
                        player.getPokemon1().lostHp(amount);
                        pt.HPLost(player.getPokemon1());
                        attackInfo.display2(amount, player.getPokemon1());
                    }

                    // checks is Player 2's Pokemon 2 is being attacked
                    else if (pkmChosen == 2 && player.getPokemon2().getHealthLeft() > 0) {
                        if (player.getPokemon2().getHealthLeft() - amount < 1) {
                            pkmAppear2.setp1p5a2();
                            pkmswitch.pkmgone(22);
                        }
                        player.getPokemon2().lostHp(amount);
                        pt.HPLost(player.getPokemon2());
                        attackInfo.display2(amount, player.getPokemon2());
                    }

                    // checks is Player 2's Pokemon 3 is being attacked
                    else if (pkmChosen == 3 && player.getPokemon3().getHealthLeft() > 0) {
                        if (player.getPokemon3().getHealthLeft() - amount < 1) {
                            pkmAppear2.setp1p6a2();
                            pkmswitch.pkmgone(23);

                        }
                        player.getPokemon3().lostHp(amount);
                        pt.HPLost(player.getPokemon3());
                        attackInfo.display2(amount, player.getPokemon3());
                    }
                }
                // switchAttack just alternates between Player 1 and Player 2 attacking
                else if (switchAttack == false && check1()) {
                    // hides the text above the Pokemon says who's turn it is
                    attackInfo.call(switchAttack);

                    // checks is Player 1's Pokemon 1 is being attacked
                    if (pkmChosen1 == 1 && player1.getPokemon1().getHealthLeft() > 0) {
                        if (player1.getPokemon1().getHealthLeft() - amount1 < 1) {
                            pkmAppear.setp1p1a2();
                            pkmswitch.pkmgone(11);
                        }
                        player1.getPokemon1().lostHp(amount1);
                        pt1.HPLost(player1.getPokemon1());
                        attackInfo.display1(amount1, player1.getPokemon1());
                    }

                    // checks is Player 1's Pokemon 2 is being attacked
                    if (pkmChosen1 == 2 && player1.getPokemon2().getHealthLeft() > 0) {
                        if (player1.getPokemon2().getHealthLeft() - amount1 < 1) {
                            pkmAppear.setp1p2a2();
                            pkmswitch.pkmgone(12);
                        }
                        player1.getPokemon2().lostHp(amount1);
                        pt1.HPLost(player1.getPokemon2());
                        attackInfo.display1(amount1, player1.getPokemon2());
                    }

                    // checks is Player 1's Pokemon 3 is being attacked
                    if (pkmChosen1 == 3 && player1.getPokemon3().getHealthLeft() > 0) {
                        if (player1.getPokemon3().getHealthLeft() - amount1 < 1) {
                            pkmAppear.setp1p3a2();
                            pkmswitch.pkmgone(13);

                        }
                        player1.getPokemon3().lostHp(amount1);
                        pt1.HPLost(player1.getPokemon3());
                        attackInfo.display1(amount1, player1.getPokemon3());
                    }
                }
                // switches the value of switchAttack so the player can switch turns
                switchAttack = !switchAttack;

                // checks if any of the players 3 pokemons are fainted
                win.check();
            }

        };
        this.addActionListener(listener);

    }

    //checks if Player 2's Pokemon that is sent out is not fainted
    public boolean check1() {
        if (pkmChosen == 1 && player.getPokemon1().getHealthLeft() > 0 || pkmChosen == 2 && player.getPokemon2().getHealthLeft() > 0 || pkmChosen == 3 && player.getPokemon3().getHealthLeft() > 0) {
            return true;
        }
        return false;
    }

    //checks if Player 1's Pokemon that is sent out is not fainted
    public boolean check2() {
        if (pkmChosen1 == 1 && player1.getPokemon1().getHealthLeft() > 0 || pkmChosen1 == 2 && player1.getPokemon2().getHealthLeft() > 0 || pkmChosen1 == 3 && player1.getPokemon3().getHealthLeft() > 0) {
            return true;
        }
        return false;
    }

    //mutators
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setPkmChosen(int chosen) {
        this.pkmChosen = chosen;
    }
    public void setPt(PokemonText pt) {
        this.pt = pt;
    }
    public void setAttackInfo(AttackInfo info) {
        attackInfo = info;
    }
    public void setPlayer1(Player player) {
        this.player1 = player;
    }
    public void setPkmChosen1(int chosen2) {
        this.pkmChosen1 = chosen2;
    }
    public void setPt1(PokemonText pt) {
        this.pt1 = pt;
    }
    public void setPokemonButton(PokemonButton pkmButton) {
        pb = pkmButton;
    }
    
    // accessors
    public Player getPlayer() {
        return player;
    }
    public Player getPlayer1() {
        return player1;
    }
    public int getPkmChosen() {
        return pkmChosen;
    }
    public PokemonText getPt() {
        return pt;
    }

    // Alters the "pt" instance variable
    public void check(Player player2, int player2P, PokemonAppear2 pkmAppear2) {
        if (player2P == 1) {
            this.setPt(pkmAppear2.getPt4());
        } else if (player2P == 2) {
            this.setPt(pkmAppear2.getPt5());
        } else if (player2P == 3) {
            this.setPt(pkmAppear2.getPt6());
        }
        this.setPlayer(player2);
        this.setPkmChosen(player2P);
        this.call();
    }






    public void setSwitch(PokemonSwitch newSwitch){
        pkmswitch=newSwitch;
    }
}
