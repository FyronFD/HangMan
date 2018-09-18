public class Main{

    public static void main(String[] args){
        Game game = new Game(new WordList("wordlist.txt")); // Put your own answer in the parentheses
        Prompter prompter = new Prompter(game);

        while (game.getRemainingTries() > 0 && !game.isWon()){
            prompter.displayProgress();
            prompter.promptForGuess();
        }
        prompter.displayOutcome();
    }
}
