/**
 * Created by alexandre on 27/11/16.
 */
public class DoRandomStuff {

    public char getRandomLetter(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt((int)(Math.random() * letters.length()));
    }

}
