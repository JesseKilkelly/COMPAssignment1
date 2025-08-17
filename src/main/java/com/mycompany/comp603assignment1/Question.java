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
    private int[] incorrect = {0,0,0};
    
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
        //neat collections functions
        String correctAnswer = options.get(correctOption);
        Collections.shuffle(options);
        correctOption = options.indexOf(correctAnswer);
        
        //sort incorrect options
        for (int i = 0; i < options.size()-1; ++i)
        {   
            //store incorrect options
            if (options.indexOf(i) != options.indexOf(correctAnswer))
                incorrect[i] = options.indexOf(i);
        }
    }
    //for lifelines
    public int getIncorrect(int index){
        return incorrect[index];
    }
}
