import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processor.ObjectCreationProcessor;

/**
 * Created by alexandre on 28/11/16.
 */

/*
Run spoon processors on all files in specified directory.
Create new directory with newly generated files.
 */
public class GenerateLoggedFiles {

    static SpoonAPI spoon;

    public static void main(String args[]){
        spoon = new Launcher();
        ObjectCreationProcessor proc = new ObjectCreationProcessor();
        spoon.addProcessor(proc);
        spoon.addInputResource("src/toVisualize/main");
        spoon.setSourceOutputDirectory("src/toVisualize/main-logged");
        spoon.run();
    }

}
