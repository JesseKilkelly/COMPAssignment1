package com.mycompany.comp603assignment1;

/**
 * give a 50:50 hint 
 * @author Jesse
 */
public class FiftyFifty extends LifeLine{
    private final Random rand = new Random();
    
    public FiftyFifty(){
        super("50:50");
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
        int wrongIndex = wrong.get(0);
        
        //convert index to option characters
        char firstLetter = (char)('A' + answerIndex);
        char secondLetter = (char)('A' + wrongIndex);
        
        System.out.println("Reducing the answer to two possible answers we have");
        System.out.println("(" +firstLetter+ ") " +options.get(answerIndex)+ " or");
        System.out.println("(" +secondLetter+ ") " +options.get(wrongIndex));   
    }
}
