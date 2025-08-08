package com.mycompany.comp603assignment1;

/**
 * Todo:
 * Lifelines - implement - use Random().nextInt(x) to decide if correct or not
 * using a lifeline removes it from being used
 * Correct the scoring
 * When loading player, make their currentLevel be the question they are up to
 * reset the level after losing or passing the million dollar question
 * 
 * Bonus:
 * more questions and randomize them
 * @author Jesse
 */
public class COMP603Assignment1 {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
