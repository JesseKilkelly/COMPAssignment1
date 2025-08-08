package com.mycompany.comp603assignment1;

import java.io.*;
/**
 * used to check player data from previous saves
 * Todo:
 * not sure how this would handle loading a bunch of different players
 *              might need to loop through or something
 * @author Jesse
 */
public class LoadGame {
    
    public Player load()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("./resources/WWTBAMsave.txt"))){
            String name = reader.readLine();
            int level = Integer.parseInt(reader.readLine());
            int score = Integer.parseInt(reader.readLine());
            
            Player player = new Player(name, level, score);
            return player;
        }
        catch(IOException | NumberFormatException ex){
            System.out.println("No save game found or currupt file.");
            return null;
        }
    }
}
