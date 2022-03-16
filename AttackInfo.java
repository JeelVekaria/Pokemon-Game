// AttackInfo.java
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


public class AttackInfo extends JPanel {
    //private instance variables
    private JLabel arrow1;
    private JLabel arrow2;
    private JLabel arrow1t;
    private JLabel arrow2t;
    private boolean once=true;
    private JLabel display;
    private Pokemon pkm1;
    private Pokemon pkm2;
    private Font pixelMplus;

    //constructor
    public AttackInfo(){
        //initializes the instance variables
        arrow1 = new JLabel();
        arrow2 = new JLabel();
        arrow1t = new JLabel();
        arrow2t = new JLabel();
        
        //sets layout to be abosolute
        this.setLayout(null);

        //sets a custom font
        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(22f);	
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));			
        }
        catch(IOException | FontFormatException e){
        }


        //shows whos turn it is saying Player 1, appears on Player 1's first turn
        arrow1t = new JLabel();
        ImageIcon arrowp1 = new ImageIcon("Arrowt1.png");
        arrow1t.setIcon(arrowp1);
        arrow1t.setBounds(110,205,300,100);
        this.add(arrow1t);
        
        //shows whos turn it is saying Player 2, appears on Player 2's first turn
        arrow2t = new JLabel();
        ImageIcon arrowp2 = new ImageIcon("Arrowt2.png");
        arrow2t.setIcon(arrowp2);
        arrow2t.setBounds(540,-20,250,100);
        this.add(arrow2t);
        arrow2t.setVisible(false);
        
        //shows the arrow above Player 1's Pokemon
        arrow1 = new JLabel();
        ImageIcon arrow = new ImageIcon("Arrow.png");
        arrow1.setIcon(arrow);
        arrow1.setBounds(180,260,250,100);
        this.add(arrow1);
        
        
        //shows the arrow above Player 2's Pokemon
        arrow2 = new JLabel();
        arrow2.setIcon(arrow);
        arrow2.setBounds(610,35,250,100);
        this.add(arrow2);
        arrow2.setVisible(false);
        this.setOpaque(false);

        //shows before the user presses the Fight button, saying where the attack messages will appear
        display = new JLabel();
        display.setText("   »Attack Messages Will Appear Here«");
        display.setFont(pixelMplus);
        display.setBounds(10,600,500,200);
        this.add(display);

    }
    
    //alternates between showing the attack message and the pokemons the user wants to switch with
    public void call(boolean check){
        if(once){//shows that this is Player 2's turn, only appears on the first turn
            arrow1t.setVisible(false);
            arrow2t.setVisible(true);
        }
        if(!check){
            arrow1.setVisible(true);
            arrow2.setVisible(false);
            arrow2t.setVisible(false);
        }
        else{
            arrow1.setVisible(false);
            arrow2.setVisible(true);
        }
        once=false;
    }
    //displays the Pokemon attack messages
    public void display1(int amount, Pokemon pkm) {
        display.setText("»"+pkm2.getName()+" did "+amount+" damage to "+pkm.getName()+"!«");
    }
    public void display2(int amount, Pokemon pkm) {
        display.setText("»"+pkm1.getName()+" did "+amount+" damage to "+pkm.getName()+"!«");
    }

    //sets the instance variables <- used for the code above displaying which pokemon is attacking
    public void setPkm1(Pokemon pkm1) {
        this.pkm1=pkm1;
    }
    public void setPkm2(Pokemon pkm2){
        this.pkm2=pkm2;
    }

    //switches between apeparing and not appearing <- mainly for when the Pokemon Button or Fight Button is clicked
    public void show(boolean check) {
        if(check){
            display.setVisible(true);
        }
        else{
            display.setVisible(false);
        }
    }

}
