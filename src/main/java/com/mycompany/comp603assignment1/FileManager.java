package com.mycompany.comp603assignment1;

import java.util.*;
import java.io.*;

/**
 * Was initially for saving and loading but now handles just question bank
 * @author Jesse
 */
public class FileManager {
    
    public List<String> readFile(String path){
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        }catch(IOException ex){
            System.out.println("Error reading " + ex.getMessage());
        }
        return lines;
    }
}
