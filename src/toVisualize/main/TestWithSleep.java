/**
 * Created by alexandre on 27/11/16.
 */
public class TestWithSleep {

    public static int numberOfSleep = 0;

    public static void main(String[] args){
        System.out.println("Begin program!");

        for(int i=0; i<10; i++){
            DoRandomStuff rand = new DoRandomStuff();
            System.out.println(rand.getRandomLetter());
            try{
                Thread.sleep(1000);
                numberOfSleep++;
            }
            catch (Exception exception){
                System.out.println(exception);
            }
        }

        System.out.println("End program");

    }

}