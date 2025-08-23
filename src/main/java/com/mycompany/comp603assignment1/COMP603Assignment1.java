package com.mycompany.comp603assignment1;

/**
 * Todo:
 * - bug - 50:50, display 5050 but then shows all options
 * -player-
 * Save multiple people to a file
 * 
 * Bonus:
 * more questions and randomize them
 * Do a 'Are you sure?' check
 * Safety net
 * @author Jesse
 */
public class COMP603Assignment1 {
    public static void main(String[] args) {
        
        CUI cui = new CUI();
        SaveGame saveGame = new SaveGame();
        LoadGame loadGame = new LoadGame();
        QuestionBank questionBank = new QuestionBank();
        
        Game game = new Game(cui, saveGame, loadGame, questionBank);
        game.start();
    }
}
