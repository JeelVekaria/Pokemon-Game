// Pokemon.java
// Jeel Vekaria
// ICS4U0
// December 3rd 2021

public class Pokemon {
    // private instances
    private String name;
    private String type;
    private int healthLeft;
    private int healthTotal;
    
    // constructors
    public Pokemon() {
        name = "";
        type = "";
        healthTotal = 1;
        healthLeft = 0;
    }

    public Pokemon(String name, String type, int healthLeft, int healthTotal) {
        this.name = name;
        this.type = type;
        this.healthLeft = healthLeft;
        this.healthTotal = healthTotal;
    }

    // accessors
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealthLeft() {
        return healthLeft;
    }

    public int getHealthTotal() {
        return healthTotal;
    }

    // mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealthLeft(int healthLeft) {
        this.healthLeft = healthLeft;
    }

    public void setHealthTotal(int healthTotal) {
        this.healthTotal = healthTotal;
    }

    //responsible for pokemon losing hp
    public void lostHp(int points) {
        if (healthLeft - points <= 0) {//always set healthLeft to 0 if it goes into the negatives or is just 0
            healthLeft = 0;
        } else {
            healthLeft -= points;
        }
    }

    // returns a string of every instance variables in a proper format
    public String toString() {
        return name + "(" + type + ")\t" + healthLeft + "/" + healthTotal + "hp";
    }

}
