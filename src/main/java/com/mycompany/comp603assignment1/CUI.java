package com.mycompany.comp603assignment1;

import java.util.*;

/**
 * Made this class with the foresight of us having to replace CUI with a GUI in the second assignment
 * @author Jesse
 */
public class CUI {
    private Scanner scanner = new Scanner(System.in);
    
    public boolean promptIntro(){
        System.out.println("Do you want to be a millionaire? (y/n)");
        if(scanner.nextLine().trim().equalsIgnoreCase("y")){
            return true;
        }
        else{
            return false;
        }
    }
            
    public String promptName(){
        System.out.println("Enter your name: ");
        return scanner.nextLine().trim();
    }
    
    public void displayQuestion(Question q) {
        System.out.println("\n" + q.getText());
        List<String> options = q.getOptions();
        //%c a char format specifier that is replaced with A, B , C and D
        //since using ASCII values (A+0=A, A+1=B, A+2=C,...)
        //%s then puts the string of text in(the question options)
        for (int i = 0; i < options.size(); ++i) {
            System.out.printf("%c) %s\n", 'A' + i, options.get(i));
        }
    }
    
    //pass in lifelines and print their names here---
    public int getAnswer(boolean[] lifelines) {
        while(true){
            System.out.println("Choose an option (A, B, C or D)");
            System.out.printf("or use a lifeline ( ");
            for (int i = 0; i < lifelines.length; ++i){
                if(!lifelines[i]){
                    System.out.printf((i+1)+" ");
                }
            }
            System.out.println(")");
                
            String input = scanner.nextLine().trim().toUpperCase();
        
            //hard coded switch as no new lifelines should be added
            switch(input){
                case "A": 
                    return 0;        
                case "B": 
                    return 1;        
                case "C": 
                    return 2;        
                case "D": 
                    return 3;
                //lifelines    
                case "1": //50:50
                    return 4;
                case "2": //phone a friend
                    return 5;
                case "3": // audience poll
                    return 6;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
            
    public void displayCorrect(){
        System.out.println("Correct!\n");
    }
    public void displayIncorrect(Question q){
        System.out.println("Sorry incorrect. The correct answer was: " + q.getOptions().get(q.getCorrectIndex()) + "\n");
    }
    
    public boolean promptContinue(){
        System.out.println("Press 'y' if you want to continue to the next question? or 'n' leave with what you have?: ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }
    public void congrats(){
        System.out.println("Congratulations! youre now a millionaire");
    }
    public void displayScore(int score){
        System.out.println("Your current score is now: $" + score);
    }    
    public void displayFinalScore(int score){
        System.out.println("Game over. Your final score was: $" + score);
    }
}


