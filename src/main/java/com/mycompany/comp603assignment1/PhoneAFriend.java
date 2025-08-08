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
        //same as audience poll but less correct
        //System.out.println("I think it could be " + answer1 + " or " +answer2);
    }
}
