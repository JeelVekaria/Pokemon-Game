// FightButton.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

public class Player {
    // private object instances
    private Pokemon pkm1;
    private Pokemon pkm2;
    private Pokemon pkm3;

    // constructors
    public Player() {
        pkm1 = new Pokemon();
        pkm2 = new Pokemon();
        pkm3 = new Pokemon();
    }
    public Player(Pokemon pkm1, Pokemon pkm2, Pokemon pkm3){
        this.pkm1 = pkm1;
        this.pkm2 = pkm2;
        this.pkm3 = pkm3;
    }

    // accessor
    public Pokemon getPokemon1(){
        return pkm1;
    }
    public Pokemon getPokemon2(){
        return pkm2;
    }
    public Pokemon getPokemon3(){
        return pkm3;
    }

    // mutators
    public void setPokemon1(Pokemon pkm1){
        this.pkm1 = pkm1;
    }
    public void setPokemon2(Pokemon pkm2){
        this.pkm2 = pkm2;
    }
    public void setPokemon3(Pokemon pkm3){
        this.pkm3 = pkm3;
    }

    // returns a string of every instance variables in a proper format
    public String toString(){
        return "|| Pokemon 1: "+pkm1.getName()+" Type: "+pkm1.getType()+"\t||\n|| Pokemon 2: "+pkm2.getName()+" Type: "+pkm2.getType()+"\t||\n|| Pokemon 3: "+pkm3.getName()+" Type: "+pkm3.getType()+"\t||";
    }
}
