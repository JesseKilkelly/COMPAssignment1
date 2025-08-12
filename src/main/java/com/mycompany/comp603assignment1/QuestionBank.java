package com.mycompany.comp603assignment1;

import java.util.*;
/**
 * This class Loads the questions from the different difficulty files
 * Using load all questions put all the questions into one list
 * @author Jesse
 */
public class QuestionBank {
    private final List<Question> questions = new ArrayList<>();
    
    //hope this still counts as 3 loads? - This was the easiest way i could think of for loading where left off
    public void loadAllQuestions(String easyFile, String hardFile, String finalFile){
        loadFile(easyFile);
        loadFile(hardFile);
        loadFile(finalFile);
    }
    
    public void loadFile(String filename){
        FileManager fileManager = new FileManager();
        try{
            List<String> lines = fileManager.readFile(filename);
            //collecting questions from form to add to question list
            for (int i = 0; (i + 5) < lines.size(); i+=6){
                String questionText = lines.get(i);
                List<String> options = Arrays.asList(lines.get(i+1),lines.get(i+2),lines.get(i+3),lines.get(i+4));
                int correctIndex = Integer.parseInt(lines.get(i+5));

                Question q = new Question(questionText, options, correctIndex);
                q.shuffleOptions();
                questions.add(q);
            }
        }catch(Exception ex){
            System.out.println("Error loading questions: " +ex.getMessage());
        }  
    }
    
    public Question getQuestionByLevel(int level){
        int index = level;
        if (index >=0 && index < questions.size()){
            return questions.get(index);
        }
        return null;
    }
    
    public Question getNextQuestion(){
        if (!questions.isEmpty())
            return questions.remove(0);
        return null;
    }
}
