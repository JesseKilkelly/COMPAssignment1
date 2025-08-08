package com.mycompany.comp603assignment1;

/**
 * Holds all player data
 * @author Jesse
 */
public class Player {
    private String name;
    private int currentLevel;
    private int score;
    
    //new player constructor
    public Player(String name){
        this.name = name;
        this.currentLevel = 0;
        this.score = 0;
    }
    //overload constructor - for loading
    public Player(String name, int currentLevel, int score)
    {
        this.name = name;
        this.currentLevel = currentLevel;
        this.score = score;
    }

    //gets and sets
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return currentLevel;
    }
    public void setLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void levelUp()
    {
        this.currentLevel += 1;
    }    
    
}
