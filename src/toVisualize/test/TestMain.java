import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processor.ObjectCreationProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexandre on 28/11/16.
 */
public class TestMain{

    @Before
    public void setUp(){ Logger.open(); }

    @After
    public void tearDown(){
        Logger.close();
    }

    @Test
    public void getRandomLetterTest(){
        DoRandomStuff r = new DoRandomStuff();
        assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(""+r.getRandomLetter()));
    }

    @Test
    public void getRandomWordTest(){
        DoRandomStuff r = new DoRandomStuff();
        assertTrue(r.getRandomWord(5).length() == 5);
    }

//    @Test
//    public void TestWithSleep(){
//        assertEquals(0, TestWithSleep.numberOfSleep);
//        TestWithSleep.main(null);
//        assertEquals(10, TestWithSleep.numberOfSleep);
//    }



}
