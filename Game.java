//import java.util.Random;

public class Game{
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(WordList wordList){
        answer = wordList.getRandom();
        hits = "";
        misses = "";
    }

    public String getAnswer(){
        return answer;
    }

    // Checks to see if the guess is in the answer
    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
            hits += letter;
        }else{
            misses += letter;
        }
        return isHit;
    }

    private char normalizeGuess(char letter){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required. ");
        }
        letter = Character.toLowerCase(letter);
        if(hits.indexOf(letter) != -1 || misses.indexOf(letter) !=-1){
            throw new IllegalArgumentException("Letter was already picked. ");
        }
        return letter;
    }

    public boolean applyGuess(String letters){
        if(letters.length() == 0){
            throw new IllegalArgumentException("You must enter a letter. ");
        }
        return applyGuess(letters.charAt(0));
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public String getCurrentProgress(){
        String progress = "";
        for(char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon(){
        return getCurrentProgress().indexOf("-") == -1;
    }

    /*private String answers(){
        String[] answers = {
                "spiderman",
                "superman",
                "batman",
                "iceman",
                "xmen",
                "flash"
        };
        Random random = new Random();
        return answers[random.nextInt(answers.length)];
    }*/
}
