package main;

/**
 * Created by alexandre on 27/11/16.
 */
public class TestWithSleep {

    public static void main(String[] args){
        System.out.println("Let's creating 10 objects!");

        for(int i=0; i<10; i++){
            new Object();
            try{
                Thread.sleep(2000);
            }
            catch (Exception exception){
                System.out.println(exception);
            }
        }

        System.out.println("All objects have been created!");

    }

}