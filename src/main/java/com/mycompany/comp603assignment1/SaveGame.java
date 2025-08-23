package com.mycompany.comp603assignment1;

import java.io.*;
/**
 * saves player data to a file to be read from
 * Here is the at least 3 save files
 * @author Jesse
 */
public class SaveGame {
    public void save(Player player){
        //write to file (true to append saves?)
        try(PrintWriter writer = new PrintWriter(new FileWriter("./resources/WWTBAMsave.txt"))){
            writer.println(player.getName());
            writer.println(player.getLevel());
            writer.println(player.getScore());
            for (int i = 0; i < 3; ++i){
                writer.println(player.hasLifeline(i));
            }
        }catch(IOException ex){
            System.out.println("Error Saving: " +ex.getMessage());
        }
    }
}
