import org.junit.Test;
import spoon.SpoonAPI;
import spoon.processor.ObjectCreationProcessor;

/**
 * Created by alexandre on 18/11/16.
 */
public class Test1 {

    SpoonAPI spoon;

    @Test
    public void testA(){
        ObjectCreationProcessor proc = new ObjectCreationProcessor();
        spoon.addProcessor(proc);
        spoon.addInputResource("src/test/resources/java/TestA.java");
        spoon.run();
    }

}
