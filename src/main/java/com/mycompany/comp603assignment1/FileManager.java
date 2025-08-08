package com.mycompany.comp603assignment1;

import java.util.*;
import java.io.*;

/**
 * Core class for handling all the reading and writing
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
    
    public void writeToFile(String path, String data, boolean append){
        try(PrintWriter writer = new PrintWriter(new FileWriter(path, append))){
            writer.println(data);
        }catch(IOException ex){
            System.out.println("Error writing " + ex.getMessage());
        }
    }   
}
