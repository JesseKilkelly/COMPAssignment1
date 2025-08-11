package com.mycompany.comp603assignment1;

/**
 * Todo:
 * Lifelines - implement - use Random().nextInt(x) to decide if correct or not
 * using a lifeline removes it from being used
 * --Correct the scoring-- done
 * When loading player, make their currentLevel be the question they are up to
 * reset the level after losing or passing the million dollar question
 * Check input for only A B C or D
 * If the player has already beaten the game, check if they would like to play again (Overriding their current level or adding the score on top)
 * 
 * Bonus:
 * more questions and randomize them
 * Do a 'Are you sure? is that your final answer?' check
 * @author Jesse
 */
public class COMP603Assignment1 {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
