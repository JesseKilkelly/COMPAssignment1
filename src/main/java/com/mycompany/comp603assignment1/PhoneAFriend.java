package com.mycompany.comp603assignment1;

import java.util.*;
/**
 * This life line should be correct 50% of the time
 * @author Jesse
 */
public class PhoneAFriend extends LifeLine{
        public PhoneAFriend(){
        super("Phone A Friend");
    }
    
    public void use(Question q){
        //give a 50:50 hint 
        int random = new Random().nextInt(4);
            if(random <= 2)
            {
                //get wrong options
                System.out.println("I think its either " + q.getCorrectIndex() + "or " +q.getIncorrect(1));
                System.out.println("random: " + random);
            }
            else
            {
                //replace this and that with incorrect answers
                System.out.println("Thats a tricky one. It could be " + q.getIncorrect(1) + "or " + q.getIncorrect(2));   
            }
        //same as audience poll but less correct
    }
}
