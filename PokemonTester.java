    // PokemonTester.java
// Jeel Vekaria - ICS4U0
// December 3rd 2021
// This is the main tester file that runs the game

import java.util.Random;

public class PokemonTester {
    public static void main(String[] args) {
        Random rand = new Random();
        // Calls in the other classes
        FrameClass frame = new FrameClass(); //sets up the frame(main window)
        PokemonSwitch pokemonAvailable = new PokemonSwitch(); //sets up the pokemons that the user can switch with
        AttackInfo attackInfo = new AttackInfo(); //displays the pokemon attacking information
        StartScreen home = new StartScreen(); // displays the homescreen (dissapears after being clicked on)
        PokemonButton button2 = new PokemonButton(); //button that toggles the appearance of switching pokemons
        RunButton button3 = new RunButton(); // button that closes the game
        Background background = new Background(); // displays the background of the game
        CheckWin win = new CheckWin(); //checks who wins to display the winner at the end
        PokemonAppear pkmAppear = new PokemonAppear(); //sets the appearance and position of Player 1's Pokemon
        PokemonAppear2 pkmAppear2 = new PokemonAppear2();//sets the appearance and position of Player 2's Pokemon
        FightButton button1 = new FightButton(); //button that toggles between attacking Player 1 and Player 2
        PokemonText pkmtext = new PokemonText(); //displays the pokemons information(hp, type, status)

        // Randomly selects which Pokemon is being sent out at the start
        // Player1P- (1-Charmander) (2-Squirtle) (3-Butterfree)
        // Player2P- (1-Pikachu) (2-Bulbasaur) (3-Bidoof)
        int player1P = rand.nextInt(3)+1;
        int player2P = rand.nextInt(3)+1;

        // Initalizes all the pokemons and their information
        // p1 is short for Pokemon 1... and so on
        Pokemon p1 = new Pokemon("Charmander", "Fire", 250, 250);
        Pokemon p2 = new Pokemon("Squirtle", "Water", 220, 220);
        Pokemon p3 = new Pokemon("Butterfree", "Bug", 250, 250);

        Pokemon p4 = new Pokemon("Pikachu", "Electric", 220, 220);
        Pokemon p5 = new Pokemon("Bulbasaur", "Grass", 200, 200);
        Pokemon p6 = new Pokemon("Bidoof", "Normal", 300, 300);

        // Adds 3 pokemons into each player
        Player player1 = new Player(p1, p2, p3);
        Player player2 = new Player(p4, p5, p6);

        // calls methods from win
        win.setCheckWin(player1, player2);
        win.checkUpdate();

        // waits until user clicked on the homescreen to start the game
        boolean clicked = false;
        frame.add(home);
        while (!clicked) {
            clicked = home.checkClick();
        }

        // if user clicked the screen, then the homescreen will go invisible
        home.setVisible(false);

        // adds the objects into the frame, win is used for displaying winner (remains invisible until there is a winner) and attackInfo sets the attack information
        frame.add(win);
        frame.add(attackInfo);

        // sets bounds for the attackInfo panel
        attackInfo.setBounds(0, 0, 100, 100);

        // Calls some method from the pkmAppear class
        // initalizes Player 1's Pokemon that are being sent out, and player 2's Pokemon that it will attack
        // IMPORTANT: Player 1's Pokemon are randomly chosen from the PokmeonSwitch.java file lines 75-93. [function] it switches out whatever randomized Pokemon that was chosen here to a random one (or possibly the same one), it's kind of refreshing the Player 1's Pokemon in a way
        pkmAppear.setPlayer(player1);
        pkmAppear.setPlayer1P(player1P);
        pkmAppear.setPlayer2P(player2P);
        pkmAppear.call();

        // Calls some method from the pkmAppear class
        // initalizes Player 2's Pokemon that are being sent out, and player 1's Pokemon that it will attack
        pkmAppear2.setPlayer(player2);
        pkmAppear2.setPlayer1P(player1P);
        pkmAppear2.setPlayer2P(player2P);
        pkmAppear2.call();

        // these method calls initalizes their own private instances in their class (Fight button)
        button1.setFightButton(pkmAppear2, win, pkmAppear);
        button1.setAttackInfo(attackInfo);
        button1.check(player2, player2P, pkmAppear2);
        button1.setPokemonButton(button2);

        // these method calls are responsible for the pokemon swithing
        pokemonAvailable.setPokemonSwitch(player1, player2, pkmAppear, pkmAppear2, button1);
        pokemonAvailable.setAttackInfo(attackInfo);

        // calls a methods from button2 that toggles showing or hiding the pokemon switches (Pokemon button)
        button2.PokemonButtonSwitch(pokemonAvailable);

        // settings bounds for each component
        pkmAppear.setBounds(50, 350, 750, 400);
        pkmAppear2.setBounds(0, 0, 750, 400);
        pokemonAvailable.setBounds(0, 640, 500, 123);
        button2.setBounds(500, 702, 150, 62);
        win.setButtons(button1, button2, button3);
        button1.setBounds(500, 640, 300, 62);
        button3.setBounds(650, 702, 150, 62);
        background.setBounds(0, -4, 800, 800);

        // adds the objects into the frame
        frame.add(pkmAppear);
        frame.add(pkmAppear2);
        frame.setLayout(null); //sets layout to be absolute
        frame.add(pokemonAvailable);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(background);
        frame.add(pkmtext);

        // calls few methods from pkmtext, will be responsible for showing the pokemon information
        pkmtext.HPLost(p1); //any pokemon can go inside the brackets(it doesn't affect the gameplay which pokemon is set), this is used only to call up the method once
        pkmtext.setBounds(0, 0, 800, 800);
        pkmtext.setVisible(false);

        // this method call sets the private instance in it's own class (Fight Button)
        button1.setSwitch(pokemonAvailable);

    }
}
