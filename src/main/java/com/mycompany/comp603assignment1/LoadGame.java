package com.mycompany.comp603assignment1;

import java.io.*;
/**
 * used to check player data from previous saves
 * Todo:
 * make this check through multiple players in a list
 * @author Jesse
 */
public class LoadGame {
    
    public Player load()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("./resources/WWTBAMsave.txt"))){
            //load the individual parts
            String name = reader.readLine();
            int level = Integer.parseInt(reader.readLine());
            int score = Integer.parseInt(reader.readLine());
            boolean[] lifelines = new boolean[3];
            for (int i = 0; i < 3; ++i){
                lifelines[i] = Boolean.parseBoolean(reader.readLine());
            }
            
            //then create new player using loaded parts
            Player player = new Player(name, level, score, lifelines);
            return player;
        }
        catch(IOException | NumberFormatException ex){
            System.out.println("No save game found or currupt file.");
            return null;
        }
    }
}
