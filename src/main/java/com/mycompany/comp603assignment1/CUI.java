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
        for (int i = 0; i < options.size(); ++i) {
            System.out.printf("%c) %s\n", 'A' + i, options.get(i));
        }
    }
    
    public int getAnswer() {
        System.out.println("Choose an option (A,B,C or D): ");
        String input = scanner.nextLine().trim().toUpperCase();
        return input.charAt(0) - 'A';
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
    
}
