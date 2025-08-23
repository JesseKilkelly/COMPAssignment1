package assignment1;

import java.util.*;
/**
 * This life line should be correct 75% of the time
 * @author Jesse
 */
public class AudiencePoll extends LifeLine{
    private final Random rand = new Random();
    
    public AudiencePoll(){
       super("Audience Poll");
    }
    
    public void use(Question q){
        List<String> options = q.getOptions();
        int answerIndex = q.getCorrectIndex();
        
        //get the wrong answers into a list
        List<Integer> wrong = new ArrayList<>();
        for (int i = 0; i < options.size(); ++i){
            if(i != answerIndex)
                wrong.add(i);
        }
        Collections.shuffle(wrong, rand);
        
        System.out.println("Audience Poll use!");
        int percentage = rand.nextInt(4);
        //75% chance of being right
        if(percentage < 3)
        {
            //convert index to option characters
            char letter = (char)('A' + answerIndex);
            System.out.println("75% of the audidence voted for: " +letter+ ") " +options.get(answerIndex));
        }else{
            char letter = (char)('A' + wrong.get(0));
            System.out.println("75% of the audidence voted for: " +letter+ ") " +options.get(wrong.get(0)));
        }
    }
}
