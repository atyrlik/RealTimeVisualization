import junit.framework.TestCase;
import org.junit.*;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processor.ObjectCreationProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexandre on 28/11/16.
 */
public class TestMain{

    @BeforeClass
    public static void setUp(){ Logger.open(); }

    @AfterClass
    public static void tearDown(){
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

    @Test
    public void TestWithSleep(){
        assertEquals(0, TestWithSleep.numberOfSleep);
        TestWithSleep.main(null);
        assertEquals(10, TestWithSleep.numberOfSleep);
    }



}
