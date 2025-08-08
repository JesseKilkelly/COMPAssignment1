package com.mycompany.comp603assignment1;

import java.util.Collections;
import java.util.List;

/**
 * for the single question pulled from the bank
 * holds the question, 4 options and correct option
 * @author Jesse
 */
public class Question {
    private String question;
    private List<String> options;
    private int correctOption;
    
    //constructor
    public Question(String question, List<String> answers, int correctIndex){
        this.question = question;
        this.options = answers;
        this.correctOption = correctIndex;        
    }
    
    boolean IsCorrect(int choice){
        if (choice == correctOption)
            return true;
        else
            return false;
    }
    public String getText(){
        return question;
    }
    
    public List<String> getOptions(){
        return options;
    }
    
    public int getCorrectIndex(){
        return correctOption;
    }
    
    public void shuffleOptions(){
        String correctAnswer = options.get(correctOption);
        Collections.shuffle(options);
        correctOption = options.indexOf(correctAnswer);
    }
            
}
