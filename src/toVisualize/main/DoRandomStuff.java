import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alexandre on 27/11/16.
 */
public class DoRandomStuff {

    public DoRandomStuff(){
        long randomWaitTime = (long)(Math.random()*2000 + 500);
        new ArrayList();
        try{
            Thread.sleep(randomWaitTime);
        }
        catch (Exception exception){
            System.out.println(exception);
        }
        HashMap myHashMap = new HashMap();
    }

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
