import java.util.Arrays;
public class HiddenWord {
    private String word;
    private String[] arr;

    public HiddenWord(String s){
        this.word = s.toUpperCase();
        arr = word.split("");
    }



    private boolean found = false;

    public String getHint(String guess) throws IllegalArgumentException{
        String f = "";
        String[] guessArr = guess.split("");
        if (!guess.toUpperCase().equals(guess)) throw new IllegalArgumentException(String.format("Your guess ( %s ) does not contain all uppercase letters. Your guess must contain all uppercase letters!", guess));
        if(guess.length()!=word.length()) throw new IllegalArgumentException(String.format("Your guess ( %s ) has %d characters. The hidden word has %d characters. Your guess must be a word with %d characters!", guess, guess.length(), word.length(), word.length()));
        for(String i : guessArr){
            if (Arrays.asList(guessArr).indexOf(i) == Arrays.asList(arr).indexOf(i)) f += i;
            else if ((Arrays.asList(guessArr).indexOf(i) != Arrays.asList(arr).indexOf(i)) && Arrays.asList(arr).contains(i)) f += "+";
            else if (!Arrays.asList(arr).contains(i)) f += "*";
            try {
                guessArr[Arrays.asList(guessArr).indexOf(i)] = "null";
            } catch (Exception e){}
        }
        return f;
    }

    public String getHiddenWord(){return this.word;}



}
