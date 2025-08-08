package com.mycompany.comp603assignment1;

/**
 * This life line should be correct 75% of the time
 * @author Jesse
 */
public class AudiencePoll extends LifeLine{
    public AudiencePoll(){
       super("Audience Poll");
    }
    
    public void use(Question q){
        // random 3/4 chance of being correct
    }
}
