package com.mycompany.comp603assignment1;

/**
 * Todo:
 * -Lifelines-
 * - 5050, display only the 5050 choice after used
 * when a life line is removed, dont display they can use it --- pass in lifeline to CUI
 * -player-
 * Save multiple people to a file?
 * add a lifeline used to the player and save that
 * 
 * Bonus:
 * more questions and randomize them
 * Do a 'Are you sure?' check
 * Safety net
 * @author Jesse
 */
public class COMP603Assignment1 {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
