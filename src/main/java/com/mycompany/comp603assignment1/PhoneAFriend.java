package com.mycompany.comp603assignment1;

import java.util.*;
/**
 * This life line should be correct 50% of the time
 * @author Jesse
 */
public class PhoneAFriend extends LifeLine{
    private final Random rand = new Random();
    
    public PhoneAFriend(){
        super("Phone A Friend");
    }
    
    public void use(Question q){
        //give a 50:50 hint 
        List<String> options = q.getOptions();
        int answerIndex = q.getCorrectIndex();
        
        //get the wrong answers into a list
        List<Integer> wrong = new ArrayList<>();
        for (int i = 0; i < options.size(); ++i){
            if(i != answerIndex)
                wrong.add(i);
        }
        Collections.shuffle(wrong, rand);
        
        boolean coinFlip = new Random().nextBoolean();
        
        int firstFriendChoice, secondFriendChoice;
        
        if(coinFlip){//friend knows one of them
            firstFriendChoice = answerIndex;
            secondFriendChoice = wrong.get(0);
            }
        else {//friend not smart
            firstFriendChoice = wrong.get(0);
            secondFriendChoice = wrong.get(1);
                //replace this and that with incorrect answers
            }
        
        //convert index to option characters
        char firstLetter = (char)('A' + firstFriendChoice);
        char secondLetter = (char)('A' + secondFriendChoice);
        
        System.out.println("Thats a tricky one. It could be " + firstLetter + " or " + secondLetter);   
    }
}
