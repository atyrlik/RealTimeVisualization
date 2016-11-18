import org.junit.Before;
import org.junit.Test;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processor.ObjectCreationProcessor;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;

import java.util.ArrayList;

/**
 * Created by alexandre on 18/11/16.
 */
public class Test1 {

    SpoonAPI spoon;

    @Before
    public void setUp(){
        spoon = new Launcher();
    }

    @Test
    public void testA(){
        ObjectCreationProcessor proc = new ObjectCreationProcessor();
        spoon.addProcessor(proc);
        spoon.addInputResource("src/test/resources/java/TestA.java");
        spoon.run();

        DefaultJavaPrettyPrinter pp = new DefaultJavaPrettyPrinter(spoon.getEnvironment());
        pp.calculate(null, new ArrayList(spoon.getModel().getAllTypes()));
        System.out.println(pp.getResult());
    }

}
