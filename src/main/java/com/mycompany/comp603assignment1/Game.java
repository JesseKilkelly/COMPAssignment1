package com.mycompany.comp603assignment1;

/**
 * Main game flow
 * @author Jesse
 */
public class Game {
    
    private Player player;
    private QuestionBank easy;
    private QuestionBank hard;
    private QuestionBank finalQuestion;
    private LifeLine[] lifelines;
    private SaveGame saveGame;
    private LoadGame loadGame;
    private CUI cui;
    
    public Game(){
        this.cui = new CUI();
        this.saveGame = new SaveGame();
        this.loadGame = new LoadGame();
        
        //Load
        //easy questions 5
        this.easy = new QuestionBank();
        this.easy.loadFile("./resources/easy.txt");
        //hard questions 9
        this.hard = new QuestionBank();
        this.hard.loadFile("./resources/hard.txt");
        //final question 1
        this.finalQuestion = new QuestionBank();
        this.finalQuestion.loadFile("./resources/final.txt");
        
        //multi initialise - polymorphism
        this.lifelines = new LifeLine[]{new FiftyFifty(), new PhoneAFriend(), new AudiencePoll()};
    }

    public void start() {
        
        //if player doesn't want to be a millionaire then quit
        if (!cui.promptIntro())
            System.exit(0);
        //else we play
        //get player name
        String name = cui.promptName();
        
        // check if they are returning ot not
        Player loadedPlayer = loadGame.load();
        if((loadedPlayer != null) && loadedPlayer.getName().equalsIgnoreCase(name)){
            this.player = loadedPlayer;
            System.out.println("Welcome back, " + player.getName());
        }else{
            this.player = new Player(name);
            System.out.println("Welcome newcomer, " + name);
        }
        
        //start at easy ------ change this to check player level
        QuestionBank currentQuestions = easy;
        
        //Game loop
        while(true) {
            Question q = currentQuestions.getNextQuestion();
            
            //loop through the questions
            if(q == null){
                if(currentQuestions == easy){
                    currentQuestions = hard;
                    continue;
                } else if (currentQuestions == hard){
                    currentQuestions = finalQuestion;
                    continue;
                }else{
                    System.out.println("Congratulations! youre now a millionaire");
                    break;
                }
            }
            
            //display question
            cui.displayQuestion(q);
            int answer = cui.getAnswer();
            
            //check answer
            if(q.IsCorrect(answer)){
                cui.displayCorrect();
                player.levelUp();
                //sort out scores later
                player.setScore(100);
            } else{
                cui.displayIncorrect(q);
                System.out.println("Game over. Your final score was: " + player.getScore());
                break;
            }
            //If quits
            if(!cui.promptContinue()){
                saveGame.save(player);
                System.out.println("Game saved!");
                break;
            }
        }
    }
}
