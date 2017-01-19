import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processor.MethodsCallProcessor;
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
        ObjectCreationProcessor procObject = new ObjectCreationProcessor();
        MethodsCallProcessor procMethod = new MethodsCallProcessor();
        spoon.addProcessor(procObject);
        spoon.addProcessor(procMethod);
//        spoon.addInputResource("src/toVisualize/main");
//        spoon.setSourceOutputDirectory("src/toVisualize/main-logged");

        spoon.addInputResource("src/toVisualize/abstractFactory/main/java/com/iluwatar/abstractfactory");
        spoon.setSourceOutputDirectory("src/toVisualize/abstractFactory/main/java/com/iluwatar/abstractfactory-logged");

        spoon.run();
    }

}
