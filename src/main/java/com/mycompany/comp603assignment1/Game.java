package com.mycompany.comp603assignment1;

/**
 * Main game flow
 * @author Jesse
 */
public class Game {
    
    private Player player;
    private final QuestionBank qBank;
    private final LifeLine[] lifelines;
    private final SaveGame saveGame;
    private final LoadGame loadGame;
    private final CUI cui;
    private final int[] priseArray = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
    
    public Game(CUI cui, SaveGame saveGame, LoadGame loadGame, QuestionBank questionBank){
        this.cui = cui;
        this.saveGame = saveGame;
        this.loadGame = loadGame;

        //Load
        this.qBank = questionBank;
        qBank.loadAllQuestions("./resources/easy.txt", "./resources/hard.txt", "./resources/final.txt");
 
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
        
        //Game loop
        while(true) {
            //Question q = currentQuestions.getNextQuestion();
            Question currentQuestion = qBank.getQuestionByLevel(player.getLevel());
            
            //got beyond the question list
            if (currentQuestion == null){
                cui.congrats();
                player.setLevel(0);//reset level after winning
                saveGame.save(player);
                break;
            }
            
            //display question
            cui.displayQuestion(currentQuestion);
            
            boolean isAnswered = false;
            while(!isAnswered){
                
                isAnswered = true;
            }
            int answer = cui.getAnswer(player.getLifeLines());
            
            //check answer
            //lifeline has been selected
            if(answer >= 4 && answer <= 6){
                int lifelineIndex = answer -4; //to get 0,1,2
                if(!player.hasLifeline(lifelineIndex)){
                    lifelines[lifelineIndex].use(currentQuestion);
                    player.useLifeline(lifelineIndex); // remove after used
                }
                else{
                    System.out.println("Already used that lifeline");
                }
                continue; //ask question again ---- makes 50:50 a bit screwy
            }
            
            //They got it right - level up give score.
            if(currentQuestion.IsCorrect(answer)){
                cui.displayCorrect();
                player.levelUp();
                
                //get score from array and set it
                if (player.getLevel() <= priseArray.length){
                    int prise = priseArray[player.getLevel()-1];
                    player.setScore(prise);
                }
                cui.displayScore(player.getScore());
                
                //make sure the data is up to date
                saveGame.save(player);
            }
            //They got it wrong - reset player, kick them out
            else{
                cui.displayIncorrect(currentQuestion);
                cui.displayFinalScore(player.getScore());
                player.setLevel(0);
                //check if safety net here
                saveGame.save(player);
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


