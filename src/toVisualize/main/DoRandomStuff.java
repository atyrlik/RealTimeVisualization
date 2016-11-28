/**
 * Created by alexandre on 27/11/16.
 */
public class DoRandomStuff {

    public char getRandomLetter(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt((int)(Math.random() * letters.length()));
    }

    public String getRandomWord(int size){
        StringBuilder word = new StringBuilder();

        for(int i=0; i<size; i++)
            word.append(getRandomLetter());

        return word.toString();
    }

}
