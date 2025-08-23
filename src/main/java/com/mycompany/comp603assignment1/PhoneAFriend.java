package com.mycompany.comp603assignment1;

/**
 * Holds all player data
 * @author Jesse
 */
public class Player {
    private String name;
    private int currentLevel;
    private int score;
    private boolean[] lifelineUsed;
    
    //new player constructor
    public Player(String name){
        this.name = name;
        this.currentLevel = 0;
        this.score = 0;
        this.lifelineUsed = new boolean[]{false, false, false};
    }
    //overload constructor - for loading
    public Player(String name, int currentLevel, int score, boolean[] lifelines)
    {
        this.name = name;
        this.currentLevel = currentLevel;
        this.score = score;
        this.lifelineUsed = lifelines;
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
    
    //life lines
    public boolean hasLifeline(int index){
        return lifelineUsed[index];
    }
    public void useLifeline(int index){
        lifelineUsed[index] = true;
    }
    public boolean[] getLifeLines(){
        return lifelineUsed;
    }
}
