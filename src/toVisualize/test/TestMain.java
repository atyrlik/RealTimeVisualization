import junit.framework.TestCase;
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

    SpoonAPI spoon;

    @Before
    public void setUp(){
        spoon = new Launcher();
        ObjectCreationProcessor proc = new ObjectCreationProcessor();
        spoon.addProcessor(proc);
        spoon.addInputResource("src/toVisualize/main");
        spoon.setSourceOutputDirectory("src/toVisualize/main-logged");
        spoon.run();

    }

    @Test
    public void DoRandomStuffTest(){
        DoRandomStuff r = new DoRandomStuff();
        assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(""+r.getRandomLetter()));
    }

    @Test
    public void TestWithSleep(){
        assertEquals(0, TestWithSleep.numberOfSleep);
        TestWithSleep.main(null);
        assertEquals(10, TestWithSleep.numberOfSleep);
    }



}
